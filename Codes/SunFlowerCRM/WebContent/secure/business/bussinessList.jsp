<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务列表</title>
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="../common/css/topNavigation.css"
	type="text/css" />
<link rel="stylesheet" href="../common/css/footer.css" type="text/css" />
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
							<h2 class="left">
								<a href="../../home.jsp">返回主页 >> </a>服务列表
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
									<th width="3%"><input type="checkbox" class="checkbox" /></th>
									<th width="8%">编号</th>
									<th width="20%">概要</th>
									<th width="8%">类型</th>
									<th width="13%">创建日期</th>
									<th width="8%">状态</th>
									<th width="8%">创建人</th>
									<th width="8%">指派人</th>
									<th width="22%" class="ac">操作</th>
								</tr>
								<s:iterator>
									<tr>
										<th><input type="checkbox" class="checkbox" /></th>
										<th>XJ001</th>
										<th><h3>
												<a href="BussinessDetails.html">采购笔记本电脑意向</a>
											</h3></th>
										<th>咨询</th>
										<th>2014-7-10</th>
										<th>已指派</th>
										<th>杨迪</th>
										<th>陈一偲</th>
										<th><a href="#" class="ico del">删除</a><a
											href="editBussiness.html" class="ico edit">编辑</a><a
											href="designateBussiness.html" class="ico designate">重指派</a></th>
									</tr>
								</s:iterator>
								<tr class="odd">
									<th><input type="checkbox" class="checkbox" /></th>
									<th>XJ002</th>
									<th><h3>
											<a href="BussinessDetails.html">采购高考答案意向</a>
										</h3></th>
									<th>咨询</th>
									<th>2014-7-10</th>
									<th>未指派</th>
									<th>卢宇勋</th>
									<th>&nbsp;</th>
									<th><a href="#" class="ico del">删除</a><a
										href="editBussiness.html" class="ico edit">编辑</a><a
										href="designateBussiness.html" class="ico designate">指派</a></th>
								</tr>
								<tr>
									<th><input type="checkbox" class="checkbox" /></th>
									<th>XJ003</th>
									<th><h3>
											<a href="BussinessDetails.html">炸学校意向</a>
										</h3></th>
									<th>咨询</th>
									<th>2014-7-10</th>
									<th>已指派</th>
									<th>郭凌云</th>

									<th>逍遥</th>
									<th><a href="#" class="ico del">删除</a><a
										href="editBussiness.html" class="ico edit">编辑</a><a
										href="designateBussiness.html" class="ico designate">重指派</a></th>
								</tr>
								<tr class="odd">
									<th><input type="checkbox" class="checkbox" /></th>
									<th>XJ004</th>
									<th><h3>
											<a href="BussinessDetails.html">踢爆路由器意向</a>
										</h3></th>
									<th>咨询</th>
									<th>2014-7-10</th>
									<th>未指派</th>
									<th>李黛娜</th>
									<th>&nbsp;</th>
									<th><a href="#" class="ico del">删除</a><a
										href="editBussiness.html" class="ico edit">编辑</a><a
										href="designateBussiness.html" class="ico designate">指派</a></th>
								</tr>
								<tr>
									<th><input type="checkbox" class="checkbox" /></th>
									<th>XJ005</th>
									<th><h3>
											<a href="BussinessDetails.html">贩卖逍遥意向</a>
										</h3></th>
									<th>咨询</th>
									<th>2014-7-10</th>
									<th>未指派</th>
									<th>逍遥</th>
									<th>&nbsp;</th>
									<th><a href="#" class="ico del">删除</a><a
										href="editBussiness.html" class="ico edit">编辑</a><a
										href="designateBussiness.html" class="ico designate">指派</a></th>
								</tr>
								<tr class="odd">
									<th><input type="checkbox" class="checkbox" /></th>
									<th>XJ006</th>
									<th><h3>
											<a href="BussinessDetails.html">采购踏马键盘意向</a>
										</h3></th>
									<th>咨询</th>
									<th>2014-7-10</th>
									<th>未指派</th>
									<th>陈一偲</th>
									<th>&nbsp;</th>
									<th><a href="#" class="ico del">删除</a><a
										href="editBussiness.html" class="ico edit">编辑</a><a
										href="designateBussiness.html" class="ico designate">指派</a></th>
								</tr>
								<tr>
									<th><input type="checkbox" class="checkbox" /></th>
									<th>XJ007</th>
									<th><h3>
											<a href="BussinessDetails.html">交大烛光老干妈促销</a>
										</h3></th>
									<th>咨询</th>
									<th>2014-7-10</th>
									<th>已指派</th>
									<th>项璟</th>
									<th>李黛娜</th>
									<th><a href="#" class="ico del">删除</a><a
										href="editBussiness.html" class="ico edit">编辑</a><a
										href="designateBussiness.html" class="ico designate">重指派</a></th>
								</tr>
								<tr class="odd">
									<th><input type="checkbox" class="checkbox" /></th>
									<th>XJ008</th>
									<th><h3>
											<a href="BussinessDetails.html">YF609空调投标</a>
										</h3></th>
									<th>咨询</th>
									<th>2014-7-10</th>
									<th>已指派</th>
									<th>张永昇大苞米</th>
									<th>郭凌云</th>
									<th><a href="#" class="ico del">删除</a><a
										href="editBussiness.html" class="ico edit">编辑</a><a
										href="designateBussiness.html" class="ico designate">重指派</a></th>
								</tr>
								<tr>
									<th><input type="checkbox" class="checkbox" /></th>
									<th>XJ009</th>
									<th><h3>
											<a href="BussinessDetails.html">采购贱嗒嗒冰激凌意向</a>
										</h3></th>
									<th>咨询</th>
									<th>2014-7-10</th>
									<th>未指派</th>
									<th>逍遥</th>
									<th>&nbsp;</th>
									<th><a href="#" class="ico del">删除</a><a
										href="editBussiness.html" class="ico edit">编辑</a><a
										href="designateBussiness.html" class="ico designate">指派</a></th>
								</tr>
								<tr class="odd">
									<th><input type="checkbox" class="checkbox" /></th>
									<th>XJ010</th>
									<th><h3>
											<a href="BussinessDetails.html">采购踏马终极版键盘意向</a>
										</h3></th>
									<th>咨询</th>
									<th>2014-7-10</th>
									<th>未指派</th>
									<th>陈一偲</th>
									<th>&nbsp;</th>
									<th><a href="#" class="ico del">删除</a><a
										href="editBussiness.html" class="ico edit">编辑</a><a
										href="designateBussiness.html" class="ico designate">指派</a></th>
								</tr>
								<tr>
									<th><input type="checkbox" class="checkbox" /></th>
									<th>XJ011</th>
									<th><h3>
											<a href="BussinessDetails.html">交大闪亮滴眼液促销</a>
										</h3></th>
									<th>咨询</th>
									<th>2014-7-10</th>
									<th>未指派</th>
									<th>项璟</th>
									<th>李黛娜</th>
									<th><a href="#" class="ico del">删除</a><a
										href="editBussiness.html" class="ico edit">编辑</a><a
										href="designateBussiness.html" class="ico designate">指派</a></th>
								</tr>
								<tr class="odd">
									<th><input type="checkbox" class="checkbox" /></th>
									<th>XJ012</th>
									<th><h3>
											<a href="BussinessDetails.html">YF609集体逃课意向</a>
										</h3></th>
									<th>咨询</th>
									<th>2014-7-10</th>
									<th>未指派</th>
									<th>张永昇大苞米</th>
									<th>郭凌云</th>
									<th><a href="#" class="ico del">删除</a><a
										href="editBussiness.html" class="ico edit">编辑</a><a
										href="designateBussiness.html" class="ico designate">指派</a></th>
								</tr>

							</table>


							<!-- Pagging -->
							<div class="pagging">
								<div class="left">显示 1-12 of 44</div>
								<div class="right">
									<a href="#">前一页</a> <a href="#">1</a> <a href="#">2</a> <a
										href="#">3</a> <a href="#">4</a> <a href="#">245</a> <span>...</span>
									<a href="#">后一页</a> <a href="#">查看所有</a>
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
							<a href="createBussiness.html" target="_blank" class="add-button"><span>创建服务</span></a>
							<div class="cl">&nbsp;</div>

							<p class="select-all">
								<input type="checkbox" class="checkbox" /><label>选择全部</label>
							</p>
							<p>
								<a href="#">删除所选</a>
							</p>

							<!-- Sort -->
							<div class="sort">
								排序 <select class="field">
									<option value="">服务类型</option>
									<option>创建日期</option>
									<option>创建人</option>
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