//回到顶部
window.onscroll=function(){
	var top=document.documentElement.scrollTop ? document.documentElement.scrollTop :document.body.scrollTop;
	//scrollTop:滚动时隐藏的高度
	var a=document.getElementById("back");
	if( top>0 ){
		a.style.display="block";
	}else{
		a.style.display="none";
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