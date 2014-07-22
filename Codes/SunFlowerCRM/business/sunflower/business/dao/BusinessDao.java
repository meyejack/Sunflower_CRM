package sunflower.business.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import sunflower.business.entity.Business;
import sunflower.util.support.HibernateUtil;

public class BusinessDao {
	private Session session;

	// 获取服务by id
	public Business getBusiness(String businessID) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Business business = (Business) session.get(Business.class, businessID);
		return business;
	}

	// 添加服务
	public boolean saveBusiness(Business business) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			business.setBusinessId("000000000000000000000000000000000000");
			session.save(business);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 修改服务
	public boolean updateBusiness(Business business) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.update(business);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}

		return true;
	}

	// 服务状态，0：未使用，1：使用中，2：已停用
	// 取消服务
	public boolean dropBusiness(Business business) {
		business.setBusinessState(2);
		updateBusiness(business);
		return true;
	}

	//获取所有可用服务
	public List<Business> getAvailBusinesss() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Business> businesses = (List<Business>) session
				.createCriteria(Business.class)
				.add(Restrictions.lt("businessState", 2))
				.list();
		return businesses;
	}
}
