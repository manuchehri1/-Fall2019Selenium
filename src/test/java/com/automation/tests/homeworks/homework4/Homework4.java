package com.automation.tests.homeworks.homework4;

import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Homework4 {
private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    /*
    *   1. go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
        2. Randomly select a checkbox. As soon as you check any day, print the name of the day
        and uncheck immediately.
        After you check and uncheck Friday for the third time, exit the program.
        NOTE: Remember some checkboxes are not selectable. You need to find a way to ignore them
        when they are randomly selected. It has to be dynamic. Do not hard code Saturday and Sunday.
        Use values of certain attributes.
    *
    *
    * */

    @Test(description = "checkbox verifying")
    public void days (){
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        List<WebElement> checkbox = driver.findElements(By.cssSelector("[type='checkbox']"));
        List<WebElement> lst2 = driver.findElements(By.tagName("label"));


        Random rnd = new Random(lst2.size());
        int fridayCount = 0;

       while (fridayCount<3){
           int index = rnd.nextInt(checkbox.size());
           if (checkbox.get(index).isEnabled()){
               checkbox.get(index).click();
               if (lst2.get(index).getText().equals("Friday")){
                   fridayCount++;
               }
               System.out.println(lst2.get(index).getText());
               checkbox.get(index).click();
           }

       }
    }


    /*  1. go to http://practice.cybertekschool.com/dropdown
        2. verify that dropdowns under Select your date of birth display current year, month, day
    */
    @Test
    public void todays_date(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select year = new Select(driver.findElement(By.id("year")));
        Select month = new Select(driver.findElement(By.id("month")));
        Select day = new Select(driver.findElement(By.id("day")));

        String y = year.getFirstSelectedOption().getText();
        String m = month.getFirstSelectedOption().getText();
        String d = day.getFirstSelectedOption().getText();


        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMMMdd");
        Date date = new Date();
        String expected = formatter.format(date);
        Assert.assertEquals(y+m+d,expected);
    }

    /*1. go to http://practice.cybertekschool.com/dropdown
    2. select a random year under Select your date of birth
    3. select month January
    4. verify that days dropdown has current number of days
    5. repeat steps 3, 4 for all the months
    NOTE: if you randomly select a leap year, verify February has 29 days
    * */

    @Test
    public void years_months_days(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select year = new Select(driver.findElement(By.id("year")));
        Select month = new Select(driver.findElement(By.id("month")));
        Select day = new Select(driver.findElement(By.id("day")));

        String y = year.getFirstSelectedOption().getText();
        String m = month.getFirstSelectedOption().getText();
        String d = day.getFirstSelectedOption().getText();

        Random random = new Random();
        int index = random.nextInt(year.getOptions().size());
        year.selectByIndex(index);




    }


}
