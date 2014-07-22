<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="sunflower.user.entity.*,java.util.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
<link rel="stylesheet" href="css/topNavigation.css" type="text/css"
	media="all" />
</head>

<body>
	<!-- Header -->
	<div id="header">
		<div class="shell">
			<!-- Logo + Top Nav -->
			<div id="top">
				<%
					User currentUser = null;
					currentUser = (User) session.getAttribute("currentUser");
				%>
				<div id="top-navigation">
					<%
						if (currentUser != null) {
					%>
					欢迎 <a href="user_viewInfo.action"><strong> <%=currentUser.getUserName()%>
					</strong></a> <span>|</span> <a href="http://localhost:8080/SunFlowerCRM/home.jsp">主页</a> <span>|</span> 设置 <span>|</span>
					<!-- 					<a href="login_logout.action">登出</a> -->
					<a href="http://localhost:8080/SunFlowerCRM/logout.jsp">登出</a>
					<%
						} else {
					%>
					<a href="login.jsp"><strong>登录</strong></a>
					<%
						}
					%>
				</div>

				<div id="navigation">
					<ul>
						<li><a href="http://localhost:8080/SunFlowerCRM/home.jsp" class="active"><span>主页</span></a>
						</li>
						<li><a href="#"><span>营销管理</span></a>
							<ul>
								<li><a href="sale_viewChancelist.action">销售机会管理</a></li>
								<li><a href="sale_viewPlanlist.action">客户开发计划管理(主管)</a></li>
								<li><a
									href="../sales/customerPlan-client manager/designatedChanceList.html">客户开发计划管理(客户经理)</a></li>
								<!-- 客户开发计划管理需要判断登录人的身份后分别根据不同角色跳转不同的页面 -->
							</ul></li>

						<li><a href="#"><span>客户管理</span></a>
							<ul>
								<li><a href="../customer/customerInfo/customerList.html">客户列表</a></li>
								<li><a
									href="../customer/customerLoss/clientListForYujing-XSZG.html">客户流失预警(主管)</a></li>
								<li><a
									href="../customer/customerLoss/clientListForYujing-KHJL.html">客户流失预警(客户经理)</a></li>
								<!-- 客户流失预警列表需要判断登录人的身份后分别根据不同角色跳转不同的页面 -->
								<li><a
									href="../customer/customerLoss/clientLiushiList.html">流失客户列表</a></li>
							</ul></li>

						<li><a href="#"><span>服务管理</span></a>
							<ul>
								<li><a href="../business/bussinessList.html">服务列表</a></li>
								<li><a href="../business/bussinessProcessList.html">服务处理</a></li>
								<li><a href="../business/bussinessFeedBackList.html">服务反馈</a></li>
								<li><a href="../business/bussinessFileList.html">服务归档</a></li>
							</ul></li>

						<li><a href="#"><span>统计报表</span></a>
							<ul>
								<li><a href="../statistic/cusCtributeAnalyze.html">客户贡献分析</a></li>
								<li><a href="../statistic/cusFormAnalyze.html">客户构成分析</a></li>
								<li><a href="../statistic/cusServiceAnalyze.html">客户服务分析</a></li>
								<li><a href="../statistic/cusLoseAnalyze.html">客户流失分析</a></li>
							</ul></li>

						<li><a href="#"><span>基础数据</span></a>
							<ul>
								<li><a href="#">数据字典管理</a></li>
								<li><a href="#">查询产品信息</a></li>
								<li><a href="#">查询库存</a></li>
							</ul></li>
						<li><a href="#"><span>用户角色管理</span></a>
							<ul>
								<li><a href="#">账号信息管理</a></li>
								<li><a href="#">账号创建</a></li>
								<li><a href="#">账号冻结</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
			<!-- End Logo + Top Nav -->

		</div>
	</div>
	<!-- End Header -->
</body>
</html>
