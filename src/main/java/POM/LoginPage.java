package POM;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends PageBase {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id = "spree_user_email")
    private WebElement emailTextBox;
    @FindBy(id = "spree_user_password")
    private WebElement passwordTextbox;
    @FindBy(name = "commit")
    private WebElement loginButton;
    @FindBy(css = ".alert-error")
    private WebElement errorMessege;



    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
    }

    public void login(String email, String password) {
        if(emailTextBox.isDisplayed()) {
            emailTextBox.sendKeys(email);
        }
        else {
            System.out.println("Email textbox is not displayed");
        }
        if(passwordTextbox.isDisplayed()) {
            passwordTextbox.sendKeys(password);
        }
        else {
            System.out.println("Password textbox is not displayed");
        }
        if(loginButton.isDisplayed()) {
            loginButton.click();
        }
        else {
            System.out.println("Login button is not displayed");
        }
    }

    public void verifyLoginNotSuccess() {
        verifyLoginNotSuccess("Invalid email or password");

    }

    public void verifyLoginNotSuccess(String expectedMessege) {
        Assert.assertNotNull(errorMessege);
        String errorMessegeText = errorMessege.getText();
        Assert.assertEquals(expectedMessege, errorMessegeText);
    }

    public void verifyLoginPageTitle() {
        verifyPageTitle("Login - Spree Demo Site");
    }







}
