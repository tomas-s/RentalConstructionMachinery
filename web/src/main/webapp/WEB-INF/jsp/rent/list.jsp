<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<my:template title="List of Rents">
<jsp:attribute name="body">

    <h3><fmt:message key="menu.rent.listall"/></h3>

    <table class="table table-striped">
       <thead>
         <tr>
             <td><fmt:message key="id"/></td>
             <td><fmt:message key="customer"/></td>
             <td><fmt:message key="machine"/></td>
             <td><fmt:message key="since"/></td>
             <td><fmt:message key="till"/></td>
             <td></td>
             <td></td>
             <td></td>
            </tr>
        </thead>
        <c:forEach items="${rents}" var="rent">
            <tr>
                <td><c:out value="${rent.id}" /></td>
                <td><c:out value="${rent.customer.firstName}" /></td>
                <td><c:out value="${rent.machine.machineType}" /></td>
                <td><c:out value="${rent.rentSinceDate}" /></td>
                <td><c:out value="${rent.rentTillDate}" /></td>
        </c:forEach>
    </table>

</jsp:attribute>
</my:template>



