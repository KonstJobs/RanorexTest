package thucydidesTest.jbehave;

import java.util.Map;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import thucydidesTest.clasess.Category;
import thucydidesTest.clasess.Gender;

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

    @When("user {enter|type} first name <firstname>")
    public void enter_first_name(@Named("firstname") String name) {
        testSteps.enter_first_name(name);
    }

    @When("user {enter|type} last name <lastname>")
    public void enter_last_name(@Named("lastname") String name) {
        testSteps.enter_last_name(name);
    }

    @When("{press|click} {button |} '$button'") //@When("the {item |}{price|cost} is $price")
    public void press_button_add(String buttonName) {
        testSteps.press_button(buttonName);
    }

    //--------------------------------------
    @Then("vip count should be '$count'")
    public void vip_count(String count) {
        testSteps.get_vip_count(count);

    }

    //---------------------------------------------
    @Then("should be popup with message '$message'")
    public void test_popup(String message) {
        testSteps.test_popup(message);

    }

    @When("user add default persons $table")
    public void add_def_persons(ExamplesTable table) {
        for (Map<String, String> row : table.getRows()) {
            String firstName = row.get("firstName");
            String lastName = row.get("lastName");
            testSteps.add_def_persons(firstName, lastName);
        }
    }

    @When("user add persons $table")
    public void add_persons(ExamplesTable table) {
        for (Map<String, String> row : table.getRows()) {
            String firstName = row.get("firstName");
            String lastName = row.get("lastName");
            Category category = Category.valueOf(row.get("category"));
            Gender gender = Gender.valueOf(row.get("gender"));
            
            testSteps.add_def_persons(firstName, lastName, category, gender);
        }
    }

}
