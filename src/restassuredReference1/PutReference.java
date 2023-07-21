package restassuredReference1;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
public class PutReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://reqres.in/";
		
		//step 2: configure req body and resource
		String Putresponsebody = given().header("Content-Type","application/json").body("{\r\n"
				+ "    \r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").when().put("/api/users/2").then().extract().response().asString();
		System.out.println(Putresponsebody);
		//extract response body parameters
		JsonPath jp = new JsonPath(Putresponsebody);
		
		String res_name = jp.getString("name");
		String res_job = jp.getString("job");
		String res_date = jp.getString("updatedAt");
		String Date = new String(res_date);
		String result = new String(Date);
		
		System.out.println(res_name);
		System.out.println(res_job);
		System.out.println(res_date);
		System.out.println(Date.substring(0,10));
		System.out.println(result.substring(0,10));
		


	}

}
