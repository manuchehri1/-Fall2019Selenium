package com.automation.tests.day9_vytrack.fleet;

import com.automation.pages.Fleet.VehiclesPage;
import com.automation.pages.LoginPage;
import com.automation.tests.day9_vytrack.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewVehiclesPageTests extends AbstractTestBase {

    @Test
    public void verifyTitle(){
        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();

        loginPage.login();
        vehiclesPage.navigateTo("Fleet","Vehicles");

        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

    }

}
