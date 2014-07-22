package sunflower.sales.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import sunflower.sales.entity.Plan;
import sunflower.sales.entity.Sale;
import sunflower.sales.entity.ScheduleItem;
import sunflower.sales.service.PlanService;
import sunflower.sales.service.SaleService;
import sunflower.sales.service.impl.PlanServiceImpl;
import sunflower.sales.service.impl.SaleServiceImpl;
import sunflower.user.entity.User;
import sunflower.user.service.UserService;
import sunflower.user.service.impl.UserServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class PlanAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private SaleService saleService;
	private PlanService planService;
	private User currentUser;
	private Sale sale;// 销售机会
	private Plan plan;
	private ArrayList<Plan> planlist;
	private ArrayList<ScheduleItem> scheduleItemlist;

	public PlanAction() {
		saleService = (SaleService) ServletActionContext.getRequest()
				.getSession().getAttribute("saleService");
		if (saleService == null) {
			saleService = new SaleServiceImpl();
			ServletActionContext.getRequest().getSession()
					.setAttribute("saleService", saleService);
		}
		planService = (PlanService) ServletActionContext.getRequest()
				.getSession().getAttribute("planService");
		if (planService == null) {
			planService = new PlanServiceImpl();
			ServletActionContext.getRequest().getSession()
					.setAttribute("planService", planService);
		}
		userService = (UserService) ServletActionContext.getRequest()
				.getSession().getAttribute("userService");
		if (userService == null) {
			userService = new UserServiceImpl();
			ServletActionContext.getRequest().getSession()
					.setAttribute("userService", userService);
		}
		currentUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("currentUser");
	}

	public String viewPlanlist() {
		planlist = (ArrayList<Plan>) planService.getAvailPlans();
		planlist.get(0);
		return "planListforDirector";
	}

	public String viewCreate() {
		sale = saleService.getSale(sale.getSalesId());
		// scheduleItemlist;
		return "createPlan";
	}

	public String viewPlan() {
		sale = saleService.getSale(sale.getSalesId());
		return "viewPlan";
	}

	public String viewEdit() {
		sale = saleService.getSale(sale.getSalesId());
		return "editPlan";
	}
	
	public String deletePlan() {
		sale = saleService.getSale(sale.getSalesId());
		plan = sale.getPlans().get(0);
		boolean result =planService.dropPlan(plan);
		return "viewPlanlist";
	}
}
