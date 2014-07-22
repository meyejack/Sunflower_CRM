<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>销售机会列表（主管）</title>
<link rel="stylesheet"
	href="http://localhost:8080/SunFlowerCRM/secure/sales/css/style.css"
	type="text/css" media="all" />
<link rel="stylesheet"
	href="http://localhost:8080/SunFlowerCRM/secure/common/css/topNavigation.css"
	type="text/css" />
<link rel="stylesheet"
	href="http://localhost:8080/SunFlowerCRM/secure/common/css/footer.css"
	type="text/css" />
<style type="text/css">
a:link {
	color: #1E046C;
}
</style>

</head>
<body>
	<!-- Header -->
	<s:actionmessage cssStyle="list-style-type:none;" escape="false" />
	<%@include file="../common/topNavigation.jsp"%>
	<!-- End Header -->

	<!-- Container -->
	<div id="container">
		<div class="shell">


			<br />
			<!-- Main -->
			<div id="main">
				<div class="cl">&nbsp;</div>

				<!-- Content -->
				<div id="content">

					<!-- Box -->
					<div class="box">
						<!-- Box Head -->
						<div class="box-head">
							<a href="http://localhost:8080/SunFlowerCRM/home.jsp">返回主页 >>
							</a>开发计划列表
							</h2>
							<div class="right">

								<input type="text" class="field small-field" /> <input
									type="submit" class="button" value="搜索" />
							</div>
						</div>
						<!-- End Box Head -->

						<!-- Table -->
						<div class="table">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<th width="55"><input type="checkbox" class="checkbox" /></th>
									<th width="164">名称</th>
									<th width="99">负责人</th>
									<th width="88">计划状态</th>
									<th width="281" class="ac">客户开发计划管理</th>
								</tr>
								<s:iterator value="saleslist">
									<tr>
										<td><s:checkbox name="checkbox" value="false"></s:checkbox></td>
										<td><h3>
												<a
													href="<s:url action="sale_viewDetail.action">
                                   			 					<s:param name="sale.salesId" value="salesId"></s:param>   
																</s:url>"><s:property
														value="salesBriefIntro" /></a>
											</h3></td>
										<td><s:property value="user2.userName" /></td>
										<td><s:if test="plans.size()<1">未制定</s:if> <s:elseif
												test="plans[0].planState==0">初建</s:elseif> <s:elseif
												test="plans[0].planState==1">执行中</s:elseif> <s:elseif
												test="plans[0].planState==2">完成</s:elseif> <s:elseif
												test="plans[0].planState==3">终止</s:elseif></td>
										<td><a class="ico del"
											href="<s:url action="plan_viewCreate.action">
                                   			 					<s:param name="sale.salesId" value="sale.salesId"></s:param>   
																</s:url>">创建</a>
											<a
											href="<s:url action="plan_viewEdit.action">
                                   			 					<s:param name="sale.salesId" value="salesId"></s:param>   
																</s:url>"
											class="ico edit">审核</a> <a
											href="<s:url action="plan_viewPlan.action">
                                   			 					<s:param name="sale.salesId" value="salesId"></s:param>   
																</s:url>"
											class="ico designate">查看</a> <a class="ico del"
											href="<s:url action="plan_delete.action">
                                   			 					<s:param name="sale.salesId" value="salesId"></s:param>   
																</s:url>">删除</a>
										</td>
									</tr>
								</s:iterator>

								<tr>
									<td><input type="checkbox" class="checkbox" /></td>
									<td>XJ001</td>
									<td><a href="detailinfo.html"><h3>采购笔记本电脑意向</h3></a></td>
									<td>开发完成</td>
									<td>陈一偲</td>
									<td><a href="makeMyPlan-sell manager.html"
										class="ico edit">创建</a><a href="editPlan-sell manager.html"
										class="ico edit">编辑</a><a href="checkPlan-sell manager.html"
										class="ico edit">查看 </a><a href="chanceList.html"
										class="ico del">删除</a></td>
								</tr>

							</table>


							<!-- Pagging -->
							<div class="pagging">
								<div class="left">显示 1-12 of 44</div>
								<div class="right">
									<a href="#">前一页</a> <a href="#">1</a> <a href="#">2</a> <a
										href="#">3</a> <a href="#">4</a> <a href="#">245</a> <span>...</span>
									<a href="#">下一页</a> <a href="#">查看所有</a>
								</div>
							</div>
							<!-- End Pagging -->

						</div>
						<!-- Table -->

					</div>
					<!-- End Box -->


				</div>
				<!-- End Content -->

				<!-- Sidebar -->
				<div id="sidebar">

					<!-- Box -->
					<div class="box">

						<!-- Box Head -->
						<div class="box-head">
							<h2>管理</h2>
						</div>
						<!-- End Box Head-->

						<div class="box-content">

							<!-- Sort -->
							<div class="sort">
								排序 <select class="field">
									<option value="">创建人</option>
									<option>状态</option>
									<option>指派人</option>
									<option>编号</option>
								</select>
							</div>
							<!-- End Sort -->

						</div>
					</div>
					<!-- End Box -->
				</div>
				<!-- End Sidebar -->

				<div class="cl">&nbsp;</div>
			</div>
			<!-- Main -->
		</div>
	</div>
	<!-- End Container -->

	<!-- Footer -->
	<%@include file="../common/footer.html"%>
	<!-- End Footer -->

</body>
</html>