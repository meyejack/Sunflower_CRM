package sunflower.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import sunflower.customer.entity.Customer;
import sunflower.customer.entity.HistoryRecord;
import sunflower.util.support.HibernateUtil;

public class HistoryRecordDao {
	private Session session;

	// 获取历史交易记录 by id
	public HistoryRecord getHistoryRecord(String historyRecordID) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		HistoryRecord historyRecord = (HistoryRecord) session.get(
				HistoryRecord.class, historyRecordID);
		return historyRecord;
	}

	// 获取客户的历史交易记录 按时间排序
	public List<HistoryRecord> getCustomerHistoryRecords(Customer customer) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<HistoryRecord> resords = (List<HistoryRecord>) session
				.createCriteria(HistoryRecord.class)
				.add(Restrictions.eq("customer", customer)).addOrder(Order.desc("historyRecordDate")).list();
		return resords;
	}

}
