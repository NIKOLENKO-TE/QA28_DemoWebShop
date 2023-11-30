package com.ait.demowebshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManagerDWS  {
    WebDriver driver;
    UserHelperDWS user;
    CartHelperDWS cart;
    HomePageHelperDWS homePage;
    String browser;
    public ApplicationManagerDWS (String browser) {
        this.browser = browser;
    }
    public void init() {
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
    }
}
