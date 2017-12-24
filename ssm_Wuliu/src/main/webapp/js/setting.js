
function ChangeHeads(){
	var hs = document.getElementById("h-s");
	var mbd = document.getElementById("m-bd");
	mbd.style.display="none";
	hs.style.display="block";
}

function PersonSetting(){
	var hs = document.getElementById("h-s");
	var mbd = document.getElementById("m-bd");
	
	hs.style.display="none";
	mbd.style.display="block";
	
}

var pp ; //图片路径

function setImagePreviews(imagesObj,divid) {
    var dd = document.getElementById(divid);
    dd.style.display="block";
    dd.innerHTML = "";
    var fileList = imagesObj.files;
    for (var i = 0; i < fileList.length; i++) {            
        dd.innerHTML += "<div style='float:left;border:2px solid #95B8E7;margin-right:10px;margin-bottom:10px' > <img id='"+divid+"_img" + i + "'  /> </div><a href='javascript:save_pic()'><img src='images/baocun.jpg'/></a>";
        var imgObjPreview = document.getElementById(divid+"_img"+i); 
        if (imagesObj.files && imagesObj.files[i]) {
            //火狐下，直接设img属性
            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '322px';
            imgObjPreview.style.height = '322px';
            imgObjPreview.src = window.URL.createObjectURL(imagesObj.files[i]);
            pp=imgObjPreview.src;
            var bp = document.getElementById("big_pic");
            var sp = document.getElementById("small_pic");
            bp.src=pp;
            sp.src=pp;
            
        }else {
            //IE下，使用滤镜
            imagesObj.select();
            var imgSrc = document.selection.createRange().text; //运用IE滤镜获取数据;
            //alert(imgSrc);
            var localImagId = document.getElementById("img" + i);
            //必须设置初始大小
            localImagId.style.width = "80px";
            localImagId.style.height = "80px";
            //图片异常的捕捉
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader( true,sizingMethod=scale,src = imgSrc)";  //scale：缩放图片以适应对象的尺寸边界。
            }
            catch (e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty(); //在当前网页下不能选择对象,也就是鼠标不能选中 
        }
    }  
    return true;
}

function save_pic(){
	var photo = pp;
	var hs = document.getElementById("h-s");
	var mbd = document.getElementById("m-bd");
	var ul = document.getElementById("ul-2");
	hs.style.display="none";
	mbd.style.display="block";
	ul.src=photo;
	
	
	
	
	
}

var photo;

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
		
	//140字
	var txt=document.getElementById("signature");
		txt.onkeydown=function(){
			var txt=this.value;
			if(txt.length>139){
				alert("error");	
				}else{
					document.getElementById("remain").innerHTML=139-txt.length;	
					}
			}
	
	//年月日
	window.onload=function(){
			//首先，先放年
			for(var i=new Date().getFullYear();i>=1900;i--){
				//           id       文本值  value值
					addOption("birth_year",i,i);	
				}	
			
			//然后，放月
			for(var i=1;i<=12;i++){
					addOption("birth_month",i,i);	
				}
			//先默认每个月都放31天
			for(var i=1;i<=31;i++){
					addOption("birth_day",i,i);		
				}
			}
			
			function setDays(year,month,day){
					var monthDays=[31,28,31,30,31,30,31,31,30,31,30,31];
					var myyear=year.options[year.selectedIndex].text;
					var mymon=month.options[month.selectedIndex].text;
					
					var num=monthDays[mymon-1];
					
					if( mymon==2 && isLeapYear(myyear) ){
							num++;	
						}
						
						
					for(var j=day.options.length-1;j>num;j--){
							day.remove(j);//29						
						}
					for(var k=day.options.length;k<num;k++){
							addOption("birth_day",k,k);	
						}

				//console.log(myyear+"--"+mymon+"--"+num);
				}
			
		function addOption(id,txt,value){
				var option=document.createElement("option");
				option.text=txt;
				option.value=value;
				//添加
				document.getElementById(id).options.add(option);
			}
		function isLeapYear(year){
				return ( (year%4==0 && year%100!=0)  ||year%400==0);	
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


//保存
function save(){
	var uname = $.trim( $("#user_name").val() );//获取昵称
	var sex = null;
	var obj = document.getElementsByName("sex");
	for(var i=0,len=obj.length;i<len;i++){
		if(obj[i].checked){
			sex=obj[i].value;//获取性别
		}
	}
	var year=$("#birth_year option:selected").text();
	var month=$("#birth_month option:selected").text();
	var day=$("#birth_day option:selected").text();
	
	var birth=year+"-"+month+"-"+day;//获取出生年月
	var province=$("#province option:selected").text();//获取地区省份
	var city=$("#city option:selected").text();//获取城市
	var mark=$.trim($("#signature").val());
	var photo = pp;
	
	
	/*$.post("userServlet",{op:"updateUserInfo",uname:uname,sex:sex,birth:birth,province:province,city:city,mark:mark},function(data){
		data=parseInt($.trim(data));
		if(data>0){
			alert("修改成功");
			
		}else{
			alert("修改失败");
		}
	},"text");
	*/
	
	$.ajaxFileUpload({
		url:"userServlet?op=updatePic",
		secureuri:false,
		fileElementId:"uf",
		dataType:"text",
		data:{photo:pp,uname:uname,sex:sex,birth:birth,province:province,city:city,mark:mark},
		success:function(data,status){
			
			data=parseInt($.trim(data));
			if(data>0){
				alert("修改成功");
				location.href="person.jsp";
			}else{
				alert("修改失败");
			}
		},
		error:function(data,status,e){
			alert("修改失败");
		}
	});
	
	
	
}


