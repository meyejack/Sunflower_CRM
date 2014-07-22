package sunflower.user.action;

import org.apache.struts2.ServletActionContext;

import sunflower.user.entity.User;
import sunflower.user.service.UserService;
import sunflower.user.service.impl.UserServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;// 当前用户
	private UserService userService;
	private String message;

	public UserAction() {
		userService = (UserService) ServletActionContext.getRequest()
				.getSession().getAttribute("userService");
		if (userService == null) {
			userService = new UserServiceImpl();
			ServletActionContext.getRequest().getSession()
					.setAttribute("userService", userService);
		}
		setUser((User) ServletActionContext.getRequest().getSession()
				.getAttribute("currentUser"));
	}

	// 查看个人信息
	public String viewInfo() {
		message = null;
		return "personalinfo";

	}

	public String save() {
		System.out.println("UserAction--save:" + user.getUserId() + " "
				+ user.getUserAccount() + " " + user.getUserDepartment() + " "
				+ user.getUserPassword() + " " + user.getUserLevel() + " "
				+ user.getUserState());
		boolean result = userService.updateUser(user);
		if (result == true) {
			message = "保存成功";
			user = userService.getUser(user.getUserId());
			// 更新session里的用户对象
			ServletActionContext.getRequest().getSession()
					.setAttribute("currentUser", user);
		} else {
			message = "保存失败,请重试";
			user = (User) ServletActionContext.getRequest().getSession()
					.getAttribute("currentUser");
		}

		return "personalinfo";

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
