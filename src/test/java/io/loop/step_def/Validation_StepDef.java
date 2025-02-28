package io.loop.step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.loop.pages.DocWebElem;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Validation_StepDef {
    DocWebElem home = new DocWebElem();


    @Given("User login as {string}")
    public void user_login_as(String role) {
        Driver.getDriver().get(ConfigurationReader.getProperty("docuport.ui.url"));

        switch (role) {
            case "Advisor":
                home.username.sendKeys(ConfigurationReader.getProperty("advisor_username"));
                home.password.sendKeys(ConfigurationReader.getProperty("advisor_password"));
                home.loginButton.click();
                break;
            case "Supervisor":
                home.username.sendKeys(ConfigurationReader.getProperty("supervisor_username"));
                home.password.sendKeys(ConfigurationReader.getProperty("supervisor_password"));
                home.loginButton.click();
                break;
            case "Employee":
                home.username.sendKeys(ConfigurationReader.getProperty("employee_username"));
                home.password.sendKeys(ConfigurationReader.getProperty("employee_password"));
                home.loginButton.click();
                break;
            case "Client":
                home.username.sendKeys(ConfigurationReader.getProperty("client_username"));
                home.password.sendKeys(ConfigurationReader.getProperty("client_password"));
                home.loginButton.click();
                try {
                    if (BrowserUtils.waitForClickable(home.continueButton, 5) != null) {
                        home.continueButton.click();
                    }
                } catch (TimeoutException e) {
                    throw e;
                }
                break;
        }
    }

    @Then("validate {string}")
    public void validate(String items) {
        try {
            List<String> expectedItems = Arrays.asList(items.split(","));
            for (int i = 0; i < expectedItems.size(); i++) {
                String expectedSubItems = expectedItems.get(i).trim();
                WebElement menuItem = Driver.getDriver().findElement(By.xpath("//*[text()='" + expectedSubItems + "']"));
                Assert.assertEquals(expectedSubItems, menuItem.getText());
            }
        } catch (StaleElementReferenceException e) {
            List<String> expectedItems = Arrays.asList(items.split(","));
            for (int i = 0; i < expectedItems.size(); i++) {
                String expectedSubItems = expectedItems.get(i).trim();
                WebElement menuItem = Driver.getDriver().findElement(By.xpath("//*[text()='" + expectedSubItems + "']"));
                Assert.assertEquals(expectedSubItems, menuItem.getText());
            }
        }
    }
}