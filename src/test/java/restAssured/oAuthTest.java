package restAssured;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.Courses;
import pojo.GetCourse;
import pojo.WebAutomation;

public class oAuthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	String response = 	given()
		.formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.formParams("grant_type","client_credentials")
		.formParams("scope","trust")
		.when()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
	
	//System.out.println(response);
	JsonPath jsonPath = new JsonPath(response);
	String accessToken = jsonPath.getString("access_token");
	
	
	GetCourse gc=	given()
		.queryParams("access_token", accessToken)
		.when()
		.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
	
//	System.out.println(gc);
//	System.out.println(gc.getInstructor());
//	System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
//	System.out.println(gc.getCourses().getMobile().get(0).getCourseTitle());
//	
	
	String titleCourse = gc.getCourses().getWebAutomation().get(2).getCourseTitle();
	System.out.println(titleCourse);
	List<WebAutomation> cr = gc.getCourses().getWebAutomation();
	for(int i=0;i<cr.size();i++) {
		String t = cr.get(i).getCourseTitle();
		if(t.equalsIgnoreCase(titleCourse)) {
			System.out.println(cr.get(i).getPrice());
		}
	}
	Courses c = gc.getCourses();
	c.getWebAutomation();
//	List<Api> apiCourses=gc.getCourses().getApi();
//	for(int i=0;i<apiCourses.size();i++)
//	{
//		if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
//				{
//			System.out.println(apiCourses.get(i).getPrice());
//				}
//	}
//	
//	//Get the course names of WebAutomation
//			ArrayList<String> a= new ArrayList<String>();
//			
//			
//			List<pojo.WebAutomation> w=gc.getCourses().getWebAutomation();
//			
//			for(int j=0;j<w.size();j++)
//			{
//				a.add(w.get(j).getCourseTitle());
//			}
//			
//			List<String> expectedList=	Arrays.asList(courseTitles);
//			
//			Assert.assertTrue(a.equals(expectedList));
//			
//			
			
	
	
	
	
	
	
	
	
	
	
		
		
	}

}
