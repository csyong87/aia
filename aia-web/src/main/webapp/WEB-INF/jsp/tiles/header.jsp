<%@ include file="../tags.jsp"%>
<div class="logo-header">
	<a href="/aia-web/index.jsp" class="logolink"> <spring:message
			code="aia.login.logolink.message" />
	</a>
</div>
<sec:authorize access="isAuthenticated()">
	<div class="misc">
		<ul>
			<li><a href="/aia-web/settings.html">Settings</a></li>
			<li><a href="/aia-web/settings.html">My Profile</a></li>
		</ul>
	</div>
</sec:authorize>