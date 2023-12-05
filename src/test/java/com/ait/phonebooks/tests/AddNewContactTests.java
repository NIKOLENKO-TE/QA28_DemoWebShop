package com.ait.phonebooks.tests;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.models.User;
import com.ait.phonebook.utils.ContactData;
import com.ait.phonebook.utils.DataProviders;
import com.ait.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddNewContactTests extends TestBase {
    @BeforeClass
    public void beforeClass() {
        System.out.println("*******Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("*******After Class");
    }

    @BeforeMethod
    public void ensurePrecondition() {
        System.out.println("***********Before Method");
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addNewContactPositiveTest(Contact contact) {
        app.getContact().clickOnAddLink();
        logger.info("Test run with data: " + contact);
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastName(ContactData.LASTNAME)
                .setPhoneNumber(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreatedByText(ContactData.NAME));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addNewContactFromDataProviderPositiveTest(String name, String lastName, String phone, String email, String address, String description) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastName(lastName)
                .setPhoneNumber(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        app.getContact().clickOnSaveButton();
    }

    @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviders.class)
    public void addNewContactFromDataProviderCSVPositiveTest(Contact contact){
        logger.info("Test run with dta: " + contact.toString());
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreatedByText(contact.getName()));
        Assert.assertTrue(app.getContact().isContactCreatedByText(contact.getPhoneNumber()));
    }
}
