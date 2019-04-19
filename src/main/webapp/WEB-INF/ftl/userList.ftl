<#import "part/mainLayout.ftl" as main/>
<#import "/spring.ftl" as spring/>

<@main.header title="${pageTitle}">

    <#include "part/menu.ftl">

    <div class="container">
        <div class="col-11 list">
            <div class="row justify-content-center">
                <div class="col-3">
                    <div class="card">
                        <div class="card-header">
                            <span class="title-table-coach"> Поиск </span>
                        </div>
                        <div class="card-body">
                            <form method="get" action='${action("MC#${page}")}'>
                                <div class="container-fluid">
                                    <div class="row justify-content-center">

                                        <div class="input-group mb-1">
                                            <input type="text"
                                                   name="criteria"
                                                   class="form-control search"
                                                   placeholder="Имя и Фамилия"
                                                <#if criteria??>
                                                    value="${criteria}"
                                                </#if>
                                            >
                                        </div>

                                        <input type="submit" class="btn btn-primary submit-search" value="Найти" placeholder="Search">

                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-8">
                    <div class="card">
                        <div class="card-header">
                            <span class="title-table-coach"> ${pageTitle} </span>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-border table-hover table-fluid" id="coachTable">
                                    <tr>
                                        <th>Логин</th>

                                        <th>Фамилия</th>
                                        <th>Имя</th>
                                        <th>Отчество</th>
                                    </tr>

                                    <#list users as user>
                                        <tr onclick="window.location.href='${action('UC#personalProfile', 0, user.getUsername())}'"">
                                            <td>${normalize('${user.getUsername()}')}</td>

                                            <td>${normalize('${user.getSurname()}')}</td>
                                            <td>${normalize('${user.getName()}')}</td>
                                            <#if user.getPatronymic()??>
                                                <td>${normalize('${user.getPatronymic()}')}</td>
                                            <#else>
                                                <td></td>
                                            </#if>
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