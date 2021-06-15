package com.spreetest;

import com.shiftedtech.spree.ActionBaseForXcelFileObjectRepo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class SpreeBaseForExcelFileObjectRepo extends ActionBaseForXcelFileObjectRepo {

    @Before
    public void setUp() {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         driver.navigate().to("http://spree.shiftedtech.com/");
     }

     @After
    public void tearDown() {
         driver.close();
         driver.quit();
     }


}
