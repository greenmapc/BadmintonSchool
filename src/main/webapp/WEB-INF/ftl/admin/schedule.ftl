<#import "adminLayout.ftl" as main/>

<@main.base title='Расписание'>
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
                        <#list groups as group>
                            <#list group.scheduleSet as schedule>
                                <tr>
                                    <td>${time('${schedule.time}')}</td>
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
</@main.base>