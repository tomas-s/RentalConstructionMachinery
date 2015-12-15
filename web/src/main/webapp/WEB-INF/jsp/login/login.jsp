<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:template title="Login">
<jsp:attribute name="body">

   <h3><fmt:message key="login.msg"/></h3>
   <font color="red">${message}</font>
   <div style="width: 400px">
   <form:form id="loginForm" method="post" action="${pageContext.request.contextPath}/j_spring_security_check" modelAttribute="loginDTO">
      
      <fieldset class="form-group">
         <form:label path="username" for="username"><fmt:message key="login.username"/></form:label>
         <form:input id="username" name="username" path="username" class="form-control" />
      </fieldset>
      
      <fieldset class="form-group">
         <form:label path="username" for="password"><fmt:message key="login.password"/></form:label>
         <form:password id="password" name="password" path="password" class="form-control" />
      </fieldset>
      
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <input type="submit" class="btn btn-primary" value="Submit" />
   </form:form>
   </div>

</jsp:attribute>
</my:template>