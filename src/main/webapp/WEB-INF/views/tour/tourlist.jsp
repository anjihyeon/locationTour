<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../layout/menu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<meta charset="UTF-8">
	<title></title>
<script src="/resources/js/jquery.imageScroll.js"></script>

<style>
select{
  display: inline-block;
  float: left;
  margin-left: 10px;
}
.card{
	text-align:center;
	width: 300px;
	height: 300px;
	display:inline-block;
    margin-bottom: 10px;
}
.card img{
	width: 320px;
	height: 200px;
}
.listmain{
	width: 100%;
	height: 400px;
	background-size:  cover;
}
.listmain p {
	text-align: center;
}
.inner{
    overflow: hidden;
}
 
.inner img{
    transition: all 1.5s ease;
}
 
.inner:hover img{
    transform: scale(1.5);
}
</style>
<head>
<script type="text/javascript">
var pageNo = ${pageNo};
var contenttypeid =${type};	

$(document).ready(function () {
	// 자동으로 늘어나는 스크롤
	// 스크롤 이벤트시 발생
	$('.listmain').imageScroll({
		 coverRatio: 0.5
	});
	
	$(window).scroll(function () {
		 //if($(window).scrollTop() == $(document).height() - $(window).height()) { 
	    //}
		 var maxHeight = $(document).height();
		 var currentScroll = $(window).scrollTop() + $(window).height();
		 if (maxHeight <= currentScroll + 10) {
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
				$("#columns").append("<div class='col-md-4'><div class='card shadow' style='width: 20rem;'><div class='inner'><img class='card-img-top' src="+ val.firstimage2 +"></div><div class='card-body text-center'><a href='/tour/view?type=" + val.contenttypeid +"&contentid="+ val.contentid + "><h5 class='card-title'>"+ val.title +"</h5></a></div></div></div>");
			});
		},error:function(){
			alert("ERROR");	
		}
	})
}
</script>
</head>
<body>

<c:choose>
	<c:when test="${type eq 12}">
	<div class="listmain border-bottom shadow-sm" data-image="/resources/img/img1.jpg">
		<p>관광지</p>	
	</div>
	</c:when>
	
	<c:when test="${type eq 14}">
	<div class="listmain border-bottom shadow-sm" data-image='/resources/img/img8.jpg'>	
		<p>문화시설</p>
	</div>	
	</c:when>
	
	<c:when test="${type eq 15}">
	<div class="listmain border-bottom shadow-sm"  data-image='/resources/img/img9.jpg'>	
		<p>행사/공연/축제</p>
	</div>
	</c:when>
	
	<c:when test="${type eq 28}">
	<div class="listmain border-bottom shadow-sm"  data-image='/resources/img/img3.jpg'>	
		<p>레포츠</p>
	</div>
	</c:when>
	
	<c:when test="${type eq 32}">
	<div class="listmain border-bottom shadow-sm"  data-image='/resources/img/img6.jpg'>	
		<p>숙박</p>
		</div>
	</c:when>
	
	<c:when test="${type eq 38}">
	<div class="listmain border-bottom shadow-sm"  data-image='/resources/img/img5.jpg'>	
		<p>쇼핑</p>
	</div>	
	</c:when>
	
	<c:when test="${type eq 39}">
	<div class="listmain border-bottom shadow-sm"  data-image='/resources/img/img7.jpg'>	
		<p>음식점</p>
		</div>
	</c:when>
</c:choose>	

</div>
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
		<h4 class='h4'></h4><br><br>	
</div>
<div>
	    <div class="container">
       	 	<div class="row" id="columns">
			<c:forEach items="${tList}" var="t">	
            <div class="col-md-4">
                <div class="card shadow" style="width: 20rem;">
                    <div class="inner">
                        <img class="card-img-top" src="${t.firstimage2==null ? '/resources/img/white.jpg':t.firstimage2}">
                    </div>
                    <div class="card-body text-center">
                      <a href="/tour/view?type=${t.contenttypeid}&contentid=${t.contentid}">
                      ${t.title}
					</a>                   
                    </div>
                  </div>
            </div>
            </c:forEach>
        	</div>
        </div>
</div>
</div>
</body>
</html>
