<#import "/spring.ftl" as spring/>
<#import "adminLayout.ftl" as main/>

<@main.base title='Новая группа'>

    <div class="col-4 info">

        <form method="post" action=${action('AC#createGroup')}>

            <@spring.bind "group"/>
            <div class="title">
                <p class="info-title"> Номер группы </p>
                <@spring.formInput "group.groupNumber" "class='form-control'" "text"/>
            </div>

            <div class="title">
                <p class="info-title"> Возрастная категория </p>
                <@spring.formInput "group.ageCategory" "class='form-control'" "text"/>
            </div>

            <div class="title">
                <p class="info-title"> Расписание </p>
                <@spring.formMultiSelect "group.scheduleSet" schedule 'class="schedule-input form-control"'/>

                <p class="hint">Чтобы выбрать несколько, удерживайте CTRL</p>
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