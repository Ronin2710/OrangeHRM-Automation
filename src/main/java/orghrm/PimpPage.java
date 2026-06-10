package orghrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PimpPage {
    WebDriver driver;
    WebDriverWait wait;
    public PimpPage(WebDriver driver) {

        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private final By pimMenu = By.xpath("//span[text()='PIM']");
    private final By addEmployee = By.xpath("//a[text()='Add Employee']");
    private final By firstName = By.name("firstName");
    private final By lastName = By.name("lastName");
    private final By saveButton = By.xpath("//button[@type='submit']");


    public void addEmployee(String firstName, String lastName) {
        WebElement ClickOnPimp = driver.findElement(pimMenu);
        ClickOnPimp.click();

        WebElement AddEmployee = driver.findElement(addEmployee);
        AddEmployee.click();

        WebElement FName=driver.findElement(this.firstName);
        FName.sendKeys(firstName);

        WebElement LName=driver.findElement(this.lastName);
        LName.sendKeys(lastName);

        WebElement SubmitButton=wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        SubmitButton.click();

        System.out.println("Employee added successfully: " + firstName + " " + lastName);
    }

}
