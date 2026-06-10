package org.example; // change package to your project's package if needed

import Utilities.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import orghrm.BaseClass;
import orghrm.EmpListPage;
import orghrm.LoginPage;
import orghrm.PimpPage;

import java.io.IOException;

public class LoginTest extends BaseClass {

    @Test(dataProvider = "loginData", dataProviderClass = TestData.class)
    public void verifylogin(String UserName, String Password) {
        LoginPage loginPage = new LoginPage(BaseClass.getDriver());
        loginPage.login(UserName, Password);
        System.out.println("Login Success");
    }


    @Test
    public void verifyLoggedInUser() throws IOException {
        LoginPage loginPage = new LoginPage(BaseClass.getDriver());
        loginPage.login("Admin", "admin123");
        String loggedInUser = loginPage.getLoggedinUser();
        Assert.assertFalse(loggedInUser.isEmpty());
        System.out.println("User Name Is: " + loggedInUser);

        ScreenshotUtil.takeScreenshot("LoginTest Success");
    }

    @Test(dataProvider = "employeeData", dataProviderClass = TestData.class)
    public void VerifyAddEmp(String firstName, String lastName) throws IOException {
        LoginPage loginPage = new LoginPage(BaseClass.getDriver());
        loginPage.login("Admin", "admin123");
        PimpPage pimPage = new PimpPage(BaseClass.getDriver());
        pimPage.addEmployee(firstName, lastName);
        ScreenshotUtil.takeScreenshot("VerifyAddEmp Successfully");
    }

    @Test
    public void VerifySearchEmployee() {
        LoginPage loginPage = new LoginPage(BaseClass.getDriver());
        loginPage.login("Admin", "admin123");
        EmpListPage empListPage = new EmpListPage(BaseClass.getDriver());
        empListPage.SearchEmployee("Piyush");

    }

    @Test
    public void VerifyInvalidLogin(){
        LoginPage loginPage = new LoginPage(BaseClass.getDriver());
        loginPage.login("Admin", "WrongPassword");
        String errorMessage = loginPage.getErrorMessage();
        System.out.println("Error Message Is: " + errorMessage);
        Assert.assertEquals(errorMessage, "Invalid credentials", "error Message mismatch");
    }
}






