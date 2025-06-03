import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
public class activity2 {
	// Set Base URL with path parameter
	String ROOT_URI = "http://ip-api.com/json/{ipAddress}";

	@Test
	public void getIPInformation() {
	    Response response = 
	        given().contentType(ContentType.JSON) // Set headers
	        .when()
	        .pathParam("ipAddress", "107.218.134.107") // Set path parameter
	        .get(ROOT_URI); // Send GET request

	    // Print response
	    System.out.println(response.getBody().asPrettyString());
	}
	
	// Set Base URL
	// No need to add questions mark in the URL.
	// queryParam() will automatically add it while parsing.
	final static String NEW_URI = "http://ip-api.com/json";

	@Test
	public void getIPInformation2() {
	    Response response = 
	        given().contentType(ContentType.JSON) // Set headers
	        // Add query parameter
	        .when().queryParam("fields", "query,country,city,timezone")
	        .get(NEW_URI + "/125.219.5.94"); // Send GET request
	    
	    // Print response
	    System.out.println(response.getBody().asPrettyString());
	}

}
