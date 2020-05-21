<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
.card{
	text-align:center;
	width: 300px;
	height: 300px;
	display:inline-block;
    margin-bottom: 10px;
    margin-top: 10px;
}
.card img{
	width: 320px;
	height: 200px;
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
				$("#columns").append("<div class='col-md-4'><div class='card shadow' style='width: 20rem;'><div class='inner'><img class='card-img-top' src="+ val.firstimage2 +"></div><div class='card-body text-center'><a href='/tour/view?type=" + val.contenttypeid +"&contentid="+ val.contentid + "><h5 class='card-title'>"+ val.title +"</h5></a></div></div></div>");
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
       	 	<div class="row" id="columns">
			<c:forEach items="${tsList}" var="t">	
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
</body>
</html>