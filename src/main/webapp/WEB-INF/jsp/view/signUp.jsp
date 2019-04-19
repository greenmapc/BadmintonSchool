<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<t:mainLayout title="Регистрация" style="${context}/style/registrationStyle.css" script="${context}/script/registScript.js">
    <!--Registration content-->
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-9">
                <p class="card-header" >
                    Регистрация в системе
                </p>

                <form:form method="post" modelAttribute="signUpForm">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-5 registration-fields">


                            <div class=" field-title">
                                <form:label path="login">Логин</form:label>
                                <div class="input-group mb-1">
                                    <form:input path="login"
                                                type="text"
                                                class="form-control"/>
                                </div>
                                <div class="sign-up-div-hint">
                                    <form:errors path="login" style="color: red"/>
                                </div>
                            </div>

                            <div class=" field-title" style="margin-bottom: 30px !important;">
                                <form:label path="password">Пароль</form:label>
                                <div class="input-group mb-1">
                                    <form:input path="password"
                                                type="password"
                                                class="form-control"/>
                                </div>
                                <div class="sign-up-div-hint">
                                    <p class="field-hint">
                                        <form:errors path="password" style="color: red"/>
                                    </p>
                                </div>
                            </div>


                            <div class="field-title">
                                <form:label path="repeatPassword" for="regRepeatPassword">Введите пароль еще раз</form:label>
                                <div class="input-group mb-1">
                                    <form:input path="repeatPassword"
                                                type="password"
                                                class="form-control"
                                                id="regRepeatPassword"/>
                                </div>
                                <div class="sign-up-div-hint">
                                    <p class="field-hint">
                                        <form:errors path="repeatPassword" style="color: red" />
                                    </p>
                                </div>

                            </div>
                        </div>


                        <div class="col-5 registration-fields">
                            <div class=" field-title">
                                <form:label path="name">Ваше имя</form:label>
                                <div class="input-group mb-1">
                                    <form:input path="name"
                                                type="text"
                                                class="form-control"
                                                id="regName"/>
                                </div>
                                <div class="sign-up-div-hint"> </div>
                            </div>

                            <div class=" field-title">
                                <form:label path="surname">Ваша фамилия</form:label>
                                <div class="input-group input-with-prepend mb-1">
                                    <form:input path="surname"
                                                type="text"
                                                class="form-control"
                                                id="regSurname"/>
                                </div>
                                <div style="margin-bottom: 75px"></div>
                            </div>

                            <p>
                                <form:radiobutton path="type" value="coach"/>
                                Тренер
                            </p>
                            <p>
                                <form:radiobutton path="type" value="athlete"/>
                                Спортсмен
                            </p>
                        </div>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="col-9">
                        <div id="empty-field"
                            <form:errors path="emptyFieldsConstraint" style="color: red"/>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-10">
                    <div>
                        <button type="submit"
                                id="buttonRegistration"
                                name="send"
                                class="btn btn-primary btn-register">
                            Создать аккаунт
                        </button>
                    </div>
                </div>
            </div>

        </div>

        </form:form>
    </div>

</t:mainLayout>