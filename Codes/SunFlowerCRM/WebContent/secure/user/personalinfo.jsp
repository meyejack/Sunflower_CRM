<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人信息</title>
<link rel="stylesheet" href="http://localhost:8080/SunFlowerCRM/secure/user/css/style.css"
	type="text/css" media="all" />
<link rel="stylesheet" href="http://localhost:8080/SunFlowerCRM/secure/common/css/topNavigation.css"
	type="text/css" />
<link rel="stylesheet" href="http://localhost:8080/SunFlowerCRM/secure/common/css/footer.css"
	type="text/css" />
<link rel="stylesheet" href="http://localhost:8080/SunFlowerCRM/secure/user/css/style.css" type="text/css"
	media="all" />
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
							<h2>个人信息</h2>
						</div>
						<!-- End Box Head -->

						<form action="user_save.action" method="post">
							<s:if test="message!=null">
								<label>提示：</label>
								<s:property value="message" />
							</s:if>
							<!-- Form -->
							<div class="form">
								<p>

									用户名
									<s:textfield name="user.userName" cssClass="field size1"></s:textfield>
									<!-- 																		 <input type="text" class="field size1" value="李黛娜" /> -->
								</p>
								<p>
									部门
									<s:textfield readonly="true" name="user.userDepartment"
										cssClass="field size1"></s:textfield>
									<!-- 									<input type="text" class="field size1" value="产品营销部门" /> -->
								</p>
								<p>
									职位
									<s:if test="user.userLevel==1">
										<input type="text" readonly="true" class="field size1"
											value="客户经理" />
										<%-- 										<s:textfield readonly="true" name="user.userLevel" --%>
										<%-- 											cssClass="field size1" value="客户经理" /> --%>
									</s:if>
									<s:else>
										<input type="text" readonly="true" class="field size1"
											value="销售主管" />
										<%-- 										<s:textfield readonly="true" name="user.userLevel" --%>
										<%-- 											cssClass="field size1" value="销售主管" /> --%>
									</s:else>
									<!-- <input type="text" class="field size1" value="客户经理" /> -->
								</p>
								<%-- 								<p>${user.userLevel==1?'客户经理':'销售主管' }</p> --%>
								<p>
									联系电话
									<s:textfield name="user.userTelephone" cssClass="field size1" />
									<!-- 									<input name="textfield" type="text" id="textfield" -->
									<!-- 										value="13810414444"> -->

								</p>
								<p>
									邮箱
									<s:textfield name="user.userAccount" cssClass="field size1" />
									<!-- 										 <input name="textfield2" -->
									<!-- 										type="text" id="textfield2" value="lidaina@mailme.com"> -->
								</p>


							</div>
							<!-- End Form -->

							<!-- Form Buttons -->
							<div class="buttons">

								<a href="#"><input type="submit" class="button" value="保存" /></a>
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