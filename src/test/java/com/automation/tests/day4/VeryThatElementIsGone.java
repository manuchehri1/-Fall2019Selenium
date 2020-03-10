package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VeryThatElementIsGone {
    public static void main(String[] args)throws Exception {

        /**
         * Interview Question?
         * how to check if element doesn't exists any more DOM (Document Object Model)?
         *
         *
         */


        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        if (driver.findElements(By.id("disappearing_button")).size()==0){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        Thread.sleep(2000);



        for (String arg : args) {

        }

        driver.quit();

    }

}
