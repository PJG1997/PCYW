<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>   
<script type="text/javascript">
	$(function(){
		$("#msg").html("");
		$.ajax({
			url:"findAllo.action",
			method:"POST",
			dataType:"JSON",
			success:function(data){
				$("#osid").html("<option>-全部-</option>");
					$.each(data.obj,function(index,item){
						$("<option value='"+item.osid+"'>"+item.osid+"</option>").appendTo($("#osid"));
					});
				
			}
		});
		$("#btn").click(function(){
			osid=$('#osid').val();
			$.ajax({
				url:"findhandover.action",
				type:"POST",
				data:{osid:osid},
				dataType:"json",
				success:function(data){
					$("#result").html("");
					if(data.code==1){
						$.each(data.obj,function(index,item){
							var tr="<tr><td>"+item.hid+"</td>";
							tr+="<td>"+item.hfromspname+"</td>";
							tr+="<td>"+item.htospname+"</td>";
							tr+="<td>"+item.status+"</td>";
							tr+="<td><a id='operation' href='javascript:update("+item.hid+")' style='color:#39f'>修改</a></td></tr>";
							$(tr).appendTo($("#result"));
						});
					}else{
						$("#msg").html("查无数据");
					}
				}
			});  
		});
	});
	function update(val){
		window.location.href='add.jsp?'+val;
	}
</script>

<center>
	<form id="myform" name="myform">
		<h1>查询交接单</h1>
		<hr />
		订单编号:<select id="osid" name="osid">
		
			  </select><br />

		<input type="button" id="btn" name="btn" value="查询"/>
	</form>
	<div id="msg"></div>
	<hr />
	<table border="1" width="600px">
		<thead>
			<tr>
				<td>交接单编号</td>
				<td>起始配送点</td>
				<td>到达配送点</td>
				<td>状态</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody id="result">
		</tbody>
	</table>	
</center>
<%@ include file="bottom.jsp" %>
