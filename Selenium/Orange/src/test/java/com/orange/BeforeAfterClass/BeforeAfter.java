package com.orange.BeforeAfterClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by PS2 on 18-Sep-17.
 */
public class BeforeAfter {
    public static final String BASE_URL = ("http://opensource.demo.orangehrmlive.com/");  // Base URL
    WebDriver webDriver;  // Create instance of web driver

    @BeforeClass
    public void TestBeforeClass(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        webDriver = new ChromeDriver();  // call created instance
        webDriver.get(BASE_URL);  // call base URL
        webDriver.manage().window().maximize();
        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");  // Enter valid UN
        webDriver.findElement(By.id("txtPassword")).sendKeys("admin");  // Enter valid PW
        webDriver.findElement(By.id("btnLogin")).click();             // Press "click" Button
    }


    @AfterClass
    public void TestAfterClass(){
        webDriver.close(); // once you done all testing web driver should be close
    }

    @Test
    public void LoginLogout(){
        webDriver.findElement(By.id("menu_pim_viewPimModule")).click();  //
        webDriver.findElement(By.id("menu_pim_addEmployee")).click();    //
    }
}
