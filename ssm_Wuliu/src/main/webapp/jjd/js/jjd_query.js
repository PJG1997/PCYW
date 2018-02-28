$(function(){
	
	var page=1;
	var rows=5;
	
	$.ajax({
		url:"../findAllhandover.action",
		data:{page:page,rows:rows},
		dataType:"JSON",
		method:"POST",
		success:function(data){
			var sp = $("#froms"); //获取起始点对象
			var ep = $("#tos"); //获取终止点对象
			var jjdtable=$("#jjdInfo"); //获取表格对象
			$.each(data.rows,function(index,item){
				var i =0;
				sp.append("<option value='"+i+"'>"+item.hfromspname+"</option>");
				ep.append("<option value='"+i+"'>"+item.htospname+"</option>");
				i++;
				var j=1;
				var str="<tr><td>"+j+"</td>";
				str+="<td >"+item.hid+"</td>";
				str+="<td >"+item.osid+"</td>";
				str+="<td >"+item.hfromspname+"</td>";
				str+="<td >"+item.htospname+"</td>";
				str+="<td >"+gettime(item.hstarttime)+"</td>";
				str+="<td >"+item.dname+"</td>";
				str+="<td >"+item.cnumber+"</td>";
				str+="<td >"+gettime(item.hendtime)+"</td>";
				var status='未知';
				if(item.hstatus==0){
					status="未发车";
				}else if(item.hstatus==1){
					status="已发车";
				}else{
					status="已完成";
				}
				str+="<td name='status'>"+status+"</td></tr>"
				jjdtable.append(str);
			});
			
			
			
		}
	});
});

  //获取时间
  function gettime(t){
    var _time=new Date(t);
    var   year=_time.getFullYear();//2017
    var   month=_time.getMonth()+1;//7
    var   date=_time.getDate();//10
    var   hour=_time.getHours();//10
    var   minute=_time.getMinutes();//56
    var   second=_time.getSeconds();//15
    return   year+"年"+month+"月"+date+"日   "+hour+":"+minute+":"+second;//这里自己按自己需要的格式拼接
}

function search(){
	var hstatus = $("#hstatus").val();
	var hid=$("#osid").val();
	var hstarttime=$("#starttime").val();
	var hfromspname=$("#froms").find("option:selected").text();
	var htospname=$("#tos").find("option:selected").text();
	
	
	$.ajax({
		url:"../selectInfo.action",
		data:{hstatus:hstatus,hid:hid,hstarttime:hstarttime,hfromspname:hfromspname,htospname:htospname},
		dataType:"JSON",
		method:"POST",
		success:function(data){
			
		}
	});
		
		
	
}