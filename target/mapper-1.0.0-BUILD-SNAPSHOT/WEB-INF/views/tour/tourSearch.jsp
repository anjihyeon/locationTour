<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
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
<script type="text/javascript">
var pageNo = ${pageNo};
var keyword = "${keyword}";
$(document).ready(function () {
	// 자동으로 늘어나는 스크롤
	// 스크롤 이벤트시 발생
	$(window).scroll(function () {
		 if($(window).scrollTop() == $(document).height() - $(window).height()) { 
	    	pageNo = pageNo +1;
	        pageNoScroll();
	    }
	});
});
function pageNoScroll(){
	$.ajax({
		url:'/scorllPage2?keyword='+keyword+'&pageNo='+pageNo,
		type: "post",
		dataType: "json",
		success : function(data){         
			$.each(data, function(idx, val) {
				$("#columns").append("<figure><a href='/tour/view?type=" + val.contenttypeid + "&contentid=" + val.contentid + "'><img class='card-img-top' src='"+ val.firstimage2 + "'></a><figcaption><a href='/tour/view?type=" + val.contenttypeid + "&contentid=" + val.contentid + "'>"+val.title+"["+val.readcount+"]</a></figcaption></figure>");
			});
		},error:function(){
			alert("결과가 없습니다.");	
		}
	})
}
</script>
</head>
<body>
<div class="container">
	<div id="columns">
		<c:forEach items="${tsList}" var="t">	
	      <figure>
	      <a href="/tour/view?type=${t.contenttypeid}&contentid=${t.contentid}">
			<img class="card-img-top" src="${t.firstimage2==null ? '/resources/img/white.jpg':t.firstimage2}">
	      </a>
	        <figcaption><a href="/tour/view?type=${t.contenttypeid}&contentid=${t.contentid}">${t.title}  [${t.readcount}]</a></figcaption>
	      </figure>
		</c:forEach>
	</div>
</div>
</body>
</html>