package sunflower.customer.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import sunflower.customer.entity.CustomerLostPause;
import sunflower.util.support.HibernateUtil;

public class CustomerLostPauseDao {
	private Session session;

	// 添加客戶流失暂缓
	public boolean saveCustomerLostPause(CustomerLostPause customerLostPause) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			customerLostPause
					.setCustomerLostPauseId("000000000000000000000000000000000000");
			session.save(customerLostPause);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 修改客戶流失暂缓
	public boolean updateCustomerLostPause(CustomerLostPause customerLostPause) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.update(customerLostPause);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}

		return true;
	}

	// 获取所有流失暂缓 ----检查客户在流失暂缓状态
	public List<CustomerLostPause> getAllCustomerLostPauses() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<CustomerLostPause> all = (List<CustomerLostPause>) session
				.createCriteria(CustomerLostPause.class).list();
		List<CustomerLostPause> result = new ArrayList<CustomerLostPause> ();
		for(CustomerLostPause c :all){
			if(c.getCustomer().getCustomerState()==3)
				result.add(c);
		}
		return result;
	}
}
