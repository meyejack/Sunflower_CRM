package sunflower.customer.dao;

import org.hibernate.Session;

import sunflower.customer.entity.ContactRecord;
import sunflower.util.support.HibernateUtil;

public class ContactRecordDao {
	private Session session;

	// 获取交往记录by id
	public ContactRecord getContactRecord(String contactRecordID) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		ContactRecord contactRecord = (ContactRecord) session.get(
				ContactRecord.class, contactRecordID);
		return contactRecord;
	}

	// 添加交往记录
	public boolean saveContactRecord(ContactRecord contactRecord) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			contactRecord
					.setContactRecordId("000000000000000000000000000000000000");
			session.save(contactRecord);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 修改交往记录
	public boolean updateContactRecord(ContactRecord contactRecord) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.update(contactRecord);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}

		return true;
	}

	// 删除交往记录
	public boolean deleteContactRecord(ContactRecord contactRecord) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.delete(session.load(ContactRecord.class,
					contactRecord.getContactRecordId()));
			session.getTransaction().commit();
		} catch (Exception e) {
			return false;
		}

		return true;
	}
}
