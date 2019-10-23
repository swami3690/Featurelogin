package OrangeFeature;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs  extends Utils {
LoadProp loadProp = new LoadProp();
HomePage homePage = new HomePage();


    @Given("User is on homepage")
    public void user_is_on_homepage() {

    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
    homePage.credentials();

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {


        homePage.Login();
    }

    @Then("user should be logged in and able to see welcome message")
    public void user_should_be_logged_in_and_able_to_see_welcome_message() {
        homePage.massage();
    }


    @When("I enter Username as {string} and Password as {string}")
    public void i_enter_Username_as_and_Password_as(String string, String string2) {
        homePage.failLogin();

    }

    @When("User click on login button")
    public void user_click_on_login_button() {
        homePage.Login();
    }

    @Then("User should not be logged in with error message {string}")
    public void user_should_not_be_logged_in_with_error_message(String string) {


    }
}
