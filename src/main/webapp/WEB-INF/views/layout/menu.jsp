<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동네투어</title>
<!-- Bootstrap import -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;500&display=swap" rel="stylesheet">
<style>
* {
	font-family: 'Noto Sans KR', sans-serif;
}
a:link { color: black; text-decoration: none;}
a:visited { color: black; text-decoration: none;}
a:hover { color: blue; text-decoration: none;}
</style>
</head>


<body>
	<header>
		<div
			class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 bg-white border-bottom shadow-sm">
			<h5 class="my-0 mr-md-auto font-weight-normal"><a href="/"><img src="/resources/img/towntour2.jpg" style="width: 150px; height: 50px;"></a></h5>
			<nav class="my-2 my-md-0 mr-md-3">
				<a class="p-2 text-dark" href="/tour/tourlist?type=12&pageNo=1">관광지</a>
				<a class="p-2 text-dark" href="/tour/tourlist?type=14&pageNo=1">문화시설</a>&nbsp;&nbsp;
				<a class="p-2 text-dark" href="/tour/tourlist?type=15&pageNo=1">축제/공연/행사</a>&nbsp;&nbsp;
				<a class="p-2 text-dark" href="/tour/tourlist?type=28&pageNo=1">레포츠</a>&nbsp;&nbsp;
				<a class="p-2 text-dark" href="/tour/tourlist?type=39&pageNo=1">음식점</a>&nbsp;&nbsp;
				<a class="p-2 text-dark" href="/tour/tourlist?type=32&pageNo=1">숙박</a>&nbsp;&nbsp;
				<a class="p-2 text-dark" href="/tour/tourlist?type=38&pageNo=1">쇼핑센터</a>&nbsp;&nbsp;
				<a class="p-2 text-dark" href="/map">지도</a>
			</nav>
			<div class="p-2">
				<form action="/tour/tourSearch" method="get">
					<input type="text" name="keyword" value="${keyword}" style="width: 150px;"> <input
						type="hidden" name="pageNo" value="1"> <input
						type="submit" class="btn btn-sm btn-outline-secondary" value="검색">
				</form>
			</div>
		</div>
	</header>
</body>
</html>