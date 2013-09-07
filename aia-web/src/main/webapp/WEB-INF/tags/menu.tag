<%@tag description="display the whole Menu Tree" pageEncoding="UTF-8" %>
<%@attribute name="node" type="com.techmahindra.aia.model.FunctionInfo" required="true" %>
<%@taglib prefix="menu" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<li><a href="${node.url}">${node.name}</a>
    <c:if test="${node.children ne null && fn:length(node.children) > 0}">
        <ul class="menu-box-small">
            <c:forEach var="child" items="${node.children}">
                <li><a href="${child.url}">${child.name}</a></li>
            </c:forEach>
        </ul>
    </c:if>
</li>