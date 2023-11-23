package com.ait.phonebooks.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test
    public void registerExistedUserNegativeTest() {
        clickOnLoginLink();
        fillLoginRegisterForm("admin@gmail.com", "Qwertyuiop$1");
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertPresent());
    }
}

