<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<h1>Вот твои заявки</h1>
<form method="post" action="searchBid" >
    <div class="input-group mb-5">
        <input type="text" name="searchBid" class="form-control" placeholder="Введите номер заказа" aria-label="Recipient's username" aria-describedby="button-addon2">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="input-group-append">
        	<button type="submit" class="btn btn-sm btn-outline-success" id="button-addon2">Найти/Показать все</button>
        </div>
	</div>
</form>
<table class="table">
	<tr>
		<th>Номер заказа</th>
		<th>Название заказа</th>
		<th>Адрес доставки</th>
		<th>Дата отказа курьера</th>
		<th>Действие</th>
	</tr>
	<#list orders as order>
	<tr>
		<td>${order.id}</td>
		<td>${order.title}</td>
		<td>${order.address}</td>
		<td>${order.date}</td>
		<td>
		<#if battonOne>
			<a href="/operator?id=${order.id}" class="btn btn-outline-success">Позвонить клиенту</a>
		</#if>
		<#if battonTwo>
			<a href="/deletebid?idOrder=${order.id}" role="button" class="btn btn-outline-success">Отдать заказ курьеру</a>	
		</#if>
		</td>
	</tr>
	<#else>
	<h1>Заявок нету</h1>
	</#list>
<table>
</@c.page>