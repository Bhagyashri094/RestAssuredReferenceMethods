package restassuredReference1;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class deleteReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
RestAssured.baseURI = "https://reqres.in/";
		
		//step 2: configure req body 
	
		int statuscode = given().header("Content-Type","application/json").log().all().when().delete("/api/users/2").then().
				extract().statusCode();
		System.out.println(statuscode);

	}

}
