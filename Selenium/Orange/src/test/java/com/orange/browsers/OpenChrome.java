package com.orange.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by PS2 on 18-Sep-17.
 */
public class OpenChrome {

    @Test
    public void TestOpenChrome(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://opensource.demo.orangehrmlive.com/");
       // webDriver.close();
    }
}
