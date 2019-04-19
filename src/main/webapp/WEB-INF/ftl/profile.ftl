<#import "part/mainLayout.ftl" as main/>
<#import "part/warning.ftl" as warning/>
<#import "/spring.ftl" as spring/>
<#import "function/ru_role.ftl" as role_function/>

<#assign type = ""coachRole = "COACH"/>
<#assign athleteRole = "ATHLETE"/>
<#assign noInforamtion = "Информация не указана">

<@main.header title="${page_user.getUsername()}" script="openCoachGroupsScript">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-9">
                <p class="card-header" >
                    ${normalize('${page_user.getUsername()}')} (${normalize('${role_function.ru_role(page_user.getSchoolRole())}')})
                </p>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-5 info">
                            <div class="title">
                                <p class="info-title"> Фамилия </p>
                                <p class="info-val"> <@warning.emptyField value = page_user.getSurname()/> </p>
                            </div>

                            <div class="title">
                                <p class="info-title"> Имя </p>
                                <p class="info-val"> <@warning.emptyField value = page_user.getName()/>  </p>
                            </div>

                            <div class="title">
                                <p class="info-title"> Отчество </p>
                                <p class="info-val"> <@warning.emptyField value = page_user.getPatronymic()/> </p>
                            </div>

                            <div class="title">
                                <p class="info-title"> Дата рождения </p>
                                <p class="info-val"> <@warning.emptyField value = page_user.getBirthday()/> </p>
                            </div>
                        </div>
                        <div class="col-5 info">
                            <div class="title">
                                <p class="info-title"> Email </p>
                                <p class="info-val"> <@warning.emptyField value = page_user.getEmail()/> </p>
                            </div>

                            <div class="title">
                                <p class="info-title"> Номер телефона </p>
                                <p class="info-val"> <@warning.emptyField value = page_user.getContactNumber()/> </p>
                            </div>

                            <div class="title">
                                <#if roles?seq_contains(coachRole)>
                                    <p class="info-title"> Группы </p>
                                    <#if page_user.getGroups()??>
                                        <a href="#" id="open-group" class="info-val"> Открыть список групп </a>
                                        <ul id="group-list" style="display: none">
                                            <#if page_user.getGroups()?size == 0>
                                                ${noInforamtion}
                                            <#else>
                                                <#list page_user.getGroups() as group>
                                                    <a href=${action("GC#groupPage", 0, group.groupNumber)} class="group-link"> <li class="group"> ${normalize(group.groupNumber)} </li> </a>
                                                </#list>
                                            </#if>
                                        </ul>
                                    <#else>
                                        <p class="info-val"> ${noInforamtion} </p>
                                    </#if>
                                <#elseif roles?seq_contains(athleteRole)>
                                    <p class="info-title"> Группа </p>
                                    <#if page_user.getGroup()??>
                                        <ul id="group-list">
                                            <a href="${action("GC#groupPage", 0, page_user.group.groupNumber)}" class="group-link"> <li class="group"> ${normalize(page_user.group.groupNumber)} </li> </a>
                                        </ul>
                                    <#else>
                                        <p class="info-val"> ${noInforamtion} </p>
                                    </#if>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@main.header>
