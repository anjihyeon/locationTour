<%@ page import="org.w3c.dom.*"%>
<%@ page import="javax.xml.parsers.*"%>
<%@ page import="java.util.*"%>

<%@ include file="../layout/menu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%	
   		String[] fieldNames ={"mapx", "mapy","title","contenttypeid","contentid"};
   		ArrayList<Map> pubList = new ArrayList<Map>();
   		
   		try{
			String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=JRWTmtB5qI3WJcvA7HrFcBrSWgA6OKvW16HVK5YNuTvodOeEo2noxhbEsS020kBYMYHDEBWqTFITnB0u88vtnw%3D%3D&numOfRows=100&arrange=B&contentTypeId=12&MobileOS=ETC&MobileApp=AppTest";
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    Document document = builder.parse(url);
		    document.getDocumentElement().normalize();
		    
		    NodeList items = document.getElementsByTagName("item");
		    System.out.println(items.getLength());
		    for(int i=0;i<items.getLength();i++){
		    	Node n = items.item(i);
		    	if(n.getNodeType() != Node.ELEMENT_NODE)
		    		continue;
		    	Element e = (Element) n;
		    	HashMap pub = new HashMap();
		    	for(String name : fieldNames){
		    		NodeList list = e.getElementsByTagName(name);
		    		Element elem = (Element)list.item(0);
		    		Node node = elem.getChildNodes().item(0);
		    		pub.put(name,node.getNodeValue());
		    	}
		    	
		    	pubList.add(pub);
		    }
		    System.out.println(pubList);
		    
		}catch(Exception e) {
		    throw e;
		}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<div class="container">
<div>[관광지 100위 지도]</div>
<div id="map" style="width:1100px;height:700px;"></div>
</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fb9aed23f848063a34eed98d2d7ea36b"></script>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function() {
	  if(navigator.geolocation) {
	        navigator.geolocation.getCurrentPosition(getLocation, function(error) {
	            consol.log(error.message);    
	        });
	    } else {
	        consol.log("Geolocation을 지원하지 않는 브라우저 입니다.");
	    }
    function getLocation(position) {
        var latitud = position.coords.latitude;
        var longitude = position.coords.longitude;
        var mapContainer = document.getElementById("map")    // 지도를 표시할 DIV
        var mapOption = {
              center : new daum.maps.LatLng(latitud, longitude)    // 지도의 중심좌표
            , level : 3    // 지도의 확대레벨
        };
        // 지도를 생성
        var map = new daum.maps.Map(mapContainer, mapOption);
        // 마커가 표시될 위치
        var markerPosition = new daum.maps.LatLng(latitud, longitude);
        // 마커를 생성
        var marker = new daum.maps.Marker({ position:markerPosition });
        var infowindow = null;
    <%
    	for(Map pub : pubList){
    %>		
        marker = new daum.maps.Marker({
            position: new daum.maps.LatLng(<%=pub.get("mapy") %>, <%=pub.get("mapx") %>), // 마커의 좌표
            title : "<%=pub.get("title")%>",
            map: map // 마커를 표시할 지도 객체
        });
		// 인포윈도우를 생성합니다
		infowindow = new kakao.maps.InfoWindow({
		   content : '<div style="padding:5px;"><a href="/tour/view?type='+<%=pub.get("contenttypeid") %>+'&contentid='+<%=pub.get("contentid") %>+'">'+"<%=pub.get("title") %>"+'</a></div>',
		   removable : true
		}); 
		// 마커에 클릭이벤트를 등록합니다
		kakao.maps.event.addListener(marker, 'click', infowindow.open(map, marker));	
/* 		// 마커에 마우스오버 이벤트를 등록합니다
		kakao.maps.event.addListener(marker, 'mouseover',infowindow.open(map, marker));
	
		// 마커에 마우스아웃 이벤트를 등록합니다
		kakao.maps.event.addListener(marker, 'mouseout',infowindow.close()); */
	<%
		}
	%>
    	 // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
	     var mapTypeControl = new kakao.maps.MapTypeControl();
	
	     // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
	     // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
	     map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
	
	     // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
	     var zoomControl = new kakao.maps.ZoomControl();
	     map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
         marker.setMap(map);
		  
		

	};
 
});
</script>
</body>
</html>