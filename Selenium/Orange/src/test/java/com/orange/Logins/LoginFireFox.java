package com.orange.Logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by PS2 on 18-Sep-17.
 */
public class LoginFireFox {

    @Test
    public void TestLoginWithValidCredentials(){

        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://opensource.demo.orangehrmlive.com/");
        webDriver.manage().window().maximize();  // maximize the window size (this is not really required)
        webDriver.findElement(By.name("txtUsername")).sendKeys("Admin");
        webDriver.findElement(By.id("txtPassword")).sendKeys("admin");
        webDriver.findElement(By.name("Submit")).click();
        webDriver.close();
    }

    @Test
    public void TestLoginWithInvalidCredentials1(){
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://opensource.demo.orangehrmlive.com/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.id("txtUsername")).sendKeys("");
        webDriver.findElement(By.id("txtPassword")).sendKeys("");
        webDriver.findElement(By.id("btnLogin")).click();
        webDriver.close();
    }

    @Test
    public void TestLoginWithInvalidCredentials2(){
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://opensource.demo.orangehrmlive.com/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.name("txtUsername")).sendKeys("Admin");
        webDriver.findElement(By.name("txtPassword")).sendKeys("");
        webDriver.findElement(By.name("Submit")).click();
        webDriver.close();
    }

    @Test
    public void TestLoginWithInvalidCredentials3(){
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://opensource.demo.orangehrmlive.com/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.name("txtUsername")).sendKeys("");
        webDriver.findElement(By.name("txtPassword")).sendKeys("admin");
        webDriver.findElement(By.name("Submit")).click();
        webDriver.close();
    }

    @Test
    public void TestLoginWithInvalidCredentials4(){
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://opensource.demo.orangehrmlive.com/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.name("txtUsername")).sendKeys("Admin");
        webDriver.findElement(By.name("txtPassword")).sendKeys("admin1");
        webDriver.findElement(By.name("Submit")).click();
        webDriver.close();
    }

    @Test
    public void TestLoginWithInvalidCredentials5(){
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://opensource.demo.orangehrmlive.com/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.name("txtUsername")).sendKeys("Admin");
        webDriver.findElement(By.name("txtPassword")).sendKeys("admin1");
        webDriver.findElement(By.name("Submit")).click();
        webDriver.close();
    }

    @Test
    public void TestLoginWithInvalidCredentials6(){
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://opensource.demo.orangehrmlive.com/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.name("txtUsername")).sendKeys("Admin1");
        webDriver.findElement(By.name("txtPassword")).sendKeys("admin1");
        webDriver.findElement(By.name("Submit")).click();
        webDriver.close();
    }
}
