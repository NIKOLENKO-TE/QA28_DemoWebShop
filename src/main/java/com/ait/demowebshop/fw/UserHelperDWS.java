package com.ait.demowebshop.fw;

import com.ait.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelperDWS extends BaseHelperDWS {

    public UserHelperDWS(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistrationButton() {
        driver.findElement(By.name("register-button")).click();
    }

    public void fillConfirmPassword(String confirmPassword) {
        driver.findElement(By.name("ConfirmPassword")).clear();
        driver.findElement(By.name("ConfirmPassword")).sendKeys(confirmPassword);
    }

    public void clickConfirmPassword() {
        driver.findElement(By.name("ConfirmPassword")).click();
    }


    public void fillPassword(String password) {
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys(password);
    }

    public void fillEmail(String email) {
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys(email);
    }

    public void clickPassword() {
        driver.findElement(By.name("Password")).click();
    }

    public void clickEmail() {
        driver.findElement(By.name("Email")).click();
    }

    public void fillLastName(String LastName) {
        driver.findElement(By.name("LastName")).clear();
        driver.findElement(By.name("LastName")).sendKeys(LastName);
    }

    public void clickLastName() {
        driver.findElement(By.name("LastName")).click();
    }

    public void fillFirstName(String FirstName) {
        driver.findElement(By.name("FirstName")).sendKeys(FirstName);
    }

    public void fillRecipientName(String RecipientName) {
        driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientName']")).sendKeys(RecipientName);
    }

    public void fillRecipientEmail(String RecipientEmail) {
        driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientEmail']")).sendKeys(RecipientEmail);
    }

    public void clickFirstNameRegistration() {
        driver.findElement(By.name("FirstName")).click();
        driver.findElement(By.name("FirstName")).clear();
    }

    public void chooseMaleGender() {
        WebElement maleCheckbox = driver.findElement(By.xpath("//input[@name='Gender' and @id='gender-male']"));
        if (!maleCheckbox.isSelected()) {
            maleCheckbox.click();
        }
    }

    public void clickOnRegisterLink() {
        driver.findElement(By.cssSelector("[href='/register']")).click();
    }

    public void clickSignOut() {
        driver.findElement(By.xpath("//button[.='Log out']")).click();
    }

    public void clickLogInLink() {
        driver.findElement(By.cssSelector("[href='/login']")).click();
    }

    public void clickLogInButton() {
        driver.findElement(By.cssSelector("[value='Log in']")).click();
    }

    public boolean isLogOutButtonIsPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public void clickToMainPage() {
        driver.findElement(By.cssSelector("[href='/']"));
    }

    public void clickOnRecipientEmail() {
        driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientEmail']")).click();
        driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientEmail']")).clear();
    }

    public void clickOnRecipientsName() {
        driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientName']")).click();
        driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientName']")).clear();
    }

    public void clickShoppingCartLink() {
        driver.findElement(By.cssSelector("[href='/cart']")).click();
    }

    public void clickAddToCartButton() {
        driver.findElement(By.xpath("//input[@id='add-to-cart-button-2']")).click();
    }
    public void ensureLogOut() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            clickSignOut();
        }
    }
    public WebElement checkErrorMessageEmailAlreadyExist() {
        WebElement errorMessage = driver.findElement(By.xpath("//li[text()='The specified email already exists']"));
        return errorMessage;
    }
    public void fillEmailPassword(User user) {
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
    }
//    public void fillLoginRegisterForm(User user) {
//        type(By.name("email"), user.getEmail());
//        type(By.name("password"), user.getPassword());
//    }
}
