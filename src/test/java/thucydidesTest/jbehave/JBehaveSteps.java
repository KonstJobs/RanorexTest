package thucydidesTest.jbehave;

import java.util.Map;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
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

    //------------------ ***  @Given *** ---------------------------
    @Given("the user is on the test page")
    public void user_is_on_the_test_page() {
        testSteps.enter_main_page();
    }

    //------------------ ***  @When *** ---------------------------
    @When("user press button {Disconnect|Connect}")
    public void user_press_button_connection() {
        testSteps.press_button_connection();
    }

    @When("user {press|click} button '$button' in popup")
    public void user_press_button_in_popup(String button) {
        testSteps.press_button_in_popup(button);
    }

    @When("user add person with name '$John'")
    public void when_user_add_first_name(String word) {
        testSteps.enter_first_name(word);
    }

    @When("user {enter|type} first name <firstname>")
    @Alias("user {enter|type} first name '$firsname'")
    public void enter_first_name(@Named("firstname") String name) {
        testSteps.enter_first_name(name);
    }

    @When("user {enter|type} last name <lastname>")
    @Alias("user {enter|type} last name '$lastname'")
    public void enter_last_name(@Named("lastname") String name) {
        testSteps.enter_last_name(name);
    }

    @When("user {press|click} {button |} '$button'")
    public void press_button_add(String buttonName) {
        testSteps.press_button(buttonName);
    }

    @When("user {add|create} persons with category and gender $table")
    public void add_def_persons(ExamplesTable table) {
        for (Map<String, String> row : table.getRows()) {

            String firstName = row.get("firstName");
            String lastName = row.get("lastName");
            String cat = row.get("category");
            String gen = row.get("gender");

            Category category = Category.valueOf(cat.toUpperCase());
            Gender gender = Gender.valueOf(gen.toUpperCase());

            testSteps.add_def_persons(firstName, lastName, category, gender);
        }
    }

    @When("user {add|create} persons $table")
    public void add_persons(ExamplesTable table) {
        for (Map<String, String> row : table.getRows()) {

            String firstName = row.get("firstName");
            String lastName = row.get("lastName");
            testSteps.add_def_persons(firstName, lastName);

        }
    }

    //------------------ ***  @Then *** ---------------------------
    @Then("vip count should be '$count'")
    public void vip_count(String count) {
        testSteps.get_vip_count(count);

    }

    @Then("should be popup with message '$message'")
    public void get_popup_message(String message) {
        testSteps.get_popup_message(message);
    }

    @Then("state of database should be '$state'")
    public void check_database_sate(String state) {
        testSteps.check_database_sate(state);
    }

    @Then("person should be")
    public void person_should_be() {
        testSteps.person_should_be();
    }

}
