<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../layout/menu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<style>
select{
  display: inline-block;
  float: left;
  margin-left: 10px;
}
.select{
}
#columns figure{
	text-align:center;
	display:inline-block;
	width: 33%;
   	margin:0;
    margin-bottom: 15px;
    padding:10px;
}
#columns figure img{
    width:300px;
    height: 200px;
}
#columns figure figcaption{
    padding:10px;
    margin-top:11px;
}
</style>
<head>
<script type="text/javascript">
var pageNo = ${pageNo};
var contenttypeid =${type};	

$(document).ready(function () {
	// 자동으로 늘어나는 스크롤
	// 스크롤 이벤트시 발생
	
	$(window).scroll(function () {
		 if($(window).scrollTop() == $(document).height() - $(window).height()) { 
	    	pageNo = pageNo +1;
	        pageNoScroll();
	    }
	});
	$('#addrCode').on('change', function() {
		var addrCode = this.value;
		var url='/tour/tourAddrCodelist?type='+contenttypeid+'&pageNo='+pageNo+'&addrCode='+addrCode;
		location.href = url;
	});
	$('#cat1').on('change', function() {
		var cat1 = this.value;
		var url='/tour/tourCat1list?type='+contenttypeid+'&pageNo='+pageNo+'&cat1='+cat1;
		location.href = url;
	});
	$('#cat2').on('change', function() {
		var cat2 = this.value;
		var cat1 = cat2.substr(0,3);

		var url='/tour/tourCat2list?type='+contenttypeid+'&pageNo='+pageNo+'&cat1='+cat1+'&cat2='+cat2;
		location.href = url;
		$('.h4').text(cat1name+"-"+cat2name);
	});
	$('#cat3').on('change', function() {
		var cat3 = this.value;
		var cat2 = cat3.substr(0,5);
		var cat1 = cat2.substr(0,3);
		var url='/tour/tourCat3list?type='+contenttypeid+'&pageNo='+pageNo+'&cat1='+cat1+'&cat2='+cat2+'&cat3='+cat3;
		location.href = url;
	});
});
function pageNoScroll(){
	$.ajax({
		url:'/scorllPage?type='+contenttypeid+'&pageNo='+pageNo,
		type: "post",
		dataType: "json",
		success : function(data){         
			$.each(data, function(idx, val) {
				$("#columns").append("<figure><a href='/tour/view?type=" + val.contenttypeid + "&contentid=" + val.contentid + "'><img class='card-img-top' src='"+ val.firstimage2+"'></a><figcaption><a href='/tour/view?type=" + val.contenttypeid + "&contentid=" + val.contentid + "'>"+val.title+"["+val.readcount+"]</a></figcaption></figure>");
			});
		},error:function(){
			alert("ERROR");	
		}
	})
}
</script>
<meta charset="UTF-8">
	<title></title>
</head>
<body>
<div  class="container">
<div class="select">

		<select name="addrCode" id="addrCode">
			<option selected value="0">전국</option>
		<c:forEach items="${lList}" var="l">
			<option value="${l.code}">${l.name}</option>
		</c:forEach>
		</select>

		<select name="cat1" id="cat1">
			<option selected value="0">대분류</option>
		<c:forEach items="${cList}" var="c">
			<option value="${c.code}">${c.name}</option>
		</c:forEach>
		</select>

		<select name="cat2" id="cat2">
			<option selected value="0">중분류</option>
		<c:forEach items="${c2List}" var="c">
			<option value="${c.code}">${c.name}</option>
		</c:forEach>
		</select>

		<select name="cat3" id="cat3">
			<option selected value="0">소분류</option>
		<c:forEach items="${c3List}" var="c">
			<option value="${c.code}">${c.name}</option>
		</c:forEach>
		</select>
		<h4 class='h4'></h4><br>	
</div>
<div>
	<div id="columns">
		<c:forEach items="${tList}" var="t">	
	      <figure>
	      <a href="/tour/view?type=${t.contenttypeid}&contentid=${t.contentid}">
			<img class="card-img-top" src="${t.firstimage2==null ? '/resources/img/white.jpg':t.firstimage2}">
	      </a>
	        <figcaption><a href="/tour/view?type=${t.contenttypeid}&contentid=${t.contentid}">${t.title}  [${t.readcount}]</a></figcaption>
	      </figure>
		</c:forEach>
	</div>
</div>
</div>
</body>
</html>
