

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="submit" class="btn btn-sm btn-outline-success" value="Выйти"/>
</form>
</#macro>
