<#import "part/mainLayout.ftl" as main/>

<@main.header title="Новости">
    <#include "part/menu.ftl">

    <div class="container news">
        <div class="row">
            <#list news as new>
                <div class="col-md-4 mb-5">
                    <div class="card">
                        <div class="date card-header">
                            ${new.getNewsDate()}
                        </div>
                        <div class="card-body">
                            <div class="card-text">
                                <a href="${action("NC#getNewsItem", 0, '${new.id}')}">
                                    <img class=".img-fluid news-img"
                                         src=" <#if new.imgURI == "">
                                                    ${context.getContextPath()}/assets/img/news_default.jpg
                                                <#else>
                                                    ${new.imgURI}
                                                </#if>">
                                </a>
                            </div>
                        </div>
                        <div class="card-footer">
                            <a class="title-href" href="${action("NC#getNewsItem", 0, '${new.id}')}">
                                ${new.title}
                            </a>
                        </div>
                    </div>
                </div>
            </#list>
        </div>

        <div class="pagination-row row justify-content-center">
            <nav aria-label="News navigation">
                <ul class="pagination">
                    <#if previousPage??>
                    <li class="page-item">
                    <a class="page-link" href="${action("NC#getNews", 0, '${previousPage}')}">
                <#else>
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">
                     </#if>Предыдущая</a>
                    </li>

                    <#if nextPage??>
                    <li class="page-item">
                        <a class="page-link" href="${action("NC#getNews", 0, '${nextPage}')}">
                <#else>
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">
                    </#if>Следующая</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</@main.header>