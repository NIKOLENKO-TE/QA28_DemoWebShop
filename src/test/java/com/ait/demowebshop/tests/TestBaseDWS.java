package com.ait.demowebshop.tests;

import com.ait.demowebshop.fw.ApplicationManagerDWS;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.*;

public class TestBaseDWS {

    protected static ApplicationManagerDWS app = new ApplicationManagerDWS(System
            .getProperty("browser", Browser.CHROME.browserName()));

    @BeforeSuite
    public void setUp() {
        app.init();
        System.out.println("Before Suite!");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("*****Before Test!");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("*****After Test!");
    }

    // @AfterMethod(enabled = true)
    @AfterSuite
    public void tearDown() {
        app.stop();
        System.out.println("After Suite!");
    }

}
