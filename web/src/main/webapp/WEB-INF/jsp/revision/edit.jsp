<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<my:template title="Editation of Revision ID: ${revision.id}">
<jsp:attribute name="body">

    <h1>Editation of customer <c:out value="${customer.username}" /></h1>

    <form:form method="post" action="${pageContext.request.contextPath}/revision/edit" modelAttribute="revision" cssClass="form-horizontal">

        <form:input path="id" type="hidden" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="form-group ${firstName_error?'has-error':''}">
            <form:label path="firstName" cssClass="col-sm-2 control-label">First name</form:label>
            <div class="col-sm-5">
                <form:input path="firstName" cssClass="form-control"/>
                <form:errors path="firstName" cssClass="help-block"/>
            </div>
        </div>

        <div class="form-group ${lastName_error?'has-error':''}">
            <form:label path="lastName" cssClass="col-sm-2 control-label">Last name</form:label>
            <div class="col-sm-5">
                <form:input path="lastName" cssClass="form-control"/>
                <form:errors path="lastName" cssClass="help-block"/>
            </div>
        </div>

        <div class="form-group ${phoneNumber_error?'has-error':''}">
            <form:label path="phoneNumber" cssClass="col-sm-2 control-label">Phone number</form:label>
            <div class="col-sm-5">
                <form:input path="phoneNumber" cssClass="form-control"/>
                <form:errors path="phoneNumber" cssClass="help-block"/>
            </div>
        </div>

        <div class="form-group">
            <form:label path="customerType" cssClass="col-sm-2 control-label">Color</form:label>
            <div class="col-sm-10">
                <form:select path="customerType" cssClass="form-control">
                    <c:forEach items="${types}" var="t">
                        <form:option value="${t}">${t}</form:option>
                    </c:forEach>
                </form:select>
                <form:errors path="customerType" cssClass="error"/>
            </div>
        </div>

        <button class="btn btn-primary" type="submit">Edit customer</button>
    </form:form>

</jsp:attribute>
</my:template>



