package com.orange.AddLeaves;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by PS2 on 20-Sep-17.
 */
public class AddLeaves {
    public static final String BASE_URL = ("http://opensource.demo.orangehrmlive.com/");  //
    WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(BASE_URL);
        webDriver.manage().window().maximize();
        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");
        webDriver.findElement(By.id("txtPassword")).sendKeys("admin");
        webDriver.findElement(By.id("btnLogin")).click();
    }

    @AfterClass
    public void afterClass(){
        //webDriver.close();   //
    }

    @Test
    public void AddLeaves1(){
        webDriver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        webDriver.findElement(By.id("menu_leave_assignLeave")).click();
        webDriver.findElement(By.id("assignleave_txtEmployee_empName")).sendKeys("John Smith");
        webDriver.findElement(By.id("assignleave_txtLeaveType")).click();
        Select dropdownvalue2 = new Select(webDriver.findElement(By.id("assignleave_txtLeaveType")));
        dropdownvalue2.selectByIndex(4);
        webDriver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);  // wait to see the TC as it run very fast
        webDriver.findElement(By.id("leaveBalance_details_link")).click();
        webDriver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);   // wait to see the TC as it run very fast
        webDriver.findElement(By.id("closeButton")).click();

        webDriver.findElement(By.id("assignleave_txtFromDate")).click();  // click on From Date* calender entry
        Select dropdown1 = new Select(webDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"))); // Select Month value using Xpath
        dropdown1.selectByIndex(9); // month value
        Select dropdown2 = new Select(webDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]"))); // select year value using XPath
        dropdown2.selectByValue("2016");  // year value
        webDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[5]/a")).click(); //select date using XPath
        webDriver.findElement(By.id("assignleave_txtFromDate")).click(); // application running very fast.so add extar click to see clearly.

        webDriver.findElement(By.id("assignleave_txtToDate")).click();  // click on To Date* calender entry
        Select dropdown3 = new Select(webDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"))); // Select Month value using Xpath
        dropdown3.selectByValue("9"); // month value
        Select dropdown4 = new Select(webDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]"))); // select Year value using Xpath
        dropdown4.selectByValue("2017");  // year value
        webDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[6]/a")).click();  // select Day using XPath
        //webDriver.findElement(By.id("assignleave_txtToDate")).click();

        //webDriver.findElement(By.id("assignleave_partialDays")).click();
        Select dropdown5 = new Select(webDriver.findElement(By.id("assignleave_partialDays")));  // call value for partial days field
        dropdown5.selectByValue("all");
        //webDriver.findElement(By.id("assignleave_partialDays")).click();

        Select dropdown6 = new Select(webDriver.findElement(By.id("assignleave_firstDuration_duration")));  // call value for Duration field
        dropdown6.selectByValue("specify_time");
        Select dropdown7 = new Select(webDriver.findElement(By.id("assignleave_firstDuration_time_from"))); // enter from time
        dropdown7.selectByValue("08:30"); // enter from value
        Select dropdown8 = new Select(webDriver.findElement(By.id("assignleave_firstDuration_time_to")));  // Enter to time
        dropdown8.selectByValue("17:30");  // enter to value

        webDriver.findElement(By.id("assignleave_txtComment")).sendKeys("Leave Required");  // Enter text
        //webDriver.findElement(By.id("assignBtn")).click();   // click on "Assign" button
        webDriver.findElement(By.xpath("//*[@id=\"assignBtn\"]")).click();
        webDriver.manage().timeouts().implicitlyWait(6000,TimeUnit.SECONDS);

        //webDriver.findElement(By.id("confirmOkButton")).click();
    }
}

