package com.orange.AddVacancies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by PS2 on 20-Sep-17.
 */
public class AddVacancies {
    public static final String BASE_URL = ("http://opensource.demo.orangehrmlive.com/");  //
    WebDriver webDriver;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
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
    public void AddVacancy1(){
        webDriver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
        webDriver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
        webDriver.findElement(By.id("btnAdd")).click();
        webDriver.findElement(By.id("addJobVacancy_jobTitle")).click();
        Select dropdownvalue1 = new Select(webDriver.findElement(By.id("addJobVacancy_jobTitle")));  // select dropdown
        dropdownvalue1.selectByIndex(6);         // select dropdown value
        webDriver.findElement(By.id("addJobVacancy_name")).sendKeys("Administrator");  // Enter vacancy name
        webDriver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("John Smith");
        webDriver.findElement(By.id("addJobVacancy_noOfPositions")).sendKeys("1");
        webDriver.findElement(By.id("addJobVacancy_description")).sendKeys("New IT Admin");
        webDriver.findElement(By.xpath("//*[@id=\"addJobVacancy_status\"]")).click();
        //webDriver.findElement(By.xpath("//*[@id=\"addJobVacancy_status\"]")).click();
        webDriver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        WebElement elt = webDriver.findElement(By.xpath("//*[@id=\"addJobVacancy_status\"]"));
        if(elt.isSelected()){
            //System.out.println("no");
        }
        else {
            elt.click();

        webDriver.findElement(By.id("btnSave")).click();
        }
    }
}
