<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>
<style>
#update_handover li {
	list-style-type: none;
	margin-top: 20px;
}

#update_handover {
	border: 1px solid #95b8e7;
	line-height: 20px;
}</style>
<script type="text/javascript">
$(function(){
	$("#msg").html("");
	var hid=window.location.href.split('?')[1];
	$.ajax({
		url:'getspnameByupdate.action',
		method:"POST",
		dataType:"JSON",
		data:{hid:hid},
		success:function(data){
					$("#fromspname").html(data.obj.hfromspname);
					$("#tospname").html(data.obj.htospname);
					$("#osid").html(data.obj.order1.osid);
					$("#cnumber").html(data.obj.car.cnumber);
					$("#dname").html(data.obj.driver.dname);
					$("#cid").val(data.obj.car.cid);
					$("#did").val(data.obj.driver.did);
					$("#starttime").val(data.obj.starttime);
					$("#endtime").val(data.obj.endtime);
					$("#hstatus").val(data.obj.hstatus);
					$("#remark").val(data.obj.hremark);
		}
	})
	$("#btn").click(function(){
		osid=$("#osid").html();
		cnumber=$("#cid").val();
		dname=$("#did").val();
		hstarttime=$("#starttime").val();
		hendtime=$("#endtime").val();
		hstatus=$("#hstatus").val();
		hremark=$("#remark").val();
		hfromspname=$("#fromspname").val();
		htospname=$("#tospname").val();
		$.ajax({
			url:"Onlyupdatehandover.action",
			method:"POST",
			data:{osid:osid,hfromspname:hfromspname,htospname:htospname,cnumber:cnumber,dname:dname,hstarttime:hstarttime
				,hendtime:hendtime,hstatus:hstatus,hremark:hremark,hid:hid},
			dataType:"json",
			success:function(data){
				if(data.code==1){
					location.href='jjd/jjd_query.jsp';
					$("#msg").html("添加成功...");
				}else{
					$("#msg").html("添加失败..."+data.msg);
				}
			}
		});
	});
});

</script>

<center>
	<form id="myform" name="myform">
		<h1>修改交接单</h1>
		<hr />

		订单编号:<label id="osid"></label><br />
		司机姓名:<label id="dname" name="dname">
			  </label><br />
			  <input id="did" name="did" type="hidden"></input>
	  	车  牌  号:<label id="cnumber" name="cnumber">
		
			  </label><br />
			  <input id="cid" name="cid" type="hidden"></input>
		<label>起始配送点名称:</label><label id="fromspname"></label><br />
		<label>到达配送点名称:</label><label id="tospname"></label><br />
		起始时间:<input type="text"
				name="update_insert_hendtime" id="starttime"
				onfocus="WdatePicker({lang:'en'})" class="Wdate" /><br />
		到达时间:<input type="text"
				name="update_insert_hendtime" id="endtime"
				onfocus="WdatePicker({lang:'en'})" class="Wdate" /><br />
		交接单状态:<select id="hstatus" name="hstatus">
				<option value="0">未发车</option>
					<option value="1">已发车</option>
					<option value="2">已完成</option>
			  </select><br />
		<label>备注:</label><br/><textarea rows="10" cols="100"
				name="remark"	id="remark"></textarea><br />
		<input type="button" id="btn" value="修改交接单"/>
	</form>
</center>

<div id="msg"></div>

<%@ include file="bottom.jsp" %>