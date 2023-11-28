package com.ait.demowebshop.tests;

import com.ait.demowebshop.fw.ApplicationManagerDWS;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseDWS {


    public static ApplicationManagerDWS app = new ApplicationManagerDWS();

    public static void fillRegisterNewUserForm(User user) {
        app.getUser().chooseMaleGender();
        app.getUser().clickFirstNameRegistration();
        app.getUser().fillFirstName(user.getFirstName());
        app.getUser().clickLastName();
        app.getUser().fillLastName(user.getLastName());
        app.getUser().clickEmail();
        app.getUser().fillEmail(user.getEmail());
        app.getUser().clickPassword();
        app.getUser().fillPassword(user.getPassword());
        app.getUser().clickConfirmPassword();
        app.getUser().fillConfirmPassword(user.getPassword());
    }

    @BeforeMethod
    public void setUp() {
        app.init();
    }


    @AfterMethod(enabled = false)
    public void tearDown() {
       app.stop();
    }

}
