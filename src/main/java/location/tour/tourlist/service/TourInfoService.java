package location.tour.tourlist.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import location.tour.tourlist.model.TourInfoDTO;

@Service
public class TourInfoService {
	public static final String CALLBACKURL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon";
	public static final String SERVICEKEY = "JRWTmtB5qI3WJcvA7HrFcBrSWgA6OKvW16HVK5YNuTvodOeEo2noxhbEsS020kBYMYHDEBWqTFITnB0u88vtnw%3D%3D";
	

	public List<TourInfoDTO> tourInfoList(Long type,Long contentid) throws Exception{
			String urlStr = CALLBACKURL + "?ServiceKey=" + SERVICEKEY + "&contentId="+contentid+"&contentTypeId="+type+"&defaultYN=Y&firstImageYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&MobileOS=ETC&MobileApp=AppTest&_type=json";
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
			List<TourInfoDTO> tList = new ArrayList<TourInfoDTO>();
			
			
			// 필요한 데이터만 가져오려고합니다.
			for(int i = 0 ; i < parse_items.size(); i++)
			{
				TourInfoDTO t = new TourInfoDTO();
//				t.setPageNo((Long)parse_body.get("pageNo"));
				parse_item = (JSONObject) parse_items.get("item");
				t.setContentid((Long)parse_item.get("contentid"));
				t.setContenttypeid((Long)parse_item.get("contenttypeid"));
				t.setCreatedtime((Long)parse_item.get("createdtime"));
				t.setHomepage((String)parse_item.get("homepage")); 
				t.setModifiedtime((Long)parse_item.get("modifiedtime")); 
				t.setTel((String)parse_item.get("tel")); 
				t.setTitle((String)parse_item.get("title"));
				t.setFirstimage((String)parse_item.get("firstimage"));
				t.setFirstimage2((String)parse_item.get("firstimage2"));
				t.setAddr1((String)parse_item.get("addr1"));
				t.setAddr2((String)parse_item.get("addr2"));
				String x = String.valueOf(parse_item.get("mapx"));
				t.setMapx(Double.parseDouble(x));
				String y = String.valueOf(parse_item.get("mapy"));
				t.setMapy(Double.parseDouble(y));
				t.setMlevel((Long)parse_item.get("mlevel"));
				t.setOverview((String)parse_item.get("overview"));
				tList.add(t);
			}

	       bf.close();
	       
//	       System.out.println(tList);
			return tList;
			
			
		}
}
