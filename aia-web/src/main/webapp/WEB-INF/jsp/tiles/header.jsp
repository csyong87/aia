<%@ include file="../tags.jsp"%>
<div class="logo-header">
	<a href="/aia-web/index.jsp" class="logolink"> <spring:message
			code="aia.login.logolink.message" />
	</a>
</div>
<sec:authorize access="isAuthenticated()">
	<div class="misc">
		<ul class="nav-menu">
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="/aia-web/settings.html">Administration</a>
				<ul>
					<li><a href="/aia-web/userManagement.html">User Management</a></li>
					<li><a href="/aia-web/systemManagement.html">System Management</a></li>
				</ul>
			</li>
			</sec:authorize>
			<li>
				<a href="/aia-web/myProfile.html">My Profile</a>
				<ul class="menu-box-small">
					<li><a href="/aia-web/myProfile.html">My Profile</a></li>
					<li><a href="/aia-web/logout.html">Logout</a></li>
				</ul>
			</li>
		</ul>
	</div>
</sec:authorize>