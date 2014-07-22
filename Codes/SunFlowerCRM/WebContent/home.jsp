<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="sunflower.user.entity.*,java.util.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>Sun Flower-CRM</title>
<link rel="stylesheet" href="resource/css/style.css" type="text/css"
	media="all" />
<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
<script src="js/jquery-func.js" type="text/javascript"></script>
</head>
<body>
	<div id="page" class="shell">
		<!-- Logo + Search + Navigation -->
		<div id="top">
			<div class="cl">&nbsp;</div>
			<h1 id="logo">
				<a href="#">Sun Flower</a>
			</h1>
			<%
				User currentUser = null;
				currentUser = (User) session.getAttribute("currentUser");
			%>
			<div id="top-navigation" class="alignright">
				<%
					if (currentUser != null) {
				%>
				欢迎 <a href="user_viewInfo.action"><strong> <%=currentUser.getUserName()%>
				</strong></a> <span>|</span> <a href="home.jsp">主页</a> <span>|</span> 设置 <span>|</span>
				<a href="login_logout.action">登出</a>
				<%
					} else {
				%>
				<a href="login.jsp"><strong>登录</strong></a>
				<%
					}
				%>
			</div>

			<div class="cl">&nbsp;</div>
			<div id="navigation">
				<ul>
					<li><a href="home.jsp" class="active"><span>Home</span></a></li>
					<li><a href="#"><span>营销管理</span></a>
						<ul>
							<li><a href="sale_viewChancelist.action">销售机会管理</a></li>
							<li><a href="sale_viewPlanlist.action">客户开发计划管理</a></li>
							<li><a
								href="YX-index1/KFJH-client manager/designatedChanceList.html">客户开发计划管理(客户经理)</a></li>
							<!-- 客户开发计划管理需要判断登录人的身份后分别根据不同角色跳转不同的页面 -->
						</ul></li>

					<li><a href="#"><span>客户管理</span></a>
						<ul>
							<li><a href="KHGL-zys/customerList.html">客户列表</a></li>
							<li><a href="KHLSGL-index/clientListForYujing-XSZG.html">客户流失预警(主管)</a></li>
							<li><a href="KHLSGL-index/clientListForYujing-KHJL.html">客户流失预警(客户经理)</a></li>
							<!-- 客户流失预警列表需要判断登录人的身份后分别根据不同角色跳转不同的页面 -->
							<li><a href="KHLSGL-index/clientLiushiList.html">流失客户列表</a></li>
						</ul></li>

					<li><a href="#"><span>服务管理</span></a>
						<ul>
							<li><a href="FW-index/bussinessList.html">服务列表</a></li>
							<li><a href="FW-index/bussinessProcessList.html">服务处理</a></li>
							<li><a href="FW-index/bussinessFeedBackList.html">服务反馈</a></li>
							<li><a href="FW-index/bussinessFileList.html">服务归档</a></li>
						</ul></li>

					<li><a href="#"><span>统计报表</span></a>
						<ul>
							<li><a href="KHLB-pages/cusCtributeAnalyze.html">客户贡献分析</a></li>
							<li><a href="KHLB-pages/cusFormAnalyze.html">客户构成分析</a></li>
							<li><a href="KHLB-pages/cusServiceAnalyze.html">客户服务分析</a></li>
							<li><a href="KHLB-pages/cusLoseAnalyze.html">客户流失分析</a></li>
						</ul></li>

					<li><a href="#"><span>基础数据</span></a>
						<ul>
							<li><a href="#">数据字典管理</a></li>
							<li><a href="#">查询产品信息</a></li>
							<li><a href="#">查询库存</a></li>
						</ul></li>
					<li><a href="#"><span>用户角色管理</span></a>
						<ul>
							<li><a href="#">账号信息查询</a></li>
							<li><a href="#">账号密码找回</a></li>
							<li><a href="#">账号密码修改</a></li>
							<li><a href="#">账号创建</a></li>
							<li><a href="#">账号冻结</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!-- END Logo + Search + Navigation -->
		<!-- Header -->
		<div id="header">
			<!-- Slider -->
			<div id="slider">
				<div id="slider-holder">
					<ul>
						<li>



							<div class="slide-image">
								<img src="resource/css/images/slider2.gif" alt="" />
							</div>
						</li>
						<li>

							<div class="slide-image">
								<img src="resource/css/images/slider1.gif" alt="" />
							</div>
						</li>
						<li>

							<div class="slide-image">
								<img src="resource/css/images/slider2.gif" alt="" />
							</div>
						</li>
					</ul>
				</div>
			</div>
			<!-- END Slider -->
		</div>
		<!-- END Header -->

		<!-- Main -->
		<div id="main">
			<!-- you can edit here -->
			<p>Welcome to Sunflower Client Relationship Management Sysytem.
			<p>
			<p>


				<!-- END of you edit Content -->
		</div>


		<!-- END Main -->
		<!-- Footer -->
		<div id="footer">
			<p class="right">
				&copy; 2014 - Sunflower group &nbsp; <a href="#" target="_blank"
					title="Sunflower">Home</a>
			<p>
				<a href="#">Home</a><span>&nbsp;</span><a href="#">About Us</a><span>&nbsp;</span><a
					href="#">Services</a><span>&nbsp;</span><a href="#">Solutions</a><span>&nbsp;</span><a
					href="#">Support</a><span>&nbsp;</span><a href="#">Partners</a><span>&nbsp;</span><a
					href="#">Contact</a>
			</p>
			<div class="cl">&nbsp;</div>
		</div>
		<!-- END Footer -->
		<br />
	</div>
</body>
</html>