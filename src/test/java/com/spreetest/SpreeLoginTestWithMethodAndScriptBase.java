package com.spreetest;

import org.junit.Test;
import utils.IObjectrepository;
import utils.PropertyFileObjectRepositoryManager;

public class SpreeLoginTestWithMethodAndScriptBase {

    private IObjectrepository or = PropertyFileObjectRepositoryManager.getInstance();

   //@Override
   public void setUp() {
       // super.setUp();
        or.reset();
        or.load(System.getProperty("user.dir") + "/src/test/resources/SpreeObjectRepo.properties");
    }

    @Test

    public void validLogin2() {

      //verifyPageTitle("Spree Demo Site");

    }



}
