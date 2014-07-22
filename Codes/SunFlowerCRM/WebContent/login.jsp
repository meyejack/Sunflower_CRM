<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>login</title>
<link rel="stylesheet" href="resource/css/homeStyle.css" type="text/css"
	media="all" />
<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
<script src="js/jquery-func.js" type="text/javascript"></script>
</head>

<body>

	<div style="position: absolute; left: 650px; top: 413px">
		<form action="login_execute.action" method="post" name="form1"
			id="form1">

			<label><strong>Username</strong></label>
			<div align="right">
				<input type="text" id="username" name="username" length=16>
			</div>

			<label><strong>Password</strong></label>
			<div align="right">
				<input type="password" name="password" id="password" length=16>
			</div>
			<p>
				<s:property value="message" />
			</p>
			<button type="submit" class="btn btn-default">登录</button>
			<!-- 			<button style="background: url('resource/css/images/submit.gif');" -->
			<!-- 				class="btn btn-default" type="submit" /> -->
			<%-- 			<a href="login_execute.action?username=${username} "><img --%>
			<!-- 				src="resource/css/images/submit.gif" align="right"></img></a> -->
		</form>

	</div>
</body>
</html>
