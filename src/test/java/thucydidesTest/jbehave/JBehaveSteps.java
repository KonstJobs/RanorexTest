package thucydidesTest.jbehave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import thucydidesTest.clasess.Category;
import thucydidesTest.clasess.Gender;

import thucydidesTest.steps.TestPageSteps;

public class JBehaveSteps {

    @Steps
    TestPageSteps testSteps;

    //------------------ ***  @GIVEN *** ---------------------------
    @Given("the user is on the test page")
    public void user_is_on_the_test_page() {
        testSteps.enter_main_page();
    }

    //------------------ ***  @WHEN *** ---------------------------
    @When("user press button {Disconnect|Connect}")
    public void user_press_button_connection() {
        testSteps.press_button_connection();
    }

    @When("user {press|click} button '$button' in popup")
    public void user_press_button_in_popup(String button) {
        testSteps.press_button_in_popup(button);
    }

    @When("user add person with name '$name'")
    public void when_user_add_first_name(String $name) {
        testSteps.enter_first_name($name);
    }

    @When("user {enter|type} first name <firstname>")
    @Alias("user {enter|type} first name '$firsname'")
    public void enter_first_name(@Named("firstname") String firstname) {
        testSteps.enter_first_name(firstname);
    }

    @When("user {enter|type} last name <lastname>")
    @Alias("user {enter|type} last name '$lastname'")
    public void enter_last_name(@Named("lastname") String lastname) {
        testSteps.enter_last_name(lastname);
    }

    @When("user {press|click} {button |} '$button'")
    public void press_button(String buttonName) {
        testSteps.press_button(buttonName);
    }

    @When("user {press|click} {button |} '$button' $number times")
    public void press_button_several_times(String buttonName, String number) {
        for (int i = 1; i <= Integer.parseInt(number); i++) {
            testSteps.press_button(buttonName);
        }
    }

    @When("user add {people|person} to database:$table")
    public void add_vips(ExamplesTable table) {
        List<Map<String, String>> listPeople = getListOfPeople(table);
        for (Map<String, String> person : listPeople) {

            String firstName = person.get("First Name");
            String lastName = person.get("Last Name");
            Category category = Category.valueOf(person.get("Category").toUpperCase());
            Gender gender = Gender.valueOf(person.get("Gender").toUpperCase());

            testSteps.add_person_to_database(firstName, lastName, category, gender);
        }

    }

    @When("user add people '$number' times to database:$table")
    public void add_number_of_vips(String number, ExamplesTable table) {
        for (int i = 0; i < Integer.parseInt(number); i++) {
            add_vips(table);
        }
    }

    @When("user add {person|people}:$table")
    public void add_people(ExamplesTable table) {
        for (Map<String, String> person : table.getRows()) {

            String firstName = person.get("First Name");
            String lastName = person.get("Last Name");
            testSteps.add_def_person(firstName, lastName);

        }
    }

    @When("user check person:$table")
    public void check_person(ExamplesTable table) {

        Map<String, String> map = getListOfPeople(table).get(0);

        String firstName = map.get("First Name");
        String lastName = map.get("Last Name");
        Category category = Category.valueOf(map.get("Category").toUpperCase());
        Gender gender = Gender.valueOf(map.get("Gender").toUpperCase());

        testSteps.select_person(firstName, lastName, category, gender);

    }

    //------------------ ***  @THEN *** ---------------------------
    @Then("vip count should be '$count'")
    public void vip_count(String count) {
        testSteps.assert_value_of_the_counter_VIP_count(count);

    }

    @Pending
    @Then("position of database on the page should be the same")
    public void get_database_position() {

    }

    @Then("should be popup with message: '$message'")
    public void get_popup_message(String message) {
        testSteps.check_popup_message(message);
    }

    @Then("state of database should be '$state'")
    public void check_database_sate(String state) {
        testSteps.check_database_sate(state);
    }

    @Then("button '$button' should be disabled")
    public void button_should_be_disabled(String button) {
        testSteps.assert_that_button_is_disabled(button);
    }

    @Then("button '$button' should be enabled")
    public void button_should_be_enabled(String button) {
        testSteps.assert_that_button_is_enabled(button);
    }

    @Then("number of people in the database should be '$number'")
    public void number_of_people_in_database(String number) {
        testSteps.check_number_of_people_in_database(number);
    }

    @Then("popup is closed")
    public void close_popup() {
        testSteps.close_popup();
    }

//------------------- *** Assertion Persons *** ----------------------------
    @Then("person with '$parametr' '$value' should display in database")
    public void person_should_display(String parametr, String value) {
        testSteps.assert_that_person_is_displayed_in_database(parametr, value);
    }

    @Then("{people|person} should display in database:$table")
    public void people_should_display(ExamplesTable table) {

        List<Map<String, String>> listPeople = getListOfPeople(table);
        for (Map<String, String> person : listPeople) {

            String firstName = person.get("First Name");
            String lastName = person.get("Last Name");
            Category category = Category.valueOf(person.get("Category").toUpperCase());
            Gender gender = Gender.valueOf(person.get("Gender").toUpperCase());

            testSteps.assert_that_person_is_displayed_in_database(firstName, lastName, category, gender);
        }

    }

    // -------------------------------------------------------------------------
    public List<Map<String, String>> getListOfPeople(ExamplesTable table) {

        List<Map<String, String>> listPeople = new ArrayList<Map<String, String>>();
        Map<String, String> person;

        for (Map<String, String> row : table.getRows()) {
            person = new HashMap<String, String>();

            person.put("First Name", row.get("First Name"));
            person.put("Last Name", row.get("Last Name"));
            person.put("Category", row.get("Category"));
            person.put("Gender", row.get("Gender"));

            listPeople.add(person);
        }
        return listPeople;
    }

}
