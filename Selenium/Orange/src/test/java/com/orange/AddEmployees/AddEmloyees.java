package com.orange.AddEmployees;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by PS2 on 18-Sep-17.
 */
public class AddEmloyees {
    public static final String BASE_URL = ("http://opensource.demo.orangehrmlive.com/");  // define the url
    WebDriver webDriver;            // create object called webDriver using WebDriver

    @BeforeClass
    public void TestBeforeClass(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        webDriver = new ChromeDriver();  // call created instance
        webDriver.get(BASE_URL);  // call base URL
        webDriver.manage().window().maximize();  // full screen the window
        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");  // Enter valid UN
        webDriver.findElement(By.id("txtPassword")).sendKeys("admin");  // Enter valid PW
        webDriver.findElement(By.id("btnLogin")).click();             // Press "click" Button
    }

    @AfterClass
    public void TestAfterClass(){
     //   webDriver.close();
    }

    @Test
    public void AddEmployee() throws IOException {
        webDriver.findElement(By.id("menu_pim_viewPimModule")).click();  // Move to the PIM
        webDriver.findElement(By.id("menu_pim_addEmployee")).click();    // Move to the Add Employee
        webDriver.findElement(By.id("firstName")).sendKeys("Lew");  //  Enter Firstname
        webDriver.findElement(By.id("middleName")).sendKeys("Car");  //  Enter Middle name
        webDriver.findElement(By.id("lastName")).sendKeys("Ham");  //  Enter Lastname
        webDriver.findElement(By.id("photofile")).click();   // click on "Choose File" button
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    // set the time
        Runtime.getRuntime().exec("E:\\Selenium\\Orange\\images\\New folder\\fileupload4.exe");
       // Runtime.getRuntime().exec("E:\\Selenium\\Orange\\images\\fileupload4.exe");   // upload image using AutoIT
        webDriver.findElement(By.id("chkLogin")).click();  //        // click on "Create Login Details" checkbox
        webDriver.findElement(By.id("user_name")).sendKeys("Lha01");  // Enter UN
        webDriver.findElement(By.id("user_password")).sendKeys("mer1");  // Enter PW
        webDriver.findElement(By.id("re_password")).sendKeys("mer1");  // Enter Confirm PW
        webDriver.findElement(By.id("status")).sendKeys("Enabled");  // Select enabled status from dropdown
        webDriver.findElement(By.id("btnSave")).click();  // Click on Save Button

        webDriver.findElement(By.id("welcome")).click();      // move it into welcome admin tab before logout
        webDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //webDriver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a")).click();
        webDriver.findElement(By.id("welcome-menu")).click();    // click on Logout button
    }
}
