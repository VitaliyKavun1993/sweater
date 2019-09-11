<#import "parts/commonMacro.ftl" as c>
<#import "parts/loginMacro.ftl" as l>

<@c.page>
    Add new user
    <#if message>
        ${message}
    </#if>
    <@l.login "/registration"></@l.login>
</@c.page>
