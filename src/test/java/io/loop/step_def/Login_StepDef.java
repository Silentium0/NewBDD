package io.loop.step_def;

import io.cucumber.java.en.Then;
import io.loop.pages.DocWebElem;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Login_StepDef {

    DocWebElem home = new DocWebElem();

    @Then("user click {string} than click {string}")
    public void userClickThanClick(String myUploads, String Search) {
        BrowserUtils.justClick(myUploads);
        BrowserUtils.clickButtonByText(Search);
    }
    @Then("validate text {string}")
    public void validateText(String text) {
        DocWebElem.validateText(text);
    }





    @Then("user click {string} than click {string} send input field {string} than click sent than {string} and validate {string}")
    public void userClickThanClickSendInputFieldThanClickSentThanAndValidate(String invitations, String searc1, String loop, String search, String validation) {
        BrowserUtils.justClick(invitations);
        BrowserUtils.justClick(searc1);
        home.sent.click();
        home.inputField.sendKeys(loop);
        BrowserUtils.justClick(search);
        DocWebElem.validateText(validation);
    }
}
