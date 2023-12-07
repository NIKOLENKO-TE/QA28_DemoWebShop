package com.ait.demowebshop.tests;

import com.ait.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestsDWS extends TestBaseDWS {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHomePage().isHomeLinkPresent()){
            app.getHomePage().clickOnHomeLink();
        }
            app.getUser().clickLogInLink();
    }

    @Test(testName = "Login existing user with positive data")
    public void loginRegisteredUserPositiveTest() {
        app.getUser().fillEmailPassword(new User()
                .setEmail("admfix727sbnfbdfb@gmail.com")
                .setPassword("Adminbbsbfbdfb@gmail.com"));
        app.getUser().clickLogInButton();
        Assert.assertTrue(app.getUser().isLogOutButtonIsPresent());
    }

    @Test
    public void loginRegisteredUserNegativeTestWithoutEmail() {
        app.getUser().fillEmailPassword(new User().setPassword("Qwertyuiop$1"));
        app.getUser().clickLogInButton();
        Assert.assertTrue(app.getUser().isErrorLoginPresent());
    }
}
