var cropper=null;
var options=null;

$(function(){
	options ={thumbBox : '.thumbBox',spinner : '.spinner',imgSrc : 'images/head.jpg'};
	cropper = $('.imageBox').cropbox(options);
	$('#upload-file').on('change', function() {
		var reader = new FileReader();
		reader.onload = function(e) {
			options.imgSrc = e.target.result;
			cropper = $('.imageBox').cropbox(options);
		}
		reader.readAsDataURL(this.files[0]);
		this.files = [];
	});
	
	$('#btnCrop').on('click',function() {
		var img = cropper.getDataURL();
		$('.cropped').html('');
		$('.cropped').append('<img id="headinfo1" src="'+img+'" align="absmiddle" style="width:64px;margin-top:4px;border-radius:64px;box-shadow:0px 0px 12px #7E7E7E;" ><p>64px*64px</p>');
		$('.cropped').append('<img id="headinfo2" src="'+img+'" align="absmiddle" style="width:128px;margin-top:4px;border-radius:128px;box-shadow:0px 0px 12px #7E7E7E;"><p>128px*128px</p>');
		$('.cropped').append('<img id="headinfo3" src="'+img+'" align="absmiddle" style="width:180px;margin-top:4px;border-radius:180px;box-shadow:0px 0px 12px #7E7E7E;"><p>180px*180px</p>');
	});

	$('#btnZoomIn').on('click', function() {
		cropper.zoomIn();
	});
	
	$('#btnZoomOut').on('click', function() {
		cropper.zoomOut();
	});
});

function init(t) {
	accessLocalWebCam("navy_video");
	$("#showVideo").css("display","block");
}

window.URL = window.URL || window.webkitURL || window.msURL || window.oURL;
navigator.getUserMedia = navigator.getUserMedia|| navigator.webkitGetUserMedia || navigator.mozGetUserMedia|| navigator.msGetUserMedia;

function isChromiumVersionLower() {
	var ua = navigator.userAgent;
	var testChromium = ua.match(/AppleWebKit\/.* Chrome\/([\d.]+).* Safari\//);
	return (testChromium && (parseInt(testChromium[1].split('.')[0]) < 19));
}

function successsCallback(stream) {
	document.getElementById('navy_video').src = (window.URL && window.URL.createObjectURL) ? window.URL.createObjectURL(stream): stream;
}

function errorCallback(err) {

}

var context=null;
var video=null;
var videoWidth = 0;  
var videoHeight = 0;  

function accessLocalWebCam(id) {
	try {
		navigator.getUserMedia({
			video : true
		}, successsCallback, errorCallback);
	} catch (err) {
		navigator.getUserMedia('video', successsCallback, errorCallback);
	}
}

window.addEventListener("DOMContentLoaded", function() {
	var canvas = document.createElement("canvas"),
	context = canvas.getContext("2d"),
	video = document.getElementById("navy_video"),
	videoObj = {
		"video" : true
	}, errBack = function(error) {
		
	};
	
	video.addEventListener("canplay", function () {  
        canvas.width = videoWidth =$("#navy_video").width();  
        canvas.height = videoHeight = $("#navy_video").height();  

        context.fillStyle = '#ffffff';  
        context.fillRect(0, 0, videoWidth, videoWidth);  
        video.removeEventListener("canplay", arguments.callee);  
	 });  
	
	
	document.getElementById("snap").addEventListener("click", function() {
		$("#showVideo").css("display","none");
		
		context.drawImage(video, 0, 0,videoWidth, videoHeight);
		
		var dataUrl = canvas.toDataURL("image/png");
		$("#imageBox").css("background-image","url("+dataUrl+")");
		
		options.imgSrc=dataUrl;
		cropper = $('#imageBox').cropbox(options);
	});
}, false);

function uploadHead() {
	var pic = $("#headinfo2").attr("src");
	pic = pic.replace(/^data:image\/(png|jpg);base64,/, "");
	
	$.post("uploadServlet",{imageData:pic},function(data){
		data=parseInt($.trim(data));
		
		if(data==1){
			alert("图片上传成功...");
		}else{
			alert("图片上传失败...");
		}
	},"text");
}