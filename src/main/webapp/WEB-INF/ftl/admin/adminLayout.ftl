<#import "../part/mainLayout.ftl" as main/>

<#macro base title>
    <@main.header title="${title}">
    <div class="container admin-page">
        <div class="row justify-content-center">
            <div class="col-3">
                <p class="admin-headline"> Admin </p>
                <ul class="admin">
                    <li class="admin-section">
                        <a href=${action("AC#getCreatingPage")}> Добавить группу </a>
                    </li>
                    <li class="admin-section">
                        <a href=${action("AC#getCreatingSchedulePage")}> Добавить расписание </a>
                    </li>
                    <li class="admin-section">
                        <a href=${action("AC#getGroupList")}> Посмотреть все группы </a>
                    </li>
                    <li class="admin-section">
                        <a href=${action("AC#getSchedule")}> Посмотреть расписание </a>
                    </li>
                </ul>
            </div>
            <#nested>
        </div>
    </div>
    </@main.header>
</#macro>
