package restAssured;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo1.Content;
import pojo1.Location;
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Content c = new Content();
		List<String> l = new ArrayList<String>();
		Location loc =new Location();
		loc.setLat(66.99);
		loc.setLng(88.99);
		l.add("show"); l.add("content");
		c.setAddress("priya content");
		c.setPhone_number("98765345");
		c.setLanguage("english");
		c.setLocation(loc);
		c.setName("priya");
		c.setWebsite("www.uyo.com");
		c.setTypes(l);
		c.setAccuracy(55);
		
		RequestSpecification res=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
	
		ResponseSpecification uu = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RequestSpecification resp = given().spec(res).body(c);
				
		Response respp = resp.when().post("/maps/api/place/add/json").then().
				spec(uu).extract().response();
		System.out.println(respp.asString());
	}

}
