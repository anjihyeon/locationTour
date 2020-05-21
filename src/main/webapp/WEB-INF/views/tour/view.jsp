<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../layout/menu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
#div1 img{
	display: block; margin: 0px auto;
}
#map{
	display: block; margin: 0px auto;
}
h2,h3{
	font-weight: bold;
}
#sharebtn{
	text-align: center;
	
}
</style>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
<div class="container">
<div id="div1">
<c:forEach items="${tiList }" var="ti">
<img src="${ti.firstimage}"> <br>
<h2>${ti.title}</h2>
<div style="border: 2px solid black;"></div>
주소 : ${ti.addr1 }<br>
${ti.overview } <br>
</c:forEach>
</div>
<div>
<br>
<h3>이용안내</h3>
<div style="border: 2px solid black;"></div>
<c:forEach items="${tList}" var="t">
		<script>
			var contentid = ${t.contentid};
			var type = ${t.contenttypeid};
		</script>
<c:choose>


		<c:when test="${t.contenttypeid eq 12}"> <!-- 관광지 -->
			체험안내 : ${t.expguide} <br>
			문의 및 안내 : ${t.infocenter} <br>
			주차시설 : ${t.parking} <br>
			휴무일 : ${t.restdate} <br>
			이용시기 :${t.useseason} <br>
			이용시간 : ${t.usetime}
		</c:when>  
		<c:when test="${t.contenttypeid eq 14}"> <!-- 문화시설 -->
			문의 및 안내 : ${t.infocenterculture} <br>
			주차시설 : ${t.parkingculture} <br>
			휴무일 : ${t.restdateculture} <br>
			이용요금 : ${t.userfee} <br>
			이용시간 :${t.usetimeculture} <br>
			관람소요시간 : ${t.spendtime}
		</c:when>  
		<c:when test="${t.contenttypeid eq 15}"> <!-- 행사공연축제 -->
			예매처 : ${t.bookingplace} <br>
			행사 홈페이지 : ${t.eventhomepage} <br>
			행사 장소 :${t.eventplace} <br>
			행사 위치안내 : ${t.placeinfo} <br>
			행사 시작일 : ${t.eventstartdate} <br>
			행사 종료일 : ${t.eventenddate} <br>
			공연시간 : ${t.playtime} <br>
			행사 프로그램 :${t.program} <br>
			이용요금 : ${t.usetimefestival} <br>
			관람 소요시간 : ${t.spendtimefestival} <br>
			관람가능연령 : ${t.agelimit} <br>
		</c:when>  
		<c:when test="${t.contenttypeid eq 25}"> <!-- 여행코스 -->
			코스 총거리 : ${t.distance} <br>
			문의 및 안내 : ${t.infocentertourcourse} <br>
			코스 일정 : ${t.schedule} <br>
			코스 총 소요시간 : ${t.taketime} <br>
			코스 테마 :${t.theme} <br>
		</c:when>  
		<c:when test="${t.contenttypeid eq 28}"> <!-- 레포츠 -->
			체험 가능연령 : ${t.expagerangeleports} <br>
			문의 및 안내 : ${t.infocenterleports} <br>
			개장기간 : ${t.openperiod} <br>
			주차시설 : ${t.parkingleports} <br>
			예약안내 :${t.reservation} <br>
			휴무일 : ${t.restdateleports} <br>
			입장료 :${t.usefeeleports} <br>
			이용시간 : ${t.usetimeleports} <br>
		</c:when>  
		<c:when test="${t.contenttypeid eq 32}"> <!-- 숙박 -->
			수용 가능인원 : ${t.accomcountlodging} <br>
			입실시간 : ${t.checkintime} <br>
			퇴실 시간 : ${t.checkouttime} <br>
			객실내 취사 여부 : ${t.chkcooking} <br>
			문의 및 안내 :${t.infocenterlodging} <br>
			주차시설 : ${t.parkinglodging} <br>
			픽업 서비스 : ${t.pickup} <br>
			객실수 : ${t.roomcount} <br>
			예약안내 : ${t.reservationlodging} <br>
			예약안내 홈페이지 : ${t.reservationurl} <br>
			객실유형 :${t.roomtype} <br>
			규모 : ${t.scalelodging} <br>
			환불규정 :${t.refundregulation} <br>
		</c:when>
		<c:when test="${t.contenttypeid eq 38}"> <!-- 쇼핑 -->
			장서는 날 : ${t.fairday} <br>
			문의 및 안내 : ${t.infocentershopping} <br>
			개장일 : ${t.opendateshopping} <br>
			영업시간 : ${t.opentime} <br>
			주차시설 :${t.parkingshopping} <br>
			휴무일 : ${t.restdateshopping} <br>
			판매품목 :${t.saleitem} <br>
			매장안내 : ${t.shopguide} <br>
		</c:when>  
		<c:when test="${t.contenttypeid eq 39}"> <!-- 음식점 -->
			대표 메뉴 : ${t.firstmenu} <br>
			문의 및 안내 : ${t.infocenterfood} <br>
			개업일 : ${t.opendatefood} <br>
			영업시간 : ${t.opentimefood} <br>
			휴무일 :${t.restdatefood} <br>
			취급메뉴 : ${t.treatmenu} <br>
		</c:when>  
</c:choose>
</c:forEach>
<br>
</div>

<c:forEach items="${tiList}" var="ti">
<div id="map" style="width:800px;height:400px;"></div>
<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=fb9aed23f848063a34eed98d2d7ea36b"></script>
<script type="text/javascript">
var mapx = ${ti.mapx};
var mapy = ${ti.mapy};
var level = ${ti.mlevel};
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(mapy, mapx), //지도의 중심좌표.
	level: level //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
//일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
var marker = new kakao.maps.Marker();

//타일 로드가 완료되면 지도 중심에 마커를 표시합니다
kakao.maps.event.addListener(map, 'tilesloaded', displayMarker);

function displayMarker() {
 
 // 마커의 위치를 지도중심으로 설정합니다 
 marker.setPosition(map.getCenter()); 
 marker.setMap(map); 

 // 아래 코드는 최초 한번만 타일로드 이벤트가 발생했을 때 어떤 처리를 하고 
 // 지도에 등록된 타일로드 이벤트를 제거하는 코드입니다 
 // kakao.maps.event.removeListener(map, 'tilesloaded', displayMarker);
}
</script>
<script type="text/javascript">
  // input your appkey
  	Kakao.init('fb9aed23f848063a34eed98d2d7ea36b');
	
  	var title = '${ti.title}';
	var imgurl = '${ti.firstimage}'; 
 	
	function sendLink() {
    Kakao.Link.sendDefault({
      objectType: 'feed',
      content: {
        title: title,
        description: '',
        imageUrl: imgurl,
        link: {
          mobileWebUrl: 'http://13.209.227.5/tour/view?type='+type+'&contentid='+contentid+'',
          webUrl: 'http://13.209.227.5/tour/view?type='+type+'&contentid='+contentid+'',
        },
      },
      social: {
        likeCount: 286,
        commentCount: 45,
        sharedCount: 845,
      },
      buttons: [
        {
          title: '웹으로 보기',
          link: {
            mobileWebUrl: 'https://developers.kakao.com',
            webUrl: 'https://developers.kakao.com',
          },
        },
        {
          title: '앱으로 보기',
          link: {
            mobileWebUrl: 'https://developers.kakao.com',
            webUrl: 'https://developers.kakao.com',
          },
        },
      ],
    })
  }
</script>
</c:forEach>
<div id="sharebtn">
	<br>
	<a id="kakao-link-btn" href="javascript:sendLink()">
	  <img
	    src="//developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"
	   style="width: 40px; height: 40px;"/>
	</a>카카오톡 공유하기
		
	<span>
		<script type="text/javascript" src="https://ssl.pstatic.net/share/js/naver_sharebutton.js"></script>
		<script type="text/javascript">
		new ShareNaver.makeButton({"type": "f"});
		</script>
	네이버 공유하기
	</span>
	<br><br>
</div>
</div>
</body>
</html>