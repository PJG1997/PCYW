$(function(){
	
	 page=1;
	 rows=5;
	
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
				
				sp.append("<option >"+item.hfromspname+"</option>");
				ep.append("<option >"+item.htospname+"</option>");
				
				var str="<tr><td>"+(index+1)+"</td>";
				str+="<td >"+item.hid+"</td>";
				str+="<td >"+item.osid+"</td>";
				str+="<td >"+item.hfromspname+"</td>";
				str+="<td >"+item.htospname+"</td>";
				str+="<td >"+gettime(item.hstarttime)+"</td>";
				if(item.dname==null){
					str+="<td >无</td>";
				}else{
					str+="<td >"+item.dname+"</td>";
				}
				if(item.cnumber==null){
					str+="<td >无</td>";
				}else{
					str+="<td >"+item.cnumber+"</td>";
				}
				
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
	
	$("#froms option").each(function(){
		var text= $(this).text();
		
		
		
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
	var osid=$("#osid").val();
	var hstarttime=$("#starttime").val();
	var hfromspname=$("#froms").find("option:selected").text();
	var htospname=$("#tos").find("option:selected").text();
	
	$.ajax({
		url:"../selectInfo.action",
		data:{hstatus:hstatus,osid:osid,hstarttime:hstarttime,hfromspname:hfromspname,htospname:htospname},
		dataType:"JSON",
		method:"POST",
		success:function(data){
			console.info(data);
			var jjdtable=$("#jjdInfo"); //获取表格对象
			jjdtable.html("");
			$.each(data.rows,function(index,item){
				var str="<tr><td>"+(index+1)+"</td>";
				str+="<td>"+item.hid+"</td>";
				str+="<td>"+item.osid+"</td>";
				str+="<td>"+item.hfromspname+"</td>";
				str+="<td>"+item.htospname+"</td>";
				str+="<td>"+gettime(item.hstarttime)+"</td>";
				if(item.dname==null){
					str+="<td >无</td>";
				}else{
					str+="<td >"+item.dname+"</td>";
				}
				if(item.cnumber==null){
					str+="<td >无</td>";
				}else{
					str+="<td >"+item.cnumber+"</td>";
				}
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
		
		
	
}

function nextPage(){
	
	page=page+1;
	rows=5;
	
	$.ajax({
		url:"../findAllhandover.action",
		data:{page:page,rows:rows},
		dataType:"JSON",
		method:"POST",
		success:function(data){
			console.info(data.total);
			if(data.total==0){
				alert("当前已经是最后一页");
				page=page-1;
			}else{
				var jjdtable=$("#jjdInfo"); //获取表格对象
				jjdtable.html("");
				$.each(data.rows,function(index,item){
					
					var str="<tr><td>"+(index+1)+"</td>";
					str+="<td >"+item.hid+"</td>";
					str+="<td >"+item.osid+"</td>";
					str+="<td >"+item.hfromspname+"</td>";
					str+="<td >"+item.htospname+"</td>";
					str+="<td >"+gettime(item.hstarttime)+"</td>";
					if(item.dname==null){
						str+="<td >无</td>";
					}else{
						str+="<td >"+item.dname+"</td>";
					}
					if(item.cnumber==null){
						str+="<td >无</td>";
					}else{
						str+="<td >"+item.cnumber+"</td>";
					}
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
		}
	});
	
	
}


function lastPage(){
	page=page-1;
	rows=5;
	
	if(page<=0){
		alert("当前已经是首页");
		page=1;
	}else{
		$.ajax({
			url:"../findAllhandover.action",
			data:{page:page,rows:rows},
			dataType:"JSON",
			method:"POST",
			success:function(data){
				
				var jjdtable=$("#jjdInfo"); //获取表格对象
				jjdtable.html("");
				$.each(data.rows,function(index,item){
					
					var str="<tr><td>"+(index+1)+"</td>";
					str+="<td >"+item.hid+"</td>";
					str+="<td >"+item.osid+"</td>";
					str+="<td >"+item.hfromspname+"</td>";
					str+="<td >"+item.htospname+"</td>";
					str+="<td >"+gettime(item.hstarttime)+"</td>";
					if(item.dname==null){
						str+="<td >无</td>";
					}else{
						str+="<td >"+item.dname+"</td>";
					}
					if(item.cnumber==null){
						str+="<td >无</td>";
					}else{
						str+="<td >"+item.cnumber+"</td>";
					}
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
	}
	
}

//去掉重复的表格数据
function clearTable(){
	var finaljjdTable=$("#jjdInfo"); //获取表格对象
	
}