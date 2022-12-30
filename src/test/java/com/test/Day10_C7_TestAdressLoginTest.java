package com.test;

import com.pages.Day10_C6_TestAdressLoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.annotations.Test;

public class Day10_C7_TestAdressLoginTest {
    @Test
    public void testAdressLogin(){
        // application git https://www.testyou.in/Login.aspx

        Driver.getDriver().get(ConfigReader.getProperty("test_address_url"));
        Day10_C6_TestAdressLoginPage testAdressLoginPage=new Day10_C6_TestAdressLoginPage();

        testAdressLoginPage.email.sendKeys(ConfigReader.getProperty("test_address_email"));
        testAdressLoginPage.password.sendKeys(ConfigReader.getProperty("test_address_password"));
        testAdressLoginPage.loginButton.click();

        //driver kapat

        Driver.closeDriver();

        /*
        Diyelim ki 100 tane test case iniz var hepsinde sifre kullanmıssınız
        Daha sonra sifre değisirse ne yaparsınız
        config.properties olmazsa tüm 100 test case e gidip her biri için sifresi değistirmemiz lazım
        config.properties ile configuration.properties deki file e gidip sadece orada sifrenin value kısmını değistirmek yeterli olacak

         */
    }
}
