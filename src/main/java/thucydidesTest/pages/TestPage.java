package thucydidesTest.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.thucydides.core.pages.PageObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import thucydidesTest.clasess.Person;

@DefaultUrl("http://www.ranorex.com/web-testing-examples/vip")
public class TestPage extends PageObject {

    //------------------------  * Buttons *  ----------------------------
    @org.openqa.selenium.support.FindBy(id = "connect")
    private WebElement buttonConnect;

    @org.openqa.selenium.support.FindBy(id = "Load")
    private WebElement buttonLoad;

    @org.openqa.selenium.support.FindBy(id = "Save")
    private WebElement buttonSave;

    @org.openqa.selenium.support.FindBy(id = "Clear")
    private WebElement buttonClear;

    @org.openqa.selenium.support.FindBy(id = "Add")
    private WebElement buttonAdd;

    //------------------------  * Fields *  ----------------------------
    @org.openqa.selenium.support.FindBy(id = "FirstName")
    private WebElement fieldFristName;

    @org.openqa.selenium.support.FindBy(id = "LastName")
    private WebElement fieldLastName;

    @org.openqa.selenium.support.FindBy(id = "Category")
    private WebElement selectElement;

    @org.openqa.selenium.support.FindBy(id = "count")
    private WebElement fieldVipCount;

    //------------------------  * Methods *  ----------------------------
    public void addPerson(Person person) throws InterruptedException {

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

    public void addSecondName(String name) {
        fieldLastName.sendKeys(name);
    }

    public void pressButton(String buttonName) {
        find(By.id(buttonName)).click();
    }

    public void popup() {
//        PageObject pob = waitForAbsenceOf("#popup");
//        System.out.println("lsfdldslfsdjlfldslf + " + pob.getTitle());
        
        WebDriver driver = getDriver();
       
    }

}
