<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:template title="Login">
<jsp:attribute name="body">


    <h1>Please log in</h1>
    <font color="red">${message}</font>
    <form:form id="loginForm" method="post" action="${baseUrl}/j_spring_security_check" modelAttribute="loginDTO">

    	            <form:label path="username">Enter your user-name</form:label>
    	            <form:input id="username" name="username" path="username" /><br>
    	            <form:label path="username">Please enter your password</form:label>
    	            <form:password id="password" name="password" path="password" /><br>
    	            <input type="submit" value="Submit" />
    	        </form:form>

</jsp:attribute>
</my:template>