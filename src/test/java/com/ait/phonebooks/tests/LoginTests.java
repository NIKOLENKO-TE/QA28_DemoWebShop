package com.ait.phonebooks.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        clickOnLoginLink();
        fillLoginRegisterForm("admin@gmail.com", "Qwertyuiop$1");
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }
}
