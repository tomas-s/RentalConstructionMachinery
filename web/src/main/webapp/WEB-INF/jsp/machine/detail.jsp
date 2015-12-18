<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<my:template title="Detail of machine: ${machine.id} - ${machine.machineType}">
<jsp:attribute name="body">

    <h3><fmt:message key="machine.detail.title"/></h3>

    <table class="table table-striped">
        <tr>
            <td><fmt:message key="machine.id"/></td>
            <td><c:out value="${machine.id}" /></td>
        </tr>
        <tr>
            <td><fmt:message key="machine.type"/></td>
            <td><c:out value="${machine.machineType}" /></td>
        </tr>
        <tr>
            <td><fmt:message key="machine.state"/></td>
            <td><c:out value="${machine.machineState}" /></td>
        </tr>
    </table>
    
    <!-- Rent -->
    <h3><fmt:message key="machine.detail.rent"/></h3>
    <table class="table table-striped">
       <thead>
          <tr>
             <td><fmt:message key="since"/></td>
             <td><fmt:message key="till"/></td>
             <td><fmt:message key="customer"/></td>
           </tr>
        </thead>
        <c:forEach items="${machine.rentHistory}" var="rent">
            <tr>
                <td><c:out value="${rent.rentSinceDate}" /></td>
                <td><c:out value="${rent.rentTillDate}" /></td>
                <td><c:out value="${rent.customer}" /></td>
                <td><a href="${pageContext.request.contextPath}/customer/detail/${rent.customer.id}">${rent.customer.lastName}</a></td>
            </tr>
        </c:forEach>
     </table>

    <!-- Revision -->
    <h3><fmt:message key="machine.detail.revision"/></h3>
    <table class="table table-striped">
       <thead>
          <tr>
             <td><fmt:message key="date"/></td>
          </tr>
        </thead>
        <c:forEach items="${machine.revisionHistory}" var="revision">
            <tr>
                <td><c:out value="${revision.revisionDate}" /></td>
            </tr>
        </c:forEach>
     </table>

</jsp:attribute>
</my:template>



