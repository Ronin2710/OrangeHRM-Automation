package orghrm;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage{
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By DashboardEle = By.xpath("//h6[text()='Dashboard']");

    // Constructor receives the orghrm.EmpListPage.BaseClass instance to access the shared driver
    public HomePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver must not be null. Initialize driver before creating HomePage.");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }

    public boolean DashboardPage() {
        try {
            WebElement DashboardElem = new WebDriverWait(driver, Duration.ofSeconds(35))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
            return DashboardElem.isDisplayed();
        } catch (TimeoutException e) {
            System.err.println("Timed out waiting for Dashboard element: " + By.xpath("//h6[text()='Dashboard']"));
            System.err.println("Current URL: " + driver.getCurrentUrl());
            return false;
        }
    }
}