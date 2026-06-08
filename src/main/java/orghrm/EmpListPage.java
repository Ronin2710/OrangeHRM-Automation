package orghrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmpListPage {
   private static WebDriver driver;

    public EmpListPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By pimMenu = By.xpath("//span[text()='PIM']");
    //private final By employeeList = By.xpath("//a[text()='Employee List']");
    private final By employeeNameInput = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By saveButton = By.xpath("//button[normalize-space()='Search']");

    public void SearchEmployee(String usernameField) {

        WebElement ClickOnPimp = driver.findElement(pimMenu);
        ClickOnPimp.click();

        WebElement EnterEmpName = driver.findElement(employeeNameInput);
        EnterEmpName.sendKeys(usernameField);

        WebElement ClickOnSearch = driver.findElement(saveButton);
        ClickOnSearch.click();
        System.out.println("Employee search completed successfully");

    }

    public boolean isEmpDisplayed(String usernameField) {

        By employeeLocator = By.xpath("//div[contains(text(),'" + usernameField + "')]]");
        return driver.findElement(employeeLocator).isDisplayed();

    }
}