<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<h1>Вот твои заказы</h1>
<table class="table">
	<tr>
		<th>Номер заказа</th>
		<th>Название заказа</th>
		<th>Адрес доставки</th>
		<th>Действие</th>
		<th></th>
	</tr>
	<#list orders as order>
	<tr>
		<td>${order.id}</td>
		<td>${order.title}</td>
		<td>${order.address}</td>
		<td>
		<#if battonOne>
			<a href="/courier?id=${order.id}" class="btn btn-outline-success">Взять заказ</a>
		</#if>
		<#if battonTwo>
		<form method="post" action="courier">
		<input type="hidden" name="_csrf" value="${_csrf.token}" />		
			<button type="submit" name ="idOperator" value=${order.id} class="btn btn-outline-success">Не успеваю</button>		
		</form>
		</td>
		<td>
			<a href="/deleteOrder?idOrder=${order.id}" role="button" class="btn btn-outline-success">Посылку доставили</a>	
		</#if> 
		</td>
	</tr>
	<#else>
	На данный момент заказов нет
	</#list>	
<table>
</@c.page>