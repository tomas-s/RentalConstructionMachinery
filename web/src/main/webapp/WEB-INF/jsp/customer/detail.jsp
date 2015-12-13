<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<my:template title="Detail of customer ${customer.username}">
<jsp:attribute name="body">

    <h1>Detail of customer <c:out value="${customer.username}" /></h1>

    <table>
        <tr>
            <td>ID</td>
            <td><c:out value="${customer.id}" /></td>
        </tr>
        <tr>
            <td>Username</td>
            <td><c:out value="${customer.username}" /></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><c:out value="${customer.firstName}" /></td>
        </tr>
        <tr>
            <td>Surname</td>
            <td><c:out value="${customer.lastName}" /></td>
        </tr>
        <tr>
            <td>Telephone</td>
            <td><c:out value="${customer.phoneNumber}" /></td>
        </tr>
        <tr>
            <td>User role</td>
            <td><c:out value="${customer.role}" /></td>
        </tr>
        <tr>
            <td>Type</td>
            <td><c:out value="${customer.customerType.toString()}" /></td>
        </tr>

        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/customer/edit/${customer.id}">
                    <button class="btn btn-primary">Edit</button></a>
            </td>
                <td>
                    <form method="post" action="${pageContext.request.contextPath}/customer/delete/${customer.id}">
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
        </tr>
    </table>

</jsp:attribute>
</my:template>



