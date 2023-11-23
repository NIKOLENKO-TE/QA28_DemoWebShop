package com.ait.demowebshop;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTestsDemoWebShop extends TestBaseDemoWebShop{
    @BeforeMethod
    public void ensurePrecondition() {
        ensureLogOut();
    }
    @Test(testName = "Add product to cart using existing user with positive data")
    public void addToCartRegisteredUserPositiveTest() {
        //TODO [ Вы говорили, что тесты должны быть автономными. Но можно ли использовать уже имеющийся тест проверки логина из другого класса в этом тесте? ]
        clickLogInLink();
        fillEmail("admfix727sbnfbdfb@gmail.com");
        fillPassword("Adminbbsbfbdfb@gmail.com");
        clickLogInButton();
        clickToMainPage();
        clickOnFirstProduct();
        clickOnRecipientsName();
        fillRecipientName("Steve Jobs");
        clickOnRecipientEmail();
        fillRecipientEmail("stevejobs@icloud.com");
        clickAddToCartButton();
        rememberProductNameToCart();
        clickShoppingCartLink();
        isProductNameIsMatching();
        Assert.assertTrue(isProductNameIsMatching(), "Product in cart does not match expected");
    }


}
