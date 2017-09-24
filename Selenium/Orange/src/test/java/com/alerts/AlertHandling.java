package com.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by PS2 on 20-Sep-17.
 */
public class AlertHandling {
    public static final String URL = "https://the-internet.herokuapp.com/javascript_alerts";
    WebDriver webDriverAlert;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        webDriverAlert = new ChromeDriver();
        webDriverAlert.get(URL);
        webDriverAlert.manage().window().maximize();
    }

    @AfterClass
    public void afterClass(){
     //   webDriverAlert.close();   // close the browser
    }

    @Test
    public void TestAlertHandling(){
        webDriverAlert.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();  // click on "Click for JS Alert" button
        //webDriverAlert.findElement(By.id(""))

        Alert newAlert = webDriverAlert.switchTo().alert();   // move to the Alert message as we dont have source of it
        String alertText = newAlert.getText();
        System.out.println("I am a JS Alert" + alertText);
        Assert.assertEquals(alertText, "I am a JS Alert");
        newAlert.accept();
    }


    @Test
    public void TestConfirmationHandlingOK(){
        webDriverAlert.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();  // click on "Click for JS Alert" button

        Alert newAlert = webDriverAlert.switchTo().alert();   // move to the Alert message as we dont have source of it
        String alertText = newAlert.getText();
        System.out.println("I am a JS Confirm" + alertText);
        Assert.assertEquals(alertText, "I am a JS Confirm");
        newAlert.accept();

        Assert.assertEquals(webDriverAlert.findElement(By.id("result")).getText(), "You clicked: Ok");

    }

    @Test
    public void TestConfirmationHandlingCancel(){
        webDriverAlert.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();  // click on "Click for JS Confirm" button

        Alert newAlert = webDriverAlert.switchTo().alert();   // move to the Alert message as we dont have source of it
        String alertText = newAlert.getText();  // using this method retrieve the text from that perticuler alert
        System.out.println("I am a JS Confirm" + alertText);
        Assert.assertEquals(alertText, "I am a JS Confirm");
        newAlert.dismiss();

        Assert.assertEquals(webDriverAlert.findElement(By.id("result")).getText(), "You clicked: Cancel");

    }

    @Test
    public void TestPromptHandlingOK() throws InterruptedException {
        webDriverAlert.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();  // click on "Click for JS Prompt" button

        Alert newAlert = webDriverAlert.switchTo().alert();
        String alertText = newAlert.getText();
        System.out.println("I am a JS prompt" + alertText);
        Assert.assertEquals(alertText,"I am a JS prompt");
        newAlert.sendKeys("Prompt Accepted");
        Thread.sleep(4000);
        newAlert.accept();

        Assert.assertEquals(webDriverAlert.findElement(By.id("result")).getText(),"You entered: Prompt Accepted");
    }

    @Test
    public void TestPromptHandlingCancel() throws InterruptedException {
        webDriverAlert.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert newAlert = webDriverAlert.switchTo().alert();
        String alertText = newAlert.getText();
        System.out.println("I am a JS prompt" + alertText);
        Assert.assertEquals(alertText, "I am a JS prompt");
        newAlert.sendKeys("Prompt Cancelled");
        Thread.sleep(4000);
        newAlert.dismiss();

        Assert.assertEquals(webDriverAlert.findElement(By.id("result")).getText(),"You entered: null");
    }
}
