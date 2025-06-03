
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class Activity3 {
	Long petId;
	@Test
	public void AddNewPet() {
	    // Write the request body
		
		baseURI = "https://petstore.swagger.io/v2/pet";
	    String reqBody = "{ \"name\": \"jaina\", \"status\": \"alive\"}";
	    
	 
	    Response response = 
	        given().contentType(ContentType.JSON) // Set headers
	        .body(reqBody).when().post(baseURI); // Send POST request
	 
	    // Print response of POST request
	    String body = response.getBody().asPrettyString();
	    System.out.println(body);
	    
	    petId = response.then().extract().path("id");
        System.out.println(petId);
	}
	@Test
	public void UpdatePet() {
	    // Write the request body
		
		baseURI = "https://petstore.swagger.io/v2/pet";
		String reqBody = "{ \"id\": " + petId + ", \"name\": \"jaina\", \"status\": \"studying\" }";
	    System.out.println(reqBody);
	    Response response = 
	        given().contentType(ContentType.JSON) // Set headers
	        .body(reqBody).when().put(baseURI); // Send POST request
	 
	    // Print response of POST request
	    String body = response.getBody().asPrettyString();
	    System.out.println(body);
	    
	   
	}
	@Test
	public void GetPetDetails() {
        // Specify the base URL to the RESTful web service
        baseURI = "https://petstore.swagger.io/v2/pet";

        // Make a request to the server by specifying the method Type and 
        // resource to send the request to.
        // Store the response received from the server for later use.
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .when().get(baseURI + "/" + petId); // Run GET request

        // Now let us print the body of the message to see what response
        // we have received from the server
        String responseBody = response.getBody().prettyPrint();
        System.out.println("Response Body is =>  " + responseBody);
        
        List<Header> responseHeaders = response.getHeaders().asList();
        System.out.println(responseHeaders);
	}
}
       





