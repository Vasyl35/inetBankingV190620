package com.inetbanking.testcases;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustommerTest_003 extends BaseClass {

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        Logger.info("User name is provided");
        lp.setPassword(password);
        Logger.info("Password is provided");
        lp.clickSubmit();

        Thread.sleep(3000);

        AddCustomerPage addcust=new AddCustomerPage(driver);
        addcust.clickAddNewCustomer();

        Logger.info("providing customer details...");

        addcust.custName("Vasyl");
        addcust.custgender("male");
        addcust.custdob("09","17","2009");
        Thread.sleep(5000);
        addcust.custaddress("Ukraine");
        addcust.custcity("HYD");
        addcust.custstate("AP");
        addcust.custpinno("5000074");
        addcust.custtelephonne("987890091");

        String email=randomestring()+"@gmail.com";
        addcust.custemailid(email);
        addcust.custpossword("abcdef");
        addcust.custsubmit();

        Thread.sleep(3000);

        Logger.info("Validation started....");

        boolean res = driver.getPageSource().contains("Customer");
        System.out.println(res);
        if(res == true){
            Assert.assertTrue(true);
            Logger.info("Test case passed!");
        }
        else {
            captureScreen(driver,"addNewCustomer");
            Assert.assertTrue(false);
            Logger.info("Test case failed(:");
        }
    }
}
