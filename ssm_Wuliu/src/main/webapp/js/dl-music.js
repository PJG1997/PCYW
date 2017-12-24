
window.onload=function(){
	$.post("songSheetServlet",{op:"findAll"},function(data){
		var str="";
		console.info(data);
		var SongNum = data.length;
		$.each(data,function(data,item){
			
			
			
			
			
			var ssid = item.ssid;
			str+= '<ul class="l-2">';
			str+='<li class="li1">';
			str+='<div class="gd" >';
			if(item.photo==null){
				str+='<div class="left"><a href="javascript:editSheet()"><img src="images/3397490930543093.jpg" /></a></div>';
			}else{
				str+='<div class="left"><a href="javascript:editSheet()"><img src="'+item.photo+'" /></a></div>';

			}
			str+=' <p  class="name"><a id="gd_name'+item.ssid+'" href="javascript:editSheet('+ssid+')">'+item.ssname+'</a></p>';
			str+='<p id="gqcount" class="num">'+0+'首</p>';
			str+='</div></li></ul>';
			
		});
		$("#bd-1").append($(str)); 
	},"json");
	
	
	
	
}


/*
function editSongSheet(){
	var gdedit1 = document.getElementById("editor-gd");
	var gd_header = document.getElementById("gd-header");
	gd_header.style.display="none";
	gdedit1.style.display="block";
	
}*/



function editSheet(ssid){
	var nlist = document.getElementById("n-list");
	var gd_header = document.getElementById("gd-header");
	
	nlist.style.display="none";
	gd_header.style.display="block";
	
	var gdid = ssid;
	
	console.info(gdid);
	
	var gdname = $("#gd_name"+ssid).html();
	
	$("#f-ff2").html(gdname);
	
	
	$.post("songServlet",{op:"findSheetSong",ssid:gdid},function(data){
		var songStr="";
		console.info(data.length);
		if(data.length!=undefined){
			$("#songcount").html(data.length);
			
		}else{
			$("#songcount").html(0);
			
		}
		
		$("#m-table tfoot").html("");
		$.each(data,function(data,item){
			
			songStr+=' <tfoot><tr id="tr_body" class="even"><td><div class="hd">';
			songStr+='<span class="num">'+(data+1)+'</span>   </div></td> ';
			songStr+='<td class="rank"><div class="tt">';
			songStr+='<img src="'+item.photo+'" style="height:50px;width:50px;"/><a id="ply_'+item.sid+'" href="javascript:playSong()"><span id="ply" class="ply"><i id="ply_i" style="display:none;">'+item.saddr+'</i></span></a><div class="ttc"><span class="txt"> ';
			songStr+='<a href="">'+item.sname+'</a></span></div></div></td> ';
			songStr+=' <td class="sc_md"><div class="md2"><span class="time">'+item.longs+'</span></div>';
			songStr+=' <div class="lqbz"><a id="tj_'+item.sid+'" class="md_tj" href="javascript:addSong('+item.sid+')"></a><a id="sc_'+item.sid+'" class="md_sc" href="javascript:colSong('+item.sid+')"></a><a class="md_fx" href=""></a><a class="md_xz" href=""></a> </div> </td>';
			songStr+=' <td class="gs_md"><div><a href="" title="歌手">'+item.singerName+' </a> </div></td> </tr></tfoot>';
			
		});
		$("#m-table").append(songStr);
	
		
	},"json");
	
	
	
	
	
}
                        	
                           
function playSong(){
	
	var addr = $("#ply_i").html();
	console.info(addr);
	$("#song_listen audio").attr("src",addr).attr("autoplay",true);
	
}                            
                         	
                           
                           

//新建歌单
function addSongSheet(){
	
	var add = document.getElementById("new-gd");
	var qd=document.getElementById("qd");
	
	add.style.display="block";
	
	
		
	
	
	qd.onclick=function(){
		
		var name=$.trim($("#gdname").val());
		var songSheetStr="";
		songSheetStr+= '<ul class="l-2">';
		songSheetStr+='<li class="li1">';
		songSheetStr+='<div class="gd" >';
		songSheetStr+='<div class="left"><a href="javascript:void(0)"><img src="images/3397490930543093.jpg" /></a></div>';
		songSheetStr+=' <p class="nam"><a href="javascript:void(0)">'+name+'</a></p>';
		songSheetStr+='<p class="num">0首</p>';
		songSheetStr+='</div></li></ul>  ';
	    
		$.post("songSheetServlet",{op:"addSongSheet",ssname:name},function(data){
			data = parseInt($.trim(data));
			if(data==1){
				  $("#bd-1").append($(songSheetStr));   
				    add.style.display="none";
				    location.reload();
			}else{
				alert('添加失败');
			}
		},"text");
		
		
	  
	}
	
	
}

var add = document.getElementById("new-gd");
var cls2=document.getElementById("cls-2");


cls2.onclick=function(){
	add.style.display="none";
}
























//改变nav的背景

function change_hd(obj){
	var h=document.getElementById("head").getElementsByTagName("a");
	for(var i=0;i<h.length;i++){
		h[i].className="";
	}
	obj.className="first_a";
}



//获焦失焦
var ipt=document.getElementById("ipt");
ipt.onfocus=function(){
	if(ipt.placeholder!=""){
		ipt.placeholder="";
	}else if(ipt.value==""){
		onblur();
	}else{
		ipt.setAttribute("value",this.value);
	}
}
ipt.onblur=function(){
	ipt.placeholder="单曲/歌手/专辑/歌单/MV/用户";
}








//设置移入移出事件
var btmbar=document.getElementsByClassName("btmbar")[0];
btmbar.addEventListener("mouseover", btmover,false) ;
//btmbar.onmouseover=btmover;
	function btmover(){

		btmbar.style.bottom="0px";
	}
btmbar.addEventListener("mouseout",btmOut,false)
//btmbar.onmouseout= btmOut;
	function btmOut (){
		btmbar.style.bottom="-46px";
	}



//对锁加点击事件
	var flg=true;

	var btn=document.getElementsByClassName("btn")[0];
		btn.addEventListener("click",aaa);
			function aaa(){
				if(flg){
					btn.style['background-position-x']='-100px';
					btmbar.removeEventListener("mouseout",btmOut)
					btmbar.style.bottom="0px";
						}else{
							btmbar.addEventListener("mouseout",btmOut,false)
							btn.style['background-position-x']='-80px';
						};
						flg=!flg;
		}

//音乐播放器
		function playOrPause(obj){
			if(audio.paused){
				audio.play();
				run(); 		
				}else{
					audio.pause();	
					}
			}
		function aa(){
			var bb=document.getElementById("ply1");
			bb.style['background-position-y']='-165px';	
			}
		function cc(){
			var dd=document.getElementById("ply1");
			dd.style['background-position-y']='-204px';
			}
			
			
			
			
		//上一首和下一首			
		function shang(obj){
				var ply=document.getElementById("ply1");
				audio.src="music/刘涛 - 说不出口.mp3";
				audio.play();
				ply.style['background-position-y']='-165px';
				var rdy = document.getElementsByClassName("rdy")[0]; 
				rdy.style.width = "0";
				run();
				var na=document.getElementById("na");
				var st=document.getElementById("st");
				na.innerText="说不出口";
				st.innerText="刘涛";
			}
			
		function xia(obj){
				var ply=document.getElementById("ply1");
				audio.src="music/PICO太郎 - Pen Pineapple apple Pen - Hoaprox remix.mp3";
				audio.play();		
				ply.style['background-position-y']='-165px';
				var rdy = document.getElementsByClassName("rdy")[0]; 
				rdy.style.width = "0";
				run();
				var na=document.getElementById("na");
				var st=document.getElementById("st");
				na.innerText=" Pen Pineapple apple Pen - Hoaprox remix";
				st.innerText="PICO太郎";
		}
			
		//进度条
		var timeout;
	    function run(){
			if(audio.paused){
				setTimeout("run","100000");
			}else{  
				var rdy = document.getElementsByClassName("rdy")[0]; 
				rdy.style.width=parseInt(rdy.style.width) + 2 + "px";  
				var curr=getCurrentTime();
				var myem=document.getElementById("myem");
				myem.innerText=curr;
				if(rdy.style.width == "100%"){ 
					clearInterval(timeout);
				} 
			}
			
		  } 
		timeout=window.setInterval("run()",1000); 
		
		
		//获取播放时间
		function getCurrentTime(){
			var time=audio.currentTime;
			var minute=parseInt(time/60);
			var second=parseInt(time%60);
			var t=toTwo(minute)+":"+toTwo(second);
			return t;
		}
		function toTwo(n){
			return n<10 ? "0"+n : ""+n;
		}
		
		//音量
		function vol(){
			var vo=document.getElementById("volu");
			if(vo.style.display=="none"){
				vo.style.display="block";
			}else{
				vo.style.display="none";
			}
		}
		function volu(type){
			if(type=="up"){
				var volume = audio.volume + 0.1;
				if(volume >=1 ){
					volume = 1 ;
				}
				audio.volume = volume;
			}else if(type == 'down'){
				var volume = audio.volume - 0.1;
				if(volume <=0 ){
					volume = 0 ;
				}
				audio.volume = volume;
			}
			document.getElementById("volu").innerHTML=Math.round(audio.volume*100);
		}
		
		
		//快捷键
		document.onkeydown=function(event){
			var e=arguments[0]||window.event;
			var keycode=e.keyCode;
			//空格  ->   播放暂停
			if(keycode==32){
				playOrPause();
				var dd=document.getElementById("ply1");
				dd.style['background-position-y']='-204px';
			}
			//ctrl + ↑  ->  音量+
			if(e.ctrlKey && keycode==38){
				volu("up");
			}
			if(e.ctrlKey && keycode==39){
				audio.currentTime=audio.currentTime+5;
			}
			//ctrl + ↓  ->  音量-
			if(e.ctrlKey && keycode==40){
				volu("down");
			}
		}