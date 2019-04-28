<#import "part/mainLayout.ftl" as main/>

<#assign noInforamtion = "Информация не указана">

<@main.header title='${normalize(group.groupNumber)}'>

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-9">
                <p class="card-header" >
                    Группа ${normalize(group.groupNumber)}
                </p>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-5 info">
                            <div class="title">
                                <p class="info-title"> Номер группы </p>
                                <p class="info-val">  ${normalize(group.groupNumber)}  </p>
                            </div>

                            <div class="title">
                                <p class="info-title"> Возрастная категория </p>
                                <p class="info-val"> ${normalize('${group.getAgeCategory()}')} </p>
                            </div>

                            <div class="title">
                                <p class="info-title"> Тренер </p>
                                <#if group.getCoach()??>
                                    <a href=${action('UC#personalProfile', 0, group.getCoach().getUsername())} class="info-val coach-href">
                                        ${normalize('${group.getCoach().getSurname()}')} ${normalize('${group.getCoach().getName()}')}
                                        <#if group.getCoach().getPatronymic()??>
                                            ${normalize('${group.getCoach().getPatronymic()}')}
                                        </#if>
                                    </a>
                                <#else>
                                    <a class="info-val coach-href"> У группы еще нет тренера </a>
                                </#if>
                            </div>
                        </div>

                        <div class="col-5 info">

                            <div class="title">
                                <p class="info-title"> Участники группы </p>
                                <ul id="group-list">
                                    <#if group.getParticipants()?size == 0>
                                        <a class="info-val coach-href"> В группе еще нет участников </a>
                                    <#else >
                                        <#list group.getParticipants() as participant>
                                            <a href=${action('UC#personalProfile', 0, participant.getUsername())} class="group-link">
                                                <li class="group"> ${normalize('${participant.getSurname()}')} ${normalize('${participant.getName()}')}
                                                    <#if participant.getPatronymic()??>
                                                        ${normalize('${participant.getPatronymic()}')}
                                                    </#if> </li>
                                            </a>
                                        </#list>
                                    </#if>
                                </ul>
                            </div>

                            <div class="title">
                                <p class="info-title"> Расписание </p>
                                <ul class="group-schedule">
                                    <#list group.getScheduleSet() as schedule>
                                        <li>
                                            ${time(schedule.time)} ${schedule.weekday}
                                        </li>

                                    </#list>
                                </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@main.header>