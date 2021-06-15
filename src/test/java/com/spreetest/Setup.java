package com.spreetest;

import com.shiftedtech.spree.MethodClass;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup extends MethodClass {

    @Before

    public void setup() {

        String driverPath = System.getProperty("user.dir") + "/drivers/chromedriver";

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.navigate().to("http://spree.shiftedtech.com/");
        driver.manage().window().maximize();
    }

    @After

    public void TearDown(){
        driver.close();
        driver.quit();
    }
}
