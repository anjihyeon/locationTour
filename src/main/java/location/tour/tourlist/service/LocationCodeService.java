package location.tour.tourlist.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import location.tour.tourlist.model.LocationCodeDTO;

@Service
public class LocationCodeService {
	public static final String CALLBACKURL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode";
	public static final String SERVICEKEY = "JRWTmtB5qI3WJcvA7HrFcBrSWgA6OKvW16HVK5YNuTvodOeEo2noxhbEsS020kBYMYHDEBWqTFITnB0u88vtnw%3D%3D";
	

	public List<LocationCodeDTO> locationcodeList() throws Exception{
			String urlStr = CALLBACKURL + "?ServiceKey=" + SERVICEKEY + "&numOfRows=17&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";
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
			JSONArray parse_item = (JSONArray) parse_items.get("item");
			JSONObject item;
			
//			JSONObject item; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용합니다.
			List<LocationCodeDTO> lList = new ArrayList<LocationCodeDTO>();
			
			// 필요한 데이터만 가져오려고합니다.
			for(int i = 0 ; i < parse_item.size(); i++)
			{
//				t.setPageNo((Long)parse_body.get("pageNo"));
				LocationCodeDTO l = new LocationCodeDTO();
				item = (JSONObject) parse_item.get(i);
				l.setCode((Long)item.get("code"));
				l.setName((String)item.get("name"));
				l.setRnum((Long)item.get("rnum"));
				lList.add(l);
			}
//			System.out.println(lList);

	       bf.close();
	       
//	       System.out.println(tList);
			return lList;
			
			
		}
}
