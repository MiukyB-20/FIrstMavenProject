package com.shiftedtech.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionBaseFunction extends Spree{

    protected WebDriver driver;

    public void typeText(By by, String text) {

        WebElement element = driver.findElement(by);
        if((element != null) && element.isDisplayed()) {
         element.sendKeys(text);
        }

    }

    public void click(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }
}
