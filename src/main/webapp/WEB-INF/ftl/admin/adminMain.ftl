<#import "../part/mainLayout.ftl" as main/>

<@main.header title='Страница админа'>
    <div class="container admin-page">
        <div class="row justify-content-center">
            <div class="col-3">
                <p class="admin-headline"> Группы </p>
                <ul class="admin">
                    <li class="admin-section">
                        <a href="#"> Добавить группу </a>
                    </li>
                    <li class="admin-section">
                        <a href="#"> Посмотреть все группы </a>
                    </li>
                </ul>
            </div>
            <div class="col-5">
                <div class="card">
                    <div class="date card-header">
                        Работа с группами
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
                                            <a class="btn" href="#">
                                                Новая
                                            </a>
                                            <a class="btn" href="#">
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
        </div>
    </div>
</@main.header>