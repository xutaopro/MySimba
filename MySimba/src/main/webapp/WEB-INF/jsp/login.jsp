<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
#loginBtnBg {
	width: 44px;
	height: 44px;
	margin-top: 101px;
	margin-bottom: 101px;
	float: left;
	cursor: pointer;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/login/login" method="post">
		<span>账号</span><input type="text" id="userName" name="userName" value="${userName }" />
		<span>密 码</span><input type="text" value="${password }" id="password" name="password" />
		<input type="submit" value="登录" id="login" />
		<div id="tip" style="color: red">${errMsg}</div>
	</form>
</body>
</html>