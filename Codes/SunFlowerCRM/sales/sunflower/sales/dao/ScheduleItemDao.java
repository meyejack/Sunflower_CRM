package sunflower.sales.dao;

import org.hibernate.Session;

import sunflower.sales.entity.ScheduleItem;
import sunflower.util.support.HibernateUtil;

public class ScheduleItemDao {
	private Session session;

	// 添加ScheduleItem  
	public boolean saveScheduleItem(ScheduleItem scheduleItem) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			scheduleItem.setScheduleId("000000000000000000000000000000000000");
			session.save(scheduleItem);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 修改ScheduleItem  
	public boolean updateScheduleItem(ScheduleItem scheduleItem) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.update(scheduleItem);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 删除计划项
	public boolean deleteScheduleItem(ScheduleItem scheduleItem) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.delete(session.load(ScheduleItem.class,
					scheduleItem.getScheduleId()));
			session.getTransaction().commit();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	// 获取scheduleItem 此方法不需要
	public ScheduleItem getScheduleItem(String scheduleItemid) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		ScheduleItem scheduleItem = (ScheduleItem) session.get(
				ScheduleItem.class, scheduleItemid);
		return scheduleItem;
	}

}
