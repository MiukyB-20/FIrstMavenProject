package com.shiftedtech.spree;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MethodClass extends ActionBaseFunction {

    public void goToLoginPage() {
        driver.findElement(By.linkText("Login")).click();
    }

    public void verifyPageTitle() {

        String getPageTitle = driver.getTitle();
        Assert.assertEquals("Login - Spree Demo Site" , getPageTitle);

}

    public void Login(String email, String password) {

        typeText(By.name("spree_user[email]"), email);
        typeText(By.name("spree_user_password"), password);
        click(By.name("commit"));

    }

    public void verifyValidLogin() {

        WebElement login = driver.findElement(By.cssSelector(".alert-success"));
        Assert.assertNotNull(login);
        String successMessege = login.getText();
        Assert.assertEquals("Logged in successfully",successMessege);

    }

    public void InvalidLogin(String email, String password) {

        typeText(By.name("spree_user[email]"),email);
        typeText(By.name("spree_user_password"),password);
        click(By.name("commit"));
    }

    public void verifyInvalidLogin(){

        WebElement login = driver.findElement(By.cssSelector(".alert-error"));
        Assert.assertNotNull(login);
        String errorMessege = login.getText();
        Assert.assertEquals("Invalid email or password",errorMessege);
    }

    public void goToLogoutPage(){

        driver.findElement(By.linkText("Logout")).click();
    }

    public void verifyLogout(){

        WebElement logout = driver.findElement(By.cssSelector(".alert-notice"));
        Assert.assertNotNull(logout);
        String successMessege = logout.getText();
        Assert.assertEquals("Signed out successfully",successMessege);
    }


}
