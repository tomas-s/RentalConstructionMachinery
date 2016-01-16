<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:template title="List of Revision">
<jsp:attribute name="body">


    <h3>List of Revisions</h3>
    
        <table class="table table-striped">
		<thead>
        	<tr>
            	<td>Revision ID</td>
                <td>Date</td>
                <td>Machine</td>
                
            </tr>
        </thead>
        <c:forEach items="${Revisions}" var="revision">
            <tr>
                <td><c:out value="${revision.id}" /></td>
                <td>
                    <fmt:formatDate type="date" value="${revision.revisionDate}" />
                <td><c:out value="${revision.machine}" /></td>
                <td><a href="${pageContext.request.contextPath}/revision/detail/${revision.id}">Detail</a></td>
                    
                <td>
                    <form method="post" action="${pageContext.request.contextPath}/revision/delete/${revision.id}">
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </form>
                </td>
                      
            </tr>
        </c:forEach>
    </table>
    
    
</jsp:attribute>
</my:template>