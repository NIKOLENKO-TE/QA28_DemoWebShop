package com.ait.demowebshop.tests;

import com.ait.demowebshop.models.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CreateAccountTestsDWS extends TestBaseDWS {
    public static void fillRegisterNewUserForm(User user) {
        app.getUser().chooseMaleGender();
        app.getUser().clickFirstNameRegistration();
        app.getUser().fillFirstName(user.getFirstName());
        app.getUser().clickLastName();
        app.getUser().fillLastName(user.getLastName());
        app.getUser().clickEmail();
        app.getUser().fillEmail(user.getEmail());
        app.getUser().clickPassword();
        app.getUser().fillPassword(user.getPassword());
        app.getUser().clickConfirmPassword();
        app.getUser().fillConfirmPassword(user.getPassword());
    }

    @BeforeMethod
    public void ensurePrecondition() {
        app.init();
    }

    @Test(testName = "Register a new user with positive data")
    public void registerNewUserPositiveTest() {
        app.getUser().clickOnRegisterLink();
        fillRegisterNewUserForm(new User()
                .setFirstName("Tymofii")
                .setLastName("Nikolenko")
                .setEmail("adfzdmsbnfbdfb@gmail.com")
                .setPassword("adfzdmsbnfbdfb@gmail.com"));
        app.getUser().clickOnRegistrationButton();
    }

    @Test(testName = "Register an existing user")
    public void registerExistedUserNegativeTest() {
        app.getUser().clickOnRegisterLink();
        fillRegisterNewUserForm(new User().setFirstName("Tymofii").setLastName("Nikolenko").setEmail("admfix727sbnfbdfb@gmail.com").setPassword("Adminbbsbfbdfb@gmail.com"));
        app.getUser().clickOnRegistrationButton();
        WebElement errorMessage = app.getUser().checkErrorMessageEmailAlreadyExist();
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test(dataProvider = "addNewAccount", testName = "Register a new user from DataProvider with positive data")
    public void registerNewUserFromDataProviderPositiveTest(String firstName, String lastName, String email, String password) {
        app.getUser().clickOnRegisterLink();
        fillRegisterNewUserForm(new User()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password));
        app.getUser().clickOnRegistrationButton();
    }

    @DataProvider
    public Iterator<Object[]> addNewAccount() {
        List<Object[]> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String uniqueId = UUID.randomUUID().toString();
            String shortUniqueId = uniqueId.substring(0, 4); // Берем первые 4 символа
            String email = "lastname" + shortUniqueId + "@gmail.com";
            list.add(new Object[]{"Name" + (i + 2), "Lastname" + (i + 2), email, "Qwertyuiop@1"});
        }
        return list.iterator();
    }

    @Test(dataProvider = "addNewAccountFromCSV", testName = "Register a new user from DataProvider with CSV positive data")
    public void registerNewUserFromDataProvideCSVPositiveTest(User user) {
        app.getUser().clickOnRegisterLink();
        fillRegisterNewUserForm(user);
        app.getUser().clickOnRegistrationButton();
    }

    @DataProvider
    public Iterator<Object[]> addNewAccountFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/DWS_data.csv"));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            String uniqueId = UUID.randomUUID().toString().substring(0, 4);
            list.add(new Object[]{new User()
                    .setFirstName(split[0])
                    .setLastName(split[1])
                    .setEmail("random_email_" + uniqueId + "@gmail.com")
                    .setPassword(split[3])});
            line = reader.readLine();
        }
        return list.iterator();
    }


}