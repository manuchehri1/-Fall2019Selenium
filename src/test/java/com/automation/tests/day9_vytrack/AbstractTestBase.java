package com.automation.tests.day9_vytrack;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class AbstractTestBase {
    protected WebDriverWait wait;
    private Actions actions;
    protected WebDriver driver = Driver.getDriver();


    @BeforeMethod
     public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        driver.get(URL);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver,15);
        actions = new Actions(driver);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}

