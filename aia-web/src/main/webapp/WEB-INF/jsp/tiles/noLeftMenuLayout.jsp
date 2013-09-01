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
	<div class="t-t">
		<span class="tt-l-corner"></span>
		<sec:authorize access="isAuthenticated()">
	        <span>
	            <ul class="nav-menu">
					<li><a href="/aia-web/dashboard.html">Dashboard</a></li>
					<li><a href="/aia-web/deployments.html">Deployments</a>
	                	<ul>
	                		<li><a href="/aia-web/createDeployment.html">Create Deployment</a></li>
	                	</ul>
	                </li>
	                <li><a href="/aia-web/reports.html">Reports</a>
	                	<ul>
	                		<li><a href="/aia-web/mwreport.html">Middleware</a></li>
	                		<li><a href="/aia-web/wcreport.html">Webcomm</a></li>
	                	</ul>
	                </li>
	            </ul>
	        </span>
        </sec:authorize>
		<span class="tt-r-corner"></span>
	</div>
	<div class="t-m">
		<div class="login-mainarea">
			<tiles:insertAttribute name="body" />
		</div>
		<div class="footer-info">
			<div>
				 This site is intended solely for use by TechM's authorized users. Use of this site is subject to the Legal Notices, Terms for Use and Privacy Statement located on this site. 
				 Use of the site by customers and partners, if authorized, is also subject to the terms of your contract(s) with TechM. 
				 Use of this site by TechM employees is also subject to company policies, including the Code of Conduct. 
				 Unauthorized access or breach of these terms may result in termination of your authorization to use this site and/or civil and criminal penalties.
			</div>
		</div>
	</div>
	<div class="t-b">
		<span class="tb-l-corner"></span>
		<span class="tb-r-corner"></span>
	</div>
</div>
<div class="aia-footer">
	<tiles:insertAttribute name="footer" />
</div>
</html>