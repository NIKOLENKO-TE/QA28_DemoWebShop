package com.ait.phonebooks.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {
     @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        fillLoginRegisterForm("admin@gmail.com", "Qwertyuiop$1");
        clickOnLoginButton();
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
    }

    @Test
    public void removeContactPositiveTest() {
//Get size of contact before remove
        int sizeBefore = sizeOfContacts();
//click on Contact card
        click(By.cssSelector(".contact-item_card__2SOIM"));
//click on Remove button
        click(By.xpath("//button[.='Remove']"));
//get size of contacts after remove
        pause(1000);
        int sizeAfter = sizeOfContacts();
//assert: Contact is removed by Size
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}
