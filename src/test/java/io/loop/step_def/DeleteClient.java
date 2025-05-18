package io.loop.step_def;

import io.cucumber.java.en.Then;
import io.loop.pages.DocWebElem;
import io.loop.utilities.BrowserUtils;
import org.openqa.selenium.ElementClickInterceptedException;

public class DeleteClient {
    DocWebElem docWebElem = new DocWebElem();


    @Then("user click {string}")
    public void user_click(String MyUploads) {
        BrowserUtils.justClick(MyUploads);
    }
    @Then("user click last checkbox")
    public void user_click_last_checkbox() {
        docWebElem.checkbox.click();

    }
    @Then("press {string} button")
    public void press_button(String delete) throws InterruptedException {
        BrowserUtils.justClick(delete);
    }
    @Then("press button {string}")
    public void pressButton(String remove) {
        try {
            BrowserUtils.waitForClickable(docWebElem.remove,10).click();
        }catch (ElementClickInterceptedException e){
            e.printStackTrace();
        }

    }
}
