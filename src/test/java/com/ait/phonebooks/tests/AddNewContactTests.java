package com.ait.phonebooks.tests;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddNewContactTests extends TestBase {
    @BeforeClass
    public void beforeClass(){
        System.out.println("*******Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("*******After Class");
    }
@BeforeMethod
    public void ensurePrecondition() {
    System.out.println("***********Before Method");
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
                .setEmail("admidnsdskgvjb@gmail.com")
                .setAddress("Varienstrasse 10").setDescription("Description of input KarlName"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreatedByText("KarlName"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }
}
