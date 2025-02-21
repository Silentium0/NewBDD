package io.loop.pages;

import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google {


    @FindBy(xpath = "//textarea[@name='q']")
    public WebElement search;

    @FindBy(xpath = "/html/body/div[3]/div/div[12]/div[4]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/span[2]/span/a")
    public WebElement capital;



    public void capch(){
        try {
            WebElement capch = Driver.getDriver().findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
            capch.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Google(){

        PageFactory.initElements(Driver.getDriver(),this);

    }
}
