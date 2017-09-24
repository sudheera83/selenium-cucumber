package com.orange.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

/**
 * Created by PS2 on 18-Sep-17.
 */
public class OpenIE {

    @Test
    public void TestOpenIE(){

        System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();
        webDriver.get("http://opensource.demo.orangehrmlive.com/");
        webDriver.close();
    }
}
