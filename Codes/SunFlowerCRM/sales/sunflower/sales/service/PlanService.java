package sunflower.sales.service;

import java.util.List;

import sunflower.sales.entity.Plan;

public interface PlanService {
	public Plan getPlan(String planid);

	public boolean addPlan(Plan plan);

	public boolean updatePlan(Plan plan);

	public boolean dropPlan(Plan plan);

	public List<Plan> getAvailPlans();
}
