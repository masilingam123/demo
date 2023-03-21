package stepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.*;
import org.testng.Assert;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class StepDefinition {
	RequestSpecification reqspec;
	Response response;
		
	@Given("visiting the API")
	public void visiting_the_api() {
		RestAssured.baseURI = "https://ergast.com/api/f1/2017/circuits.json";
		reqspec = RestAssured.given();		
	}

	@When("get response from API")
	public void get_response_from_api() {
		response = reqspec.get();
	}

	@Then("validate the response code")
	public void validate_the_response_code() {
		Assert.assertEquals(200 , response.statusCode());
	}

	@Then("verify series")
	public void verify_series() {
		String  b ="f1";
		Assert.assertEquals(b, response.jsonPath().get("MRData.series"));		
	}
	@Given("visiting the API2")
	public void visiting_the_api2() {
		RestAssured.baseURI = "https://ergast.com/api/f1/2017/circuits.json";
		reqspec = RestAssured.given();		
	}

	@When("get response from API2")
	public void get_response_from_api2() {
		response = reqspec.get();
	}

	@Then("validate the response code2")
	public void validate_the_response_code2() {
		Assert.assertEquals(200 , response.statusCode());
	}

@Then("verify circuitID")
public void verify_circuit_id() {
	String ExcircuitId = "albert_park";
	Assert.assertEquals(ExcircuitId, response.jsonPath().getString("MRData.CircuitTable.Circuits[0].circuitId"));
}

@Then("verify the circuitName")
public void verify_the_circuit_name() {
	String ExcircuitName = "Albert Park Grand Prix Circuit";
	Assert.assertEquals(ExcircuitName,response.jsonPath().getString("MRData.CircuitTable.Circuits[0].circuitName"));	
}

@Then("verify the locality")
public void verify_the_locality() {
	String Exlocality = "Melbourne";
	Assert.assertEquals(Exlocality,response.jsonPath().getString("MRData.CircuitTable.Circuits[0].Location.locality"));		 
}
@Given("visiting the API3")
public void visiting_the_api3() {
	RestAssured.baseURI = "https://ergast.com/api/f1/2017/circuits.json";
	reqspec = RestAssured.given();		
}

@When("get response from API3")
public void get_response_from_api3() {
	response = reqspec.get();
}

@Then("validate the response code3")
public void validate_the_response_code3() {
	Assert.assertEquals(200 , response.statusCode());
}
@Then("verify url")
public void verify_url() {
    String a = "http://ergast.com/api/f1/2017/circuits.json";
    Assert.assertEquals(a, response.jsonPath().getString("MRData.url"));
}

@Then("verify season")
public void verify_season() {
	String b = "2017";
	Assert.assertEquals(b, response.jsonPath().getString("MRData.CircuitTable.season"));
}
@Given("visiting the API4")
public void visiting_the_api4() {
	RestAssured.baseURI = "https://ergast.com/api/f1/2017/circuits.json";
	reqspec = RestAssured.given();		
}

@When("get response from API4")
public void get_response_from_api4() {
	response = reqspec.get();
}

@Then("validate the response code4")
public void validate_the_response_code4() {
	Assert.assertEquals(200 , response.statusCode());
}
@Then("print the responce in console")
public void print_the_responce_in_console() {
   response.prettyPrint();
}

@Given("visiting the targeted API {string}  {string}")
public void visiting_the_targeted_api(String url, String target) {
    // Write code here that turns the phrase above into concrete actions
    RestAssured.baseURI = url+ target;
	reqspec = RestAssured.given();
}

@When("get targeted response from API")
public void get_targeted_response_from_api() {
    response = reqspec.get();
}

@Then("print the targeted responce in console")
public void print_the_targeted_responce_in_console() { 
	response.prettyPrint();
}

@Given("hitting the API with payload")
public void hitting_the_api_with_payload() {
    RestAssured.baseURI = "https://reqres.in/api/users/2";
    reqspec = RestAssured.given();
    String d = "{\r\n"
    		+ "    \"name\": \"morpheus\",\r\n"
    		+ "    \"job\": \"zion resident\"\r\n"
    		+ "}";
    response = reqspec.body(d).put();
    
}
@When("store the response")
public void store_the_response() {
   response.prettyPrint();
}
@Given("hitting the post with payload")
public void hitting_the_post_with_payload() {
	String res  = "{\r\n"
			+ "    \"email\": \"peter@klaven\"\r\n"
			+ "}";
    RestAssured.baseURI = "https://reqres.in/api/login";
    reqspec = RestAssured.given();
    response = reqspec.body(res).post();
}
@Then("Store the post response")
public void store_the_post_response() {
    response.prettyPrint();
}
@Then("verify the response")
public void verify_the_response() {
    Assert.assertEquals("Missing email or username", response.jsonPath().getString("error"));
}

@Given("trying to hit delete API with payload")
public void trying_to_hit_delete_api_with_payload() {
	RestAssured.baseURI = "https://reqres.in/api/users/2";
	reqspec=RestAssured.given();
	
	response = reqspec.delete();
 
}
@Then("strore delete response")
public void strore_delete_response() {
    response.prettyPrint();
}

@Then("verify the delete response")
public void verify_the_delete_response() {
    Assert.assertEquals("HTTP/1.1 204 No Content",response.statusLine());
    Assert.assertEquals(204,response.statusCode());
    int s = response.getStatusCode();
    System.out.println(s);
}

@Given("Get and print API response")
public void Get_and_print_API_response() {		 
	RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
	reqspec = RestAssured.given();	
	response = reqspec.request(Method.GET, "");
	System.out.println("Response=>" + response.prettyPrint());
	
}

@When("get the responce")
public void get_the_responce() 
{
	System.out.println("status code "+ response.statusCode());
	
	
    
}

@Then("validate the outcomes")
public void validate_the_outcomes() {
    
	Assert.assertEquals(200, response.getStatusCode());
}
@Given("visit the page")
public void visit_the_page() {
	RestAssured.baseURI = "https://openlibrary.org/works/OL45804W/editions.json";
	 reqspec = RestAssured.given();	
	 response = reqspec.request(Method.GET, "");
	//System.out.println(response.getBody().prettyPrint());
	
   
}

@When("get the book")
public void get_the_book() 
{
		String s = response.jsonPath().getString("entries[1].full_title");
		System.out.println(s);
		
    
}

@Then("print the value of the book")
public void print_the_value_of_the_book() {
	RestAssured.baseURI = "https://openlibrary.org/works/OL45804W/editions.json";
	reqspec = RestAssured.given();	
	response = reqspec.request(Method.GET, "");
	
	Assert.assertEquals("Fantastic Mr. Fox",response.jsonPath().getString("entries[1].full_title"));
	System.out.println(response.jsonPath().getString("entries[1].full_title")+ "verified");
    
}





}
