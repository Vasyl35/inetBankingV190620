package com.inetbanking.testcases;

import com.inetbanking.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC_LoginTest_001 extends BaseClass{

    @Test
    public void loginTest() throws IOException {
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        Logger.info("Entered username");
        lp.setPassword(password);
        Logger.info("Enteare password");
        lp.clickSubmit();
        Logger.info("clickSubmitBnt");

//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Agile Testing Tutorial";
//        assertEquals(actualTitle, expectedTitle);


        if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
        {
            Assert.assertTrue (true);
            Logger.info("Login test passed");
        }
        else
        {
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            Logger.info("Login test failed");
            System.out.println("Test failed");
        }

    }
}
