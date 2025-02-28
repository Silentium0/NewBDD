package io.loop.step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.FormWebElem;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class Form {
    FormWebElem form = new FormWebElem();


    @Given("user is already logged in and navigated to order page")
    public void user_is_already_logged_in_and_navigated_to_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("form"));
        form.setLogin();
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String productType) {
        Select prrdtype = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        prrdtype.selectByVisibleText(productType);
    }

    @When("user enters quantity  {string}")
    public void user_enters_quantity(String quantity) {
        form.quantuty.sendKeys(Keys.BACK_SPACE + quantity);
    }

    @When("user enters customer {string}")
    public void user_enters_customer(String customer) {
        form.customer.sendKeys(customer);
    }

    @When("user enters street  {string}")
    public void user_enters_street(String street) {
        form.street.sendKeys(street);
    }

    @When("user enters city  {string}")
    public void user_enters_city(String city) {
        form.city.sendKeys(city);
    }

    @When("user enters state  {string}")
    public void user_enters_state(String state) {
        form.state.sendKeys(state);
    }

    @When("user enters zip {string}")
    public void user_enters_zip(String zip) {
        form.zip.sendKeys(zip);
    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String cardType) {
        form.cardType.sendKeys(cardType);
    }

    @When("user enters credit {string}")
    public void user_enters_credit(String credit) {
        form.cardNum.sendKeys(credit);
    }

    @When("user enters xp num {string}")
    public void user_enters_xp_num(String xpnum) {
        form.xpDate.sendKeys(xpnum);
    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {
        form.process.click();
    }

    @Then("user should see {string} in the first row of the table")
    public void user_should_see_in_the_first_row_of_the_table(String string) {
        Assert.assertEquals(string, form.newOrderMassage.getText());
    }


}
