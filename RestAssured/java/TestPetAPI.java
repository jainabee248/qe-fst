
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class TestPetAPI {

    @Test
    public void GetPetDetails() {
        // Specify the base URL to the RESTful web service
        baseURI = "https://petstore.swagger.io/v2/pet";

        // Make a request to the server by specifying the method Type and 
        // resource to send the request to.
        // Store the response received from the server for later use.
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .when().get(baseURI + "/findByStatus?status=sold"); // Run GET request

        // Now let us print the body of the message to see what response
        // we have received from the server
        String responseBody = response.getBody().prettyPrint();
        System.out.println("Response Body is =>  " + responseBody);
        
        List<Header> responseHeaders = response.getHeaders().asList();
        System.out.println(responseHeaders);
        
     // Extract status from response
        Long responseJSON_status = response.then().extract().path("[2].id");
        System.out.println(responseJSON_status);



        

        // Assertions
        response.then().statusCode(200);
        response.then().body("[0].status", equalTo("sold"));
    }
    
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
    
	
    
@Test
public void AddNewPet() {
    // Write the request body
	
	baseURI = "https://petstore.swagger.io/v2/pet";
    String reqBody = "{\"id\": 77232, \"name\": \"jaina\", \"status\": \"alive\"}";
 
    Response response = 
        given().contentType(ContentType.JSON) // Set headers
        .body(reqBody).when().post(baseURI); // Send POST request
 
    // Print response of POST request
    String body = response.getBody().asPrettyString();
    System.out.println(body);
}

}
