package com.ait.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelperDWS extends BaseHelperDWS{
    public HomePageHelperDWS(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/']"));
    }
    public void clickOnHomeLink() {
        click(By.cssSelector("[href='/']"));
    }
}
