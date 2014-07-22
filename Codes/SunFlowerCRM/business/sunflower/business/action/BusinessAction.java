package sunflower.business.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import sunflower.business.entity.Business;
import sunflower.business.service.BusinessService;
import sunflower.business.service.impl.BusinessServiceImpl;
import sunflower.user.entity.User;

import com.opensymphony.xwork2.ActionSupport;

public class BusinessAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private BusinessService businessService;

	private User currentUser;
	private String businessID;
	private Business business;// 销售机会
	private ArrayList<Business> businesslist;

	public BusinessAction() {
		businessService = (BusinessService) ServletActionContext.getRequest()
				.getSession().getAttribute("businessService");
		if (businessService == null) {
			businessService = new BusinessServiceImpl();
			ServletActionContext.getRequest().getSession()
					.setAttribute("businessService", businessService);
		}
		currentUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("currentUser");
	}

	// 进入服务列表
	public String viewBusinessList() {
		businesslist = (ArrayList<Business>) businessService
				.getAvailBusinesss();
		return "businessList";
	}

	// 查看服务详情
	public String viewBusinessDetails() {
		business = businessService.getBusiness(businessID);
		return "businessDetails";
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public ArrayList<Business> getBusinesslist() {
		return businesslist;
	}

	public void setBusinesslist(ArrayList<Business> businesslist) {
		this.businesslist = businesslist;
	}

	public String getBusinessID() {
		return businessID;
	}

	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}

}
