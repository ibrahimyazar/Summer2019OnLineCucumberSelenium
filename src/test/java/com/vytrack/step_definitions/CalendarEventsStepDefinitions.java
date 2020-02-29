package com.vytrack.step_definitions;

import com.vytrack.pages.CalendarEventsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalendarEventsStepDefinitions {

//       And user verifies that column names are displayed
//            | TITLE             |
//            | CALENDAR          |
//            | START             |
//            | END               |
//            | RECURRENT         |
//            | RECURRENCE        |
//            | INVITATION STATUS |

    // we have to create claender event page objcet
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Then("user verifies that column names are displayed")
    public void user_verifies_that_column_names_are_displayed(List<String>  dataTable) {

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(dataTable);
        // we need to
        // cucumber automaticly finded the step definitioans
       calendarEventsPage.waitUntilLoaderMaskDisappear();
        calendarEventsPage.getCulumnNames();  // thgis is aur actual result from calendareventpage
        Assert.assertEquals(calendarEventsPage.getCulumnNames(), dataTable);


    }



}
