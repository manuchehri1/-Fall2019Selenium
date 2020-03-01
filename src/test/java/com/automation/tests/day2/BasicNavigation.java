package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {
        // to start selenium script we need
        // setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // In selenium, everything stars from WebDriver interface
        driver.get("http://google.com"); //to open the google website

        Thread.sleep(3000); // for demo, wait 3 seconds

        String title = driver.getTitle(); // returns <title>some title</title>
        String expectedTitle = "Google";

        System.out.println("The title is : "+title);

        if (expectedTitle.equals(title)){
            System.out.println("TEST PASSED!");
        }else {
            System.out.println("TEST FAILED!");
        }

        driver.close(); // to close the website





    }
}
