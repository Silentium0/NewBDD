package io.loop.step_def;

import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.loop.pages.DocWebElem;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.junit.Assert;

import java.util.Map;

public class LoginDocuport_Step_Def  {
    DocWebElem docWebElem =  new DocWebElem();

    @Given("user on Docuport login page page")
    public void user_on_docuport_login_page_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("docuport"));
    }
    @When("user enter username {string}")
    public void userEnterUsername(String userName) {
        docWebElem.username.sendKeys(userName);
    }
    @When("user enter password {string}")
    public void userEnterPassword(String password) {
        docWebElem.password.sendKeys(password);
    }
    @When("user click login button")
    public void user_click_login_button() {
        try {
            docWebElem.loginButton.click();
        } catch (Exception e) {
            e.printStackTrace(); // Prints the exception details
        }
    }

    @When("user click continue button")
    public void userClickContinueButton() {
        BrowserUtils.waitForClickable(docWebElem.continueButton,10).click();

    }
    @When("user should see {string} page")
    public void userShouldSeePage(String home) {
        BrowserUtils.waitForVisibility(docWebElem.Home,10);
        Assert.assertEquals(home,docWebElem.Home.getText());
    }


    @Given("user login docuport")
    public void userLoginDocuport() {

    }

    @Given("User login with Map")
    public void userLogin(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            switch (key) {
                case "username":
                    docWebElem.username.clear();
                    docWebElem.username.sendKeys(value);
                    break;
                case "password":
                    docWebElem.password.clear();
                    docWebElem.password.sendKeys(value);
                    break;
                case "loginButton":
                    docWebElem.loginButton.click();
                default:
                    System.out.println("No matching field found for key: " + key);
            }
        }


    }
}
