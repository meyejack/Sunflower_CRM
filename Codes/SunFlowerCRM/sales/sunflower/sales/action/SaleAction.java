package sunflower.sales.action;

import java.util.ArrayList;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import sunflower.sales.entity.Plan;
import sunflower.sales.entity.Sale;
import sunflower.sales.service.SaleService;
import sunflower.sales.service.impl.SaleServiceImpl;
import sunflower.user.entity.User;
import sunflower.user.service.UserService;
import sunflower.user.service.impl.UserServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class SaleAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SaleService saleService;
	private UserService userService;
	private User currentUser;
	private String managerID;
	private Sale sale;// 销售机会
	private ArrayList<Sale> saleslist;
	private ArrayList<User> managerlist;
	private String[] checkbox;

	public SaleAction() {
		saleService = (SaleService) ServletActionContext.getRequest()
				.getSession().getAttribute("saleService");
		if (saleService == null) {
			saleService = new SaleServiceImpl();
			ServletActionContext.getRequest().getSession()
					.setAttribute("saleService", saleService);
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

	// 进入销售机会列表
	public String viewChancelist() {
		// 判断是主管还是经理。主管进入销售机会管理页面，管理所有机会，可以创建机会。经理进入指派的销售机会列表页面。
		if (currentUser.getUserLevel() == 2) {
			saleslist = (ArrayList<Sale>) saleService.getAvailSales();
			return "chancelist";
		} else {
			saleslist = (ArrayList<Sale>) saleService
					.getManagerSales(currentUser);
			return "designatedChanceList";
		}

	}

	// 主管 进入创建机会页面
	public String addChance() {
		return "createChance";
	}

	// 主管 创建机会保存
	public String saveChance() {
		sale.setUser1(currentUser);
		sale.setUser2(currentUser);// 数据库自动设为未指派
		sale.setSalesCreateTime(new Date());
		sale.setSalesState(0);
		boolean result = saleService.addSale(sale);
		if (result == false)
			addActionMessage("<script>alert('创建失败！请检查输入是否完整');</script>");
		else
			addActionMessage("<script>alert('创建成功！');</script>");
		saleslist = (ArrayList<Sale>) saleService.getAvailSales();
		return "chancelist";
	}

	// 主管 删除机会
	public String delete() {
		System.out.println("sale-delete:" + sale.getSalesId());
		sale = saleService.getSale(sale.getSalesId());
		System.out.println("sale-delete:" + sale.getSalesCustomerName() + " "
				+ sale.getSalesBriefIntro());
		boolean result = saleService.dropSale(sale);
		System.out.println("sale-delete result:" + result);
		if (result == false)
			addActionMessage("<script>alert('删除失败，请重试');</script>");
		else
			addActionMessage("<script>alert('删除成功！');</script>");
		// return "viewChancelist";
		saleslist = (ArrayList<Sale>) saleService.getAvailSales();
		return "chancelist";
	}

	// 主管 批量删除机会
	public String deleteSelectedChances() {
		for(int i = 0;i<checkbox.length;i++)
			System.out.println("checkbox "+(i+1)+ "  :"+checkbox[i]);
		saleslist = (ArrayList<Sale>) saleService.getAvailSales();
		return "chancelist";
	}

	// 主管 进入编辑机会页面
	public String viewEdit() {
		System.out.println("sale-edit:" + sale.getSalesId());
		sale = saleService.getSale(sale.getSalesId());
		return "editChance";
	}

	// 主管 编辑保存
	public String saveEdit() {
		Sale one = saleService.getSale(sale.getSalesId());
		one.setSalesCustomerName(sale.getSalesCustomerName());
		one.setSalesSource(sale.getSalesSource());
		one.setSalesBriefIntro(sale.getSalesBriefIntro());
		one.setSalesContactPerson(sale.getSalesContactPerson());
		one.setSalesContactTel(sale.getSalesContactTel());
		one.setSalesSuccessProb(sale.getSalesSuccessProb());
		one.setSalesDescription(sale.getSalesDescription());

		boolean result = saleService.updateSale(one);
		if (result == false) {
			addActionMessage("<script>alert('保存失败，请重试');</script>");
			return "editChance";
		} else {
			addActionMessage("<script>alert('保存成功！');</script>");
			// return "viewChancelist";
			saleslist = (ArrayList<Sale>) saleService.getAvailSales();
			return "chancelist";
		}
	}

	// 主管 进入指派页面
	public String viewDesignate() {
		managerlist = (ArrayList<User>) userService.getManagers();
		sale = saleService.getSale(sale.getSalesId());
		return "designate";
	}

	// 主管 指派并保存
	public String saveDesignate() {
		System.out.println("sale-saveDesignate:" + managerID);

		sale = saleService.getSale(sale.getSalesId());
		User u = userService.getUser(managerID);
		u.addSales2(sale);// 需要保持数据一致性
		sale.setUser2(u);
		sale.setSalesState(1);// 已分配
		boolean result = saleService.updateSale(sale);
		System.out.println("saveDesignate result " + result);
		if (result == false) {
			addActionMessage("<script>alert('指派失败，请重试');</script>");
			return "viewDesignate";
		} else {
			addActionMessage("<script>alert('指派成功！');</script>");
			saleslist = (ArrayList<Sale>) saleService.getAvailSales();
			return "chancelist";
		}
	}

	// 进入查看机会详情页面
	public String viewDetail() {
		System.out.println("sale-detail:" + sale.getSalesId());
		sale = saleService.getSale(sale.getSalesId());
		return "detailInfo";
	}

	// 进入开发计划列表页面
	public String viewPlanlist() {
		// 主管
		if (currentUser.getUserLevel() == 2) {
			saleslist = (ArrayList<Sale>) saleService.getAppointedSales();
			return "planListforDirector";
		} else {// 经理
			saleslist = (ArrayList<Sale>) saleService
					.getManagerSales(currentUser);
			return "planListforManager";
		}

	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public ArrayList<Sale> getSaleslist() {
		return saleslist;
	}

	public void setSaleslist(ArrayList<Sale> saleslist) {
		this.saleslist = saleslist;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}

	public String getManagerID() {
		return managerID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	public ArrayList<User> getManagerlist() {
		return managerlist;
	}

	public void setManagerlist(ArrayList<User> managerlist) {
		this.managerlist = managerlist;
	}
}
