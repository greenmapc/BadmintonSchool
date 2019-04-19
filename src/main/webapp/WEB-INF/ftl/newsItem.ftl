<#import "part/mainLayout.ftl" as main/>

<@main.header title="${news.title}">
    <#include "part/menu.ftl">

    <div class="container news">
        <div class="row justify-content-center">
            <div class="col-md-4 mb-5">
                <img class=".img-fluid news-img"
                     src=" <#if news.imgURI == "">
                                ${context.getContextPath()}/assets/img/news_default.jpg
                            <#else>
                                ${news.imgURI}
                            </#if>">
            </div>
            <div class="col-md-7 news-desc">
                ${news.text}
            </div>
        </div>
    </div>
</@main.header>