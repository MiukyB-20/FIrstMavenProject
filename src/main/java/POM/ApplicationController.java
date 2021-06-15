package POM;

import org.openqa.selenium.WebDriver;

public class ApplicationController {

    protected WebDriver driver;

    {
        driver = null;
    }

    private HomePage homePage = null;
    private LoginPage loginPage = null;


    public ApplicationController(WebDriver driver){
        this.driver = driver;
    }

    public HomePage homePage() {
        if(homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public LoginPage loginPage() {
        if(loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return  loginPage;
    }
}
