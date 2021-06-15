package com.spreetest;

import org.junit.Test;

public class TestScripts extends Setup {

    @Test

    public void validLoginTest() {

        goToLoginPage();
        verifyPageTitle();
        Login("shiftqa01@gmail.com", "shiftedtech");
        verifyValidLogin();
        goToLogoutPage();
        verifyLogout();
    }

    @Test

    public void invalidUserLoginTest() {

        goToLoginPage();
        verifyPageTitle();
        InvalidLogin("shiftqa04@gmail.com", "abcd");
        verifyInvalidLogin();
    }
}
