package io.loop.pages;

import io.loop.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocWebElem {

    @FindBy(xpath = "//label[contains(text(),'Username or email')]/following-sibling::input")
    public WebElement username;

    @FindBy(xpath = "//label[contains(text(),'Password')]/following-sibling::input")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(),' Continue ')]/..")
    public WebElement continueButton;

    @FindBy(xpath = "//span[contains(text(),'Home')]")
    public WebElement Home;

    @FindBy(xpath = "//label[contains(text(),'Recipient')]/following-sibling::input")
    public WebElement inputField;

    @FindBy(xpath = "//label[contains(text(),'Sent')]/../div")
    public WebElement sent;




    public static void  validateText(String text) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
        Assert.assertEquals(text,element.getText());
    }


    public DocWebElem() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
