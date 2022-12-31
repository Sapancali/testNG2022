package com.test.smoketest;

import com.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day11_C9_NegativeLoginTest {
/*
    invalidPassword()
    When Kullanıcı sadece yanlış password girer
    Then Kullanıcı ‘wrong password’ mesajını verify eder
    Test Data:
    Url: http://www.carettahotel.com/
    username : manager
    password  : Manage
     */
@Test
    public void invalidPassword(){
    Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

    LoginPage loginPage=new LoginPage();
    loginPage.advancedLink.click();
    loginPage.proceedLink.click();

//    When Kullanıcı sadece yanlış password girer
//    loginPage.username.sendKeys("manager");
//    loginPage.password.sendKeys("Manage");

    loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
    loginPage.password.sendKeys(ConfigReader.getProperty("wron_manager_possword"));

    loginPage.loginButton.click();

//    Then Kullanıcı ‘wrong password’ mesajını verify eder
    System.out.println(loginPage.errorMessage.getText());
    Assert.assertTrue(loginPage.errorMessage.getText().contains("Wrong password"));


}
    @Test
    public void invalidID(){
        /*
        InvalidID()
When Kullanıcı sadece yanlış username girer
Then Kullanıcı ‘Try again please’ mesajını verify eder
Test Data:
Url: http://www.carettahotel.com/
username : manager123
password  : Manager1!

         */
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        LoginPage loginPage=new LoginPage();
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();

        //When Kullanıcı sadece yanlış username girer
        loginPage.username.sendKeys("manager123");
        loginPage.password.sendKeys("Manager1!");
        loginPage.loginButton.click();

        //Then Kullanıcı ‘Try again please’ mesajını verify eder
        System.out.println(loginPage.errorMessage.getText());
        Assert.assertTrue(loginPage.errorMessage.getText().contains("Try again please"));


    }
    @Test
    public void invalidIDandPassword(){
    /*
    invalidIDAndPassword()
When Kullanıcı hem yanlış username ve password girer
Then Kullanıcı ‘Username or password is incorrect, please correct them and try again’ mesajını verify eder
Test Data:
Url: http://www.carettahotel.com/
username : manager123
password  : Manage!
     */
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        LoginPage loginPage=new LoginPage();
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();

        //When Kullanıcı hem yanlış username ve password girer
        loginPage.username.sendKeys(ConfigReader.getProperty("wrong_manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("wron_manager_possword"));
        loginPage.loginButton.click();

//Then Kullanıcı ‘Username or password is incorrect, please correct them and try again’ mesajını verify eder
        System.out.println(loginPage.errorMessage.getText());
        Assert.assertTrue(loginPage.errorMessage.getText().contains("Username or password is incorrect, please correct them and try again"));
    Driver.closeDriver();
    }

}
