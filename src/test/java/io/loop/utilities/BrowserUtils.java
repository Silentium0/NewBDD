package BDD.utillities;

import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.validation.Validator;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class BrowserUtils {

    private static final Logger logger = Logger.getLogger(Validator.class.getName());


    public static Scenario myScenario;

    public static void takeScreenshot(){
        try {
            myScenario.log("Current url is: " + Driver.getDriver().getCurrentUrl());
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            myScenario.attach(screenshot, "image/png", myScenario.getName());
        }catch (WebDriverException wbd){
            wbd.getMessage();
        } catch (ClassCastException cce){
            cce.getMessage();
        }
    }


    /**
     * validate if driver switch to expected url and title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @autor Sergii
     * inmplement assertion
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle){
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set <String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     *
     * switches to the new window bu the exact title
     * return to original window if the window with given title not found
     * @param driver
     * @param  targetTitle
     */


    public static  void switchToWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        for (String handel:driver.getWindowHandles()){
            driver.switchTo().window(handel);
            if (driver.getTitle().contains(targetTitle)){
                return;
            }
        }
        driver.switchTo().window(origin);

    }

    /**
     * @param driver
     * @param expectedTitle
     * return void, assertion is implement
     *
     */

    public static void validateTitle(WebDriver driver,String expectedTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }


    /**
     * Click any link from loop practice
     * @param nameOfPage
     */

    public static  void loopLinkClick  (String nameOfPage){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='"+nameOfPage+"']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    /**
     * Move the mouse to given element
     * @param element on witch to hover
     *
     */

    public static void hoverOver(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Scroll down to on element using JavaScript
     * @param element
     */
    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    /**
     * Click on element using JavaScript
     * @param element
     *
     */

    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click;", element);
    }

    /**
     * Perfrorms double click on the element
     * @param element
     */
    public static void doubleClick(WebElement element){
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }


    /**
     * Waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @return
     * @author nadir
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));

    }

    /**
     * Waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @return
     * @author nadir
     */

    public static void  waitForInVisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    /**
     * Waite for element to be clickable
     * @param element
     * @param timeout
     * @return
     */
    public static  WebElement waitForClickable(WebElement element,int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * performs a pause
     * @param seconds
     *
     */
    public static void justWait (int seconds){
        try{
            Thread.sleep(seconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void listOfElements(List<WebElement> elements) {
        for (int i = 0; i < elements.size()-1; i++) {
            System.out.print((i + 1) + " ");
            System.out.println(elements.get(i).getText());

        }
    }

    public static void clickButtonByText(String elementText) {
        try {
            List<WebElement> foundElements = Driver.getDriver().findElements(By.xpath("//*[text()='" + elementText + "']"));
            if (!foundElements.isEmpty()) {
                for (WebElement el : foundElements) {
                        el.click();
                        logger.info("Clicked element with text: '" + elementText + "'");
                        break; // Stop after the first click if only one click is desired
                }
            } else {
                logger.warning("Element with text '" + elementText + "' is not displayed.");
            }
        } catch (Exception e) {
            logger.severe("Error finding elements with text: '" + elementText + "'. Exception: " + e.getMessage());
        }
    }

    public static void clickWithNormalizeSpace(String text){
        try{
            List<WebElement> foundElements = Driver.getDriver().findElements(By.xpath("//*[normalize-space()='" + text + "']"));
            for (WebElement each : foundElements){
                BrowserUtils.waitForVisibility(each,10);
                each.click();
            }
        }catch (Exception e){
            logger.info(" Can't Click Element " +text);
        }
    }

    public static  void justClick(String name){
        Driver.getDriver().findElement(By.xpath("//*[contains(text(),'"+name+"')]")).click();
    }













}
