<%@ include file="../tags.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<BASE
	HREF="http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/" />

<script type="text/javascript" src="scripts/jquery-1.10.2.js"></script>
<script type="text/javascript" src="scripts/jquery-ui-1.10.3.custom.js"></script>

<link rel="stylesheet" type="text/css" href="css/smoothness/jquery-ui-1.10.3.custom.css"></link>
<link rel="stylesheet" type="text/css" href="css/aia.css"></link>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<div class="aia-header">
	<tiles:insertAttribute name="header" />
</div>
<div class="main-container">
	<tiles:insertAttribute name="body" />
</div>
<div class="aia-footer">
	<tiles:insertAttribute name="footer" />
</div>
</html>