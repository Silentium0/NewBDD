package io.loop.step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.loop.pages.ProductWebElem;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Product_Step_Def {

    private static final Logger log = LogManager.getLogger(Product_Step_Def.class);

    ProductWebElem productWebElem = new ProductWebElem();





    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() throws InterruptedException {

        Driver.getDriver().get("https://demoblaze.com");
        log.info("Home page opened");



    }
    @Then("User should be able to see expected prices in the following products")
    public void user_should_be_able_to_see_expected_prices_in_the_following_products(List<Map<String, String>> productDetails ) throws InterruptedException {
        for (Map<String , String> productDetail : productDetails) {
            productWebElem.clickCategory(productDetail.get("Category"));
            productWebElem.productPrice(productDetail.get("Product"));
            assertEquals(productDetail.get("expectedPrice"), productWebElem.productPrice(productDetail.get("Product")));
            log.info("Product price is " + productDetail.get("Product"));



        }






    }


}
