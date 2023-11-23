package com.ait.phonebooks.tests;

import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void registerExistedUserNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("admin@gmail.com")
                .setPassword("Qwertyuiop$1"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}

