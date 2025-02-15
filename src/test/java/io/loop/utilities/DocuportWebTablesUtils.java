package BDD.utillities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.InputMismatchException;

public class DocuportWebTablesUtils {

    /**
     * returns any field from table by given email
     * @param driver
     * @param emailAddress
     * @param field
     * @author sergii
     *
     */

    public static String returnAnyField(WebDriver driver, String emailAddress, String field){
        WebElement element = null;
        String xPath = "";
        switch (field.toLowerCase()){
            case "full name":
                xPath = "//td[2][text()='"+emailAddress+"']/preceding-sibling::td//span[2]";
                element = driver.findElement(By.xpath(xPath));
                break;
            case "username":
                xPath = "//td[2][text()='"+emailAddress+"']/following-sibling::td[1]";
                element = driver.findElement(By.xpath(xPath));
                break;
            case "inviter":
                xPath = "//td[2][text()='"+emailAddress+"']/following-sibling::td[2]";
                element = driver.findElement(By.xpath(xPath));
                break;
            case "phone number":
                xPath = "//td[2][text()='"+emailAddress+"']/following-sibling::td[3]/span";
                element = driver.findElement(By.xpath(xPath));
                break;
            case "role":
                xPath = "//td[2][text()='"+emailAddress+"']/following-sibling::td[4]/span/span";
                element = driver.findElement(By.xpath(xPath));
                break;
            case "advisor":
                xPath = "//td[2][text()='"+emailAddress+"']/following-sibling::td[5]";
                element = driver.findElement(By.xpath(xPath));
                break;

            default: throw new InputMismatchException("There no such role: "+field);
        }
        return element.getText();

    }














}
