package sunflower.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import sunflower.customer.entity.Customer;
import sunflower.util.support.HibernateUtil;

public class CustomerDao {
	private Session session;

	// 获取客户by id
	public Customer getCustomer(String customerID) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, customerID);
		return customer;
	}

	// 添加客户
	public boolean saveCustomer(Customer customer) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			customer.setCustomerId("000000000000000000000000000000000000");
			session.save(customer);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 修改客户
	public boolean updateCustomer(Customer customer) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.update(customer);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}

		return true;
	}

	// 客户状态，  0:正常，1:申报流失，2：确认预警；3:流失暂缓，4：确认流失

	// 解除客户关系（流失客户）
	public boolean dropCustomer(Customer customer) {
		customer.setCustomerState(4);
		updateCustomer(customer);
		return true;
	}

	// 获取客户列表  未流失的客户
	public List<Customer> getNotLostCustomers() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Customer> customers = (List<Customer>) session
				.createCriteria(Customer.class)
				.add(Restrictions.lt("customerState", 4))
				.list();
		return customers;
	}
	// 获取客户列表 申报流失的客户
	public List<Customer> getMayLostCustomers() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Customer> customers = (List<Customer>) session
				.createCriteria(Customer.class)
				.add(Restrictions.eq("customerState", 1))
				.list();
		return customers;
	}
	// 获取客户列表 预警的客户
	public List<Customer> getWarnCustomers() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Customer> customers = (List<Customer>) session
				.createCriteria(Customer.class)
				.add(Restrictions.eq("customerState", 2))
				.list();
		return customers;
	}
	
	// 获取客户列表 流失暂缓的客户
	public List<Customer> getLostPauseCustomers() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Customer> customers = (List<Customer>) session
				.createCriteria(Customer.class)
				.add(Restrictions.eq("customerState", 3))
				.list();
		return customers;
	}
}
