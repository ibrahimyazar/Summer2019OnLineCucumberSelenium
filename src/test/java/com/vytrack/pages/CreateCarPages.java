package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCarPages  extends BasePage {

    @FindBy(css = "[id^= 'custom_entity_type_LicensePlate']")
    public WebElement  licencePlateElement;

    @FindBy(css = "[name= 'custom_entity_type[Driver]']")
    public WebElement driverElemnent;

    /**
     * This method stands for selecting tags
     * Provide tag name to select
     * If checkbox already selected, it will not do anything
     * @param tagName
     * @return webelement of checkbox that was selected
     */
    public WebElement selectTags(String tagName){

        //locator for checkbox is based on label name
        //label and checkbox are siblings
        String locater = "//label[text() = '" + tagName + "']/preceding-sibling::input[@type = 'checkbox']";  //video 1:25
        WebElement checkBox = Driver.get().findElement(By.xpath(locater));
        BrowserUtils.waitForVisibility(checkBox, 15);
        BrowserUtils.waitForClickablility(checkBox, 15);

        if(!checkBox.isSelected()){  // is check box is not selecting
            checkBox.click();
        }

        return checkBox;
    }

}
