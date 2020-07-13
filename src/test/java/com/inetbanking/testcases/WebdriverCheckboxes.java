package com.inetbanking.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import org.testng.annotations.Test;

import javax.swing.*;
import java.util.*;

//@Test(enabled = false)
public class WebdriverCheckboxes {
//    public static boolean verify_Values_In_Dropdown(List<WebElement> listOfElements, String[] strValues) {
//        boolean bValue = false;
//        List<String> list = new ArrayList<String>();
//        for (String strValue : strValues) {
//            boolean bflag = false;
//            for (WebElement element : listOfElements) {
//                String elementValue = element.getText();
//                if (strValue.equals(elementValue)) {
//                    bflag = true;
//                }
//            }
//            if (! bflag)
//                list.add(strValue);
//        }
//        if (list.size() > 0) {
//            for (String strList : list) {
//                System.out.println("Value not present in dropdown: " + strList);
//            }
//            //Assign false if any of the value not found in dropdown
//            bValue = false;
//        } else {
//            //Assign true if all values found in dropdown
//            System.out.println("All value(s) found in dropdown");
//            bValue = true;
//        }
//        return bValue;
//    }
//    public void WebdriverCheckboxesTest() {
//        System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(System.getProperty("user.dir") + "//src//test//java//com//inetbanking//testdata//CheckboxTest.html");
//
//        WebElement checkbox1 = driver.findElement(By.id("LettuceCheckbox"));
//        checkbox1.click();
//
//        WebElement checkbox2 = driver.findElement(By.id("mayoCheckbox"));
//        checkbox2.click();
//
//        WebElement checkbox3 = driver.findElement(By.id("turkeyCheckbox"));
//        checkbox3.click();
//        driver.quit();
//    }

//    @Test(enabled = false)
//
//    public void WebdriverSelectItems() {
//        System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(System.getProperty("user.dir") + "//src//test//java//com//inetbanking//testdata//SelectItemTest.html");
//
//        WebElement selectElement = driver.findElement(By.id("select1"));
//        Select select = new Select(selectElement);
//        select.selectByVisibleText("MaybeNo");
//        System.out.println("\"MaybeNo\" option is selected");
//
//        WebElement selectedElement = select.getFirstSelectedOption();
//        String selectedOption = selectedElement.getText();
//
//        Assert.assertEquals(selectedOption, "MaybeNo1");
////        if (selectedOption.equals("MaybeNo")) {
////            Assert.assertTrue(true);
////            System.out.println("Test passed");
////            driver.quit();
////        } else {
////            Assert.assertTrue(false);
////            System.out.println("Test failed");
////        }
//        driver.quit();
//    }
//
//    @Test(enabled = true)

//
//    public void WebdriverSelectItems1() {
//        System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(System.getProperty("user.dir") + "//src//test//java//com//inetbanking//testdata//DropDownListBox.html");
//
//        WebElement selectElement = driver.findElement(By.name("Mobdevices"));
//        Select select = new Select(selectElement);
//        List<WebElement> valuesInDropDown = select.getOptions();
//        String[] checkValues = {"iPhone", "Nokia", "Samsung"};
//
//        //System.out.println(valuesInDropDown);
//
//        Assert.assertEquals(valuesInDropDown, checkValues);
//                //(valuesInDropDown, checkValues), "Values are not matching with the dropdown list");
//    }

    @Test//(enabled = false)

    public void dragAndDrop() {
        System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(System.getProperty("user.dir") + "//src//test//java//com//inetbanking//testdata//DragAndDrop.html");

        WebElement sourceEle = driver.findElement(By.id("draggable"));
        WebElement targetEle = driver.findElement(By.id("droppable"));
        Actions actionProvider = new Actions(driver);
        actionProvider.dragAndDrop(sourceEle, targetEle).build().perform();
    }

    @Test(enabled = false)

    public void getAllCookies() {
        System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.example.com");
        // Add few cookies
        //driver.manage().addCookie(new Cookie("test1", "cookie1"));
        //driver.manage().addCookie(new Cookie("test2", "cookie2"));
        Cookie cookie1 = new Cookie("test1", "cookie1");

        // Get All available cookies
        //Set<Cookie> cookies = driver.manage().getCookies();
        //driver.manage().deleteCookieNamed("test1");
        driver.manage().deleteAllCookies();

        System.out.println(cookie1);
        System.out.println(cookie1);
        Cookie cookie2 = new Cookie("test2", "cookie2");
        driver.manage().addCookie(new Cookie("test2", "cookie2"));

        System.out.println(cookie2);
        System.out.println(cookie1);
        driver.quit();
    }
//?
}


