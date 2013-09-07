<%@ include file="../tags.jsp" %>
<div class="logo-header">
    <a href="/aia-web/index.jsp" class="logolink"> <spring:message
            code="aia.login.logolink.message"/>
    </a>
</div>
<sec:authorize access="isAuthenticated()">
    <div class="misc">
        <ul class="nav-menu">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <c:forEach var="item" items="${sessionScope.adminFunctions}">
                    <menu:menu node="${item}"/>
                </c:forEach>
            </sec:authorize>
            <c:if test="${sessionScope.profile ne null}">
                <c:forEach var="item" items="${sessionScope.profile}">
                    <menu:menu node="${item}"/>
                </c:forEach>
            </c:if>
        </ul>
    </div>
</sec:authorize>