package location.tour.tourlist.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

import location.tour.tourlist.model.CategoryCodeDTO;

@Service
public class CategoryCodeService {
	public static final String CALLBACKURL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/categoryCode";
	public static final String SERVICEKEY = "JRWTmtB5qI3WJcvA7HrFcBrSWgA6OKvW16HVK5YNuTvodOeEo2noxhbEsS020kBYMYHDEBWqTFITnB0u88vtnw%3D%3D";
	

	public List<CategoryCodeDTO> cat1List(Long type) throws Exception{
			String urlStr = CALLBACKURL + "?ServiceKey=" + SERVICEKEY + "&contentTypeId="+type+"&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest";
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
	        List<CategoryCodeDTO> tList = new ArrayList<CategoryCodeDTO>();

	        for (int i = 0; i < nodeList.getLength(); i++) {
	            NodeList child = nodeList.item(i).getChildNodes();
	            CategoryCodeDTO t = new CategoryCodeDTO();
	            for (int j = 0; j < child.getLength(); j++) {
	                Node node = child.item(j);
	                if(node.getNodeName().equals("name")) {
	                	String x = node.getTextContent();
	                	t.setName(x);
	                }
	                else if(node.getNodeName().equals("code")) {
	                	String x =  node.getTextContent();
	                	t.setCode(x);
	                }
	                else if(node.getNodeName().equals("rnum")) {
	                	String x =  node.getTextContent();
	                	t.setRnum(Long.parseLong(x));
	                }
	            }
	            tList.add(t);
	     }
	     return tList;
	}
	public List<CategoryCodeDTO> cat2List(Long type,String cat1) throws Exception{
		String urlStr = CALLBACKURL + "?ServiceKey=" + SERVICEKEY + "&contentTypeId="+type+"&cat1="+cat1+"&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest";
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
        List<CategoryCodeDTO> tList = new ArrayList<CategoryCodeDTO>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            NodeList child = nodeList.item(i).getChildNodes();
            CategoryCodeDTO t = new CategoryCodeDTO();
            for (int j = 0; j < child.getLength(); j++) {
                Node node = child.item(j);
                if(node.getNodeName().equals("name")) {
                	String x = node.getTextContent();
                	t.setName(x);
                }
                else if(node.getNodeName().equals("code")) {
                	String x =  node.getTextContent();
                	t.setCode(x);
                }
                else if(node.getNodeName().equals("rnum")) {
                	String x =  node.getTextContent();
                	t.setRnum(Long.parseLong(x));
                }
            }
            tList.add(t);
     }
     return tList;
}
	public List<CategoryCodeDTO> cat3List(Long type,String cat1,String cat2) throws Exception{
		String urlStr = CALLBACKURL + "?ServiceKey=" + SERVICEKEY + "&contentTypeId="+type+"&cat1="+cat1+"&cat2="+cat2+"&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest";
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
        List<CategoryCodeDTO> tList = new ArrayList<CategoryCodeDTO>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            NodeList child = nodeList.item(i).getChildNodes();
            CategoryCodeDTO t = new CategoryCodeDTO();
            for (int j = 0; j < child.getLength(); j++) {
                Node node = child.item(j);
                if(node.getNodeName().equals("name")) {
                	String x = node.getTextContent();
                	t.setName(x);
                }
                else if(node.getNodeName().equals("code")) {
                	String x =  node.getTextContent();
                	t.setCode(x);
                }
                else if(node.getNodeName().equals("rnum")) {
                	String x =  node.getTextContent();
                	t.setRnum(Long.parseLong(x));
                }
            }
            tList.add(t);
     }
     return tList;
}
}
