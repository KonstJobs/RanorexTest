package thucydidesTest.jbehave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import thucydidesTest.clasess.Person;

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

    @When("user {add|create} persons with category and gender:$table")
    public void add_def_persons(ExamplesTable table) {
        List<Map<String, String>> listPersons = createObjects(table);
        for (Map<String, String> listPerson : listPersons) {

            String firstName = listPerson.get("First Name");
            String lastName = listPerson.get("Last Name");
            Category category = Category.valueOf(listPerson.get("Category").toUpperCase());
            Gender gender = Gender.valueOf(listPerson.get("Gender").toUpperCase());

            testSteps.add_person_to_database(firstName, lastName, category, gender);
        }

    }

    @When("user {add|create} persons '$count' times with category and gender:$table")
    public void add_a_lot_of_persons(String count, ExamplesTable table) {
        List<Map<String, String>> listPersons = createObjects(table);
        for (int i = 0; i < Integer.parseInt(count); i++) {
            for (Map<String, String> listPerson : listPersons) {

                String firstName = listPerson.get("First Name");
                String lastName = listPerson.get("Last Name");
                Category category = Category.valueOf(listPerson.get("Category").toUpperCase());
                Gender gender = Gender.valueOf(listPerson.get("Gender").toUpperCase());

                testSteps.add_person_to_database(firstName, lastName, category, gender);
            }
        }
    }

    @When("user create persons:$table")
    public void add_persons(ExamplesTable table) {
        for (Map<String, String> row : table.getRows()) {

            String firstName = row.get("First Name");
            String lastName = row.get("Last Name");
            testSteps.add_def_person(firstName, lastName);

        }
    }

    //------------------ ***  @Then *** ---------------------------
    @Then("vip count should be '$count'")
    public void vip_count(String count) {
        testSteps.get_vip_count(count);

    }

    @Then("should be popup with message: '$message'")
    public void get_popup_message(String message) {
        testSteps.get_popup_message(message);
    }

    @Then("state of database should be '$state'")
    public void check_database_sate(String state) {
        testSteps.check_database_sate(state);
    }

    @Then("button '$button' should be disabled")
    public void button_should_be_disabled(String button) {
        testSteps.is_button_disabled(button);
    }

    @Then("button '$button' should be enabled")
    public void button_should_be_enabled(String button) {
        testSteps.is_button_enabled(button);
    }

    @Then("count persons on the page should be '$count'")
    public void count_persons_on_the_page(String count) {
        testSteps.count_persons_on_the_page(count);
    }

    @Then("close popup")
    public void close_popup() {
        testSteps.close_popup();
    }

//------------------- *** Assertion Persons *** ----------------------------
    @Then("person with '$parametr' '$value' should display in database")
    public void person_should_display(String parametr, String value) {
        testSteps.person_should_display_in_database(parametr, value);
    }

    @Then("following persons should display in database:$table")
    public void persons_should_display(ExamplesTable table) {

        List<Map<String, String>> listPersons = createObjects(table);
        for (Map<String, String> listPerson : listPersons) {

            String firstName = listPerson.get("First Name");
            String lastName = listPerson.get("Last Name");
            Category category = Category.valueOf(listPerson.get("Category").toUpperCase());
            Gender gender = Gender.valueOf(listPerson.get("Gender").toUpperCase());

            testSteps.persons_should_display_in_database(firstName, lastName, category, gender);
        }

    }

    // -------------------------------------------------------------------------
    public List<Map<String, String>> createObjects(ExamplesTable table) {

        List<Map<String, String>> listPersons = new ArrayList<Map<String, String>>();
        Map<String, String> mapPersons;

        for (Map<String, String> row : table.getRows()) {
            mapPersons = new HashMap<String, String>();

            mapPersons.put("First Name", row.get("First Name"));
            mapPersons.put("Last Name", row.get("Last Name"));
            mapPersons.put("Category", row.get("Category"));
            mapPersons.put("Gender", row.get("Gender"));

            listPersons.add(mapPersons);
        }
        return listPersons;
    }

}
