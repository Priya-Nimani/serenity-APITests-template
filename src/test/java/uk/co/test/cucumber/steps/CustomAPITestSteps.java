package uk.co.test.cucumber.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import java.util.List;
import static java.lang.Boolean.parseBoolean;
import static org.hamcrest.CoreMatchers.is;


public class CustomAPITestSteps {

    private Response response;
    String BASE_URI = "http://api.postcodes.io/postcodes/";

    @Then("^the server should return a error status along with the error message \"([^\"]*)\"$")
    public void theServerShouldReturnAErrorStatusAlongWithTheErrorMessage(String errMsg) throws Throwable {
        response.then().statusCode(404).and().body("error",is(errMsg));
    }

    @Step
    @When("^a user attempts to validate a postcode \"([^\"]*)\"$")
    public void aUserAttemptsToValidateAPostcode(String postcode) throws Throwable {
        String url = BASE_URI + postcode + "/validate";
        response = RestAssured.when().get(url);
    }

    @Step
    @Then("^the server should return the validation status as \"([^\"]*)\"$")
    public void theServerShouldReturnTheValidationStatusAs(String status) throws Throwable {
        response.then().body("result",is(parseBoolean(status)));
    }

    @Step
    @When("^a user does a look up for postcode \"([^\"]*)\"$")
    public void aUserDoesALookUpForPostcode(String postcode) throws Throwable {
        response = RestAssured.when().get(BASE_URI + postcode);
    }

    @Step
    @Then("^the server should return a success status along with admin district as \"([^\"]*)\"$")
    public void theServerShouldReturnASuccessStatusAlongWithAdminDistrictAs(String adminDistrict) throws Throwable {
        response.then().statusCode(200).and().body("result.admin_district",is(adminDistrict));
    }

    @When("^user does a search with longitude \"([^\"]*)\" and lattitude \"([^\"]*)\"$")
    public void userDoesASearchWithLongitudeAndLattitude(String longitude, String latitude) throws Throwable {
        String url = BASE_URI + "?lon=" + longitude + "&lat=" + latitude;
        response = RestAssured.when().get(url);
    }

    @Then("^list of valid postcodes is returned$")
    public void listOfValidPostcodesIsReturned(DataTable postcodes) throws Throwable {
        List<List<String>> postCode = postcodes.raw();
        String expectedPostCode, result;

        int iLoop;

        for(iLoop =0 ; iLoop < postCode.size();iLoop++){
            expectedPostCode = postCode.get(iLoop).get(0);
            result = "result[" + iLoop + "].postcode";
            response.then().body(result, is(expectedPostCode));
        }

    }
}
