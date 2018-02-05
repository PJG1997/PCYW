function generateHandovers(){
	if(  window.confirm("确定要自动生成交接单吗?") == false){
		return;
	}
	//根据其始发配送点，终点配送点查询route表
		//1.获取始发配送点，终点配送点名
	var osids = new Array();		//存储所有被选取的始发配送点名
	var fromSpnames = new Array();		//存储所有被选取的始发配送点名
	var toSpnames = new Array();		//存储所有被选取的终点配送点名
	
	if($("input:checked").length <= 0){	//判断用户有没有选中input
		alert("您没有选中任何订单！");
		return;
	}
		//2.循环被选取的数据input标签，获取被选取的数据
	for(var i=0; i < $("input:checked").length; i++){
		osids[i] = $("input:checked").eq(i).val();
		fromSpnames[i] = $("input:checked").eq(i).parent().parent().parent().parent().find("#fromSpname").text();
		toSpnames[i] = $("input:checked").eq(i).parent().parent().parent().parent().find("#toSpname").text();
	}
//	var alertStr = "";		//用来存储需要提示的内容
	for(var i=0; i < $("input:checked").length; i++){
		//3.循环发送请求到action
		$.ajax({
			async:false, 	//设置ajax的同步
			cache:false,	//设置不缓存order
			url: "handover_add?order.osid="+osids[i]+"&order.shipPoint.spname="+fromSpnames[i]+"&order.orecSpname="+toSpnames[i],	//状态改为按钮传过来的状态值
			success: function(data){
				if(data=="error"){
					alert("错误，订单："+osids[i]+"自动生成交接单失败！");
				}else if(data=="noroute"){
					alert("没有为订单："+osids[i]+"找到合适的路线，自动生成交接单失败！");
				}else{
					alert("订单："+osids[i]+"自动生成交接单成功！");
				}
			}
		});
	}
	alert("自动生成交接单完成！");
	window.location.href="handover_selectAllNewHandovers?handover.hstatus=0";
}

