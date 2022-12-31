package com.test.smoketest;

import com.github.javafaker.Faker;
import com.pages.DefaultPage;
import com.pages.HotelRoomPage;
import com.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Day11_C10_HotelRoomOlusturma {

    LoginPage loginPage=new LoginPage();
    DefaultPage defaultPage=new DefaultPage();
    HotelRoomPage hotelRoomPage=new HotelRoomPage();
    Faker faker=new Faker();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        loginPage.advancedLink.click();
        loginPage.proceedLink.click();

        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();

        //login basarılı oldğunu verify ediyoruz
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());

    }
    @Test
    public void hotelRoomOlusturma() throws InterruptedException {

        //hotel management click yap
        defaultPage.hotelManagement.click();

        //hotel room click yap
        defaultPage.hotelRoom.click();

        //add hotelRoom a clikc yap
        hotelRoomPage.addHotelRoomLink.click();

        // zorunlu butun alanları doldurmam gerek
        //id hotel dropdown
        Select select=new Select(hotelRoomPage.IdDropDown);
        select.selectByIndex(2);

        //code
        hotelRoomPage.code.sendKeys(faker.code().imei());

        //name
        hotelRoomPage.name.sendKeys(faker.gameOfThrones().character());

        //location
        hotelRoomPage.location.sendKeys(faker.address().fullAddress());

        //description
        hotelRoomPage.description.sendKeys(faker.howIMetYourMother().catchPhrase());

        //price
        //1. yol
//        hotelRoomPage.price.sendKeys(faker.code().asin());

        //2. yol
        Actions actions=new Actions(Driver.getDriver());
        actions.dragAndDrop(hotelRoomPage.price600, hotelRoomPage.price).perform();

        //room type
        Select roomtype=new Select(hotelRoomPage.roomTypeDropDown);
        roomtype.selectByVisibleText("Queen");

        //Max adult
        hotelRoomPage.maxAdultCount.sendKeys("2");

        //Max children
        hotelRoomPage.maxChildrenCount.sendKeys("4");

        //approve
        hotelRoomPage.approvedCheckBox.click();

        //save
        hotelRoomPage.saveButton.click();

        // HotelRoom was inserted successfully  mesajı veriy et

 //       WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);
 //       wait.until(ExpectedConditions.visibilityOf(hotelRoomPage.popupMessage));
        Thread.sleep(5000);
        Assert.assertTrue(hotelRoomPage.popupMessage.getText().contains("HotelRoom was inserted successfully"));

        //ok click yap
        hotelRoomPage.okButton.click();

        Driver.closeDriver();


    }
}
