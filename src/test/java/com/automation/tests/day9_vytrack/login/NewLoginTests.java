package com.automation.tests.day9_vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.day9_vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void verifyTitle(){

        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard","Page Title mismatch");

    }

    /**
     * Enter wrong credentials and verify warning message
     *
     */

    @Test
    public void verifyWarningMessage(){

        loginPage.login("wrong","password");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");

    }
}
