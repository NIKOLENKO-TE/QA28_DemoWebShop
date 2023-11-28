package com.ait.demowebshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManagerDWS  {
    WebDriver driver;
    UserHelperDWS user;
    CartHelperDWS cart;
    HomePageHelperDWS homePage;

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
