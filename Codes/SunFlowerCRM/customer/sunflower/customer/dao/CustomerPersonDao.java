package sunflower.customer.dao;

import org.hibernate.Session;

import sunflower.customer.entity.CustomerPerson;
import sunflower.util.support.HibernateUtil;

public class CustomerPersonDao {
	private Session session;

	// 获取客户联系人by id
	public CustomerPerson getCustomerPerson(String customerPersonID) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		CustomerPerson customerPerson = (CustomerPerson) session.get(
				CustomerPerson.class, customerPersonID);
		return customerPerson;
	}

	// 添加客户联系人
	public boolean saveCustomerPerson(CustomerPerson customerPerson) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			customerPerson
					.setCustomerPersonId("000000000000000000000000000000000000");
			session.save(customerPerson);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 修改客户联系人
	public boolean updateCustomerPerson(CustomerPerson customerPerson) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.update(customerPerson);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}

		return true;
	}

	// 删除客户联系人
	public boolean deleteCustomerPerson(CustomerPerson customerPerson) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.delete(session.load(CustomerPerson.class,
					customerPerson.getCustomerPersonId()));
			session.getTransaction().commit();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

}
