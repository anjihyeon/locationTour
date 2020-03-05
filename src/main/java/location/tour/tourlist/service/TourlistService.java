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

import location.tour.tourlist.model.TourlistDTO;

@Service
public class TourlistService {
	public static final String CALLBACKURL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList";
	public static final String SERVICEKEY = "JRWTmtB5qI3WJcvA7HrFcBrSWgA6OKvW16HVK5YNuTvodOeEo2noxhbEsS020kBYMYHDEBWqTFITnB0u88vtnw%3D%3D";
	
	public List<TourlistDTO> tourList(Long type,Long num) throws Exception{
		String urlStr = CALLBACKURL + "?ServiceKey=" + SERVICEKEY + "&contentTypeId="+type+"&pageNo="+num+"&arrange=B&MobileOS=ETC&MobileApp=AppTest&_type=json";
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
		
		JSONObject item; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용합니다.
		List<TourlistDTO> tList = new ArrayList<TourlistDTO>();
		
		
		// 필요한 데이터만 가져오려고합니다.
		for(int i = 0 ; i < parse_item.size(); i++)
		{
			TourlistDTO t = new TourlistDTO();
			t.setPageNo((Long)parse_body.get("pageNo"));
			item = (JSONObject) parse_item.get(i);
			t.setAddr1((String)item.get("addr1"));
			t.setTitle((String)item.get("title"));
			t.setTel((String)item.get("tel"));
			t.setArecode((Long)item.get("arecode")); //지역코드
			t.setContentid((Long)item.get("contentid")); 
			t.setContenttypeid((Long)item.get("contenttypeid")); 
			t.setCreaetedtime((Long)item.get("creaetedtime"));
			t.setModifiedtime((Long)item.get("modifiedtime"));
			t.setReadcount((Long)item.get("readcount"));
			t.setFirstimage((String)item.get("firstimage"));
			String firstimage2Null = (String)item.get("firstimage2");
			if(firstimage2Null == null) {
				t.setFirstimage2("/resources/img/white.jpg");
			}else {
				t.setFirstimage2(firstimage2Null);
			}
			t.setMlevel((Long)item.get("mlevel"));
//			t.setMapx((double) item.get("mapx"));
//			t.setMapy((double) item.get("mapy"));
			tList.add(t);
		}

       bf.close();
       
//       System.out.println(tList);
		return tList;
		
		
	}
	public List<TourlistDTO> tourAddrCodeList(Long type,Long num,Long addrCode) throws Exception{
		String urlStr = CALLBACKURL + "?ServiceKey=" + SERVICEKEY + "&contentTypeId="+type+"&pageNo="+num+"&areaCode="+addrCode+"&arrange=B&MobileOS=ETC&MobileApp=AppTest&_type=json";
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
		
		JSONObject item; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용합니다.
		List<TourlistDTO> tList = new ArrayList<TourlistDTO>();
		
		
		// 필요한 데이터만 가져오려고합니다.
		for(int i = 0 ; i < parse_item.size(); i++)
		{
			TourlistDTO t = new TourlistDTO();
			t.setPageNo((Long)parse_body.get("pageNo"));
			item = (JSONObject) parse_item.get(i);
			t.setAddr1((String)item.get("addr1"));
			t.setTitle((String)item.get("title"));
			t.setTel((String)item.get("tel"));
			t.setArecode((Long)item.get("arecode")); //지역코드
			t.setContentid((Long)item.get("contentid")); 
			t.setContenttypeid((Long)item.get("contenttypeid")); 
			t.setCreaetedtime((Long)item.get("creaetedtime"));
			t.setModifiedtime((Long)item.get("modifiedtime"));
			t.setReadcount((Long)item.get("readcount"));
			t.setFirstimage((String)item.get("firstimage"));
			String firstimage2Null = (String)item.get("firstimage2");
			if(firstimage2Null == null) {
				t.setFirstimage2("/resources/img/white.jpg");
			}else {
				t.setFirstimage2(firstimage2Null);
			}
			t.setMlevel((Long)item.get("mlevel"));
//			t.setMapx((double) item.get("mapx"));
//			t.setMapy((double) item.get("mapy"));
			tList.add(t);
		}

       bf.close();
       
//       System.out.println(tList);
		return tList;
		
		
	}
	public List<TourlistDTO> tourcat1List(Long type,Long num,String cat1) throws Exception{
		String urlStr = CALLBACKURL + "?ServiceKey=" + SERVICEKEY + "&contentTypeId="+type+"&pageNo="+num+"&cat1="+cat1+"&arrange=B&MobileOS=ETC&MobileApp=AppTest&_type=json";
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
		
		JSONObject item; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용합니다.
		List<TourlistDTO> tList = new ArrayList<TourlistDTO>();
		
		
		// 필요한 데이터만 가져오려고합니다.
		for(int i = 0 ; i < parse_item.size(); i++)
		{
			TourlistDTO t = new TourlistDTO();
			t.setPageNo((Long)parse_body.get("pageNo"));
			item = (JSONObject) parse_item.get(i);
			t.setAddr1((String)item.get("addr1"));
			t.setTitle((String)item.get("title"));
			t.setTel((String)item.get("tel"));
			t.setArecode((Long)item.get("arecode")); //지역코드
			t.setContentid((Long)item.get("contentid")); 
			t.setContenttypeid((Long)item.get("contenttypeid")); 
			t.setCreaetedtime((Long)item.get("creaetedtime"));
			t.setModifiedtime((Long)item.get("modifiedtime"));
			t.setReadcount((Long)item.get("readcount"));
			t.setFirstimage((String)item.get("firstimage"));
			String firstimage2Null = (String)item.get("firstimage2");
			if(firstimage2Null == null) {
				t.setFirstimage2("/resources/img/white.jpg");
			}else {
				t.setFirstimage2(firstimage2Null);
			}
			t.setMlevel((Long)item.get("mlevel"));
//			t.setMapx((double) item.get("mapx"));
//			t.setMapy((double) item.get("mapy"));
			tList.add(t);
		}

       bf.close();
       
//       System.out.println(tList);
		return tList;
		
		
	}
	public List<TourlistDTO> tourcat2List(Long type,Long num,String cat1,String cat2) throws Exception{
		String urlStr = CALLBACKURL + "?ServiceKey=" + SERVICEKEY + "&contentTypeId="+type+"&pageNo="+num+"&cat1="+cat1+"&cat2="+cat2+"&arrange=B&MobileOS=ETC&MobileApp=AppTest&_type=json";
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
		
		JSONObject item; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용합니다.
		List<TourlistDTO> tList = new ArrayList<TourlistDTO>();
		
		
		// 필요한 데이터만 가져오려고합니다.
		for(int i = 0 ; i < parse_item.size(); i++)
		{
			TourlistDTO t = new TourlistDTO();
			t.setPageNo((Long)parse_body.get("pageNo"));
			item = (JSONObject) parse_item.get(i);
			t.setAddr1((String)item.get("addr1"));
			t.setTitle((String)item.get("title"));
			t.setTel((String)item.get("tel"));
			t.setArecode((Long)item.get("arecode")); //지역코드
			t.setContentid((Long)item.get("contentid")); 
			t.setContenttypeid((Long)item.get("contenttypeid")); 
			t.setCreaetedtime((Long)item.get("creaetedtime"));
			t.setModifiedtime((Long)item.get("modifiedtime"));
			t.setReadcount((Long)item.get("readcount"));
			t.setFirstimage((String)item.get("firstimage"));
			String firstimage2Null = (String)item.get("firstimage2");
			if(firstimage2Null == null) {
				t.setFirstimage2("/resources/img/white.jpg");
			}else {
				t.setFirstimage2(firstimage2Null);
			}
			t.setMlevel((Long)item.get("mlevel"));
//			t.setMapx((double) item.get("mapx"));
//			t.setMapy((double) item.get("mapy"));
			tList.add(t);
		}

       bf.close();
       
//       System.out.println(tList);
		return tList;
		
		
	}
	public List<TourlistDTO> tourcat3List(Long type,Long num,String cat1,String cat2,String cat3) throws Exception{
		String urlStr = CALLBACKURL + "?ServiceKey=" + SERVICEKEY + "&contentTypeId="+type+"&pageNo="+num+"&cat1="+cat1+"&cat2="+cat2+"&cat3="+cat3+"&arrange=B&MobileOS=ETC&MobileApp=AppTest&_type=json";
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
		
		JSONObject item; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용합니다.
		List<TourlistDTO> tList = new ArrayList<TourlistDTO>();
		
		
		// 필요한 데이터만 가져오려고합니다.
		for(int i = 0 ; i < parse_item.size(); i++)
		{
			TourlistDTO t = new TourlistDTO();
			t.setPageNo((Long)parse_body.get("pageNo"));
			item = (JSONObject) parse_item.get(i);
			t.setAddr1((String)item.get("addr1"));
			t.setTitle((String)item.get("title"));
			t.setTel((String)item.get("tel"));
			t.setArecode((Long)item.get("arecode")); //지역코드
			t.setContentid((Long)item.get("contentid")); 
			t.setContenttypeid((Long)item.get("contenttypeid")); 
			t.setCreaetedtime((Long)item.get("creaetedtime"));
			t.setModifiedtime((Long)item.get("modifiedtime"));
			t.setReadcount((Long)item.get("readcount"));
			t.setFirstimage((String)item.get("firstimage"));
			String firstimage2Null = (String)item.get("firstimage2");
			if(firstimage2Null == null) {
				t.setFirstimage2("/resources/img/white.jpg");
			}else {
				t.setFirstimage2(firstimage2Null);
			}
			t.setMlevel((Long)item.get("mlevel"));
//			t.setMapx((double) item.get("mapx"));
//			t.setMapy((double) item.get("mapy"));
			tList.add(t);
		}

       bf.close();
       
//       System.out.println(tList);
		return tList;
		
		
	}
}
