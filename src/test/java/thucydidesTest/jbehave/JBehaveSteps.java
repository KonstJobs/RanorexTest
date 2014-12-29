package thucydidesTest.jbehave;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import thucydidesTest.steps.TestPageSteps;

public class JBehaveSteps {

    @Steps
    TestPageSteps testSteps;

    @Given("the user is on the Test page")
    public void user_is_on_the_test_page() {
        testSteps.enter_main_page();
    }

    @When("user add person with name '$John'")
    public void when_user_add_first_name(String word) {
        testSteps.enter_first_name(word);
    }

    @When("enter second name '$asdf'")
    public void enter_second_name(String word) {
        testSteps.enter_second_name(word);
    }

    @When("press button '$Add'")
    public void press_button_add(String buttonName) {
        testSteps.press_button(buttonName);
    }

    @Then("vip count should be '$count'")
    public void vip_count(String count) {
        testSteps.get_vip_count(count);

    }

    @Then("should be popup")
    public void test_popup() {
        testSteps.test_popup();

    }

}
