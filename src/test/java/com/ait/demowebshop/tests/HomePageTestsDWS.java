package com.ait.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTestsDWS extends TestBaseDWS {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHomePage().isHomeLinkPresent()){
            app.getHomePage().clickOnHomeLink();
        }
    }

    @Test
    public void isHomeComponentPresentTest() {
        Assert.assertTrue(app.getHomePage().isHomeLinkPresent());
    }

}
