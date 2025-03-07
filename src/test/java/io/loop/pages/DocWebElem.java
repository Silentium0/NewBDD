package io.loop.pages;

import io.loop.utilities.Driver;
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





    public DocWebElem() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
