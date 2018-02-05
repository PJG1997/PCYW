//$(document).ready(function(){
//	$.getJSON("handover_selectAvailableCarByCon",function(data){
//		$("#showCar").html("");
//		var tablestr="";
//		tablestr+="<tr bgcolor=\"#FFFFFF\"><td width=\"9%\">序号</td><td width=\"11%\" height=\"25\">车牌号</td><td width=\"9%\">营运证号</td><td width=\"9%\">" +
//		"车型</td><td width=\"7%\">容积(m3)<br></td><td width=\"5%\">吨位</td><td width=\"9%\">是否箱式<br></td><td width=\"9%\">购买日期<br></td>" +
//		"<td width=\"5%\">车辆状态<br></td><td width=\"9%\">备注</td><td width=\"9%\">操作</td> ";
//		
//		$.each(data.map,function(key,value){
//			tablestr+="</tr><tr bgcolor=\"#FFFFFF\"> ";
//			tablestr+="<td width=\"9%\"><input type=\"checkbox\" name=\"carnum\" >"+value.cid+"</td>";
//			tablestr+="<td width=\"8%\" height=\"25\">"+value.cnumber+"<br></td>";
//			tablestr+="<td width=\"8%\">"+value.crunNum+"<br></td>";
//			tablestr+="<td width=\"8%\">"+value.ctype+"<br></td>";
//			tablestr+="<td width=\"7%\" >"+value.cvolume+"<br></td>";
//			tablestr+="<td width=\"5%\">"+value.cton+"</td>";
//			if(value.cisBox==0){
//				tablestr+="<td width=\"9%\">箱式<br></td>";
//			}
//			if(value.cisBox==1){
//				tablestr+="<td width=\"9%\">非箱式<br></td>";
//			}
//			tablestr+="<td width=\"10%\" >"+value.cbuyDay+"</td>";
//			if(value.cstatus==0){
//				tablestr+="<td width=\"6%\" >空闲<br></td> ";
//			}
//			if(value.cstatus==1){
//				tablestr+="<td width=\"6%\" >已出车<br></td>"; 
//			}
//	        tablestr+="<td width=\"9%\" >"+value.cremark+"<br></td>";
//	        tablestr+="<td width=\"9%\" ><a href=\"handover_updateManual?handover.hid="+value.cid+"&car.cnumber="+value.cnumber+"&car.crunNum="+value.crunNum+
//	        	"&car.ctype="+value.ctype+"&car.cvolume="+value.cvolume+"&car.cton="+value.cton+"&car.cisBox="+value.cisBox+
//	        	"&car.cbuyDay="+value.cbuyDay+"&car.cremark="+value.cremark+"\"></a></td></tr>";
//		});
//		tablestr+="<tr bgcolor=\"#FFFFFF\"><td colspan=\"11\" style=\"text-align:center\"><a href=\"#\"> 首页</a> &nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\">上 一页</a> &nbsp;&nbsp; &nbsp;&nbsp;<a href=\"#\">下一页</a> &nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\">末页</a></td></tr>";
//	
//		$("#showCar").html(tablestr);
//
//	});
//});

//$("#chaxun").click(function(){
//	var volume=$("#volume").val();//取出车的容积
//	var number=$("#number").val();//取出车牌号
//	var status=$("#status").val();//取出车状态
//	if (volume== "") {
//		if(number==""){
//			if(status==""){
//				alert("请填写查询条件");
//				return ;
//			}
//		}
//	}
//	var volumeStr=encodeURIComponent(volume);
//	var numberStr=encodeURIComponent(number);
//	var statusStr=encodeURIComponent(status);
//	var r=Math.random();

//else{
//tablestr+="<tr bgcolor=\"#FFFFFF\"><td colspan=\"11\" style=\"text-align:center\"></td></tr><tr bgcolor=\"#FFFFFF\">";
//tablestr+="<td colspan=\"12\" style=\"text-align:center\">没有符合条件的记录</td></tr>";
//$("#volume").val("");
//$("#number").val("");
//$("#status").val("");
//$("#showCar").html(tablestr);
//}