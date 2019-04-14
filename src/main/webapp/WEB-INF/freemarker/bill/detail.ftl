<#assign ctx = request.contextPath>

<#include "/macro/layout.ftl"/>
<#include "/macro/qryForm.ftl"/>
<#include "/macro/manage_modal.ftl"/>

<@modalShow title="详情">
	<@detail fId="id" />
	<@detail fId="idBuyer" />
	<@detail fId="idCommodity" />
	<@detail fId="idSeller" />
	<@detail fId="quantity" />
	<@detail fId="price" />
	<@detail fId="time" />
	<@detail fId="state" />
	<@detail fId="evaluation" />
</@modalShow>