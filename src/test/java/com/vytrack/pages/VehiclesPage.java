package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class VehiclesPage extends BasePage{  // BasePage is a super class

/**
 * This method stands for selecting tags
 * Provide tag name to select
 * If checkbox already selected, it will not do anything
 * @param tagName
 */
    @FindBy(css = ("[title = 'Create Car']"))
    public WebElement createCarElement;

    public void clickToCreateACar(){
        BrowserUtils.waitForClickablility(createCarElement,10);
        BrowserUtils.waitForVisibility(createCarElement, 10);
        createCarElement.click();
    }



}
