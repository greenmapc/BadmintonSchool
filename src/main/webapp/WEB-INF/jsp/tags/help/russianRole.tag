<%@tag description="Default Input Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@attribute name="role" required="true" %>

<c:if test="${role == 'coach'}">Тренер</c:if>

<c:if test="${role == 'athlete'}">Спортсмен</c:if>