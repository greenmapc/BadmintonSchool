<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!--menu-->
<div class="container content">
    <nav class="navbar navbar-expand-lg navbar-light">

        <div class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto">
                <li class="menu-item">
                    <a class="nav-link" href="#"> Главная </a>
                </li>
                <li class="menu-item">
                    <a class="nav-link" href="#"> Наши спортсмены </a>
                </li >
                <li class="menu-item">
                    <a class="nav-link" href=""> Наши тренеры </a>
                </li>


                <li class="menu-item-img li-vk-icon">
                    <a class="nav-link-img" href="http://vk.com"> <img src="<c:url value="/assets/img/icon-vk-link.png"/>"> </a>
                </li>
                <li class="menu-item-img li-insta-icon">
                    <a class="nav-link-img" href="http://instagram.com"><img src="<c:url value="/assets/img/icon-insta-link.png"/>"></a>
                </li>
            </ul>
        </div>
    </nav>
</div>
