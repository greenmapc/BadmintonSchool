<#import "../part/mainLayout.ftl" as main/>

<@main.header title='Расписание'>
    <div class="container">
        <div class="col-11 list">
            <div class="row justify-content-center">
                <div class="col-7">
                    <div class="card">
                        <div class="card-header">
                            <span class="title-table-coach"> Расписание </span>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-border table-hover table-fluid group-table" id="coachTable">
                                    <tr>
                                        <th>Время</th>

                                        <th>День недели</th>
                                        <th>Номер группы</th>
                                    </tr>
                                    <#list schedules as schedule>
                                        <#list schedule.groups as group>
                                        <tr>
                                            <td>${schedule.time}</td>
                                            <td>${schedule.weekday}</td>
                                            <td>
                                                <a href="${action("AC#getGroupSettings", 0, group.groupNumber)}">${group.groupNumber}</a>
                                            </td>
                                        </tr>
                                        </#list>
                                    </#list>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@main.header>