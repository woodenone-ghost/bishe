<#assign ctx = request.contextPath>
<#assign basePath = request.contextPath+"/"+entityConf.abbr>
<#assign entityAbbr = entityConf.abbr>
<#assign entityNm = entityConf.entityName>
<#assign fields = entityConf.fields>

<#include "/macro/layout.ftl"/>
<#include "/macro/qryForm.ftl"/>
<#include "/macro/manage_modal.ftl"/>

<@html>
	<@page_head />
	<@page_body>
		<div class="row" style="height:830px;">
  			<div class="col-lg-2"> <!-- 左侧导航栏 -->
				<nav class="navbar bg-light navbar-light h-100">
  					<ul class="navbar-nav" style="position: relative;left: 30px;bottom: 300px;">
    					<li class="nav-item">			
      						<a class="nav-link " href="${ctx}/loginout">登 出</a>
    					</li> 
    					<li class="nav-item">			
      						<a class="nav-link " href="${ctx}/buyer/manage">买 家 管 理</a>
    					</li>
    					<li class="nav-item">
      						<a class="nav-link" href="${ctx}/seller/manage">卖 家 管 理</a>
    					</li>
    					<li class="nav-item">
      						<a class="nav-link" href="${ctx}/commodity/manage">商 品 管 理</a>
    					</li>
    					<li class="nav-item">
      						<a class="nav-link" href="${ctx}/bill/manage">账 单 管 理</a>
    					</li>
	    					<li class="nav-item dropdown">
						    	<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">图 表 查 看</a>
						    	<div class="dropdown-menu">
						    		<a class="dropdown-item" href="${ctx}/commodity/lineChart">折 线 图</a>
						      		<a class="dropdown-item" href="${ctx}/commodity/barChart">柱 状 图</a>
						      		<a class="dropdown-item" href="${ctx}/commodity/pieGraph">饼 图</a>
						    	</div>
						    </li> 	   					
  					</ul>
				</nav>
			</div>  			
  			<div class="col-lg-10"> <!-- 网页具体内容 -->
				<@qryForm id="${entityAbbr}Qry" action="${basePath}/qry">
					<@qryInput fId="idBuyer" colClass="col-lg-6" />
					<@qryInput fId="nameBuyer" colClass="col-lg-6" />
					<@qryInput fId="ageBuyer" colClass="col-lg-6" />
					<@qryInput fId="childNameBuyer" colClass="col-lg-6" />
				</@qryForm>
				
				<div style="position: relative;top: 40px;">
				<table
				  id="${entityAbbr}QryTable"
  			      data-toggle="table"
  			      data-pagination="true"
  			      data-side-pagination="server"
  			      data-query-params="queryParams"
  			      data-query-params-type=''
  			      data-single-select="true"
  				  data-click-to-select="true">
  			      <thead>
				  	<tr>
				  	  <th data-field="state" data-checkbox="true"></th>
				      <th data-field="idBuyer">${entityConf.fields["idBuyer"].fName}</th>
				      <th data-field="nameBuyer">${entityConf.fields["nameBuyer"].fName}</th>
				      <th data-field="sexBuyer">${entityConf.fields["sexBuyer"].fName}</th>
				      <th data-field="ageBuyer">${entityConf.fields["ageBuyer"].fName}</th>
				      <th data-field="childNameBuyer">${entityConf.fields["childNameBuyer"].fName}</th>
				      <th data-field="childIdentityBuyer">${entityConf.fields["childIdentityBuyer"].fName}</th>
				      <th data-field="sexBuyer">${entityConf.fields["sexBuyer"].fName}</th>
				      <th data-field="childPhoneBuyer">${entityConf.fields["childPhoneBuyer"].fName}</th>
				    </tr>
				  </thead>			  
				</table>
				</div>
			</div>  			
		</div>
	</@page_body>
	
	<@modal id="manageModal" />
	
	
	<@js_include />

	<script>
	
		jQuery.validator.addMethod("zhengzhengshu", function(value, element) {
			var zhengzhengshu =  /^[1-9]\d*$/
			return this.optional(element) || (zhengzhengshu.test(value));
		}, "请输入正确的内容");
		
		function queryParams(params) {
    		params._QRY_idBuyer = $("#idBuyer").val()
    		params._QRY_nameBuyer = $("#nameBuyer").val()
    		params._QRY_ageBuyer = $("#ageBuyer").val()
    		params._QRY_childNameBuyer = $("#childNameBuyer").val()
    		return params
  		}
  		
  		 function getData(number, size) {
    	 	$.get('${basePath}/qry', {
      			pageNumber: number,
      			pageSize: size,
      			_QRY_idBuyer : $("#idBuyer").val(),
      			_QRY_nameBuyer : $("#nameBuyer").val(),
      			_QRY_ageBuyer : $("#ageBuyer").val(),
      			_QRY_childNameBuyer : $("#childNameBuyer").val()
    		}, function (data) {
    		var $qryTable=$("#${entityAbbr}QryTable");
      		$qryTable.bootstrapTable("load", data.data.pager)
    		})
 		}
  			
		$(document).ready(function(){
			var $qryForm=$("#${entityAbbr}QryForm");
			var $qryTable=$("#${entityAbbr}QryTable");
			var $mngModal=$("#manageModal");
			
			$qryTable.on('page-change.bs.table', function (e, number, size) {
      			getData(number, size)
    		})
			
			<!-- 格式检验代码 -->
			$qryForm.validate({
				rules:{
					_QRY_idBuyer: {zhengzhengshu:true},					
					_QRY_nameBuyer: {maxlength:10},
					_QRY_ageBuyer:{
						digits:true,
						zhengzhengshu:true,
						range:[30,99]
					},
					_QRY_childNameBuyer: {maxlength:10}
				},
	        	submitHandler:function(form){
	            	$("#qryButton").attr("disabled","disabled");
	            	$(form).ajaxSubmit({
	                	type:"post",
	                    dateType:"json",
	                    success:function(resp){
	                    	$.dealAjaxResp(resp,function(data){
	                        	$("#qryButton").removeAttr("disabled");
	                            $qryTable.bootstrapTable("load",data.pager);
	                        });
	                    }
	                });
	            },
	            errorPlacement:function(error,element){
	                error.appendTo(element.parent());
	            }
        	});
			
			<!-- 删除记录代码 -->
			$("#deleteButton").click(function(){
				var rows=$qryTable.bootstrapTable('getSelections');
				if(rows==null||rows.length!=1){
					alert("请选择一条记录");
					return;
				}
				if(confirm("确认删除?")){
					$.ajax({
						url:"${basePath}/delete",
						data:{
							idBuyer:rows[0].idBuyer
						},
						method:"post",
						dataType:"json",
						success:function(resp){
							$.dealAjaxResp(resp,function(data){
								alert("删除成功");
								$qryForm.submit();
							});
						}
					});
				}
			}); 
			
            $("#editButton").click(function(){
                var rows=$qryTable.bootstrapTable('getSelections');
                if(rows==null||rows.length!=1){
                    alert("请选择一条记录");
                    return;
                }
                $mngModal.find(".modal-content").empty();
                var url="${basePath}/edit?idBuyer="+rows[0].idBuyer;
                $.get(url,function(data){
                    $mngModal.find(".modal-content").html(data);
                    $mngModal.modal('show');
                });
            });            
			
			<!-- 记录详情代码 -->			
            $("#detailButton").click(function(){
                var rows=$qryTable.bootstrapTable('getSelections');
				if(rows==null||rows.length!=1){
					alert("请选择一条记录");
					return;
				}
                $mngModal.find(".modal-content").empty();
                var url="${basePath}/detail?idBuyer="+rows[0].idBuyer;
                $.get(url,function(data){
                    $mngModal.find(".modal-content").html(data);
                    $mngModal.modal('show');
                });
            });			
			
			    
		});
		
	
	</script>
	
</@html>	