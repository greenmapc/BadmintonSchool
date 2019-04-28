<#import "adminLayout.ftl" as main/>

<@main.base title='Страница администратора'>
    <div class="col-5">
        <div class="card">
            <div class="date card-header">
                Работа с сайтом
            </div>
            <div class="card-body">
                <div class="card-text">
                    <table class="table" style="margin-bottom: 0">
                        <tr>
                            <td style="padding-top: 20px">
                                Группа
                            </td>
                            <td>
                                <div class="btn-group">
                                    <a class="btn" href=${action("AC#getCreatingPage")}>
                                        Новая
                                    </a>
                                    <a class="btn" href=${action("AC#getGroupList")}>
                                        Список
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="padding-top: 20px">
                                Расписание
                            </td>
                            <td>
                                <div class="btn-group">
                                    <a class="btn" href=${action("AC#getCreatingSchedulePage")}>
                                        Новое
                                    </a>
                                    <a class="btn" href=${action("AC#getSchedule")}>
                                        Список
                                    </a>
                                </div>
                            </td>

                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</@main.base>