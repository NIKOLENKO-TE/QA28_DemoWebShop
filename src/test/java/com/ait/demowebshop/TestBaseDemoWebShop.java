package com.ait.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBaseDemoWebShop {
    WebDriver driver;
    private String h1NameOfProductToCart;

    @BeforeMethod
    public void setUp() {
        chromeDriverSetUpDemoWebShop();
    }

    public void chromeDriverSetUpDemoWebShop() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.cssSelector("div:nth-child(2)>div>div>h1")).size()>0;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public void clickRegistrationButton() {
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

    public void clickPassword() {
        driver.findElement(By.name("Password")).click();
    }

    public void fillEmail(String email) {
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys(email);
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

    public void clickRegisterLink() {
        driver.findElement(By.cssSelector("[href='/register']")).click();
    }

    public void ensureLogOut() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            clickSignOut();
        }
    }

    public void clickSignOut() {
        driver.findElement(By.xpath("//button[.='Log out']")).click();
    }

    public WebElement checkErrorMessageEmailAlreadyExist() {
        WebElement errorMessage = driver.findElement(By.xpath("//li[text()='The specified email already exists']"));
        return errorMessage;
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

    public void clickOnFirstProduct() {
        //driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']//div[@class='item-box'][1]")).click();
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

    public void rememberProductNameToCart() {
        h1NameOfProductToCart = driver.findElement(By.tagName("h1")).getText();
    }

    public boolean isProductNameIsMatching() {
        WebElement productElement = driver.findElement(By.xpath("//a[@class='product-name']"));
        String actualProductText = productElement.getText();
        String expectedProductText = h1NameOfProductToCart;
        return actualProductText.contains(expectedProductText);
    }
}
