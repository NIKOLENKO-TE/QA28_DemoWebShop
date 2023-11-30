package com.ait.demowebshop.tests;
import com.ait.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTestsDWS extends TestBaseDWS {

    @BeforeMethod
    public void ensurePrecondition() {
        app.getUser().ensureLogOut();
        app.getUser().clickLogInLink();
        app.getUser().fillEmailPassword(new User()
                .setEmail("admfix727sbnfbdfb@gmail.com")
                .setPassword("Adminbbsbfbdfb@gmail.com"));
        app.getUser().clickLogInButton();
        app.getUser().clickToMainPage();
    }

    @Test(testName = "Add product to cart using existing user with positive data")
    public void addToCartRegisteredUserPositiveTest() {
        app.getCart().clickOnFirstProduct();
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
