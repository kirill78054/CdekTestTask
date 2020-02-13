<#import "parts/common.ftl" as c>

<@c.page>
<form action="/login" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Логин :</label>
        <div class="col-sm-4">
            <input type="text" name="username" class="form-control" placeholder="Логин" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Пароль:</label>
        <div class="col-sm-4">
            <input type="password" name="password" class="form-control" placeholder="Пароль" />
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <a href="/registration" class="btn btn-sm btn-outline-success">Регистрация</a>
    <button class="btn btn-sm btn-outline-success" type="submit">Войти</button>
</form>
</@c.page>