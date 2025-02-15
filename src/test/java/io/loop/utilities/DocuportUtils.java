package BDD.utillities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.InputMismatchException;

public class DocuportUtils {


    /**
     * Login to the Docuport App
     * @param driver , witch initialized int test base
     * @param role,  comes from docuport constants
     * @author Sergii
     */

    public static  void login(WebDriver driver,String role) throws InterruptedException {
        //driver.get("https://beta.docuport.app/");
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement userName =  Driver.getDriver().findElement(By.xpath("//label[contains(text(), 'Username or email')]/following-sibling::input"));
        WebElement password =  Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton =  Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));


        switch (role.toLowerCase()){
            case "client":
                userName.sendKeys(DocuportConstants.USERNAME_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
                break;
            case "supervisor":
                userName.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
                break;
            case "advisor":
                userName.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
                break;
            case "employee":
                userName.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
                break;
            default: throw new InputMismatchException("There are no such Element" + role);

        }
        loginButton.click();

        if (role.toLowerCase().equals("client")){
            Thread.sleep(2500);
            WebElement loginBUtton =  Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
            loginBUtton.click();

        }


    }

    /**
     * logs out from app
     * @param driver
     * @author sergii
     */


    public static void logOut(WebDriver driver) throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement userIcon =  Driver.getDriver().findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement logOut =  Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


}
