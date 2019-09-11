<#import "parts/commonMacro.ftl" as c>
<#import "parts/loginMacro.ftl" as l>

<@c.page>
<div>добавление слова</div>

<div>
    <form  method="post">
        <input type="text" name="word" placeholder="Введите слово">
        <input type="text" name="translation" placeholder="Введите перевод">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Добавить</button>
    </form>
    <form method="post" action="/filterByWord">
        <input type="text" name="filter">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Найти</button>
    </form>

</div>

<div>
    <@l.logout></@l.logout>
</div>


<div>список сообщений</div>
    <#list words as word>
        <div>
            <b>${word.id}</b>
            <span>${word.word}</span>
            <i>${word.translation}</i>
            <strong>${word.authorName}</strong>
        </div>
        <#else>
        No words
    </#list>
</@c.page>