package stepdefs;

import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

import apiEngine.RequestEndPoints;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import modal.Pet;
import utils.JSONhelper;

public class APIStepdefinitions {

	private static final String BaseUrl = "https://petstore.swagger.io/";
	private static RequestEndPoints endPoints;
	private static Response response;
	static String jsonPet;
	private static Pet addPet;

	@Given("^I have a payload with pet information$")
	public void i_have_a_payload_with_pet_information() throws Throwable {
		endPoints = new RequestEndPoints(BaseUrl);
		JSONhelper jsonHelper = new JSONhelper();
		addPet = jsonHelper.JSONRequest();
		ObjectMapper mapper = new ObjectMapper();
		jsonPet = mapper.writeValueAsString(addPet);
	}

	@When("^I send a POST request to add a new pet$")
	public void i_send_a_POST_request_to_add_a_new_pet() throws Throwable {
		response = endPoints.addPet(jsonPet);
	}

	@Then("^I get a response with (\\d+) success$")
	public void i_get_a_response_with_success(int code) throws Throwable {
		Assert.assertEquals(code, response.getStatusCode());
	}
	
	@And("^I validate pet details in response body$")
	public void i_validate_pet_details_in_response_body() throws Throwable {
		int id = response.jsonPath().get("id");
		String status = response.jsonPath().get("status");
		String name = response.jsonPath().get("name");
		Assert.assertEquals(1, id);
		Assert.assertEquals("available",status);
		Assert.assertEquals("doggie", name);
	}

	@Given("^I had ID of pet$")
	public void i_had_ID_of_pet() throws Throwable {
		Long petId = (long) 1;
		Long getId = addPet.getId();
		Assert.assertEquals(petId, getId);
	}

	@When("^I send a GET request to get details of pet based on ID$")
	public void i_send_a_GET_request_to_get_details_of_pet_based_on_ID() throws Throwable {
		response = endPoints.getPet(1);	   
	}

	@Then("^I can see pet details in response body$")
	public void i_can_see_pet_details_in_response_body() throws Throwable {
		int id = response.jsonPath().get("id");
		String status = response.jsonPath().get("status");
		String name = response.jsonPath().get("name");
		Assert.assertEquals(1, id);
		Assert.assertEquals("available",status);
		Assert.assertEquals("doggie", name);
	}

	@Given("^I want to update pet status as \"([^\"]*)\"$")
	public void i_want_to_update_pet_status_as(String status) throws Throwable {
		addPet.setStatus(status);
	}

	@When("^I send a PUT request with pet ID and status as sold$")
	public void i_send_a_POST_request_with_pet_ID_and_status_as_sold() throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		jsonPet = mapper.writeValueAsString(addPet);
		response = endPoints.updatePet(jsonPet);
	}

	@And("^I can see pet details updated in response body$")
	public void i_can_see_pet_details_updated_in_response_body() throws Throwable {
		int id = response.jsonPath().get("id");
		String status = response.jsonPath().get("status");
		String name = response.jsonPath().get("name");
		Assert.assertEquals(1, id);
		Assert.assertEquals("sold",status);
		Assert.assertEquals("doggie", name);
	}

	@When("^I send a DELETE request with pet ID$")
	public void i_send_a_DELETE_request_with_pet_ID() throws Throwable {
		response = endPoints.removePet(1);
	}

	@And("^I can see deleted pet details in response body$")
	public void i_can_see_deleted_pet_details_in_response_body() throws Throwable {
		int code = response.jsonPath().get("code");
		String message = response.jsonPath().get("message");
		Assert.assertEquals(200, code);
		Assert.assertEquals("1",message);
	}
}
