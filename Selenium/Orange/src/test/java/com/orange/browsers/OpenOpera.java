package com.orange.browsers;

import jdk.nashorn.internal.runtime.options.Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

/**
 * Created by PS2 on 18-Sep-17.
 */
public class OpenOpera {

    @Test
    public void TestOpenOpera(){
        String OperaChromiumDriver = "drivers/operadriver_win64/operadriver.exe";  // opera Driver Location
        String OperaBrowserLocation = "C:\\Program Files\\Opera\\launcher.exe";    // Opera Browser Location in your machine

        System.setProperty("webdriver.opera.driver", OperaChromiumDriver);

        ChromeOptions options = new ChromeOptions();
        options.setBinary(OperaBrowserLocation);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        OperaDriver browser = new OperaDriver(capabilities);

        WebDriver driver = browser;
        driver.get("http://opensource.demo.orangehrmlive.com/");

    }
}
