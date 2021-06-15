package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageBase {

    protected WebDriver driver = null;
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void delayFor(int timeInMili) {
        try {
            Thread.sleep(timeInMili);

        } catch (InterruptedException e) {
            e.printStackTrace();
         }
    }
    public void verifyPageTitle(String expectedPageTitle) {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle, pageTitle);


    }

    public void sendKeys(By by,String text) {
        logger.info("sendkeys {}",text);

        WebElement element = null;
        try{
            element = driver.findElement(by);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        if(element != null && element.isDisplayed()){
            element.sendKeys(text);
        }
        else{
            logger.error("could not find the element");
        }
    }

    public void typeText(By by,String text) {
        logger.info("typeText{}", text);

        WebElement element = null;
        element = driver.findElement(by);
            if(element != null && element.isDisplayed()){
                element.sendKeys(text);
            }
            else {
                logger.error("Element was found but not visible");
        }
    }

    public void click(By by) {
        logger.info("click");
        WebElement element = driver.findElement(by);
        if(element != null && element.isDisplayed()){
            element.click();
        }
    }

    public void verifyText(By by, String expectedText) {

        logger.info("verifyTex{}",expectedText);

        WebElement element = driver.findElement(by);
        if(element != null && element.isDisplayed()) {
            String actualText = element.getText();
            Assert.assertEquals(expectedText, actualText);
        }
        else{
            logger.error("Element was found but not visible");
        }
    }





}
