<#import "adminLayout.ftl" as main/>

<@main.base title='Расписание'>
    <div class="col-7 schedule-table">
        <div class="card">
            <div class="title-schedule card-header">
                <span class="title-table-coach"> Расписание </span>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <ul class="schedule-sort">
                        <li>
                            <a href="${action("AC#getSchedule", 0, "group")}">Соритровка по группе</a>
                        </li>
                        <li>
                            <a href="${action("AC#getSchedule", 0, "time")}">Сортировка по времени</a>
                        </li>
                    </ul>
                    <table class="table table-border table-hover table-fluid group-table" id="coachTable">
                        <tr>
                            <th>Время</th>

                            <th>День недели</th>
                            <th>Номер группы</th>
                        </tr>
                        <#list schedule as item>
                            <tr>
                                <td>${time('${item.time}')}</td>
                                <td>${item.weekday}</td>
                                <td>
                                    <a href="${action("AC#getGroupSettings", 0, item.groupNumber)}">${item.groupNumber}</a>
                                </td>
                            </tr>
                        </#list>
                    </table>
                </div>
            </div>
        </div>
    </div>
</@main.base>