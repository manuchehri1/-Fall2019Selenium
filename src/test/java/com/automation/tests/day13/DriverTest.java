package com.automation.tests.day13;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DriverTest {




    @Test
    public void googleTest(){

        Driver.getDriver().get("http://google.com");

        Assert.assertEquals(Driver.getDriver().getTitle(),"Google");
        Driver.closeDriver();
    }
}
