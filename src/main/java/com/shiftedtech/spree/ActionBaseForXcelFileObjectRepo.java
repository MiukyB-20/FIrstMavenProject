package com.shiftedtech.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionBaseForXcelFileObjectRepo {

    protected WebDriver driver;

    public void Click(By by) {

        WebElement element = driver.findElement(by);
        element.click();

    }

    public void typeText (By by, String value) {

        WebElement element = driver.findElement(by);
        element.sendKeys(value);
    }
}
