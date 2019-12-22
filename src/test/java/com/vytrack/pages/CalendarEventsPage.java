package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(css = "[class = 'grid-header-cell__label']")  // dec 20 37:00 dk
    public  List<WebElement> columnNames;

    @FindBy(css = "[class = 'btn dropdown-toggle ']")
    public WebElement viewPerPageToggle;

    @FindBy(css = "[class*='btn-group'] [class='dropdown-menu pull-right'] li")
    public List<WebElement> viewPerPageOptions;


    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForVisibility(createCalendarEvent, 5);
        BrowserUtils.waitForClickablility(createCalendarEvent, 5);
        createCalendarEvent.click();
    }

    public List<String> getCulumnNames(){  // dec 20
        return BrowserUtils.getListOfString(columnNames);
    }

    public List<String> getviewPerPageOptions(){  //dec 20
        BrowserUtils.waitForVisibility(viewPerPageToggle,10);
        BrowserUtils.clickWithWait(viewPerPageToggle);
        return BrowserUtils.getListOfString(viewPerPageOptions);




    }



}


