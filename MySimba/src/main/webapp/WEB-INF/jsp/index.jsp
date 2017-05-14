<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<%@ include file="./common/header.jsp"%>
<%@ include file="./common/easyui.jsp"%>
<%@ include file="./common/ext.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/app/index.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/app/user.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/index.css" />
</head>
<body>

<script type="text/javascript">
		Ext.onReady(function() {
			Index.initMenuFrame("${sessUser.name}","<%=com.session.SessionUtil.isAdmin(session)%>");
		});
	</script>
	
</script>
</body>
</html>