<#import "parts/commonMacro.ftl" as c>
<#import "parts/loginMacro.ftl" as l>

<@c.page>
    Login page
    <@l.login "/login"></@l.login>
    <a href="/registration">Add new user</a>
</@c.page>

