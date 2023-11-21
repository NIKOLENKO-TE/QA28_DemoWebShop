package com.ait.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            driver.findElement(By.xpath("//button[.='Sign Out']")).click();
        }
    }
    @Test(testName = "Register a new user with positive data")
    public void registerNewUserPositiveTest() {
        //click on Login Link
        driver.findElement(By.cssSelector("[href='/register']")).click();
        // Select Gender - Male
        WebElement maleCheckbox = driver.findElement(By.xpath("//input[@name='Gender' and @id='gender-male']"));
        if (!maleCheckbox.isSelected()) {
            maleCheckbox.click();
        }
        //enter First name:
        driver.findElement(By.name("FirstName")).click();
        driver.findElement(By.name("FirstName")).clear();
        driver.findElement(By.name("FirstName")).sendKeys("Tymofii");
        //enter Last name:
        driver.findElement(By.name("LastName")).click();
        driver.findElement(By.name("LastName")).clear();
        driver.findElement(By.name("LastName")).sendKeys("Nikolenko");
        //enter Email:
        driver.findElement(By.name("Email")).click();
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys("admfix727sbnfbdfb@gmail.com");
        //enter Your Password
        //enter Password:
        driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys("Adminbbsbfbdfb@gmail.com");
        //enter Confirm password:
        driver.findElement(By.name("ConfirmPassword")).click();
        driver.findElement(By.name("ConfirmPassword")).clear();
        driver.findElement(By.name("ConfirmPassword")).sendKeys("Adminbbsbfbdfb@gmail.com");
        //click on Registration button
        driver.findElement(By.name("register-button")).click();
    }
    @Test(testName = "Register an existing user")
    public void registerExistedUserNegativeTest() {
        //click on Login Link
        driver.findElement(By.cssSelector("[href='/register']")).click();
        // Select Gender - Male
        WebElement maleCheckbox = driver.findElement(By.xpath("//input[@name='Gender' and @id='gender-male']"));
        if (!maleCheckbox.isSelected()) {
            maleCheckbox.click();
        }
        //enter First name:
        driver.findElement(By.name("FirstName")).click();
        driver.findElement(By.name("FirstName")).clear();
        driver.findElement(By.name("FirstName")).sendKeys("Tymofii");
        //enter Last name:
        driver.findElement(By.name("LastName")).click();
        driver.findElement(By.name("LastName")).clear();
        driver.findElement(By.name("LastName")).sendKeys("Nikolenko");
        //enter Email:
        driver.findElement(By.name("Email")).click();
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys("admfix727sbnfbdfb@gmail.com");
        //enter Your Password
        //enter Password:
        driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys("Adminbbsbfbdfb@gmail.com");
        //enter Confirm password:
        driver.findElement(By.name("ConfirmPassword")).click();
        driver.findElement(By.name("ConfirmPassword")).clear();
        driver.findElement(By.name("ConfirmPassword")).sendKeys("Adminbbsbfbdfb@gmail.com");
        //click on Registration button
        driver.findElement(By.name("register-button")).click();
        // Check for error message
        WebElement errorMessage = driver.findElement(By.xpath("//li[text()='The specified email already exists']"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }
}