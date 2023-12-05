package com.ait.demowebshop.tests;

import com.ait.demowebshop.fw.ApplicationManagerDWS;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBaseDWS {

    protected static ApplicationManagerDWS app = new ApplicationManagerDWS(System
            .getProperty("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBaseDWS.class);
    @BeforeMethod
    public void  startTest(Method method, Object[] p) {
        logger.info("Start Test " + method.getName() + " with data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void  stopTest(ITestResult result) {
        if(result.isSuccess()){
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: " + result.getMethod().getMethodName());
        }
        logger.info("===========================================");
    }

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
