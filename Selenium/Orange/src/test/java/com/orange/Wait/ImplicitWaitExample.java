package com.orange.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by PS2 on 21-Sep-17.
 */
public class ImplicitWaitExample {

    private WebDriver webDriver;
    String URL = "https://the-internet.herokuapp.com/dynamic_loading/2";   // defined URL

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");     // set the browser path. for this case it's Firefox
        webDriver = new FirefoxDriver();                                              // set new Firefox Browser
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);           // set the times using seconds though java method.

    }

    @AfterClass
    public void afterClass(){
        // webDriver.close();              // close the wen browser
    }

    @Test
    public void TestImplicitWait(){
        webDriver.get(URL);
        // webDriver.manage().window().maximize();
        //webDriver.findElement(By.xpath("//button[@text='Start']")).click();
        webDriver.findElement(By.xpath("//*[@id='start']/button")).click();
        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish"))); // element id is finish
        //element.getText();
        Assert.assertEquals(element.getText(),"Hello World!");
    }
}
