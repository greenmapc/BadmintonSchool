<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<t:mainLayout style="" title="Школа бадминтона">
    <jsp:include page="/WEB-INF/templates/menu.jsp"/>


    <%--CONTENT--%>
    <div class="container main-text" style="padding-top: 50px; padding-left: 50px" >
        <img src="<c:url value="/assets/img/main-img.png"/>" style="float: right; width: 300px; height: 400px">
        <h3 class="head-text"> Добро пожаловать на сайт! </h3>

        <p class="content-text"> Данная система предназначена для тренеров и учеников нашей спортивной школы. <br>
            &nbsp; <br>
            – &nbsp; Сервис хранит информацию о каждом спортсмене. <br>
            – &nbsp; Тренерам сервис будет полезен наличием информации о спортсменах и списков групп в профиле. </p>

        <p class="content-text"> Для регистрации на нашем сайте необходимо состоять в спортивной школе. </p>


        <p class="content-text"> Если вы хотите поступить в нашу школу, то свяжитесь с нами по контактам, указанным на сайте.</p>
    </div>


</t:mainLayout>
