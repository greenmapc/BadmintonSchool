<%@tag description="Default Input Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@attribute name="name" required="true" %>
<%@attribute name="id" required="true"%>
<%@attribute name="style" required="false"%>
<%@attribute name="type" required="true"%>

<div class="field-title">
    <label for="${id}"></label>
    <input type="${type}" name="${name}" placeholder="${name}"  id="${id}"
           class="form-control <c:if test="${not empty style}"> ${style} </c:if>">
</div>