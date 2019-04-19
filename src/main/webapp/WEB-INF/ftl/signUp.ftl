<#import "part/mainLayout.ftl" as main/>
<#import "/spring.ftl" as spring/>

<@main.header title="Регистрация" script="registScript">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-9">
                <p class="card-header" >
                    Регистрация в системе
                </p>
                <form method="post" action="${action("SC#signUp")}">

                    <@spring.bind "signUpForm"/>

                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-5 registration-fields">

                                <div class=" field-title">
                                    <label for="login">Логин</label>
                                    <div class="input-group mb-1">
                                        <@spring.formInput "signUpForm.login" "class='form-control'" "text"/>
                                    </div>
                                    <div class="sign-up-div-hint">
                                        <p class="field-hint">
                                        <@spring.showErrors "signUpForm.login" "class='field-hint'"/>
                                    </div>
                                </div>

                                <div class=" field-title" style="margin-bottom: 30px !important;">
                                    <label for="password">Пароль</label>
                                    <div class="input-group mb-1">
                                        <@spring.formPasswordInput "signUpForm.password" "class='form-control'"/>
                                    </div>
                                    <div class="sign-up-div-hint">
                                        <p class="field-hint">
                                            <@spring.showErrors "signUpForm.password"/>
                                        </p>
                                    </div>
                                </div>

                                <div class="field-title">
                                    <label for="repeatPassword">Введите пароль еще раз</label>
                                    <div class="input-group mb-1">
                                        <@spring.formPasswordInput "signUpForm.repeatPassword" "class='form-control'"/>
                                    </div>
                                    <div class="sign-up-div-hint">
                                        <p class="field-hint">
                                            <@spring.showErrors "signUpForm.repeatPassword"/>
                                        </p>
                                    </div>
                                </div>
                            </div>


                            <div class="col-5 registration-fields">
                                <div class=" field-title">
                                    <label for="name">Ваше имя</label>
                                    <div class="input-group mb-1">
                                        <@spring.formInput "signUpForm.name" "class='form-control'" "text"/>
                                    </div>
                                    <div class="sign-up-div-hint"> </div>
                                </div>

                                <div class=" field-title">
                                    <label for="surname">Ваша фамилия</label>
                                    <div class="input-group input-with-prepend mb-1">
                                        <@spring.formInput "signUpForm.surname" "class='form-control'" "text" />
                                    </div>
                                    <div style="margin-bottom: 75px"></div>
                                </div>

                                <p>
                                    <#assign radio = { "coach": "Тренер"}>
                                    <@spring.formRadioButtons "signUpForm.type" radio ""/>
                                </p>
                                <p>
                                    <#assign radio = { "athlete": "Спортсмен"}>
                                    <@spring.formRadioButtons "signUpForm.type" radio ""/>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="row justify-content-center">
                        <div class="col-9">
                            <div id="empty-field"
                            <p class="field-hint">
                                <@spring.showErrors "signUpForm.emptyFieldsConstraint" "style='color: red'"/>
                            </p>
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
                </form>
            </div>
        </div>
    </div>
</@main.header>
