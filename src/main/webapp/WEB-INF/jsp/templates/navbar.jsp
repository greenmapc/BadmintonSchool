<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="container asd">
    <nav class="navbar cap">
        <a class="navbar-brand nav-logotype" href="${spring:mvcUrl('DC#index').build()}">
            <img src="<c:url value="/assets/img/logo2.png"/>" class="img-logo">
            <span class="text-logo">Школа бадминтона</span>
        </a>
        <div>
            <c:if test="${not empty login}">
                <div class="user dropdown pull-right">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">
                        <span class="username"> ${login} </span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="" class="drop-menu"> Мой профиль </a></li>
                        <li class="divider"></li>
                        <li><a href="#" class="drop-menu"> Настройки </a></li>
                        <li class="divider"></li>
                        <li><a href="#" class="drop-menu"> Выход </a></li>

                    </ul>
                </div>
            </c:if>
            <c:if test="${empty login}">
                <button type="button"
                        class="btn btn-primary sign-in"
                        onclick="window.location.href='${spring:mvcUrl('SC#signIn').build()}'">
                    Войти
                </button>
                <button type="button"
                        class="btn btn-primary sign-up"
                        onclick="window.location.href='${spring:mvcUrl('SC#signUpPage').build()}'">
                    Зарегистрироваться
                </button>
            </c:if>
        </div>
    </nav>
    <hr size=2px width=100% align="center">
</div>
