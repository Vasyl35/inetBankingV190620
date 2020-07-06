package com.inetbanking.testcases;

import com.inetbanking.utilities.ReadConfig;
import com.mongodb.MapReduceCommand;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    ReadConfig readconfig = new ReadConfig();

    public String baseURL = readconfig.getApplicationURL();
    public String username = readconfig.getUsername();
    public String password = readconfig.getPassword();
    public static WebDriver driver;
    public static Logger Logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br) {

        Logger = Logger.getLogger("ebankingProjectName");
        PropertyConfigurator.configure("Log4j.properties");

        Logger.debug("this is a debug log message");
        Logger.info("this is a information log message");
        Logger.warn("this is a warning log message");

        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if (br.equals("ie")){
              System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
              driver = new InternetExplorerDriver();
              driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(baseURL);
        Logger.info("URL is opened");
     }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Quit");

    }
    public void captureScreen(WebDriver driver, String tname) throws IOException{
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
    public String randomestring(){
        String generatedstring = RandomStringUtils.randomAlphabetic(9);
        return (generatedstring);
    }
    public static String randomeNum(){
        String generatedstring2 = RandomStringUtils.randomNumeric(3);
        return (generatedstring2);
    }
}
