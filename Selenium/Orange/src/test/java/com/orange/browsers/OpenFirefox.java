package com.orange.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by PS2 on 18-Sep-17.
 */
public class OpenFirefox {

    @Test
    public void TestOpenFirefox(){

        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://opensource.demo.orangehrmlive.com/");
        //webDriver.close();
    }
}
