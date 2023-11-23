package com.ait.demowebshop;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTestsDemoWebShop extends TestBaseDemoWebShop {
    @BeforeMethod
    public void ensurePrecondition() {
        ensureLogOut();
    }

    @Test(testName = "Register a new user with positive data")
    public void registerNewUserPositiveTest() {
        clickRegisterLink();
        chooseMaleGender();
        clickFirstNameRegistration();
        fillFirstName("Tymofii");
        clickLastName();
        fillLastName("Nikolenko");
        clickEmail();
        fillEmail("admfix727sbnfbdfb@gmail.com");
        clickPassword();
        fillPassword("Adminbbsbfbdfb@gmail.com");
        clickConfirmPassword();
        fillConfirmPassword("Adminbbsbfbdfb@gmail.com");
        clickRegistrationButton();
    }

    @Test(testName = "Register an existing user")
    public void registerExistedUserNegativeTest() {
        clickRegisterLink();
        chooseMaleGender();
        clickFirstNameRegistration();
        fillFirstName("Tymofii");
        clickLastName();
        fillLastName("Nikolenko");
        clickEmail();
        fillEmail("admfix727sbnfbdfb@gmail.com");
        clickPassword();
        fillPassword("Adminbbsbfbdfb@gmail.com");
        clickConfirmPassword();
        fillConfirmPassword("Adminbbsbfbdfb@gmail.com");
        clickRegistrationButton();
        WebElement errorMessage = checkErrorMessageEmailAlreadyExist();
        Assert.assertTrue(errorMessage.isDisplayed());
    }

}