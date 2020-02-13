<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<form method="post" action="search">
    <div class="input-group mb-3">
        <input type="text" name="search" class="form-control" placeholder="Введите номер заказа" aria-label="Recipient's username" aria-describedby="button-addon2">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="input-group-append">
        	<button type="submit" class="btn btn-sm btn-outline-success" id="button-addon2">Найти/Показать все</button>
        </div>
	</div>
</form>  
<h1>Добавление заказа</h1>    
<form method="post" action="/main">
	<input type="text" name="title" class="form-control" placeholder="Введите заказ" />
	<input type="text" name="address" class="form-control mb-1" placeholder="Адрес">
	<input type="hidden" name="_csrf" value="${_csrf.token}" />
	<button type="submit" class="btn btn-sm btn-outline-success mb-5" >Отдать заказ курьеру</button>	
</form>
<div>
	<table class="table">
	    <tr>
	    	<th>Номер заказа</th>
	    	<th>Название заказа</th>
	    	<th>Адрес доставки</th>
	    	<th>Статус заказа</th>
	    	<th></th>
	    </tr>
	    <#list orders as order>
	    <tr>
			<td>${order.id}</td>
			<td>${order.title}</td>
			<td>${order.address}</td>
			<td>${order.status}</td>
			<td><a href="/delete?id=${order.id}" role="button" class="btn btn-outline-success">Удалить</a></td>	 
		 </tr>
		<#else>
			<h1>Заказов нет</h1>
		</#list>	
	<table>
<div>
</@c.page>