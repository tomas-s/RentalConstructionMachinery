<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<my:template title="Editation of Revision ID: ${revision.id}">
<jsp:attribute name="body">

    <h1>Editation of revision: <c:out value="${revision.id}" /></h1>

    <form:form method="post" action="${pageContext.request.contextPath}/revision/edit" modelAttribute="revision" cssClass="form-horizontal">

        <form:input path="id" type="hidden" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="form-group ${revisionDate_error?'has-error':''}">
            <form:label path="revisionDate" cssClass="col-sm-2 control-label">Datum revizie</form:label>
            <div class="col-sm-5">
                <form:input path="revisionDate" cssClass="form-control"/>
                <form:errors path="revisionDate" cssClass="help-block"/>
            </div>
        </div>

        


        <button class="btn btn-primary" type="submit">Edit revision</button>
    </form:form>

</jsp:attribute>
</my:template>



