
	import static io.restassured.RestAssured.baseURI;
	import static io.restassured.RestAssured.given;
	import static org.hamcrest.CoreMatchers.equalTo;

	import java.util.List;

	import org.testng.annotations.Test;

	import io.restassured.http.ContentType;
	import io.restassured.http.Header;
	import io.restassured.response.Response;

	public class testAPI {
	    Long petId;  

	    @Test(priority = 1)
	    public void AddNewPet() {
	        baseURI = "https://petstore.swagger.io/v2/pet";

	        String reqBody = "{ \"name\": \"jaina\", \"status\": \"alive\" }";

	        Response response = 
	            given()
	                .contentType(ContentType.JSON)
	                .body(reqBody)
	            .when()
	                .post(baseURI); // Send POST request

	        String body = response.getBody().asPrettyString();
	        System.out.println("POST Response:\n" + body);

	        petId = response.then().extract().path("id");
	        System.out.println("Pet ID: " + petId);
	    }

	    @Test(priority = 2)
	    public void UpdatePet() {
	        baseURI = "https://petstore.swagger.io/v2/pet";

	        String reqBody = "{ \"id\": " + petId + ", \"name\": \"jaina\", \"status\": \"studying\" }";
	        System.out.println("update Request Body:\n" + reqBody);

	        Response response = 
	            given()
	                .contentType(ContentType.JSON)
	                .body(reqBody)
	            .when()
	                .put(baseURI); // Send PUT request

	        String body = response.getBody().asPrettyString();
	        System.out.println("PUT Response:\n" + body);
	    }

	    @Test(priority = 3)
	    public void GetPetDetails() {
	        baseURI = "https://petstore.swagger.io/v2/pet";

	        Response response = 
	            given()
	                .contentType(ContentType.JSON)
	            .when()
	                .get(baseURI + "/" + petId); // Run GET request

	        String responseBody = response.getBody().prettyPrint();
	        System.out.println("GET Response:\n" + responseBody);
	    }

	       /* List<Header> responseHeaders = response.getHeaders().asList();
	        System.out.println("Response Headers:\n" + responseHeaders);*/
	    
	    @Test(priority = 4)
	    public void GetPet() {
	        String geturl = "https://petstore.swagger.io/v2/pet/{petId}";

	        Response response = 
	            given().contentType(ContentType.JSON)
	            .when()
	            	.pathParam("petId", petId)
	                .get(geturl); // Run GET request
            System.out.println(response.prettyPrint());
	        String petStatus = response.then().extract().path("status");
	        System.out.println(petStatus);
	    }

	    @Test(priority = 5)
	    public void deleteDetails() {
	        baseURI = "https://petstore.swagger.io/v2/pet";

	        Response response = 
	            given()
	                .contentType(ContentType.JSON)
	            .when()
	                .delete(baseURI + "/" + petId); // Run GET request

	        String responseBody = response.getBody().prettyPrint();
	        //System.out.println("delete Response:\n" + responseBody);
	    }
	}



