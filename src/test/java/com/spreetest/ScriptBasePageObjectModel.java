package com.spreetest;

import POM.ApplicationController;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ScriptBasePageObjectModel {

    protected WebDriver driver;
//    protected HomePage homePage;
//    protected LoginPage loginPage;

   protected ApplicationController spree=null;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("http://spree.shiftedtech.com/");
        spree=new ApplicationController(driver);
//        homePage = new HomePage(driver);
//        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
