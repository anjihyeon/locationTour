<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/menu2.jsp" %>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<style>
.row{
	position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
}
#div2{
	display:block;
	background-color: #0082dc;
	width: 30%;
	float: right;
}
#img{
	width: 70%;
	float: left;
	z-index: -1;
}
#img img{
}
#hometitle{
	position: absolute;
	margin: 10px;
}
#hometitle a{
	color: white;
}
ul {
	list-style:none;
}
li{
	margin-top: 10px;
	margin-left: 10px; 
}
li a{	
	display: block;
	color: black;
	font-size: 50px;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#li1").mouseover(function(){ 
			 $("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/li1.png").fadeIn(300);
			 })
		});
		$("#li1").mouseout(function(){
			 $("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/map.jpg").fadeIn(300);
			 })
		});
		$("#li2").mouseover(function(){
			$("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/li2.jpg").fadeIn(300);
			})
		});
		$("#li2").mouseout(function(){
			$("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/map.jpg").fadeIn(300);
			})
		});
		$("#li3").mouseover(function(){
			$("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/li3.jpg").fadeIn(300);
			})
		});
		$("#li3").mouseout(function(){
			$("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/map.jpg").fadeIn(300);
			})
		});
		$("#li4").mouseover(function(){
			$("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/li4.jpg").fadeIn(300);
			})
		});
		$("#li4").mouseout(function(){
			$("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/map.jpg").fadeIn(300);
			})
		});
		$("#li5").mouseover(function(){
			$("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/li5.jpg").fadeIn(300);
			})
		});
		$("#li5").mouseout(function(){
			$("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/map.jpg").fadeIn(300);
			})
		});
		$("#li6").mouseover(function(){
			$("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/li6.jpg").fadeIn(300);
			})
		});
		$("#li6").mouseout(function(){
			$("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/map.jpg").fadeIn(300);
			})
		});
		$("#li7").mouseover(function(){
			$("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/li7.jpg").fadeIn(300);
			})
		});
		$("#li7").mouseout(function(){
			$("#img1").fadeOut(200,function(){
				$("#img1").attr("src","/resources/img/map.jpg").fadeIn(300);
			})
		});
	});
</script>
<body>
<div class="container">
  <div class="row">
    <div id="img">
    	<img id="img1" src="/resources/img/map.jpg" style="width: 100%;height: 100%;">
    </div>
    <div id="hometitle">
		<a href="/">동네 투어</a>    
    </div>
    <div id="div2">
		<!-- <p style="font-size: 80px;font-weight: bold; text-align: center;">동네 투어<br>시작해보자!</p>
		<div style="border: 1px silver black;"></div><br>
		<p style="font-size: 23px; font-weight: bold; text-align: center;"> 지역과 카테고리 별로 <br>
		관광지, 공연, 축제, 행사, 문화시설, 레포츠 등 <br>
		다양한 투어을 찾아보자.</p></div>   -->
			<ul>
			 <li><a id="li1" href="/tour/tourlist?type=12&pageNo=1">관광지</a></li>
			 <li><a id="li2" href="/tour/tourlist?type=14&pageNo=1">문화시설</a></li>
			 <li><a id="li3" href="/tour/tourlist?type=15&pageNo=1">축제/공연/행사</a></li>
			 <li><a id="li4" href="/tour/tourlist?type=28&pageNo=1">레포츠</a></li>
			 <li><a id="li5" href="/tour/tourlist?type=39&pageNo=1">음식점</a></li>
			 <li><a id="li6" href="/tour/tourlist?type=32&pageNo=1">숙박</a></li>
			 <li><a id="li7" href="/tour/tourlist?type=38&pageNo=1">쇼핑센터</a></li>
			 <li><a id="li8" href="/map">지도</a>
			</ul>
    </div>
  </div>
</div>
</body>
</html>
