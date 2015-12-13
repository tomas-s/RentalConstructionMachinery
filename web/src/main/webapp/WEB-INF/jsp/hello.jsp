<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<my:template title="Categories">
<jsp:attribute name="body">


    <h1>Hello - ${pageContext.request.userPrincipal.name}</h1>
    <h2><a href="${baseUrl}/j_spring_security_logout">Logout</a></h2>

</jsp:attribute>
</my:template>