package io.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class PizzaOrderWebTableUtils {

    /**
     * @param driver
     * @param name
     * @param field
     */


    public static String returnAnyFieldValue(WebDriver driver, String name, String field) {
        String index = "";
        if(field.equalsIgnoreCase("Pizza Type")){
            index = "[1]";
        } else if (field.equalsIgnoreCase("Amount")) {
            index = "[2]";
        } else if (field.equalsIgnoreCase("Date")) {
            index = "[3]";
        } else if (field.equalsIgnoreCase("Street")) {
            index = "[4]";
        } else if (field.equalsIgnoreCase("City")){
            index = "[5]";
        } else if (field.equalsIgnoreCase("State")) {
            index = "[6]";
        } else if (field.equalsIgnoreCase("Zip")) {
            index = "[7]";
        } else if (field.equalsIgnoreCase("Card")) {
            index = "[8]";
        } else if (field.equalsIgnoreCase("Card Number")) {
            index = "[9]";
        } else if (field.equalsIgnoreCase("Exp")) {
            index = "[10]";
        } else {
            System.out.println("There is not such a field: " + field);
        }

        WebElement element = driver.findElement(By.xpath("//td[.='"+name+"']//following-sibling::td"+ index));
        return element.getText().trim();
    }



    public static void checkBoxWebTable(String Name) {
        String xpath = "//td[text()='" + Name + "']/preceding-sibling::td//input[@type='checkbox']";

        try {
            WebElement checkbox = Driver.getDriver().findElement(By.xpath(xpath));
            checkbox.click();
        } catch (NoSuchElementException e) {
            System.out.println("Checkbox not found for cardNumber: " + Name);
            throw e;
        }
    }






}
