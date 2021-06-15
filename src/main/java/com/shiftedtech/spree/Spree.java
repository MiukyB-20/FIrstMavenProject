package com.shiftedtech.spree;

import org.openqa.selenium.By;

public class Spree {

    public static By LOGIN_LINK = By.linkText("Login");
    public static  By SUCCESS_MESSEGE = By.cssSelector(".alert-success");

    public static class Login{
        public static By Email = By.id("spree_user[email]");
        public static By Password = By.name("spree_user_password");
        public static By Click = By.name("commit");

    }

    public static class invalidLogin{
        public static By Email = By.name("spree_user[email]");
        public static By Password = By.name("spree_user_password");
        public static By Click = By.name("commit");
    }


}
