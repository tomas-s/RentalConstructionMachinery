
<%@ tag pageEncoding="utf-8" dynamic-attributes="dynattrs" trimDirectiveWhitespaces="true" %>
<%@ attribute name="title" required="false" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="body" fragment="true" required="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
	<title>Rental Construction Machinery</title>
	
	<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><c:out value="${title}"/></title>
<!-- bootstrap loaded from content delivery network -->
<%-- <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon"> --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" crossorigin="anonymous">
<%-- <jsp:invoke fragment="head"/> --%>

<%-- 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css"/> --%>
</head>

<body bgcolor="white">
   

   <div class="container">
   
   <h2>Rental Construction Machinery</h2>
   
   <nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">


   <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
     <ul class="nav navbar-nav">
           <!-- CUSTOMER -->
           <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="menu.customer"/>customer</a>
              <ul class="dropdown-menu">
                 <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                    <li><a href="<c:url value='/customer/list'/>">Seznam</a></li>
                 </sec:authorize>
                 <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
				    <li><a href="<c:url value='/customer/edit/{1}'/>">Edit</a></li>
				 </sec:authorize>
		      </ul>
           </li>
           <!-- MACHINE -->
           <li><a href="<c:url value='/machine/list'/>">machine</a></li>
           <!-- HELLO -->
           <li><a href="<c:url value='/hello'/>">hello</a></li>
     </ul>
   </div>
    </div>
   
   </nav>

   <!-- PAGE BODY -->
   <jsp:invoke fragment="body"/>
   
   </div>
   
   <!-- javascripts placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>