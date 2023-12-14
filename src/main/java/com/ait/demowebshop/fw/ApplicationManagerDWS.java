package com.ait.demowebshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class ApplicationManagerDWS {
    WebDriver driver;
    UserHelperDWS user;
    CartHelperDWS cart;
    HomePageHelperDWS homePage;
    String browser;

    public ApplicationManagerDWS(String browser) {
        this.browser = browser;
    }

    private String chromedriverProcessId;

    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.get("https://demowebshop.tricentis.com/");
        user = new UserHelperDWS(driver);
        cart = new CartHelperDWS(driver);
        homePage = new HomePageHelperDWS(driver);
    }

    public UserHelperDWS getUser() {
        return user;
    }

    public CartHelperDWS getCart() {
        return cart;
    }

    public HomePageHelperDWS getHomePage() {
        return homePage;
    }

    public void stop() {
        driver.quit();
        // Завершаем только процесс chromedriver.exe
        if (chromedriverProcessId != null) {
            killProcess(chromedriverProcessId);
        }
    }

    private void killProcess(String processId) {
        try {
            Runtime.getRuntime().exec("taskkill /F /PID " + processId); // taskkill /F /IM chromedriver.exe /T
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}