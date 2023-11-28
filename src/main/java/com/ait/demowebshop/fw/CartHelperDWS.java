package com.ait.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartHelperDWS extends BaseHelperDWS {
    private String h1NameOfProductToCart;

    public CartHelperDWS(WebDriver driver) {
        super(driver);
    }

    public void rememberProductNameToCart() {
        h1NameOfProductToCart = driver.findElement(By.tagName("h1")).getText();
    }

    public boolean isProductNameIsMatching() {
        WebElement productElement = driver.findElement(By.xpath("//a[@class='product-name']"));
        String actualProductText = productElement.getText();
        String expectedProductText = h1NameOfProductToCart;
        return actualProductText.contains(expectedProductText);
    }

    public void clickOnFirstProduct() {
        driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']//div[@class='item-box'][1]")).click();
    }
}
