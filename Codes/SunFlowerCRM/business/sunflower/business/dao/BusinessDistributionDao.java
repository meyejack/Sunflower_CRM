package sunflower.business.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import sunflower.business.entity.Business;
import sunflower.business.entity.BusinessDistribution;
import sunflower.util.support.HibernateUtil;

public class BusinessDistributionDao {
	private Session session;

	// 获取服务分配by id
	public BusinessDistribution getBusinessDistribution(
			String businessDistributionID) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		BusinessDistribution businessDistribution = (BusinessDistribution) session
				.get(BusinessDistribution.class, businessDistributionID);
		return businessDistribution;
	}

	// 添加服务分配
	public boolean saveBusinessDistribution(
			BusinessDistribution businessDistribution) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			businessDistribution
					.setBusinessDistributionId("000000000000000000000000000000000000");
			session.save(businessDistribution);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 修改服务分配
	public boolean updateBusinessDistribution(
			BusinessDistribution businessDistribution) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.update(businessDistribution);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}

		return true;
	}

	// 服务分配状态，0：新创建，1：已分配，2：已处理，3：已归档，4.已停用
	// 获取所有可用服务分配
	public List<BusinessDistribution> getAllBusinessDistributions() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<BusinessDistribution> businessDistributions = (List<BusinessDistribution>) session
				.createCriteria(BusinessDistribution.class)
				.add(Restrictions.lt("businessDistributionState", 4)).list();
		return businessDistributions;
	}

	// 获取所有新创建服务分配
	public List<BusinessDistribution> getNewBusinessDistributions() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<BusinessDistribution> businessDistributions = (List<BusinessDistribution>) session
				.createCriteria(BusinessDistribution.class)
				.add(Restrictions.eq("businessDistributionState", 0)).list();
		return businessDistributions;
	}

	// 获取所有已分配服务分配
	public List<BusinessDistribution> getDistributedBusinessDistributions() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<BusinessDistribution> businessDistributions = (List<BusinessDistribution>) session
				.createCriteria(BusinessDistribution.class)
				.add(Restrictions.eq("businessDistributionState", 1)).list();
		return businessDistributions;
	}

	// 获取所有已处理服务分配
	@SuppressWarnings("unchecked")
	public List<BusinessDistribution> getDealedBusinessDistributions() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<BusinessDistribution> businessDistributions = (List<BusinessDistribution>) session
				.createCriteria(BusinessDistribution.class)
				.add(Restrictions.eq("businessDistributionState", 2)).list();
		return businessDistributions;
	}

	// 获取所有已归档服务分配
	public List<BusinessDistribution> getFinishedBusinessDistributions() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<BusinessDistribution> businessDistributions = (List<BusinessDistribution>) session
				.createCriteria(BusinessDistribution.class)
				.add(Restrictions.eq("businessDistributionState", 3)).list();
		return businessDistributions;
	}
}
