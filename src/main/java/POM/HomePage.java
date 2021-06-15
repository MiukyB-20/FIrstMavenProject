package POM;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends PageBase{

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    @FindBy(linkText = "Login")
    private WebElement loginlink;
    @FindBy(css = ".cart-info")
    private WebElement cartPagelink;
    @FindBy(css = ".alert-success")
    private WebElement successMessege;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToLoginPage() {
        logger.info("goToLoginPage");
        if( loginlink!= null && loginlink.isDisplayed()) {
            loginlink.click();
        } else {
            System.out.println("Login link is not visible");
        }
    }

    public void goToCartPage() {
        logger.info("goToCartPage");
        if(cartPagelink != null && cartPagelink.isDisplayed()) {
            cartPagelink.click();
        } else {
            System.out.println("Cart link is not visible");
        }
    }

    public void verifyLoginSuccess() {
        verifyLoginSuccess("Logged in successfully");
    }

    public void verifyLoginSuccess(String expectedMessege) {
        logger.info("verifyLoginSuccess");
        delayFor(1000);
        Assert.assertNotNull(successMessege);
        //assertThat(successMessege, notnullValue());
        String actualMessegeText = successMessege.getText();
        //assertThat(actualMessege, is(equalTo(expectedMessege)));
        Assert.assertEquals(expectedMessege,actualMessegeText);
    }

    public void verifyHomePageTitle() {
        logger.info("verifyHomePageTitle");
       verifyPageTitle("Spree Demo Site");
    }
}
