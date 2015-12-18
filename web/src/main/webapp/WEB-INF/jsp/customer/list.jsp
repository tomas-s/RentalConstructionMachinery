<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<my:template title="List of Customers">
<jsp:attribute name="body">

    <h3><fmt:message key="menu.customer.list"/></h3>

    <table class="table table-striped">
		<thead>
        	<tr>
            	<td><fmt:message key="customer.list.name"/></td>
                <td><fmt:message key="customer.list.username"/></td>
                <td><fmt:message key="customer.list.lastname"/></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </thead>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td><c:out value="${customer.username}" /></td>
                <td><c:out value="${customer.firstName}" /></td>
                <td><c:out value="${customer.lastName}" /></td>
                <td><a href="${pageContext.request.contextPath}/customer/detail/${customer.id}">Detail</a></td>
                <td><a href="${pageContext.request.contextPath}/customer/edit/${customer.id}">Edit</a></td>
                <td>
                    <form method="post" action="${pageContext.request.contextPath}/customer/delete/${customer.id}">
                        <button type="submit" class="btn btn-primary"><fmt:message key="delete"/></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</jsp:attribute>
</my:template>



