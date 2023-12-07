package com.ait.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartHelperDWS extends BaseHelperDWS {
    private String h1NameOfProductToCart;

    public void rememberProductNameToCart() {
        h1NameOfProductToCart = driver.findElement(By.tagName("h1")).getText();
    }

    public boolean isProductNameIsMatching() {
        WebElement productElement = driver.findElement(By.xpath("//a[@class='product-name']"));
        String actualProductText = productElement.getText();
        String expectedProductText = h1NameOfProductToCart;
        return actualProductText.contains(expectedProductText);
    }

    public CartHelperDWS(WebDriver driver) {
        super(driver);
    }

    public void clickOnGiftCardProduct() {
        driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-3 div.page.home-page div.page-body div.product-grid.home-page-product-grid:nth-child(4) div.item-box:nth-child(2) div.product-item > div.picture")).click();
        System.out.println("элемент ПОДАРОЧНАЯ КАРТА найден");
    }

}
