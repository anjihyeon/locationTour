<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동네투어</title>
<style>
@font-face { font-family: 'Eoe_Zno_L'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_eight@1.0/Eoe_Zno_L.woff') format('woff'); font-weight: normal; font-style: normal; }
*{
	font-family: 'Eoe_Zno_L';
}
#menu{
	display: inline-block;
	padding-left: 10%;
}
#menu a{
	font-size: 22px;
}
#hometitle{
	font-weight: bold;
	font-size: 30px;
	padding: 40px;
	display: inline-block;
}
</style>
</head>
<!-- Bootstrap import -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<link href="https://fonts.googleapis.com/css?family=Playfair+Display&display=swap" rel="stylesheet">
<body>
<header>
	<div id="hometitle">
		<a class="p-2 text-muted" href="/">동네 투어</a>
	</div>
	<div class="nav-scroller py-1 mb-2" id="menu">
		<nav class="nav d-flex justify-content-between">
			 <a class="p-2 text-muted" href="/tour/tourlist?type=12&pageNo=1">관광지</a>&nbsp;&nbsp;
			 <a class="p-2 text-muted" href="/tour/tourlist?type=14&pageNo=1">문화시설</a>&nbsp;&nbsp;
			 <a class="p-2 text-muted" href="/tour/tourlist?type=15&pageNo=1">축제/공연/행사</a>&nbsp;&nbsp;
			 <a class="p-2 text-muted" href="/tour/tourlist?type=28&pageNo=1">레포츠</a>&nbsp;&nbsp;
			 <a class="p-2 text-muted" href="/tour/tourlist?type=39&pageNo=1">음식점</a>&nbsp;&nbsp;
			 <a class="p-2 text-muted" href="/tour/tourlist?type=32&pageNo=1">숙박</a>&nbsp;&nbsp;
			 <a class="p-2 text-muted" href="/tour/tourlist?type=38&pageNo=1">쇼핑센터</a>&nbsp;&nbsp;
			 <a class="p-2 text-muted" href="/map">지도</a>
			  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 <div class="p-2">
				<form action="/tour/tourSearch" method="get">
					<input type="text" name="keyword" value="${keyword}">
					<input type="hidden" name="pageNo" value="1">
					<input type="submit" class="btn btn-sm btn-outline-secondary" value="검색"> 
				</form>
			</div>
		</nav>
	</div>
</header>
</body>
</html>