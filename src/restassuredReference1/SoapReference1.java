package restassuredReference1;

//package restAssuredReference1;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.path.xml.*;
//import org.testng.Assert;
public class SoapReference1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
String BaseURI = "https://www.dataaccess.com";
String requestBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
		+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
		+ "  <soap:Body>\r\n"
		+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
		+ "      <ubiNum>100</ubiNum>\r\n"
		+ "    </NumberToWords>\r\n"
		+ "  </soap:Body>\r\n"
		+ "</soap:Envelope>\r\n"
		+ "";
//step2:fetch request parameter
XmlPath Xml_req=new XmlPath(requestBody);
String req_param = Xml_req.getString("ubiNum");
System.out.println(req_param);

	//step 3:
RestAssured.baseURI = BaseURI;
String responseBody = given().header("Content-Type","text/xml; charset=utf-8").body(requestBody).when().post("/webservicesserver/NumberConversion.wso")
.then().extract().response().getBody().asString();

System.out.println(responseBody);
//Step4:parse the resposne Body and fetch the response parameters
XmlPath Xml_res=new XmlPath(responseBody);
String Result = Xml_res.getString("NumberToWordsResult");
System.out.println(Result);

//step5:validate response parameters
//Assert.assertEquals(Result,"one hundred");

}

}
