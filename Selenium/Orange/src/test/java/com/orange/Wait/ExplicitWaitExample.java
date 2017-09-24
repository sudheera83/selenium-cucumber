package com.orange.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * Created by PS2 on 21-Sep-17.
 */
public class ExplicitWaitExample {
    private WebDriver webDriver;
    String URL = "https://the-internet.herokuapp.com/dynamic_loading/2";   // defined URL

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");     // set the browser path. for this case it's Firefox
        webDriver = new FirefoxDriver();                                              // set new Firefox Browser
    }

    @AfterClass
    public void afterClass(){
        // webDriver.close();              // close the wen browser
    }
    public void TestExplicitWait(){
        webDriver.get(URL);
        webDriver.findElement(By.id("//*[@id='start']/button")).click();

        WebDriverWait webdriverWait = new WebDriverWait(webDriver, 10);


    }

}
