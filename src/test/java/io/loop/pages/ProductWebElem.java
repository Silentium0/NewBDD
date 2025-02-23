package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;

public class ProductWebElem {




    public void clickCategory(String category) {
        try {
            Driver.getDriver().findElement(By.xpath("//a[contains(.,'"+category+"')]")).click();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public String  productPrice(String product) throws InterruptedException {
        try {
            String act =  BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath("//a[contains(text(),'"+product+"')]/../following-sibling::h5")),20 ).getText();
            return act.substring(1);

        }catch (StaleElementReferenceException e){
            String act =  BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath("//a[contains(text(),'"+product+"')]/../following-sibling::h5")),20 ).getText();
            return act.substring(1);
        }




    }



    public ProductWebElem() {
        PageFactory.initElements(Driver.getDriver(), this);
    }






}
