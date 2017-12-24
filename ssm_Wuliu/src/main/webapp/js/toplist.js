// JavaScript Document


  
               		
                   		
                       		
                            
                      
                    
                    	
                       		
                            
                            
                           		
                               		
                                   
                           
                   
                        	
                        
                       
                       		
                   
                    	
                   			
                       
//排行榜从数据库添加歌曲
window.onload = function(){
	
	$.post("songServlet",{op:"findAll"},function(data){
		var songStr="";
		console.info(data.length);
	
		$.each(data,function(data,item){
			songStr+=' <tr class="even"><td><div class="hd">';
			songStr+='<span class="num">'+(data+1)+'</span>   </div></td> ';
			songStr+='<td class="rank"><div class="tt">';
			songStr+='<img src="'+item.photo+'" style="height:50px;width:50px;"/><span class="ply"></span><div class="ttc"><span class="txt"> ';
			songStr+='<a href="">'+item.sname+'</a></span></div></div></td> ';
			songStr+=' <td class="sc_md"><div class="md2"><span class="time">'+item.longs+'</span></div>';
			songStr+=' <div class="lqbz"><a id="tj_'+item.sid+'" class="md_tj" href="javascript:addSong('+item.sid+')"></a><a id="sc_'+item.sid+'" class="md_sc" href="javascript:colSong('+item.sid+')"></a><a class="md_fx" href=""></a><a class="md_xz" href=""></a> </div> </td>';
			songStr+=' <td class="gs_md"><div><a href="" title="歌手">'+item.singerName+' </a> </div></td> </tr>';
			
		});
		$("#m-table").append(songStr);
	
		
	},"json");
	
}

//添加歌曲到播放列表
function addSong(id){
	
	
	
}

		
			
	
	

// 收藏歌曲到歌单
function colSong(id){
	var aut_zc = document.getElementById("aut-sc");
	aut_zc.style.display="block";
	var sid = id;
	console.info(sid);
	//先清除一遍ul
	$("#gdlist").children("li").remove();
	
	
	$.post("songSheetServlet",{op:"findAllByUsid"},function(data){
		var sheetStr="";
		
		$.each(data,function(data,item){
			
			if(item.photo==null){
				item.photo="images/3397490930543093.jpg";
			}
			sheetStr+='<li><div id="mt-right"><div class="left">';
			sheetStr+='<a href="dl-mymusic.jsp"><img src="'+item.photo+'" style="height:40px;width:40px;" />';
			sheetStr+='	</a></div><p class="gd-name"><a  href="javascript:toSongSheet('+item.ssid+','+sid+','+item.song+')">'+item.ssname+'</a>';
			sheetStr+='	</p><p class="gd-num">0首</p></div></li>';
		});
		$("#gdlist").append($(sheetStr));
	},"json");
	
}

function toSongSheet(ssid,sid,song){
	var gdid = ssid;
	var gqid = sid;
	var songs = song;
	
	console.info(songs);
	
	
	$.post("songSheetServlet",{op:"addSong",ssid:gdid,sid:gqid},function(data){
	
		data = parseInt($.trim(data));
		if(data>0){
			alert('收藏成功');
		}else{
			alert('收藏失败');
		}
		
		
		
		
		
	},"text");
	
	
	
}
//关闭按钮
var aut_zc = document.getElementById("aut-sc");
var close = document.getElementById("cls-3");
close.onclick=function(){
	aut_zc.style.display="none";
	//location.reload();
}


//"搜索界面"的聚焦和失焦事件
var ipt=document.getElementById("ipt");
ipt.onfocus=function(){
	if(ipt.placeholder!=""){
		ipt.placeholder="";
	}else if(ipt.value==""){
		onblur();
	}
}
ipt.onblur=function(){
	ipt.placeholder="单曲/歌手/专辑/歌单/MV/用户";
}



//"回到顶部"按钮的显示或隐藏
document.getElementsByClassName("body1")[0].onscroll = function () {
var top=document.getElementsByClassName("body1")[0].scrollTop;

if (top>0) {

		document.getElementById("toTop").style.display = "block";
	}else{

		document.getElementById("toTop").style.display = "none";
		}
	}

//改变nav的背景
function change_bg(obj){
	var a=document.getElementById("nv").getElementsByTagName("a");
	for(var i=0;i<a.length;i++){
		a[i].className="";
	}
	obj.className="n_tj";
}

function change_hd(obj){
	var h=document.getElementById("head").getElementsByTagName("a");
	for(var i=0;i<h.length;i++){
		h[i].className="";
	}
	obj.className="first_a";
}	


//登录框
var other=document.getElementById("other");
var sj=document.getElementById("sj");
var IsMousedown, LEFT, TOP, login;
var mov=document.getElementById("mov");
console.log(mov);
	mov.onmousedown=function(e) {
	var e=arguments[0]||window.event;
	login = document.getElementById("aut");
	IsMousedown = true;
	LEFT = e.clientX - parseInt(login.style.left);
	TOP = e.clientY - parseInt(login.style.top);
	document.onmousemove = function(e) {
		var e=arguments[0]||window.event;
		if (IsMousedown) {
			login.style.left = e.clientX - LEFT + "px";
			login.style.top = e.clientY - TOP + "px";
		}
	}
	document.onmouseup=function(){
		IsMousedown=false;
	}
}
var aut=document.getElementById("aut");
var login=document.getElementById("login");
var cls=document.getElementById("cls");
login.onclick=function(){
	aut.style.display="block";
}
cls.onclick=function(){
	aut.style.display="none";
}
sj.onclick=function(){
	aut.style.display="none";
	aut1.style.display="block";
}
other.onclick=function(){
	aut.style.display="block";
	aut1.style.display="none";
}


//手机号登陆
var sjdl=document.getElementById("sjdl");
var aut1=document.getElementById("aut-phone");
var IsMousedown, LEFT, TOP, login;
var mov1=document.getElementById("mov-1");
var cls1=document.getElementById("cls-1");
var wyyx=document.getElementById("wyyx");
var wydl=document.getElementById("wydl");
console.log(mov1);
	mov1.onmousedown=function(e) {
	var e=arguments[0]||window.event;
	login = document.getElementById("aut-phone");
	IsMousedown = true;
	LEFT = e.clientX - parseInt(login.style.left);
	TOP = e.clientY - parseInt(login.style.top);
	document.onmousemove = function(e) {
		var e=arguments[0]||window.event;
		if (IsMousedown) {
			login.style.left = e.clientX - LEFT + "px";
			login.style.top = e.clientY - TOP + "px";
		}
	}
	document.onmouseup=function(){
		IsMousedown=false;
	}
}
sjdl.onclick=function(){
	aut.style.display="none";
	aut1.style.display="block";
}
wyyx.onclick=function(){
	aut1.style.display="block";
}
wydl.onclick=function(){
	aut.style.display="none";
	aut1.style.display="block";
}
cls1.onclick=function(){
	aut1.style.display="none";
}

//注册
var zc=document.getElementById("aut-zc");
console.log(zc);
var zc1=document.getElementById("zc-1");
var zc2=document.getElementById("zc-2");
var cls2=document.getElementById("cls-2");
var ret=document.getElementById("ret1");
zc1.onclick=function(){
	zc.style.display="block";
	aut1.style.display="none";
	aut.style.display="none";
}
zc2.onclick=function(){
	zc.style.display="block";
	aut1.style.display="none";
	aut.style.display="none";
}
cls2.onclick=function(){
	zc.style.display="none";
}
ret.onclick=function(){
	zc.style.display="none";
	aut.style.display="block";
}
var IsMousedown, LEFT, TOP, login;
var mov2=document.getElementById("mov-2");
mov2.onmousedown=function(e) {
	var e=arguments[0]||window.event;
	login = document.getElementById("aut-zc");
	IsMousedown = true;
	LEFT = e.clientX - parseInt(login.style.left);
	TOP = e.clientY - parseInt(login.style.top);
	document.onmousemove = function(e) {
		var e=arguments[0]||window.event;
		if (IsMousedown) {
			login.style.left = e.clientX - LEFT + "px";
			login.style.top = e.clientY - TOP + "px";
		}
	}
	document.onmouseup=function(){
		IsMousedown=false;
	}
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
		//播放/暂停
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
		