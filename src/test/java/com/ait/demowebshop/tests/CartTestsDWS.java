package com.ait.demowebshop.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTestsDWS extends TestBaseDWS {

    @BeforeMethod
    public void ensurePrecondition() {
        app.init();
        loginExistedUserPositiveData();
        app.getHomePage().clickOnHomeLink();
    }

    @Test(testName = "Add product to cart using existing user with negative data")
    public void addToCartRegisteredUserNegativeTest() {
        app.getCart().clickOnGiftCardProduct();
        app.getUser().clickOnRecipientsName();
        app.getUser().fillRecipientName("Steve");
        app.getUser().clickOnRecipientEmail();
        app.getUser().fillRecipientEmail("Jobs");
        app.getUser().clickAddToCartButton();
        Assert.assertTrue(app.getUser().isBarNotificationPresent());
    }

    @Test(testName = "Add product to cart using existing user with positive data")
    public void addToCartRegisteredUserPositiveTest() {
        app.getCart().clickOnGiftCardProduct();
        app.getUser().clickOnRecipientsName();
        app.getUser().fillRecipientName("Steve");
        app.getUser().clickOnRecipientEmail();
        app.getUser().fillRecipientEmail("Jobs");
        app.getUser().clickAddToCartButton();
        app.getCart().rememberProductNameToCart();
        app.getUser().clickShoppingCartLink();
        app.getCart().isProductNameIsMatching();
        Assert.assertTrue(app.getCart().isProductNameIsMatching());
    }
}
