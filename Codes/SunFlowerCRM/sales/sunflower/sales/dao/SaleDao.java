package sunflower.sales.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import sunflower.sales.entity.Sale;
import sunflower.user.entity.User;
import sunflower.util.support.HibernateUtil;

public class SaleDao {
	private Session session;

	// 添加Sale 已测
	public boolean saveSale(Sale sale) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			sale.setSalesId("000000000000000000000000000000000000");
			session.save(sale);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 获取Sale by id 已测
	public Sale getSale(String saleID) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Sale sale = (Sale) session.get(Sale.class, saleID);
		return sale;
	}

	// 修改Sale 已测
	public boolean updateSale(Sale sale) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.update(sale);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	// 终止Sale 已测
	public boolean dropSale(Sale sale) {
		sale.setSalesState(2);
		return updateSale(sale);
	}

	// 销售机会状态 取值范围为：0：未分配，1：已指派，2：已删除，
	// 获取可用的机会,包括未指派与已指派 已测
	public List<Sale> getAvailSales() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Sale> availSales = (List<Sale>) session.createCriteria(Sale.class)
				.add(Restrictions.lt("salesState", 2)).list();
		return availSales;
	}

	// 获取未指派的机会 已测
	public List<Sale> getFreeSales() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Sale> sales = (List<Sale>) session.createCriteria(Sale.class)
				.add(Restrictions.eq("salesState", 0)).list();
		return sales;
	}

	// 获取已指派的机会 已测
	public List<Sale> getAppointedSales() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Sale> sales = (List<Sale>) session.createCriteria(Sale.class)
				.add(Restrictions.eq("salesState", 1)).list();
		return sales;
	}
	
	//获取被指派的销售机会--客户经理
	public List<Sale> getManagerSales(User user) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Sale> sales = (List<Sale>) session.createCriteria(Sale.class)
				.add(Restrictions.eq("salesState", 1)).add(Restrictions.eq("user2", user)).list();
		return sales;
	}
	

}
