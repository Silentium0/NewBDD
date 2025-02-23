package io.loop.step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.loop.pages.Google;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleDataTable {

    Google google = new Google();


    @Given("user on google page")
    public void user_on_google_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));

    }
    @Then("user enter data")
    public void user_enter_data(List<String> data) {

        for (int i = 0; i < data.size(); i++) {
            google.search.clear();
            google.search.sendKeys(data.get(i) + Keys.ENTER);
            google.capch();
        }
    }


    @Then("user search {string}")
    public void user_search(String country) {
        google.search.sendKeys(country + Keys.ENTER);

    }
    @Then("user search  for {string}")
    public void user_search_for(String capital) {
        Assert.assertEquals(google.capital.getText(),capital);

    }

}
