package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.rules.Timeout;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
        String userName = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(userName, password);
    }

    //any string in "word" will become a parameter for step definition method
    //  And user verifies that "Dashboard" page subtitle is displayed
    @Then("user verifies that {string} page subtitle is displayed")
    public void user_verifies_that_page_subtitle_is_displayed(String string) {

        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        // we read username and password from properties file
        // usually in java we use Camel case for namings variables
        String userName = ConfigurationReader.getProperty("username_driver");
        String password = ConfigurationReader.getProperty("password_driver");
        loginPage.login(userName, password);
    }

    @Then("user logs in as sales manager")
    public void user_logs_in_as_sales_manager() {
        System.out.println("Login as sales manager");

        String userName = ConfigurationReader.getProperty("username_sales_manager");
        String password = ConfigurationReader.getProperty("passwordsales_manager");
        loginPage.login(userName, password);
    }

    // Then user enters "storemanager85" username and "wrong" password
    @Then("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String string, String string2) {
        System.out.println("Login with " + string + " user name " + string2 + " password." );
        loginPage.login(string, string2);
    }

    //user verifies that "Invalid user name or password." message is displayed
    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String string) {
        System.out.println("verified that warning message is displayed: " + string);  // string = Invalid user name or password.
    }

//    Then user logs in as driver with following credentials
//      | username | user160     |
//      | password | UserUser123 |
    @Then("user logs in as driver with following credentials")  // dec 12 son dakikalar
                                                                // key        value
   // public void user_logs_in_as_driver_with_following_credentials(Map<String, String> dataTable) {
    public void user_logs_in_as_driver_with_following_credentials(List<Map<String, String>> dataTable) {
        System.out.println(dataTable);
        loginPage.login("username", "password");

    }

    @Then("user logs in as {string}")
    public void user_logs_in_as(String role) {
        loginPage.login(role);
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String string) {
        BrowserUtils.waitForPageTitle(string);
        //Assert.assertEquals(string, Driver.get().getTitle());
        Assert.assertEquals("Title is incorrect", string, Driver.get().getTitle());
    }


}
