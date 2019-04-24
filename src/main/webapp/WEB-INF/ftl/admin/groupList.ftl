<#import "../part/mainLayout.ftl" as main/>

<@main.header title='Список групп'>
    <div class="container">
        <div class="col-11 list">
            <div class="row justify-content-center">
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
                                        <tr
                                                <#--onclick="window.location.href='${action('GC#personalProfile', 0, user.getUsername())}'"-->
                                        >
                                        <td>${group.id}</td>
                                        <td>${group.groupNumber}</td>
                                        <td>${normalize('${group.ageCategory}')}</td>
                                        </tr>
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