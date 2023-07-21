package restassuredReference1;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

public class GetReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
RestAssured.baseURI = "https://reqres.in/";
		
		//step 2: configure req body and resource
		String responsebody = given().header("Content-Type","application/json").log().all().when().get("/api/users?page=2").then().log()
				.all().extract().response().asString();
		int statuscode = given().header("Content-Type","application/json").log().all().when().get("/api/users?page=2").then().log().
				all().extract().statusCode();
		System.out.println("Response status code: " + statuscode);
		System.out.println("Response Body" + responsebody);
		
		JsonPath jsonpath = new JsonPath(responsebody);
		int datasize = jsonpath .getList("data").size();
		for(int i=0; i<datasize; i++)
		{
			String id = jsonpath.getString("data[" + i + "].id");
			String email = jsonpath.getString("data[" + i + "].email");
			String firstname = jsonpath.getString("data[" + i + "].first_name");
			String lastname = jsonpath.getString("data[" + i + "].last_name");
			String avatar = jsonpath.getString("data[" + i + "].avatar");
			
			
		}
		

	}

}
