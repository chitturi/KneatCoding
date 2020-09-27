package apiEngine;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestEndPoints {
	
	private RequestSpecification request;
	 
	private static final String BASE_URL = "https://petstore.swagger.io/";
	
	public RequestEndPoints(String baseURl) {
		RestAssured.baseURI = BASE_URL;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
	}
	public Response addPet(String jsonPet) {
        Response response = request.body(jsonPet).post(ReqeustRoutes.pet());
        return response;
    }
	
	public Response getPet(int petID) {
        Response response = request.get(ReqeustRoutes.petid(petID));
        return response;
    }
	
	public Response updatePet(String jsonPet) {
 
        Response response = request.body(jsonPet).put(ReqeustRoutes.pet());
        return response;
    }
	
	public Response removePet(int petID) {
 
        Response response = request.delete(ReqeustRoutes.petid(petID));
        return response;
    }
}
