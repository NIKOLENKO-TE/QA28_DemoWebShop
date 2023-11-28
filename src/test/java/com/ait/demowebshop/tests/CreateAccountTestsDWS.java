package com.ait.demowebshop.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTestsDWS extends TestBaseDWS {
    @BeforeMethod
    public void ensurePrecondition() {
        app.getUser().ensureLogOut();
        app.init();
    }

    @Test(testName = "Register a new user with positive data")
    public void registerNewUserPositiveTest() {
        app.getUser().clickOnRegisterLink();
        fillRegisterNewUserForm(new User().setFirstName("Tymofii").setLastName("Nikolenko").setEmail("adfzdmfix727sbnfbdfb@gmail.com").setPassword("Adminbbsbfbdfb@gmail.com"));
        app.getUser().clickOnRegistrationButton();
    }

    @Test(testName = "Register an existing user")
    public void registerExistedUserNegativeTest() {
        app.getUser().clickOnRegisterLink();
        fillRegisterNewUserForm(new User().setFirstName("Tymofii").setLastName("Nikolenko").setEmail("admfix727sbnfbdfb@gmail.com").setPassword("Adminbbsbfbdfb@gmail.com"));
        app.getUser().clickOnRegistrationButton();
        WebElement errorMessage = app.getUser().checkErrorMessageEmailAlreadyExist();
        Assert.assertTrue(errorMessage.isDisplayed());
    }

}