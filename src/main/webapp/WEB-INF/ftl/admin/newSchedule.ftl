<#import "../part/mainLayout.ftl" as main/>
<#import "/spring.ftl" as spring/>


<@main.header title='Новое расписание'>
    <form method="post" action=${action('AC#createSchedule')}>

        <@spring.bind "schedule"/>

        <div class="container">
            <div class="row justify-content-center">
                <div class="col-5 info">

                    <div class="title">
                        <p class="info-title"> Время </p>
                        <@spring.formInput "schedule.time" "class='form-control'" "time"/>
                    </div>

                    <#--ToDo: select-->
                    <div class="title">
                        <p class="info-title"> День недели </p>
                        <@spring.formSingleSelect "schedule.weekday" weekdays 'class="weekday-input form-control"'/>
                    </div>

                    <button type="submit"
                            id="buttonRegistration"
                            name="change"
                            class="btn btn-primary btn-register">
                        Создать
                    </button>

                    <#if success??>
                        <div class="row justify-content-center">
                            <div class="alert alert-success settings-warning" role="alert">
                                ${success}
                            </div>
                        </div>
                    </#if>
                    <#--<#elseif error??>-->
                        <#--<div class="row justify-content-center">-->
                            <#--<div class="alert alert-danger signin-error-block settings-warning" >-->
                                <#--<p class="signin-error"> ${error} </p>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--<#elseif inputError??>-->
                        <#--<div class="row justify-content-center">-->
                            <#--<div class="alert alert-danger signin-error-block settings-warning" >-->
                                <#--<p class="signin-error"> ${inputError} </p>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</#if>-->

                </div>
            </div>
        </div>
    </form>
</@main.header>