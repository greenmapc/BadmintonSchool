<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags/help" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:mainLayout title="Вход" style="${context}/style/loginStyle.css" script="${context}/script/loginScript.js">

        <!--content-->
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-7">
                    <p class="card-header">
                        Вход в систему
                    </p>
                    <form method="post" class="sign">
                        <div class="container">
                            <div class="row justify-content-center">
                                <div class="col-5 registration-fields">

                                    <h:input name="login" id="sign-in-login" type="text"/>
                                    <h:input name="password" id="sign-in-password" type="password"/>

                                    <div style="margin-top: 20px" class="row justify-content-center field-title">
                                        <input type="checkbox" id="rememberme" name="rememberme">
                                        <p> Запомнить меня </p>
                                    </div>
                                </div>
                            </div>


                            <div class="row justify-content-center">
                                <div class="col-7">
                                    <warning:dangerBlock message="Неверный логин или пароль" status="${status}"/>
                                </div>

                            </div>

                            <div class="row justify-content-center">
                                <div class="col-2">
                                    <div>
                                        <input type="submit"
                                                id="sign-in-button"
                                                name="signIn"
                                                class="btn btn-primary"
                                                value="Войти">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
</t:mainLayout>