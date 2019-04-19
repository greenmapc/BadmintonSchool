<#import "../part/mainLayout.ftl" as main/>

<@main.header "Школа бадминтона">
    <#include "../part/menu.ftl">
    <div class="row justify-content-center">
        <div class="col-4 page-error-message">
            <h2>${message}</h2>
        </div>

    </div>
</@main.header>