<#import "part/mainLayout.ftl" as main/>

<@main.header "Школа бадминтона">
    <#include "part/menu.ftl">

    <div class="container main-text">
        <img src="${context.getContextPath()}/assets/img/main-img.png" class="main-img" alt="main-img">
        <h3 class="head-text"> Добро пожаловать на сайт! </h3>

        <p class="content-text"> Данная система предназначена для тренеров и учеников нашей спортивной школы. <br>
            &nbsp; <br>
            – &nbsp; Сервис хранит информацию о каждом спортсмене. <br>
            – &nbsp; Тренерам сервис будет полезен наличием информации о спортсменах и списков групп в профиле. </p>

        <p class="content-text"> Для регистрации на нашем сайте необходимо состоять в спортивной школе. </p>


        <p class="content-text"> Если вы хотите поступить в нашу школу, то свяжитесь с нами по контактам, указанным на сайте.</p>
    </div>
</@main.header>
