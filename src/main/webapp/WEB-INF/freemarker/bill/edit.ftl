<#assign ctx = request.contextPath>
<#assign basePath = request.contextPath+"/"+entityConf.abbr>
<#assign entityAbbr = entityConf.abbr>

<#include "/macro/layout.ftl"/>
<#include "/macro/qryForm.ftl"/>
<#include "/macro/manage_modal.ftl"/>

<@modalShow title="修改">
	<@editForm id="${entityAbbr}Edit" action="${basePath}/edit/submit">
		<@editHidden fId="id" type="hidden"/>
		<@detail fId="id" />
		<@edit fId="accountBuyer" />
		<@edit fId="idCommodity" />
		<@edit fId="accountSeller" />
		<@edit fId="quantity" />
		<@edit fId="price" />
		<@edit fId="state" />
		<@edit fId="evaluationPrice" />
		<@edit fId="evaluationService" />
		<@edit fId="evaluation" />
	</@editForm>
</@modalShow>

<script>
	$(document).ready(function(){
		var $editForm=$("#${entityAbbr}EditForm");
		var $mngModal=$("#manageModal");
		
		<!-- 格式检验代码 -->
		$editForm.validate({
			rules:{
				id: {digits:true},	
				accountBuyer: {maxlength:32},
				idCommodity: {digits:true},	
				nameSeller: {maxlength:32},						
				quantity: {digits:true},	
				price: {digits:true},			
			},
	        submitHandler:function(form){
	            $("#editSubmitButton").attr("disabled","disabled");
	            $(form).ajaxSubmit({
	                type:"post",
	                dateType:"json",
	                success:function(resp){
	                	$.dealAjaxResp(resp,function(data){
	                	$("#editSubmitButton").removeAttr("disabled");
	                	alert("修改成功");
	                    });
	                }
	            });
	        },
	        errorPlacement:function(error,element){
	            error.appendTo(element.parent());
	        }
        });			
	});
</script>