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
@font-face { font-family: 'GmarketSansBold'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansBold.woff') format('woff'); font-weight: normal; font-style: normal; }
*{
	font-family: 'GmarketSansBold';
}
#search{
	display: inline-block;
	padding-left: 10%;
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
<%-- <header>
	<div id="hometitle">
		<a class="text-muted" href="/">동네 투어</a>
	</div>
	<div id="search">
		<form action="/tour/tourSearch" method="get">
			<input type="text" name="keyword" value="${keyword}">
			<input type="hidden" name="pageNo" value="1">
			<input type="submit" class="btn btn-sm btn-outline-secondary" value="검색"> 
		</form>
	</div>
</header> --%>
</body>
</html>