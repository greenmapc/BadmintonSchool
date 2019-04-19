<#import "part/mainLayout.ftl" as main/>
<#import "/spring.ftl" as spring/>

<#assign type = ""coachRole = "COACH"/>
<#assign athleteRole = "ATHLETE"/>
<#assign noInforamtion = "Информация не указана">

<@main.header "${user.getUsername()}">
    <div class="container">
    <div class="row justify-content-center">
        <div class="col-9">
            <p class="card-header" >
                ${user.getUsername()}
            </p>


            <form method="post" action=${action('UC#changeSettings', 0, user.getUsername())}>

                <@spring.bind "form"/>

                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-5 info">

                            <div class="title">
                                <p class="info-title"> Фамилия </p>
                                <@spring.formInput "form.surname" "class='form-control' placeholder='${noInforamtion}'" "text"/>
                            </div>

                            <div class="title">
                                <p class="info-title"> Имя </p>
                                <@spring.formInput "form.name" "class='form-control' placeholder='${noInforamtion}'" "text"/>
                            </div>

                            <div class="title">
                                <p class="info-title"> Отчество </p>
                                <@spring.formInput "form.patronymic" "class='form-control' placeholder='${noInforamtion}'" "text"/>
                            </div>

                            <div class="title">
                                <p class="info-title"> Дата рождения </p>
                                <@spring.formInput "form.birthday" "class='form-control' placeholder='${noInforamtion}'" "date"/>
                            </div>
                        </div>

                        <div class="col-5 info">
                            <div class="title">
                                <p class="info-title"> Email </p>
                                <@spring.formInput "form.email" "class='form-control' placeholder='${noInforamtion}'" "text"/>
                                <@spring.showErrors "form.email" "class='settings-warning-hint'"/>
                            </div>

                            <div class="title">
                                <p class="info-title"> Номер </p>
                                <@spring.formInput "form.number" "class='form-control' placeholder='${noInforamtion}'" "text"/>
                                <@spring.showErrors "form.number" "class='settings-warning-hint'"/>
                            </div>

                            <#if roles?seq_contains(coachRole)>
                                <div class="title">
                                    <p class="info-title"> Группы </p>

                                        <@spring.formMultiSelect "form.choosingGroups" options 'class="groups"'/>

                                    <p class="hint">Чтобы выбрать несколько групп, удерживайте CTRL</p>
                                </div>
                            </#if>

                            <#if roles?seq_contains(athleteRole)>
                                <div class="title">
                                    <p class="info-title"> Группа </p>

                                    <@spring.formSingleSelect "form.choosingGroup" allOptions 'class="groups"'/>
                                </div>
                            </#if>
                        </div>
                    </div>

                    <#if success??>
                        <div class="row justify-content-center">
                            <div class="alert alert-success settings-warning" role="alert">
                                Информация успешно обновлена
                            </div>
                        </div>
                    </#if>

                    <@spring.showErrors "emptyFieldsConstraint"/>

                    <button type="submit"
                            id="buttonRegistration"
                            name="change"
                            class="btn btn-primary btn-register">
                        Изменить
                    </button>
                </div>
            </form>
        </div>
    </div>
</@main.header>