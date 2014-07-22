<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新建客户开发计划</title>
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
									>> </a><a href="sale_viewPlanlist.action">开发计划列表>></a>新建客户开发计划
							</h2>
						</div>
						<!-- End Box Head -->

						<form action="plan_save.action" method="post">
							<s:hidden name="sale.salesId" />
							<!-- Form -->
							<div class="form">
								<h2>销售机会详细信息</h2>
								<p></p>
								<p>
									<span class="req">不多于64字符</span>销售机会客户*
									<s:textfield readOnly="true" name="sale.salesCustomerName"
										cssClass="field size1" />
								</p>
								<p>
									<span class="req">不多于64字符</span>机会来源
									<s:textfield readOnly="true" name="sale.salesSource"
										cssClass="field size1" />
								</p>
								<p>
									<span class="req">不多于64字符</span>概要*
									<s:textfield readOnly="true" name="sale.salesBriefIntro"
										cssClass="field size1" />
								</p>
								<p>
									成功机率*
									<s:textfield readOnly="true" name="sale.salesSuccessProb"
										cssClass="field size1" />
								</p>
								<p>
									创建人
									<s:textfield readOnly="true" name="sale.user1.userName"
										cssClass="field size1" />
								</p>
								<p class="inline-field">创建日期</p>
								<p>
									指派人
									<s:textfield readOnly="true" name="sale.user2.userName"
										cssClass="field size1" />
								</p>
								<p>
									<label>机会描述*<span></span></label>
									<s:textarea readOnly="true" name="sale.salesDescription"
										cssClass="field size1"></s:textarea>
								</p>
								</br>


								<h2>制定计划</h2>
								</br>
<!-- 								<form> -->
									<s:itertor value="scheduleItemlist">
										<li><input type="text" readonly> <s:property
												value="scheduleContent" /> </input> <input name="textfield6"
											type="text" disabled id="textfield6" readonly> <s:property
												value="scheduleTime" /> </input></li>
									</s:itertor>
									<li><input name="textfield7" type="text" disabled
										id="textfield7" value="2017-9-19" readonly><input
										name="textfield8" type="text" disabled id="textfield8"
										value="贩卖逍遥升级版" readonly></li>
<!-- 								</form> -->
								<br> --------------------------
								<p>
<!-- 								<form id="planItem"> -->
									日期* <input name="textfield3" type="text" id="textfield3">
									计划项* <input name="textfield4" type="text" id="textfield4">
									<a href=""><input type="submit"
										class="button" value="添加项" /></a>
<!-- 								</form> -->
								</p>



							</div>
							<!-- End Form -->

							<!-- Form Buttons -->
							<div class="buttons">
								<a href="plan_saveCreate.action"><input
									type="submit" class="button" value="保存计划" /></a>
							</div>
							<!-- End Form Buttons -->
						</form>
					</div>
					<!-- End Box -->

				</div>
				<!-- End Content -->


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