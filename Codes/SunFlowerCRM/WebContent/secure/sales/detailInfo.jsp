<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>销售机会详细信息</title>
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
								<a href="http://localhost:8080/SunFlowerCRM/home.jsp">返回主页 >> </a><a
									href="sale_viewChancelist.action">销售机会列表 >></a>销售机会详细信息
							</h2>
						</div>
						<!-- End Box Head -->

						<form action="" method="post">

							<!-- Form -->
							<div class="form">
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
									联系人
									<s:textfield readOnly="true" name="sale.salesContactPerson"
										cssClass="field size1" />
								</p>
								<p>
									联系人电话
									<s:textfield readOnly="true" name="sale.salesContactTel"
										cssClass="field size1" />
								</p>
								<p>
									成功机率*
									<s:textfield readOnly="true" name="sale.salesSuccessProb"
										cssClass="field size1" />
								</p>
								<p>
									<span class="req">不多于100字符</span> <label>机会描述*<span></span></label>
									<s:textarea readOnly="true" name="sale.salesDescription"
										cssClass="field size1"></s:textarea>
									<!-- 									<textarea class="field size1" rows="10" cols="30"></textarea> -->
								</p>

							</div>
							<!-- End Form -->

							<!-- Form Buttons -->
							<div class="buttons"></div>
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