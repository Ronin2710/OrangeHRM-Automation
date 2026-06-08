package org.example;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name="loginData")
    public Object[][] loginData()
    {
        return new Object[][]{
                {"Admin","admin123"},
        };
    }

    @DataProvider(name="employeeData")
    public Object[][] getData() {
        return new Object[][]{
                {"Piyush", "Chourse"},
                {"Jaya", "Chourse"}
        };
    }
}

