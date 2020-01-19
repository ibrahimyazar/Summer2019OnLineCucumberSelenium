package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FleetModulePage extends BasePage {

    @FindBy (xpath = "(// input [@ type = 'checkbox'])[20]")
    public WebElement fleetCheckBoxElement;
    @FindBy (xpath = "(// button [@ class = 'btn btn-default btn-small dropdown-toggle'])[1]")
    public WebElement fleetCheckBoxCarotElement;

    @FindBy (css = "[class='grid-row row-click-action']")
    public WebElement allCheckBoxElement;

    public void ClickTheCheckBox(){
        BrowserUtils.wait(3);
        fleetCheckBoxElement.click();
        BrowserUtils.wait(3);
    }

    public void checkAllCheckBox() {
        int count = 0;
        List<WebElement> allCheckBoxes = Driver.get().findElements(By.cssSelector("[type='checkbox']"));
        for (WebElement each : allCheckBoxes) {
            if (each.isSelected()) {
                count++;
                System.out.println(count + "nth checkbox is checked!");
                Assert.assertTrue(each.isSelected());
            }
        }

    }

}
