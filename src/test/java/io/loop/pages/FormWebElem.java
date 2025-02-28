package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormWebElem {
    @FindBy(xpath = "//input[@id='ctl00_MainContent_username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_login_button']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Order')]")
    public WebElement order;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
    public WebElement quantuty;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtName']")
    public WebElement  customer ;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")
    public WebElement  street ;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")
    public WebElement  city ;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")
    public WebElement  state ;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")
    public WebElement  zip ;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")
    public WebElement  cardNum ;

    @FindBy(xpath = "//label[contains(text(),'American Express')]/../input")
    public WebElement  cardType ;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")
    public WebElement  xpDate ;

    @FindBy(xpath = "//a[contains(text(),'Process')]")
    public WebElement  process ;

    @FindBy(xpath = "//*[contains(text(),'New order')]")
    public WebElement  newOrderMassage ;








    public void setLogin(){
        username.sendKeys("Tester");
        password.sendKeys("test");
        loginButton.click();
        BrowserUtils.waitForVisibility(order,10).click();
    }

    public FormWebElem() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
