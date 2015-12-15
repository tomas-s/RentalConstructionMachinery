<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:template title="List of Machines">
<jsp:attribute name="body">


    <h3><fmt:message key="menu.machine"/></h3>
    
        <table class="table table-striped">
		<thead>
        	<tr>
            	<td>ID</td>
                <td>Type</td>
            </tr>
        </thead>
        <c:forEach items="${machines}" var="machine">
            <tr>
                <td><c:out value="${machine.id}" /></td>
                <td><c:out value="${machine.machineType}" /></td>
            </tr>
        </c:forEach>
    </table>

</jsp:attribute>
</my:template>