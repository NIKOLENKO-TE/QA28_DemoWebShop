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

    public void init() {
//        if (browser.equalsIgnoreCase("chrome")){
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("firefox")){
//            driver = new FirefoxDriver();
//        }
//        driver.get("https://demowebshop.tricentis.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
//            options.addArguments("windows-size=1800*900");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.get("https://demowebshop.tricentis.com/");
        user = new UserHelperDWS(driver); // передали конструкторы в хелперы
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
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
