package thucydidesTest.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.thucydides.core.pages.PageObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import thucydidesTest.clasess.Person;

@DefaultUrl("http://www.ranorex.com/web-testing-examples/vip")
public class TestPage extends PageObject {

    String parentHandler;

    //------------------------  * Buttons *  ----------------------------
    @FindBy(id = "connect")
    private WebElement buttonConnect;

    @FindBy(id = "Load")
    private WebElement buttonLoad;

    @FindBy(id = "Save")
    private WebElement buttonSave;

    @FindBy(id = "Clear")
    private WebElement buttonClear;

    @FindBy(id = "Add")
    private WebElement buttonAdd;

    //------------------------  * Fields *  ----------------------------
    @FindBy(id = "FirstName")
    private WebElement fieldFristName;

    @FindBy(id = "LastName")
    private WebElement fieldLastName;

    @FindBy(id = "Category")
    private WebElement selectElement;

    @FindBy(id = "count")
    private WebElement fieldVipCount;

    @FindBy(id = "connection")
    private WebElement fieldConnection;

    //------------------------  * Methods *  ----------------------------
    public void addPerson(Person person) {

        fieldFristName.sendKeys(person.getFirstName());
        fieldLastName.sendKeys(person.getLastName());
        selectCategory(person);
        selectGender(person);
        buttonAdd.click();
    }

    private void selectCategory(Person person) {

        Select select = new Select(selectElement);
        String category = person.getCategory().getModifiedCategory();
        select.selectByVisibleText(category);

    }

    private void selectGender(Person person) {

        String gender = person.getGender().getModifiedGender();
        find(By.xpath("//input[@value='" + gender + "']")).click();

    }

    public String getVIPcount() {

        Pattern p = Pattern.compile("\\d+");
        String text = fieldVipCount.getText();
        Matcher m = p.matcher(text);
        m.find();
        return m.group();
    }

    public void addFirstName(String name) {
        fieldFristName.sendKeys(name);
    }

    public void addLastName(String name) {
        fieldLastName.sendKeys(name);
    }

    public void pressButton(String buttonName) {
        find(By.id(buttonName)).click();
    }

    public void addDefaultPerson(String firstName, String lastName) {
        fieldFristName.sendKeys(firstName);
        fieldLastName.sendKeys(lastName);
        buttonAdd.click();
    }

    public void pressButtonConnection() {
        buttonConnect.click();
    }

    public String getConnectionSate(String state) {

        new WebDriverWait(getDriver(), 5).
                until(ExpectedConditions.
                        textToBePresentInElement(fieldConnection, state));

        return fieldConnection.getText();
    }

    // ---------------------- *** WORK WITH POPUP *** --------------------------
    public WebDriver switchToPopUp() {

        WebDriver popupDriver = null;
        parentHandler = getDriver().getWindowHandle();
        Set<String> allHendlers = getDriver().getWindowHandles();
        for (String currentHandler : allHendlers) {
            popupDriver = getDriver().switchTo().window(currentHandler);
            if (popupDriver.getTitle().equals("VIP Database")) {
                break;
            }
        }
        return popupDriver;
    }

    public void pressPopupButton(WebDriver popupDriver, String button) {
        String xpath = "//button[text()='" + button + "']";
        popupDriver.findElement(By.xpath(xpath)).click();
        getDriver().switchTo().window(parentHandler);
    }

    public String getPopupMessage(WebDriver popupDriver) {
        String xpath = "//div[@id='alertTextOK' or @id='alertTextOKCancel']";
        String text = popupDriver.findElement(By.xpath(xpath)).getText();
        // getDriver().close();
        getDriver().switchTo().window(parentHandler);
        return text;
    }

    /*------------------------------------------------------------------------*/
    /*---------------------- *** AssertPesons *** --------------------*/
    public void findPerson(int index) {

        for (int i = 1; i <= index; i++) {
            String xpath = "//tr[td/input[@id='VIP']][" + i + "]/td[text()]";
            List<WebElementFacade> list = findAll(By.xpath(xpath));
            for (WebElementFacade elem : list) {
            }
        }
    }

    public boolean isDisplayInDataBase(String parametr, String value) {

        List<Map<String, String>> listPersons = findAllPersonsInDatabase();

        for (Map<String, String> allMaps : listPersons) {
            if (allMaps.get(parametr).equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean comparePersons(Person person) {

        List<Map<String, String>> listInDatabase = findAllPersonsInDatabase();
        List<Person> listPersons = new ArrayList<Person>();

        for (Map<String, String> listInDatabase1 : listInDatabase) {
            listPersons.add(new Person(listInDatabase1));
        }

        for (Person listPerson : listPersons) {
            if (listPerson.equals(person)) {
                return true;
            }
        }

        return false;
    }

    public List<Map<String, String>> findAllPersonsInDatabase() {

        List<Map<String, String>> listPersons = new ArrayList<Map<String, String>>();
        Map<String, String> mapPersons;

        List<WebElementFacade> allVips = findAll(By.
                xpath("//tr[td/input[@id='VIP']]"));

        for (int i = 1; i <= allVips.size(); i++) {
            List<WebElementFacade> elem = findAll(By.
                    xpath("//tr[td/input[@id='VIP']][" + i + "]/td[text()]"));

            mapPersons = new HashMap<String, String>();

            mapPersons.put("First Name", elem.get(0).getText());
            mapPersons.put("Last Name", elem.get(1).getText());
            mapPersons.put("Gender", elem.get(2).getText());
            mapPersons.put("Category", elem.get(3).getText());

            listPersons.add(mapPersons);
        }
        return listPersons;
    }

    public boolean isButtonDisabled(String button) {

        WebElementFacade but = find(By.id(button));
        String attr = but.getAttribute("disabled");
        if (attr == null) {
            return false;
        }
        return attr.equals("true");
    }

}
