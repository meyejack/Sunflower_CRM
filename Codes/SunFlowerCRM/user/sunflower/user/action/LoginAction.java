package sunflower.user.action;

import org.apache.struts2.ServletActionContext;

import sunflower.user.entity.User;
import sunflower.user.service.UserService;
import sunflower.user.service.impl.UserServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -3830138203686167366L;
	private String username;
	private String password;
	private String message;
	private UserService userService;

	public LoginAction() {
		userService = (UserService) ServletActionContext.getRequest()
				.getSession().getAttribute("userService");
		if (userService == null) {
			userService = new UserServiceImpl();
			ServletActionContext.getRequest().getSession()
					.setAttribute("userService", userService);
		}
	}

	// 登录
	public String execute() {
		System.out
				.println("login action execute:" + username + "  " + password);
		User u = userService.login(username, password);

		if (u != null) {
			System.out.println("user:" + u.getUserId() + "  " + u.getUserName()
					+ "  " + u.getUserName());
			if (!password.equals(u.getUserPassword())) {
				this.message = "请检查密码";
				return "login";
			} else {
				this.message = null;
				ServletActionContext.getRequest().getSession()
						.setAttribute("currentUser", u);
				return "home";
			}
		} else {
			this.message = "请输入正确的用户名";
			return "login";
		}
	}

	//退出
	public String logout()
	{
		ServletActionContext.getRequest().getSession().invalidate();
		return "home";
	}
	

	/**
	 * structs2拦截器通过下列方法传递值
	 */
	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String passWord) {
		this.password = passWord;
	}

	public String getPassword() {
		return password;
	}

	public UserService getUserService() {
		return userService;
	}

	/**
	 * spring通过下列的方法注入userService
	 */
	public void setUserDao(UserService userService) {
		this.userService = userService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
