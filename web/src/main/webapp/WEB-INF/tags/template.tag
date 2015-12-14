
<%@ tag pageEncoding="utf-8" dynamic-attributes="dynattrs" trimDirectiveWhitespaces="true" %>
<%@ attribute name="title" required="false" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="body" fragment="true" required="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head><title>Rental Construction Machinery</title></head>
<body bgcolor="white">
   <h2>Rental Construction Machinery</h2>
   <div>


   <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
     <ul class="nav navbar-nav">
           <!-- CUSTOMER -->
           <li >
<%--            class="<cc:if test="${section == 'flights'}">active</cc:if>" --%>
<!-- <fmt:message key="menu.customer"/> -->
              <a href="<c:url value='/customer/list'/>"><fmt:message key="menu.customer"/>customer</a></li>
           <!-- MACHINE -->
           <li><a href="<c:url value='/machine/list'/>">machine</a></li>
           <!-- HELLO -->
           <li><a href="<c:url value='/hello'/>">hello</a></li>
     </ul>
   </div>

   <!-- PAGE BODY -->
   <jsp:invoke fragment="body"/>
   
   </div>