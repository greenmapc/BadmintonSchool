<#import "part/mainLayout.ftl" as main/>
<#import "/spring.ftl" as spring/>

<@main.header title="Вход" script="loginScript">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-7">
                <p class="card-header">
                    Вход в систему
                </p>
                <form method="post" class="sign" action="${context.getContextPath()}/signin">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-5 registration-fields">

                                <input class="form-control input-sign-in" name="username" id="sign-in-login" type="text"/>
                                <input class="form-control input-sign-in" name="password" id="sign-in-password" type="password"/>
                            </div>
                        </div>

                        <#if error??>
                            <div class="row justify-content-center">
                                <div class="col-5 alert alert-danger signin-error-block" >
                                    <p class="signin-error"> ${error} </p>
                                </div>
                            </div>
                        </#if>


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
</@main.header>
