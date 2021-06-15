package com.spreetest;

import POM.HomePage;
import POM.LoginPage;
import org.junit.Test;

public class SpreeLoginTestWithPOM extends ScriptBasePageObjectModel{


    @Test

    public void validLoginTest() {

        spree.homePage().verifyHomePageTitle();
        spree.homePage().goToLoginPage();
        spree.loginPage().verifyLoginPageTitle();
//        loginPage.login("shiftqa01@gmail.com", "shiftedtech");
//        homePage.verifyHomePageTitle();
//        homePage.verifyLoginSuccess();
    }

    @Test

    public void validLoginTest2() {
        HomePage homepage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homepage.verifyHomePageTitle();
        homepage.goToLoginPage();
        loginPage.verifyLoginPageTitle();
        loginPage.login("shiftqa02@gmail.com", "shiftedtech");
        homepage.verifyHomePageTitle();
        homepage.verifyLoginSuccess();
    }
}
