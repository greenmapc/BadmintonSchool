<#import "../part/mainLayout.ftl" as main/>
<#import "/spring.ftl" as spring/>

<#assign noInforamtion = "Информация не указана">

<@main.header title='Группа ${groupNumber}'>
    <form method="post" action=${action('AC#changeGroupSettings', 0, groupNumber)}>

        <@spring.bind "group"/>

        <div class="container">
            <div class="row justify-content-center">
                <div class="col-5 info">

                    <div class="title">
                        <p class="info-title"> Номер группы </p>
                        <@spring.formInput "group.groupNumber" "class='form-control' placeholder='${noInforamtion}'" "text"/>
                    </div>

                    <div class="title">
                        <p class="info-title"> Возрастная категория </p>
                        <@spring.formInput "group.ageCategory" "class='form-control' placeholder='${noInforamtion}'" "text"/>
                    </div>

                        <@spring.formHiddenInput "group.id"/>

                    <button type="submit"
                            id="buttonRegistration"
                            name="change"
                            class="btn btn-primary btn-register">
                        Изменить
                    </button>

                    <#if success??>
                        <div class="row justify-content-center">
                            <div class="alert alert-success settings-warning" role="alert">
                                ${success}
                            </div>
                        </div>
                    <#elseif error??>
                        <div class="row justify-content-center">
                            <div class="alert alert-danger signin-error-block settings-warning" >
                                <p class="signin-error"> ${error} </p>
                            </div>
                        </div>
                    <#elseif inputError??>
                        <div class="row justify-content-center">
                            <div class="alert alert-danger signin-error-block settings-warning" >
                                <p class="signin-error"> ${inputError} </p>
                            </div>
                        </div>
                    </#if>

                </div>
            </div>
        </div>
    </form>
</@main.header>