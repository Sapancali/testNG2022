package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day10_C6_TestAdressLoginPage {
    //Bu sayfa page class
    // Bu class'ta yalnızca page objectleri ve önemli ana methodları ekleriz

    //1. constructor oluştur
    //PageFactory.initElements() bu sayfadaki objectleri calıstirir
    public Day10_C6_TestAdressLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // 2. page /sayfadaki elemenleri bul/oluştur
    //Note: 8 locator'ın tümü kullanılabilir

    @FindBy (id="ctl00_CPHContainer_txtUserLogin")
    public WebElement email;
    @FindBy (id="ctl00_CPHContainer_txtPassword")
    public WebElement password;
    @FindBy (id="ctl00_CPHContainer_btnLoginn")
    public WebElement loginButton;
}
