package location.tour.tourlist.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import location.tour.tourlist.model.TourSearchDTO;

@Service
public class TourSearchService {
	public static final String CALLBACKURL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword";
	public static final String SERVICEKEY = "JRWTmtB5qI3WJcvA7HrFcBrSWgA6OKvW16HVK5YNuTvodOeEo2noxhbEsS020kBYMYHDEBWqTFITnB0u88vtnw%3D%3D";
	
	public List<TourSearchDTO> tourSearchList(String keyword,Long pageNo) throws Exception{
		String encodeKeyword = URLEncoder.encode(keyword, "UTF-8");
		String urlStr = CALLBACKURL + "?ServiceKey=" + SERVICEKEY + "&pageNo="+pageNo+"&keyword="+encodeKeyword+"&MobileOS=ETC&MobileApp=AppTest";
		URL url = new URL(urlStr);
		
		BufferedReader br = null;
        //DocumentBuilderFactory 생성
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;

		HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
        
        //응답 읽기
        br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
        String result = "";
        String line;
        while ((line = br.readLine()) != null) {
            result = result + line.trim();// result = URL로 XML을 읽은 값
        }
        System.out.println(result);
        // xml 파싱하기
        InputSource is = new InputSource(new StringReader(result));
        builder = factory.newDocumentBuilder();
        doc = builder.parse(is);
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        // XPathExpression expr = xpath.compile("/response/body/items/item");
        XPathExpression expr = xpath.compile("/response/body/items/item");
        NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        List<TourSearchDTO> tList = new ArrayList<TourSearchDTO>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            NodeList child = nodeList.item(i).getChildNodes();
            TourSearchDTO t = new TourSearchDTO();
            for (int j = 0; j < child.getLength(); j++) {
                Node node = child.item(j);
                if(node.getNodeName().equals("addr1")) {
                	String x = node.getTextContent();
                	t.setAddr1(x);
                }
                else if(node.getNodeName().equals("contentid")) {
                	String x =  node.getTextContent();
                	t.setContentid(Long.parseLong(x));
                }
                else if(node.getNodeName().equals("contenttypeid")) {
                	String x =  node.getTextContent();
                	t.setContenttypeid(Long.parseLong(x));
                }
                else if(node.getNodeName().equals("readcount")) {
                	String x =  node.getTextContent();
                	t.setReadcount(Long.parseLong(x));
                }
                else if(node.getNodeName().equals("title")) {
                	String x = node.getTextContent();
                	t.setTitle(x);
                }
                else if(node.getNodeName().equals("pageNo")) {
                	String x =  node.getTextContent();
                	t.setPageNo(Long.parseLong(x));
                }
                else if(node.getNodeName().equals("totalCount")) {
                	String x =  node.getTextContent();
                	t.setTotalCount(Long.parseLong(x));
                }
                else if(node.getNodeName().equals("firstimage2")) {
                	String x = node.getTextContent();
                	t.setFirstimage2(x);
                }
            }
            tList.add(t);
        }
        return tList;
    }

//		BufferedReader bf;
//        String line = "";
//        String result="";
//		
//		//날씨 정보를 받아옵니다.
//       bf = new BufferedReader(new InputStreamReader(url.openStream()));
//
//       //버퍼에 있는 정보를 하나의 문자열로 변환.
//       while((line=bf.readLine())!=null){
//           result=result.concat(line);
//          // System.out.println(result);  // 받아온 데이터를 확인해봅니다.
//       }
//       System.out.println(result);
//        // Json parser를 만들어 만들어진 문자열 데이터를 객체화 합니다. 
//		JSONParser parser = new JSONParser();
//		JSONObject obj = (JSONObject) parser.parse(result);
//		
//		// Top레벨 단계인 response 키를 가지고 데이터를 파싱합니다.
//		JSONObject parse_response = (JSONObject) obj.get("response");
//		// response 로 부터 body 찾아옵니다.
//		JSONObject parse_body = (JSONObject) parse_response.get("body");
//		
//		// body 로 부터 items 받아옵니다.
//		JSONObject parse_items = (JSONObject) parse_body.get("items");
//
//
//		// items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다
//		JSONArray parse_item = (JSONArray) parse_items.get("item");
//
//		JSONObject item; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용합니다.
//		List<TourSearchDTO> tList = new ArrayList<TourSearchDTO>();
//		
//		
//		// 필요한 데이터만 가져오려고합니다.
//		for(int i = 0 ; i < parse_item.size(); i++)
//		{
//			TourSearchDTO t = new TourSearchDTO();
//			item = (JSONObject) parse_item.get(i);
//			t.setPageNo((Long)parse_body.get("pageNo"));
//			t.setTotalCount((Long)parse_body.get("totalCount"));
//			t.setAddr1((String)item.get("addr1"));
//			t.setTitle((String)item.get("title"));
//			t.setContentid((Long)item.get("contentid"));
//			t.setContenttypeid((Long)item.get("contenttypeid"));
//			t.setFirstimage((String)item.get("firstimage"));
//			String firstimage2Null = (String)item.get("firstimage2");
//			if(firstimage2Null == null) {
//				t.setFirstimage2("/resources/img/white.jpg");
//			}else {
//				t.setFirstimage2(firstimage2Null);
//			}
//			t.setReadcount((Long)item.get("readcount"));
//			tList.add(t);
//		}
//
//       bf.close();
//       
////       System.out.println(tList);
//		return tList;
//		
//		
//	}
	
}
