<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page
	import="sunflower.user.dao.*,sunflower.user.entity.*,java.util.*,sunflower.sales.dao.*,sunflower.sales.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>test</title>
</head>
<body>
<p>aaaaa</p>
	<%
		/*------------------------------UserDao----------------------------*/
		UserDao ud = new UserDao();
		/*---------get user-------------*/
		// 		User u = ud.getUser("b60c57b8-0a5c-11e4-9de8-1d1a2c8d4097");
		// 		User u = ud.getUser("卢宇勋", null);
		// 		List<Sale> userSales =  u.getSales1();
		// 		System.out.println("create sales:" + userSales);
		// 		for (Sale s : userSales) {
		// 			System.out.println("creator Sale: " + s.getSalesId() + " "
		// 					+ s.getSalesCustomerName() + " " + s.getSalesState()
		// 					+ "  creator:" + s.getUser1().getUserName()
		// 					+ "  responsible:" + s.getUser2().getUserName());
		// 		}
		/*---------add user-------------*/
		// 		User user = new User("kk@gmail.com", "CLD", 1, "Kay", "123",
		// 				0, "15639191176");
		// 						ud.saveUser(user);
		/*---------get managers-------------*/
		// 		ArrayList<User> users = (ArrayList<User>) ud.getManagers();
		// 		System.out.println("managers num:" + users.size());
		// 		for (User us : users) {
		// 			System.out.println("Manager: " + us.getUserName() + " "
		// 					+ us.getUserAccount());
		// 		}

		/*------------------------------SaleDao----------------------------*/
		SaleDao sd = new SaleDao();
		/*---------add sale-------------*/
		// 		Sale newsale = new Sale("介绍", "Jung", "45443671", "美丽心情网站小组",
		// 				"描述", "来源", 1, 50, u, u);
		// 				sd.saveSale(newsale);
		/*---------get sale-------------*/
		// 		Sale sale = sd.getSale("80438530-0a6a-11e4-9de8-1d1a2c8d4097");
		// 		System.out.println("get sale:" + sale.getSalesCustomerName()
		// 				+ " creator:" + sale.getUser1().getUserName());
		/*---------update sale-------------*/
		// 				sale.setSalesSource("这个机会来源");
		// 				sale.setSalesCustomerName("新创思源公司");
		// 				sd.updateSale(sale);
		/*---------drop sale-------------*/
		// 		Sale sale2 = sd.getSale("9a589829-0a6a-11e4-9de8-1d1a2c8d4097");
		// 		sd.dropSale(sale2);
		/*---------get available sales-------------*/
		// 		ArrayList<Sale> asales = (ArrayList<Sale>) sd.getAvailSales();
		// 		System.out.println("available sales num:" + asales.size());
		// 		for (Sale s : asales) {
		// 			System.out.println("Sale: " + s.getSalesId() + " "
		// 					+ s.getSalesCustomerName() + " " + s.getSalesState()
		// 					+ "  creator:" + s.getUser1().getUserName()
		// 					+ "  responsible:" + s.getUser2().getUserName());
		// 		}
		/*---------get appointed sales-------------*/
		// 		ArrayList<Sale> sales = (ArrayList<Sale>) sd.getAppointedSales();
		// 		System.out.println("appointed sales num:" + sales.size());
		// 		for (Sale s : sales) {
		// 			System.out.println("Sale: " + s.getSalesId() + " "
		// 					+ s.getSalesCustomerName() + " " + s.getSalesState());
		// 		}
		/*---------get free sales-------------*/
		// 		ArrayList<Sale> fsales = (ArrayList<Sale>) sd.getFreeSales();
		// 		System.out.println("appointed sales num:" + fsales.size());
		// 		for (Sale s : fsales) {
		// 			System.out.println("Sale: " + s.getSalesId() + " "
		// 					+ s.getSalesCustomerName() + " " + s.getSalesState());
		// 		}
		/*------------------------------PlanDao----------------------------*/
		PlanDao pd = new PlanDao();
		/*---------add plan-------------*/
		// 		Sale sale = sd.getSale("c587e49a-0a69-11e4-9de8-1d1a2c8d4097");
		// 		System.out.println("get sale:" + sale.getSalesCustomerName()
		// 				+ " creator:" + sale.getUser1().getUserName());
		// 		Plan plan = new Plan(sale);
		// 		pd.savePlan(plan);
		/*---------get plan-------------*/
		Plan p = pd.getPlan("000000000000000000000000000000000000");
		System.out.println("get plan:" + p.getPlanDate()
				+ "   responsible:" + p.getSale().getUser2().getUserName());
		/*---------update plan-------------*/
// 		p.setPlanState(1);
// 		pd.updatePlan(p);
		/*---------drop plan-------------*/
// 		pd.dropPlan(p);
	%>
</body>
</html>