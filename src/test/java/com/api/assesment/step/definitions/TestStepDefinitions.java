package com.api.assesment.step.definitions;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Properties;

import com.api.assesment.util.Const;
import com.api.assesment.util.JsonTypes;
import com.api.assesment.util.Promotions;
import com.api.assesment.util.PropertyLoader;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
 
public class TestStepDefinitions {
	
    private ValidatableResponse validatableResponse;
    private JsonPath jsonPath;
    private Properties properties;
    
    public TestStepDefinitions() {
    	properties = PropertyLoader.PropertyLoader();
	}

    @When("user make a request to the URL")
    public void sendRequest()
    {
    	RestAssured.baseURI = Const.BASE_URL;
    	validatableResponse = given().contentType(ContentType.JSON).when().get(Const.ENDPOINT).then();  
    	System.out.println(validatableResponse.extract().asPrettyString());
    }
    
    
    @Then("the user get an OK response")
    public void the_user_get_an_OK_response()
    {
    	validatableResponse.assertThat().statusCode(Const.STATUS);
    	jsonPath = validatableResponse.extract().jsonPath();
    }

    @And("check the response exists with Name as {string}")
    public void check_the_response_exists_with_Name_as(String input)
    {
    	String output = getValues(Const.RESPONSE_JSON_KEY_NAME,String.class);;
		assertEquals(output, input);
    }
    
    @And("CanRelist as {booleanValue}")
    public void canRelist_as(boolean input)
    {
    	boolean output = getValues(Const.RESPONSE_JSON_KEY_CAN_RELIST, Boolean.class);
    	assertEquals(output, input);
    }
    
    @And("Promotion Name as {string} and Description should be as {string}")
    public void Promotion_Name_as_description_should_be_as(String inputPromotionName, String inputDescription)
    {
    	List<Promotions> promotions =   getValuesAsList(Const.RESPONSE_JSON_KEY_PROMOTION, Promotions.class);
		assertNotEquals(errorMessage(Const.RESPONSE_JSON_KEY_PROMOTION), promotions.size(), 0);
		
		assertTrue(promotions.stream().anyMatch(pro -> pro.getName().equals(inputPromotionName)));
		assertNotNull(errorMessage(Const.RESPONSE_JSON_KEY_PROMOTION), promotions.stream().filter(pro -> pro.getName().equals(inputPromotionName) && pro.getDescription().equals(inputDescription)).findAny().orElse(null));
    }
    
    @ParameterType(value = "true|True|TRUE|false|False|FALSE")
    public Boolean booleanValue(String value) 
    {
        return Boolean.valueOf(value);
    }
    
    public String errorMessage(String key) 
    {
        return key + Const.ERROR_MESSAGE;
    }
  
    //Generic method to fetch data from JSON as a List
    private <T extends JsonTypes>List<T> getValuesAsList(String key, Class<T> type) 
    {
    	List<T> values = jsonPath.getList(key,type);
    	assertNotNull(values);
    	return values;
  
    }
    
    //Generic method to fetch data from JSON as a primitive data
    private <T extends Object>T getValues(String key, Class<T> type){
    	Object value = jsonPath.get(key);
    	assertNotNull(value);
    	return type.cast(value);
    }
    


	 
}