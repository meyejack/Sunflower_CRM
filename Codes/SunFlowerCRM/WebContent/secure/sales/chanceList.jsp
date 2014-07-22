<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>营销管理</title>
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
	<s:actionmessage cssStyle="list-style-type:none;" escape="false" />
	<%@include file="../common/topNavigation.jsp"%>

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
							<h2>
								<a href="http://localhost:8080/SunFlowerCRM/home.jsp">返回主页
									>> </a>销售机会列表
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
									<th width="37"><input type="checkbox" class="checkbox" /></th>
									<th width="65">客户</th>
									<th width="158">名称</th>
									<th width="87">创建日期</th>
									<th width="86">创建人</th>
									<th width="85">负责人</th>
									<th width="230" class="ac">Content Control</th>
								</tr>

								<s:iterator value="saleslist">

									<tr>
										<td><s:checkbox name="checkbox" value="false" fieldValue="salesId">
											</s:checkbox></td>
										<td><s:property value="salesCustomerName" /></td>
										<td><h3>
												<a
													href="<s:url action="sale_viewDetail.action">
                                   			 					<s:param name="sale.salesId" value="salesId"></s:param>   
																</s:url>"><s:property
														value="salesBriefIntro" /></a>
											</h3></td>
										<td><s:property value="salesCreateTime" /></td>
										<td><s:property value="user1.userName" /></td>
										<td><s:property value="user2.userName" /></td>
										<td><a class="ico del"
											href="<s:url action="sale_delete.action">
                                   			 					<s:param name="sale.salesId" value="salesId"></s:param>   
																</s:url>">删除</a>
											<a
											href="<s:url action="sale_viewEdit.action">
                                   			 					<s:param name="sale.salesId" value="salesId"></s:param>   
																</s:url>"
											class="ico edit">编辑</a> <s:if test="salesState==0">
												<a
													href="<s:url action="sale_viewDesignate.action">
                                   			 					<s:param name="sale.salesId" value="salesId"></s:param>   
																</s:url>"
													class="ico designate">指派</a>
											</s:if></td>

									</tr>

								</s:iterator>

							</table>


							<!-- Pagging -->
							<div class="pagging">
								<div class="left">显示 1-12 of 44</div>
								<div class="right">
									前一页<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a
										href="#">4</a> <a href="#">245</a> <span>...</span>下一页<a
										href="#">查看所有 </a>
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
							<h2>销售机会管理</h2>
						</div>
						<!-- End Box Head-->

						<div class="box-content">
							<a href="sale_addChance.action" target="_blank"
								class="add-button"><span>创建销售机会</span></a>
							<div class="cl">&nbsp;</div>

							<p class="select-all">
								<input type="checkbox" class="checkbox" /> 删除所有
							</p>
							<p>
								<a
									href="<s:url action="sale_deleteSelectedChances.action">
                                   			 					<s:param name="checkbox" value="checkbox"></s:param>   
																</s:url>">删除
									所选</a>
							</p>

							<!-- Sort -->
							<div class="sort">
								排序 <select class="field">
									<option value="">创建人</option>
									<option>创建日期</option>
									<option>编号</option>
									<option>指派人</option>
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