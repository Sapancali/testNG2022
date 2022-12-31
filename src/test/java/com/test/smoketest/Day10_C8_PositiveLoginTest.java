package com.test.smoketest;

import com.pages.DefaultPage;
import com.pages.LoginPage;
import com.pages.MainPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day10_C8_PositiveLoginTest {

    @Test
    public void positiveLoginTest(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        //1-page objet olustur== mainPage ve LoginPage
        //2-test class oluştur
        // page object oluştur
        //  -magnPage objectleri oluştur
        //  - loginPage objectleri oluştur

        MainPage mainPage=new MainPage();

        mainPage.advancedLink.click();
        mainPage.proceedLink.click();

        mainPage.mainPageLoginLink.click();

        // bu noktada loginPage teyiz
        //loginPage de objet oluştur

        LoginPage loginPage=new LoginPage();

//       loginPage.username.sendKeys("manager");
//       loginPage.password.sendKeys("Manage1!");

        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));

        loginPage.loginButton.click();

        //Adduser butonunun kullanarak defolt page e giriş yaptığımızı verify et
        //bu noktada defaultPage clasındayız

        DefaultPage defaultPage=new DefaultPage();
        boolean logedIn= defaultPage.addUserButton.isDisplayed();
        Assert.assertTrue(logedIn);

        Driver.closeDriver();

    }
}
