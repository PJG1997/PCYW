function finishHandovers(){
	if(  window.confirm("确定要完成交接单吗?") == false){
		return;
	}
	//根据其始发配送点，终点配送点查询route表
		//1.获取始发配送点，终点配送点名
	var hids = new Array();		//存储所有被选取的始发配送点名
	
	if($("input:checked").length <= 0){	//判断用户有没有选中input
		alert("您没有选中任何交接单！");
		return;
	}
		//2.循环被选取的数据input标签，获取被选取的数据
	for(var i=0; i < $("input:checked").length; i++){
		hids[i] = $("input:checked").eq(i).val();
	}
	
	for(var i=0; i < $("input:checked").length; i++){
		//3.循环发送请求到action
		$.ajax({
			async:false, 	//设置ajax的同步
			cache:false,	//设置不缓存order
			url: "handover_finishHandover?handover.hid="+hids[i],	//状态改为按钮传过来的状态值
			success: function(data){
				if(data=="error"){
					alert("交接单："+hids[i]+"交接失败！");
				}else{
					alert("交接单："+hids[i]+"交接完成！");
				}
			}
		});
	}
	alert("交接操作完毕！");
	window.location.href="handover_selectHandoversByCondition?handover.hstatus=2";
}
