<#import "/spring.ftl" as spring/>
<#import "adminLayout.ftl" as main/>


<#assign noInforamtion = "Информация не указана">

<@main.base title='Группа ${groupNumber}'>

    <div class="col-5 info">
        <form method="post" action=${action('AC#changeGroupSettings', 0, groupNumber)}>

            <@spring.bind "group"/>
            <div class="title">
                <p class="info-title"> Номер группы </p>
                <@spring.formInput "group.groupNumber" "class='form-control' placeholder='${noInforamtion}'" "text"/>
            </div>

            <div class="title">
                <p class="info-title"> Возрастная категория </p>
                <@spring.formInput "group.ageCategory" "class='form-control' placeholder='${noInforamtion}'" "text"/>
            </div>

            <div class="title">
                <p class="info-title"> Расписание </p>
                <@spring.formMultiSelect "group.scheduleSet" schedule 'class="schedule-input form-control"'/>

                <p class="hint">Чтобы выбрать несколько, удерживайте CTRL</p>
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
        </form>
    </div>
</@main.base>