<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<my:template title="Categories">
<jsp:attribute name="body">


    <h1>Hello - ${pageContext.request.userPrincipal.name}</h1>
    Details: <sec:authentication property="principal" />

    <form method="post" action="${pageContext.request.contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout" />
    </form>

</jsp:attribute>
</my:template>