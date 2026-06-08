package orghrm;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    // Current locators (update if your page actually uses different ids/names)
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By UserName = By.xpath("//p[@class='oxd-userdropdown-name']");
    private final By logoutButton = By.xpath("//a[text()='Logout']");

    private WebDriver driver;
    private WebDriverWait wait;

        public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }

     /*   public void enterUserName(String userName)
        {
        WebElement User =driver.findElement(usernameField);
        User.sendKeys(userName);
        System.out.println("Username entered successfully");
        }

        public void enterPassword(String password)
        {
        WebElement Password = driver.findElement(passwordField);
        Password.sendKeys(password);
        System.out.println("Password entered successfully");
        }

        public void clickLogin()
        {
        WebElement ClickButton=driver.findElement(loginButton);
        ClickButton.click();
        System.out.println("Login successfully");
        }

        public void GetUserNameDetails()
        {
        WebElement UserDetails=driver.findElement(UserName);
        UserDetails.click();
        System.out.println(UserDetails.getText());
        }

        public void Logout()
        {
        WebElement logout=driver.findElement(logoutButton);
        logout.click();
        System.out.println("Logout successfully");
        }

*/
    public void login(String username, String password)
    {
        WebElement User=driver.findElement(usernameField);
        User.sendKeys(username);
        System.out.println("Username entered successfully");

        WebElement Password = driver.findElement(passwordField);
        Password.sendKeys(password);
        System.out.println("Password entered successfully");

        WebElement ClickButton=driver.findElement(loginButton);
        ClickButton.click();
        System.out.println("Login successfully");
    }

    public String getLoggedinUser()
    {
        WebElement getLoggedinUser=driver.findElement(UserName);
        getLoggedinUser.click();
        return getLoggedinUser.getText();
    }

   /* public void Logout()
    {
        WebElement logout=driver.findElement(logoutButton);
        logout.click();
        System.out.println("Logout successfully");
    } */







}



