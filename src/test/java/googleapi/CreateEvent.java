package googleapi;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Response.ResponsePojo;

import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import commons.Commons;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.internal.mapping.ObjectMapping;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;

import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class CreateEvent {


	Commons commons=new Commons();
	
	String access_token;
	
	@BeforeClass(description = "Create refresh token, before calling create event api.")
	
	public void generaterefreshtoken() {
		
		String refreshtokenuri="https://accounts.google.com/o/oauth2/token";
		  
		  JSONObject refreshjsonobj=new JSONObject();
		  refreshjsonobj.put("client_id", "623240047503-odnph21k98nnpvpjap6t2fbca4p2e3cp.apps.googleusercontent.com");
		  refreshjsonobj.put("client_secret", "qbPlHcp6N0xYF1vwK61Vtgip");
		  refreshjsonobj.put("refresh_token", "1//0gfcr_CAYcNMSCgYIARAAGBASNwF-L9IrW5H1SuH_ajsURwiWXteKW7doarfL643M3bWKI6X0IlIZBOvcDrnhsLNChV1jxWXy8C4");
		  refreshjsonobj.put("grant_type", "refresh_token");
		  //refreshjsonobj.put(key, value);
		  Response refreshres=commons.getresponse(refreshtokenuri, "post", refreshjsonobj.toJSONString(), null);
		  
		  JsonPath pathevalutor=refreshres.jsonPath();
		  access_token=pathevalutor.getString("access_token");
		  
		  System.out.println("========="+access_token);
	}
	
	
	
	
	  @Test(dataProviderClass = Commons.class,dataProvider = "getDatafromTextfile", description = "Create Events")
	  public void createEvent(String eventName) throws JsonMappingException, JsonProcessingException {
		  
		 // URL for Create event
		  
		    String url="https://www.googleapis.com/calendar/v3/calendars/primary/events?conferenceDataVersion=1&maxAttendees=3&sendUpdates=none&key=[YOUR_API_KEY]";
		  
		 
		    String requestType="post";
		    
		    
		    // create headers
		    
		  	Header auth=new Header("Authorization", "Bearer "+access_token);
			Header accept=new Header("Accept", "application/json");
			Header content=new Header("Content-Type", "application/json");
			
			ArrayList<Header> headers=new ArrayList<Header>();
			headers.add(auth);
			headers.add(accept);
			headers.add(content);
			
			// Construct request payload
			
			JSONObject obj=new JSONObject();
			JSONObject end=new JSONObject();
			JSONObject start=new JSONObject();
			end.put("dateTime", "2021-07-31T22:37:38+05:30");
			start.put("dateTime", "2021-07-31T21:37:38+05:30");
			obj.put("summary", eventName);
			obj.put("description", "Test Event Description");
			obj.put("end", end);
			obj.put("start", start);
			
			
			
			String body=obj.toJSONString();
			
			
			// Get response of the api
			
			Response res=commons.getresponse(url, requestType, body, headers);
			
			
			// Verify statius of the api response
			
			Assert.assertEquals(res.statusCode(), 200);
			
			
			// Searialize response into pojo class
			
			ObjectMapper map=new ObjectMapper();
			ResponsePojo pojo=map.readValue(res.asString(), ResponsePojo.class);
			
			// Get event status and verify it
			
			String status=pojo.getStatus();
			Assert.assertEquals(status, "confirmed");
	  }

	 



}
///client id       623240047503-odnph21k98nnpvpjap6t2fbca4p2e3cp.apps.googleusercontent.com

//client secret    qbPlHcp6N0xYF1vwK61Vtgip