package sunflower.sales.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import sunflower.sales.entity.Plan;
import sunflower.user.entity.User;
import sunflower.util.support.HibernateUtil;

public class PlanDao {
	private Session session;

	// 获取plan 已测
	public Plan getPlan(String planid) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Plan plan = (Plan) session.get(Plan.class, planid);
		return plan;
	}

	// 添加Plan 已测
	public boolean savePlan(Plan plan) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			plan.setPlanId("000000000000000000000000000000000000");
			session.save(plan);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 修改Plan 已测
	public boolean updatePlan(Plan plan) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.update(plan);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 开发计划标志位，0:初建，1:执行中，2:完成，3：终止开发
	// 终止Plan 已测
	public boolean dropPlan(Plan plan) {
		plan.setPlanState(3);
		return updatePlan(plan);
	}

	// 获取所有未删除计划
	public List<Plan> getAvailPlans() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Plan> availPlans = (List<Plan>) session.createCriteria(Plan.class)
				.add(Restrictions.lt("planState", 3)).list();
		return availPlans;
	}

	//获取经理的所有计划
	public List<Plan> getManagerAvailPlans(User user) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Plan> availPlans = (List<Plan>) session.createCriteria(Plan.class)
				.add(Restrictions.lt("planState", 3)).add(Restrictions.eq("sale.user2", user)).list();
		return availPlans;
	}

}
