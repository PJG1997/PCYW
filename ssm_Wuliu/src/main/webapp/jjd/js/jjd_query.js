$(document).ready(function(){		//文档一加载就给交接单界面查出所有的订单号，所有的始发地，终止地
	$.getJSON("handover_selectNeededItems",function(data){
		//取XXXX属性:data[index].XXXX或value.XXXX
		var osidStr="<option value=''>--订单号--</option>";
		var fromStr="<option value=''>--始发地--</option>";
		var toStr="<option  value=''>--目的地--</option>";
		
		$("#osids").html("");
		$.each(data.osids,function(index,value){
	        osidStr+="<option value="+value+">";
	        osidStr+=value;
	        osidStr+="</option>";
		});
		
		$("#froms").html("");
		$("#tos").html("");
		$.each(data.froms,function(index,value){
			fromStr+="<option value='"+value+"'>";
			fromStr+=value;
			fromStr+="</option>";
			toStr+="<option value='"+value+"'>";
			toStr+=value;
			toStr+="</option>";
		});
		
		$("#osids").html(osidStr);
		$("#froms").html(fromStr);
		$("#tos").html(toStr);
	});
});

