<#import "parts/common.ftl" as c>

<@c.page>
${message?ifExists}
<form action="/registration" method="post">
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
	<div class="form-check ">
		<input class="form-check-input" type="radio" name="role" value="2" checked>
		<label class="form-check-label" for="exampleRadios1">Курьер</label>
	</div>
	<div class="form-check">
		<input class="form-check-input" type="radio" name="role" value="3">
		<label class="form-check-label" for="exampleRadios2">Оператор</label>
	</div>
	<div class="form-check">
		<input class="form-check-input" type="radio" name="role" value="1">
		<label class="form-check-label" for="exampleRadios3">Администратор</label>
	</div>
	<div class="container-lg">
    <input type="submit" class="btn btn-sm btn-outline-success" value="Зарегистрироваться"/>
    </div>
</form>
</@c.page>