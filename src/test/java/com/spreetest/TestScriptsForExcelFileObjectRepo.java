package com.spreetest;

import org.junit.After;
import org.junit.Test;
import utils.ExcelFileObjectRepositoryManager;
import utils.IObjectrepository;

public class TestScriptsForExcelFileObjectRepo extends SpreeBaseForExcelFileObjectRepo {

    //reading static file
    public IObjectrepository ex = ExcelFileObjectRepositoryManager.getInstance();

    @Override
    public void setUp() {

       // String fileName = System.getProperty(("user dir") + "/src/test/resources/SpreeObjectRepo.xls");
        super.setUp();;
        ex.reset();
        ex.load(System.getProperty("user.dir") + "/src/test/resources/SpreeObjectRepo.xls");
    }

    @Test

    public void validLogin() {

    Click(ex.getLocator("HOME_PAGE.LOGIN_LINK"));
    typeText(ex.getLocator("LOGIN_PAGE.EMAIL_TEXTBOX"),"shiftqa01@gmail.com");
    typeText(ex.getLocator("LOGIN_PAGE.PASSWORD_TEXTBOX"),"shiftedtech");
    Click(ex.getLocator("LOGIN_PAGE.LOGIN_BUTTON"));



    }

    @After
    public void tearDown() {
        super.tearDown();
    //driver.close();
   // driver.quit();
    }
}
