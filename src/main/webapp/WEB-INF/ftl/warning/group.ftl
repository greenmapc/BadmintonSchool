<#import "../part/mainLayout.ftl" as main/>

<#assign noInforamtion = "Информация не указана">

<@main.header "Not Found">

    <div class="container">
        <div class="row justify-content-center">
            <h3> Группа ${groupNumber} еще не существует! </h3>
        </div>
    </div>

</@main.header>