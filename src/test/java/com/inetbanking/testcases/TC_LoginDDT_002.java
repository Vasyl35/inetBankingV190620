package com.inetbanking.testcases;
        import java.io.IOException;

        import org.openqa.selenium.NoAlertPresentException;
        import org.testng.Assert;
        import org.testng.annotations.DataProvider;
        import org.testng.annotations.Test;

        import com.inetbanking.pageobjects.LoginPage;
        import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{

    @Test(dataProvider="LoginData")
    public void loginDDT(String user,String pwd) throws InterruptedException, IOException {
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(user);
        //logger.info("user name provided");
        lp.setPassword(pwd);
        //logger.info("password provided");
        lp.clickSubmit();

        Thread.sleep(3000);

        if(isAlertPresent()==true)
        {
            captureScreen(driver,"TC_LoginDDT_002");
            driver.switchTo().alert().accept();//close alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            Logger.warn("Login EXCEL failed");
        }
        else
        {
            Assert.assertTrue(true);

            Logger.info("Login passed");
            lp.clickLogout();
            Thread.sleep(3000);
            driver.switchTo().alert().accept();//close logout alert
            driver.switchTo().defaultContent();

        }


    }


    public boolean isAlertPresent() //user defined method created to check alert is presetn or not
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch(NoAlertPresentException e)
        {
            return false;
        }

    }


    @DataProvider(name="LoginData")
    public static Object [] [] getData() throws IOException
    {
        java.lang.String path;
        path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";

        int rownum=XLUtils.getRowCount(path, "Sheet1");
        int colcount=XLUtils.getCellCount(path,"Sheet1",1);

        String logindata[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
            }

        }
        return logindata;
    }

}
