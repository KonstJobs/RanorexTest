package thucydidesTest.pages;

import java.util.Iterator;
import java.util.Set;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.thucydides.core.pages.PageObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import thucydidesTest.clasess.Person;
import thucydidesTest.clasess.PersonBuilder;

@DefaultUrl("http://www.ranorex.com/web-testing-examples/vip")
public class TestPage extends PageObject {

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
        Matcher m = p.matcher(fieldVipCount.getText());
        m.find();
        //  Integer vipCount = Integer.parseInt(m.group());

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

    public String popup() {

        WebDriver driver = getDriver();
        String parentHandler = driver.getWindowHandle();
        Set<String> allHendlers = driver.getWindowHandles();

        for (String currentHandler : allHendlers) {
            driver.switchTo().window(currentHandler);
            if (driver.getTitle().equals("VIP Database")) {
                break;
            }
        }

        String xpath = "//div[@id='alertTextOK' or @id='alertTextOKCancel']";
        String message = driver.findElement(By.xpath(xpath)).getText();
        driver.close();
        driver.switchTo().window(parentHandler);

        return message;
    }

    public void addPerson(String firstName, String lastName) {
        fieldFristName.sendKeys(firstName);
        fieldLastName.sendKeys(lastName);
        buttonAdd.click();
    }

    public void pressButtonConnection() {
        buttonConnect.click();
    }

    public String getConnectionSate(String state) {
       return fieldConnection.getText();
    }

}
