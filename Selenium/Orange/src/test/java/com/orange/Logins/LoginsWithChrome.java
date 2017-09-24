package com.orange.Logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by PS2 on 18-Sep-17.
 */
public class LoginsWithChrome {

    @Test
    public void TestLoginsWithValidCredentials(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");  // set the path for browser
        WebDriver webDriver = new ChromeDriver();           // new webdriver using chrome
        webDriver.get("http://opensource.demo.orangehrmlive.com/");  // set the URL (orangeHRM)
        webDriver.manage().window().maximize();  // maximize the window size (this is not really required)
        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");  // Find Value using id (using Inspect) - Enter UN
        webDriver.findElement(By.name("txtPassword")).sendKeys("admin"); // Find Value using name (suing Inspect) - Enter PW
        webDriver.findElement(By.id("btnLogin")).click();  // Find Value using id (Using Inspect) - Click on button
        // webDriver.findElement(By.name("Submit")).click(); // Find Value using name (Using Inspect) - Click on button
        webDriver.close();  // close the browser once test case is done.
    }



}
