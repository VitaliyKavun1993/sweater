<#import "parts/commonMacro.ftl" as c>

<@c.page>
    User Editor

    <form action="/user" method="post">
        <input type="text" name="username" value="${user.userName}">
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}"  ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="text" value="${user.id}" name="userId">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Save</button>
    </form>
</@c.page>