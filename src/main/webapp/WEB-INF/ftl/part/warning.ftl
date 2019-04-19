<#macro emptyField value = "">
    <#if value != "">
        ${normalize('${value}')}
    <#else>
        Информация не указана
    </#if>
</#macro>