<%@ tag pageEncoding="utf-8" dynamic-attributes="dynattrs" trimDirectiveWhitespaces="true" %>
<%@ attribute name="title" required="false" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="body" fragment="true" required="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>

<!DOCTYPE html>
<%-- <html lang="${pageContext.request.locale}"> --%>
<head>
    <title>Rental Construction Machinery</title>
	
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><c:out value="${title}"/></title>
    <!-- bootstrap loaded from content delivery network -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" crossorigin="anonymous">

</head>

<body bgcolor="white">
<sec:authentication property="principal" var="user" />
<div class="container">
   
   <h1>Rental Construction Machinery</h1>
  
   <!-- MENU can see only authenticated user -->
   <sec:authorize access="isAuthenticated()"> 
      <nav class="navbar navbar-inverse" role="navigation">
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
         <ul class="nav navbar-nav">
            
            <!-- HELLO -->
            <li><a href="<c:url value='/hello'/>"><fmt:message key="menu.hello"/></a></li>
            
            <!-- CUSTOMER -->
            <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="menu.customer"/></a>
               <ul class="dropdown-menu">
                  <sec:authorize access="hasAnyRole('ROLE_ADMIN')"  >
                  <li><a href="<c:url value='/customer/list'/>"><fmt:message key="menu.customer.list"/></a></li>
                  </sec:authorize>
                  <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
   				  <li><a href="<c:url value='/customer/detail/${user.id}'/>"><fmt:message key="menu.customer.detail"/></a></li>
   				  </sec:authorize>
   		       </ul>
            </li>
            
            <!-- MACHINE -->
            <li><a href="<c:url value='/machine/list'/>"><fmt:message key="menu.machine"/></a></li>
            
            <!-- REVISION -->
            <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="menu.revision"/></a>
               <ul class="dropdown-menu">
                  <sec:authorize access="hasAnyRole('ROLE_ADMIN')"  >
                  <li><a href="<c:url value='/revision/list'/>"><fmt:message key="menu.revision.list"/>Revision List</a></li>
                  </sec:authorize>
                  <sec:authorize access="hasAnyRole('ROLE_USER')"  >
                  <li><a href="<c:url value='/revision/listUser'/>">Revision List</a></li>
                  </sec:authorize>
<%--                   <sec:authorize access="hasAnyRole('ROLE_ADMIN')"> --%>
<%--    				  <li><a href="<c:url value='/revision/create'/>"><fmt:message key="menu.revision.create"/></a></li> --%>
<%--    				  </sec:authorize> --%>
   		       </ul>
            </li>
            
            <!-- RENT -->
            <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="menu.rent"/></a>
               <ul class="dropdown-menu">
                  <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                  <li><a href="<c:url value='/rent/list'/>"><fmt:message key="menu.rent.listall"/></a></li>
                  </sec:authorize>
                  <li><a href="<c:url value='/rent/list/${user.id}'/>"><fmt:message key="menu.rent.list"/></a></li>
                  <li><a href="<c:url value='/rent/new'/>"><fmt:message key="menu.rent.new"/></a></li>
               </ul>
            </li>
            
         </ul>
      </div>
   </nav>
   </sec:authorize>
   <!-- MENU end -->

   <!-- PAGE BODY -->
   <jsp:invoke fragment="body"/>
   
</div>
   
<!-- javascripts placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>