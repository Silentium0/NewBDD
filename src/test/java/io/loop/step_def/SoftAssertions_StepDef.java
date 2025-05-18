package io.loop.step_def;

import io.cucumber.java.en.Then;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.DocuportUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;


public class SoftAssertions_StepDef {

    private Logger log = LogManager.getLogger(SoftAssertions_StepDef.class);
    private SoftAssertions softAssertions = new SoftAssertions();

    @Then("user validate {string}")
    public void user_validate(String Home) {
        softAssertions.assertThat(BrowserUtils.validateText(Home)).isEqualTo(Home);
        log.info("validated");
    }
    @Then("after user validate {string}")
    public void after_user_validate(String Myuploads) {
        softAssertions.assertThat(BrowserUtils.validateText(Myuploads)).isEqualTo(Myuploads);
        log.info("validated");
    }
    @Then("user after validate {string}")
    public void user_after_validate(String Invitations) {
        softAssertions.assertThat(BrowserUtils.validateText(Invitations)).isEqualTo(Invitations);
        log.info("validated");
    }
    @Then("and user validate {string}")
    public void and_user_validate(String Receiveddocs) {
        softAssertions.assertThat(BrowserUtils.validateText(Receiveddocs)).isEqualTo(Receiveddocs);
        log.info("validated");
    }
    @Then("validate All")
    public void validateAll() {
        softAssertions.assertAll();
    }
}
