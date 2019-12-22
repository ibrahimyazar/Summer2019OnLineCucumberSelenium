package com.vytrack.step_definitions;

import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class CreateCarStepDefinitions {


    @Then("user click the {string} button")
    public void user_click_the_button(String string) {  // dec 12 vide last minites
        System.out.println("now i am in the " + string + " page");
    }

    @Then("user adds new car information")
    public void user_adds_new_car_information(List<Map<String, String>> dataTable) {// dec 12
        System.out.println(dataTable.get(0).get("Driver"));
    }



}
