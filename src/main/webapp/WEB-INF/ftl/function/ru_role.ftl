<#function ru_role role>
    <#if role == "COACH">
        <#return "тренер">
    <#else>
        <#return "спортсмен">
    </#if>
</#function>