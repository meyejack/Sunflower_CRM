package sunflower.sales.service.impl;

import java.util.List;

import sunflower.sales.dao.PlanDao;
import sunflower.sales.entity.Plan;
import sunflower.sales.service.PlanService;

public class PlanServiceImpl implements PlanService {
	PlanDao planDao = new PlanDao();

	@Override
	public Plan getPlan(String planid) {
		return planDao.getPlan(planid);
	}

	@Override
	public boolean addPlan(Plan plan) {
		return planDao.savePlan(plan);
	}

	@Override
	public boolean updatePlan(Plan plan) {
		return planDao.updatePlan(plan);
	}

	@Override
	public boolean dropPlan(Plan plan) {
		return planDao.dropPlan(plan);
	}

	@Override
	public List<Plan> getAvailPlans() {
		return planDao.getAvailPlans();
	}

}
