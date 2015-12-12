<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ attribute name="title" required="false" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="body" fragment="true" required="true" %>

<html>
<head><title>Hello</title></head>
<body bgcolor="white">
<h2>my name is Duke. What’s yours?</h2>
<%--  <c:set var="greeting" value="Hello" /> --%>
<%--  <h2>${greeting}, my name is Duke. What’s yours?</h2> --%>
<!-- <form method="get"> -->
<!-- <input type="text" name="username" size="25"> -->
<!-- <p></p> -->
<!-- <input type="submit" value="Submit"> -->
<!-- <input type="reset" value="Reset"> -->
<!-- </form> -->

<%-- <c:if test="${fn:length(param.username) > 0}" > --%>
<%--     <h:response greeting="${greeting}" --%>
<%--         name="${param.username}"/></c:if> --%>

<!-- page body -->
<jsp:invoke fragment="body"/>

</body>
</html>