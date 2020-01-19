package com.vytrack.step_definitions;

import com.vytrack.pages.FleetModulePage;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class FleetModuleStepdefinition {
    FleetModulePage fleetModulePage = new FleetModulePage();

    @When("user click the square button box")
    public void user_click_the_square_button_box() {
      fleetModulePage.ClickTheCheckBox();
    }

    @When("Verify that all box are check")
    public void verify_that_all_box_are_check() {

     //Assert.assertTrue();
    fleetModulePage.checkAllCheckBox();
    }




}
