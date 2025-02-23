package io.loop.step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;

public class Form {


    @Given("user is already logged in and navigated to order page")
    public void user_is_already_logged_in_and_navigated_to_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("form"));

    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String productType) {

    }
    @When("user enters quantity  {string}")
    public void user_enters_quantity(String quantity) {

    }
    @When("user enters customer {string}")
    public void user_enters_customer(String customer) {

    }
    @When("user enters street  {string}")
    public void user_enters_street(String street) {

    }
    @When("user enters city  {string}")
    public void user_enters_city(String city) {

    }
    @When("user enters state  {string}")
    public void user_enters_state(String state) {

    }
    @When("user enters zip {string}")
    public void user_enters_zip(String zip) {

    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String cardType) {

    }
    @When("user enters credit {string}")
    public void user_enters_credit(String credit) {

    }
    @When("user enters xp num {string}")
    public void user_enters_xp_num(String xpnum) {

    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {

    }
    @Then("user should see {string} in the first row of the table")
    public void user_should_see_in_the_first_row_of_the_table(String string) {

    }




}
