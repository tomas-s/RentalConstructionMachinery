<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>




<my:template title="New Rent">

<jsp:attribute name="body">

    <h3><fmt:message key="menu.rent.new"/></h3>
        
    <form:form method="post" action="${pageContext.request.contextPath}/rent/add" modelAttribute="rent" cssClass="form-horizontal">
        
        <form:input path="id" type="hidden" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="form-group ${rentSinceDate_error?'has-error':''}">
            <form:label path="rentSinceDate" cssClass="col-sm-2 control-label">Since</form:label>
            <div class="col-sm-5">
                <form:input path="rentSinceDate" cssClass="form-control"/>
                <form:errors path="rentSinceDate" cssClass="help-block"/>
            </div>
        </div>
                        
        <div class="form-group ${rentTillDate_error?'has-error':''}">
            <form:label path="rentTillDate" cssClass="col-sm-2 control-label">Till</form:label>
            <div class="col-sm-5">
                <form:input path="rentTillDate" cssClass="form-control"/>
                <form:errors path="rentTillDate" cssClass="help-block"/>
            </div>
        </div>


        <div class="form-group">
            <form:label path="machine" cssClass="col-sm-2 control-label">Machine</form:label>
            <div class="col-sm-5">
                <form:select path="machine" cssClass="form-control">
                    <c:forEach items="${machines}" var="machine">
                        <form:option value="${machine.id}">${machine.machineType}</form:option>
                    </c:forEach>
                </form:select>                
                <form:errors path="machine" cssClass="error"/>
            </div>
        </div>

        <button class="btn btn-primary" type="submit">Rent</button>
    </form:form>

</jsp:attribute>

</my:template>






