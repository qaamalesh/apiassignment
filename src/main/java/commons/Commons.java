package commons;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import Constants.RequestTypes;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Commons {

	
	public Response getresponse(String uri,String requestType,String body,List<Header> headers) {
		
		RestAssured.baseURI=uri;
		RequestSpecification req=requestspecification(body, headers);
		Response response=null;
		
		switch (RequestTypes.valueOf(requestType.toUpperCase())) {
		case GET:
			
			response=req.get();
			break;
			
		case POST:
			response=req.post();
			break;

		default:
			break;
		}
		
		return response;
	}
	
	private RequestSpecification requestspecification(String body,List<Header> headers) {
		
		RequestSpecification request=RestAssured.given();
		
		
		if(body!=null&&!body.isEmpty()) {
			request.body(body);
		}
		
		if(headers!=null) {
			request.headers(new Headers(headers));
		
		
	}
		
		
		return request;
	}
	
	
	
	@DataProvider
	public Iterator<Object[]> getDatafromTextfile() throws IOException{
		
		
		
		BufferedReader br=new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/main/resources/Events"));
		String lines=null;
		
		
		List<Object[]> list=new ArrayList<Object[]>();
		
		while((lines=br.readLine())!=null) {
			list.add(new Object[]{lines});
			
		}
		
		return list.iterator();
		
		
		
		
		
	}
}
