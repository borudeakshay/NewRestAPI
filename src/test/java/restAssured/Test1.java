package restAssured;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// RestAssured.baseURI="https://rahulshettyacademy.com";
		String response =

				given()

						.formParams("client_id",
								"692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

						.formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

						.formParams("grant_type", "client_credentials")

						.formParams("scope", "trust")

						.when()

						.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

		System.out.println(response);

		
		JsonPath js =new JsonPath(response);
		String res = js.get("access_token");
		
		System.out.println(res);
		
		String resp1 = given().queryParam("access_token", res).
		when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
		System.out.println(resp1);
	}

}
