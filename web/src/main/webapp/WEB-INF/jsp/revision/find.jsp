<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>




<my:template title="Find Revision">

    <jsp:attribute name="body">

        <h3><fmt:message key="menu.revision.find"/></h3>
        
        <form:form method="get" action="${pageContext.request.contextPath}/revision/finded" cssClass="form-horizontal">
<table class="table table-striped">
        <tr>
            Date Since:  <input type="text" name="dateSince" />
</tr>
            <!--<br />-->
            <tr>
            Date Till:   <input type="text" name="dateTill" />
            </tr>
</table>

            <button class="btn btn-primary" type="submit">Find</button>
        </form:form>
            
            Write Date by format: yyyy-mm-dd   for example: 2013-10-15 / 2014-10-10

    </jsp:attribute>

</my:template>






