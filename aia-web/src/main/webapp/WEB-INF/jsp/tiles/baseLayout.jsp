<%@ include file="../tags.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<BASE
	HREF="http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/" />

<script type="text/javascript" src="scripts/jquery-1.10.2.js"></script>
<script type="text/javascript" src="scripts/jquery-ui-1.10.3.custom.js"></script>

<link rel="stylesheet" type="text/css"
	href="css/jquery-ui-1.10.3.custom.css"></link>
<link rel="stylesheet" type="text/css" href="css"></link>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body class="tundra">
	<table width="980">
		<tbody>
			<tr>
				<td><tiles:insertAttribute name="header" /></td>
			</tr>
			<tr valign="top">
				<td>
					<table width="100%">
						<tr valign="top">
							<td class="leftmenu" valign="top">
								<tiles:insertAttribute name="menu" />
							</td>
							<td class="mainbody" valign="top">
								<tiles:insertAttribute name="body" />
							</td>
						</tr>
						<tr>
							<td colspan="2"><tiles:insertAttribute name="footer" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>