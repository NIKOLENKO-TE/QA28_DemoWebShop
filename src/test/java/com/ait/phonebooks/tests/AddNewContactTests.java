package com.ait.phonebooks.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddNewContactTests extends TestBase {
    //precondition: User should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        fillLoginRegisterForm("admin@gmail.com", "Qwertyuiop$1");
        clickOnLoginButton();
    }
    @Test
    public void addNewContactPositiveTest(){
//click on Add Link
        click(By.cssSelector("[href='/add']"));
//enter name
        type(By.cssSelector("input:nth-child(1)"), "KarlName");
//enter lastname
        type(By.cssSelector("input:nth-child(2)"), "KarlLastName");
//enter phone
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
//enter email
        type(By.cssSelector("input:nth-child(4)"), "admindskgvjb@gmail.com");
//enter address
        type(By.cssSelector("input:nth-child(5)"), "Varienstrasse 10");
//enter description
        type(By.cssSelector("input:nth-child(6)"), "Description of input KarlName");
//click onSave button
        click(By.cssSelector(".add_form__2rsm2 button"));
//assert contact added by text
        Assert.assertTrue(isContactCreatedByText("KarlName"));
    }

    public boolean isContactCreatedByText(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element: contacts) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
}}
