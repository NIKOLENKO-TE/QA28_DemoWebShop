package com.ait.phonebooks.tests;

import com.ait.phonebook.fw.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase{
    WebDriver driver;
    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.init();
    }



    @AfterMethod(enabled = true)
    public void tearDown() {
        app.stop();
    }

}
