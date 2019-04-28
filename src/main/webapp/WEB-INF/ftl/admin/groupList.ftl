<#import "adminLayout.ftl" as main/>

<@main.base title='Список групп'>
    <div class="col-7">
        <div class="card">
            <div class="card-header">
                <span class="title-table-coach"> Группы </span>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-border table-hover table-fluid group-table" id="coachTable">
                        <tr>
                            <th>ID</th>

                            <th>Номер</th>
                            <th>Возрастная категория</th>
                        </tr>
                        <#list groups as group>
                            <tr onclick="window.location.href='${action('AC#getGroupSettings', 0, group.getGroupNumber())}'">
                                <td>${group.id}</td>
                                <td>${group.getGroupNumber()}</td>
                                <td>${normalize('${group.ageCategory}')}</td>
                            </tr>
                        </#list>
                    </table>
                </div>
            </div>
        </div>
    </div>
</@main.base>