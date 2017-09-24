package com.DDTExample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by PS2 on 24-Sep-17.
 */
public class DDTExample {   // Data Driven Testing

    private final String BASE_URL = "http://opensource.demo.orangehrmlive.com/";   // define the test URL
    private WebDriver webDriver;    //

    @BeforeClass         // create before class
    public void beforeClass(){
        webDriver = new HtmlUnitDriver(true);   // opening browser takes lots of time. that's y use htmlunidriver.
                                                              // also unable HTML Driver. coz HTML driver display as desabled as default
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  // set the waiting time. coz browser runs extremely fast
        // once create browser instance we are set ImplicitWait
    }

    @DataProvider(name = "userCredentials")   // Add the Data Source (Define data source here)
    private Object[][] userCredentials(){    // Returning object Array (String..interger..etc)
        return new Object[][]{     // Creating data set. (This is create data set for testing)
                {"Admin","","Password cannot be empty"},
                {"","admin","Username cannot be empty"},
                {"Admin","admin1","Invalid credentials"},
                {"Admin1","admin","Invalid credentials"}
        };
    }

    @BeforeMethod
    public void beforeMethod(){
        webDriver.get(BASE_URL);         // set the base URL
    }

    @Test(dataProvider = "userCredentials", dataProviderClass = DDTExample.class)  // set the class using dataProviderClass method
    public void testInvalidUserLogin(CharSequence username, CharSequence password, String expectedMessage){
        webDriver.findElement(By.id("txtUsername")).sendKeys(username);
        webDriver.findElement(By.id("txtPassword")).sendKeys(password);
        webDriver.findElement(By.id("txtPassword")).submit();
        Assert.assertEquals(getErrorMessage(), expectedMessage);

    }

    @Test(dataProvider = "userCredentials", dataProviderClass = DataSource.class)  // set the class using dataProviderClass method
    public void testInvalidUserLogin2(CharSequence username, CharSequence password, String expectedMessage){
        webDriver.findElement(By.id("txtUsername")).sendKeys(username);
        webDriver.findElement(By.id("txtPassword")).sendKeys(password);
        webDriver.findElement(By.id("txtPassword")).submit();
        Assert.assertEquals(getErrorMessage(), expectedMessage);

    }
    private String getErrorMessage(){
        return webDriver.findElement(By.id("spanMessage")).getText();   // return message while you click "Submit" button
    }
}

