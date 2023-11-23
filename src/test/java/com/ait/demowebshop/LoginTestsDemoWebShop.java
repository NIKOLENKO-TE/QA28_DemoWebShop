package com.ait.demowebshop;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestsDemoWebShop extends TestBaseDemoWebShop{
    @BeforeMethod
    public void ensurePrecondition() {
        ensureLogOut();
    }
    @Test(testName = "Login existing user with positive data")
    public void loginRegisteredUserPositiveTest() {
        clickLogInLink();
        fillEmail("admfix727sbnfbdfb@gmail.com");
        fillPassword("Adminbbsbfbdfb@gmail.com");
        clickLogInButton();
        Assert.assertTrue(isLogOutButtonIsPresent());
    }
}
