<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/menu.jsp" %>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<style>
#imgdiv{
	display: block;
    max-width: 1920px;
    width: 100%;
    margin: auto;
}
#div{
	display: block;
	position: absolute;
    top: 150px;
    right: 200px;
    width: 1557px;
    height: 500px;
    background-color: #0082dc;
    -webkit-animation: wideBox 1s;
    animation: wideBox 1s;
}
#img{
	display:block;
	overflow: hidden;
    position: absolute;
    top: 220px;
    left: 200px;
    width: 1300px;
    height: 560px;
    background-repeat: no-repeat;
    background-position: 0 0;
    background-size: 1300px 560px;
    -webkit-animation: wideImg 1s;
    animation: wideImg 1s;
}
#imgtitle{
	text-align: center;
	position: absolute;
	top: 50%;
	left: 70%;
	transform: translate( -50%, -50% );
}
</style>
<body>
<div id="imgdiv">
	<div id="div" style="width:890px;height: 755px;"></div>
	<div id="imgtitle"><p style="font-size: 80px;font-weight: bold;">동네 투어<br>시작해보자!</p>
	<div style="border: 1px solid white;"></div><br>
	<p style="font-size: 23px; font-weight: bold;"> 지역과 카테고리 별로 <br>
	관광지, 공연, 축제, 행사, 문화시설, 레포츠 등 <br>
	다양한 투어을 찾아보자.</p></div>
	<div id="img"><img src="/resources/img/map.jpg" height="755px" width="890px"></div>
</div>
</body>
</html>
