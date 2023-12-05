package com.ait.phonebooks.tests;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        app.getUser().fillLoginRegisterForm(new User().setEmail("admin@gmail.com").setPassword("Qwertyuiop$1"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addNewContactPositiveTest(Contact contact) {
        app.getContact().clickOnAddLink();
        logger.info("Test run with data: " + contact);
        app.getContact().fillContactForm(new Contact()
                .setName("KarlName")
                .setLastName("KarlLastName")
                .setPhoneNumber("1234567890")
                .setEmail("admidnsdskgvjb@gmail.com")
                .setAddress("Varienstrasse 10").setDescription("Description of input KarlName"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreatedByText("KarlName"));
    }

    @Test(dataProvider = "addNewContact")
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

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact()
                    .setName(split[0])
                    .setLastName(split[1])
                    .setPhoneNumber(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "addNewContactFromCSV")
    public void addNewContactFromDataProviderCSVPositiveTest(Contact contact){
        logger.info("Test run with dta: " + contact.toString());
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreatedByText(contact.getName()));
        Assert.assertTrue(app.getContact().isContactCreatedByText(contact.getPhoneNumber()));
    }
}
