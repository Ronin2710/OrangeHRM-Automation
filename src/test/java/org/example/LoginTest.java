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
    }

    @Test
    public void verifyLoggedInUser() throws IOException {
        LoginPage loginPage = new LoginPage(BaseClass.getDriver());
        loginPage.login("Admin", "admin123");
        String loggedInUser = loginPage.getLoggedinUser();
        System.out.println("User Name Is: " + loggedInUser);
        Assert.assertFalse(loggedInUser.isEmpty());
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
        boolean employeeFound = empListPage.isEmpDisplayed("Piyush");
        Assert.assertTrue(employeeFound, "Employee Not Found");
    }
}






