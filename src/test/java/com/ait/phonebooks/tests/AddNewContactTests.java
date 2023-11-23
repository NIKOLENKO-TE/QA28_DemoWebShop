package com.ait.phonebooks.tests;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("admin@gmail.com").setPassword("Qwertyuiop$1"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addNewContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("KarlName")
                .setLastName("KarlLastName")
                .setPhoneNumber("1234567890")
                .setEmail("admindskgvjb@gmail.com")
                .setAddress("Varienstrasse 10").setDescription("Description of input KarlName"));
        app.getContact().clickOnSaveButton();
//assert contact added by text
        Assert.assertTrue(app.getContact().isContactCreatedByText("KarlName"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }
}
