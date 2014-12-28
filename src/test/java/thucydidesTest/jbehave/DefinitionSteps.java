package thucydidesTest.jbehave;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


import thucydidesTest.steps.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("the user is on the Test page")
    public void user_is_on_the_test_page() {
        endUser.is_the_home_page();
    }

    @When("user add person with name '$John'")
    public void when_user_add_first_name(String word) {
        endUser.enter_first_name(word);
    }
    
    @When("enter second name '$asdf'")
    public void enter_second_name(String word) {
        endUser.enter_second_name(word);
    }
    
    @When("press button '$Add'")
    public void press_button_add(String buttonName) {
        endUser.press_button(buttonName);
    }
    
   

    @Then("vip count должно быть нахуй '$count'")
    public void vip_count(String count) {
        endUser.get_vip_count(count);

    }
    
    
    

}
