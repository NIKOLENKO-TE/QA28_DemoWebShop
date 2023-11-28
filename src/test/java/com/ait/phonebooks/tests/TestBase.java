package com.ait.phonebooks.tests;

import com.ait.phonebook.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.*;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    @BeforeSuite
    public void setUp() {
        System.out.println("Before Suite!");
        app.init();
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("***Before Test!");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("***After Test!");
    }

    @AfterSuite
            (enabled = false)
    public void tearDown() {
        System.out.println("After Suite!");
        app.stop();
    }

}
