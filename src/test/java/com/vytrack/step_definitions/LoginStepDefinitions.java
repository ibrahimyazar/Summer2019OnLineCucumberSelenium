package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDefinitions {
    // Write code here that turns the phrase above into concrete actions
    LoginPage loginPage = new LoginPage();  // We created loginpage objec

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("I am on the login page");
        Driver.get().get(ConfigurationReader.getProperty("url"));

    }
//    @When("user navigates to {string} and {string}")
//    public void user_navigates_to_and(String string, String string2) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
//    }
//    @When("user navigates to {string} then to {string}")
//    public void user_navigates_to_then_to(String string, String string2) {
//
//    }


    @Then("user logs in as store manager")
    public void user_logs_in_as_store_manager() {
        System.out.println("Login as store manager");
        // we read username and password from properties file
        // usually in java we use Camel case for namings variables
        String username = ConfigurationReader.getProperty("user_name");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);
    }

    //any string in "word" will become a parameter for step definition method
    //  And user verifies that "Dashboard" page subtitle is displayed
    @Then("user verifies that {string} page subtitle is displayed")
    public void user_verifies_that_page_subtitle_is_displayed(String string) {

//        loginPage.waitUntilLoaderMaskDisappear();
//        BrowserUtils.wait(10);
//         Assert.assertEquals(string, loginPage.getPageSubTitle());
        loginPage.waitUntilLoaderMaskDisappear();
        BrowserUtils.wait(2);
        Assert.assertEquals(string, loginPage.getPageSubTitle());
        System.out.println("Verifying page subtitle: " + string);

    }

    @Then("user logs in as driver")
    public void user_logs_in_as_driver() {
        System.out.println("Login as driver");
    }

    @Then("user logs in as sales manager")
    public void user_logs_in_as_sales_manager() {
        System.out.println("Login as sales manager");
    }

    // Then user enters "storemanager85" username and "wrong" password
    @Then("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String string, String string2) {
        System.out.println("Login with " + string + " user name " + string2 + " password." );
    }

    //user verifies that "Invalid user name or password." message is displayed
    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String string) {
        System.out.println("verified that warning message is displayed: " + string);  // string = Invalid user name or password.
    }



}
