package location.tour.tourlist.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import location.tour.tourlist.model.TourDTO;

@Service
public class TourService {
	
	public static final String CALLBACKURL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro";
	public static final String SERVICEKEY = "JRWTmtB5qI3WJcvA7HrFcBrSWgA6OKvW16HVK5YNuTvodOeEo2noxhbEsS020kBYMYHDEBWqTFITnB0u88vtnw%3D%3D";
	

	public List<TourDTO> tourList(Long type,Long contentid) throws Exception{
			String urlStr = CALLBACKURL + "?ServiceKey=" + SERVICEKEY + "&contentId="+contentid+"&contentTypeId="+type+"&MobileOS=ETC&MobileApp=AppTest&_type=json";
			URL url = new URL(urlStr);
			
			BufferedReader bf;
	        String line = "";
	        String result="";
			
			//날씨 정보를 받아옵니다.
	       bf = new BufferedReader(new InputStreamReader(url.openStream()));

	       //버퍼에 있는 정보를 하나의 문자열로 변환.
	       while((line=bf.readLine())!=null){
	           result=result.concat(line);
	          // System.out.println(result);  // 받아온 데이터를 확인해봅니다.
	       }
	       System.out.println(result);
	        // Json parser를 만들어 만들어진 문자열 데이터를 객체화 합니다. 
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(result);
			
			// Top레벨 단계인 response 키를 가지고 데이터를 파싱합니다.
			JSONObject parse_response = (JSONObject) obj.get("response");
			// response 로 부터 body 찾아옵니다.
			JSONObject parse_body = (JSONObject) parse_response.get("body");
			

			// body 로 부터 items 받아옵니다.
			JSONObject parse_items = (JSONObject) parse_body.get("items");
			
			// items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다
			JSONObject parse_item;// = (JSONObject) parse_items.get("item");
			
//			JSONObject item; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용합니다.
			List<TourDTO> tList = new ArrayList<TourDTO>();
			
			
			// 필요한 데이터만 가져오려고합니다.
			for(int i = 0 ; i < parse_items.size(); i++)
			{
				TourDTO t = new TourDTO();
//				t.setPageNo((Long)parse_body.get("pageNo"));
				//기본
				parse_item = (JSONObject) parse_items.get("item");
				t.setContentid((Long)parse_item.get("contentid"));
				t.setContenttypeid((Long)parse_item.get("contenttypeid"));
				//관광지
				t.setExpguide((String)parse_item.get("expguide"));
				t.setInfocenter((String)parse_item.get("infocenter")); 
				t.setOpendate((String)parse_item.get("opendate")); 
				t.setParking((String)parse_item.get("parking")); 
				t.setRestdate((String)parse_item.get("restdate"));
				t.setUseseason((String)parse_item.get("useseason"));
				t.setUsetime((String)parse_item.get("usetime"));
				//문화시설
				t.setInfocenterculture((String)parse_item.get("infocenterculture"));
				t.setParkingculture((String)parse_item.get("parkingculture"));
				t.setRestdateculture((String)parse_item.get("restdateculture"));
				t.setUserfee((String)parse_item.get("userfee")); 
				t.setUsetimeculture((String)parse_item.get("usetimeculture")); 
				t.setSpendtime((String)parse_item.get("spendtime")); 
				//행사공연축제
				t.setBookingplace((String)parse_item.get("bookingplace"));
				t.setEventhomepage((String)parse_item.get("eventhomepage")); 
				t.setEventplace((String)parse_item.get("eventplace")); 
				t.setPlaceinfo((String)parse_item.get("placeinfo")); 
				t.setEventstartdate((Long)parse_item.get("eventstartdate"));
				t.setEventenddate((Long)parse_item.get("eventenddate"));
				t.setPlaceinfo((String)parse_item.get("placeinfo"));
				t.setPlaytime((String)parse_item.get("playtime"));
				t.setProgram((String)parse_item.get("program"));
				t.setSpendtimefestival((String)parse_item.get("spendtimefestival"));
				t.setUsetimefestival((String)parse_item.get("usetimefestival")); 
				//여행코스 
//				t.setDistance((String)parse_item.get("distance"));
//				t.setInfocentertourcourse((String)parse_item.get("infocentertourcourse")); 
//				t.setSchedule((String)parse_item.get("schedule")); 
//				t.setTaketime((String)parse_item.get("taketime")); 
//				t.setTheme((String)parse_item.get("theme"));
				//레포츠
				t.setExpagerangeleports((String)parse_item.get("expagerangeleports"));
				t.setInfocenterleports((String)parse_item.get("infocenterleports")); 
				t.setOpenperiod((String)parse_item.get("openperiod")); 
				t.setParkingleports((String)parse_item.get("parkingleports")); 
				t.setReservation((String)parse_item.get("reservation"));
				t.setRestdateleports((String)parse_item.get("restdateleports"));
				t.setUsefeeleports((String)parse_item.get("usefeeleports"));
				t.setUsetimeleports((String)parse_item.get("usetimeleports"));
				//숙박
				t.setAccomcountlodging((String)parse_item.get("accomcountlodging"));
				t.setCheckintime((String)parse_item.get("checkintime")); 
				t.setCheckouttime((String)parse_item.get("checkouttime")); 
				t.setChkcooking((String)parse_item.get("chkcooking")); 
				t.setInfocenterlodging((String)parse_item.get("infocenterlodging"));
				t.setParkinglodging((String)parse_item.get("parkinglodging"));
				t.setPickup((String)parse_item.get("pickup"));
				t.setRoomcount((String)parse_item.get("roomcount"));
				t.setReservationlodging((String)parse_item.get("reservationlodging"));
				t.setReservationurl((String)parse_item.get("reservationurl"));
				t.setRoomtype((String)parse_item.get("roomtype"));  
				t.setScalelodging((String)parse_item.get("scalelodging"));
				t.setRefundregulation((String)parse_item.get("refundregulation")); 
				//쇼핑
				t.setFairday((String)parse_item.get("fairday"));
				t.setInfocentershopping((String)parse_item.get("infocentershopping")); 
				t.setOpendateshopping((String)parse_item.get("opendateshopping")); 
				t.setOpentime((String)parse_item.get("opentime")); 
				t.setParkingshopping((String)parse_item.get("parkingshopping"));
				t.setRestdateshopping((String)parse_item.get("restdateshopping"));
				t.setSaleitem((String)parse_item.get("saleitem"));
				t.setShopguide((String)parse_item.get("shopguide"));
				//음식점
				t.setFirstmenu((String)parse_item.get("firstmenu"));
				t.setInfocenterfood((String)parse_item.get("infocenterfood")); 
				t.setOpendatefood((String)parse_item.get("opendatefood")); 
				t.setOpentimefood((String)parse_item.get("opentimefood")); 
				t.setRestdatefood((String)parse_item.get("restdatefood"));
				t.setTreatmenu((String)parse_item.get("treatmenu"));
				
				tList.add(t);
			}

	       bf.close();
	       
//	       System.out.println(tList);
			return tList;
			
			
	}
}
