package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import orghrm.BaseClass;
import orghrm.EmpListPage;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void takeScreenshot(String filename)
        throws IOException {
            TakesScreenshot TS = (TakesScreenshot) BaseClass.getDriver();
            File Source = TS.getScreenshotAs(OutputType.FILE);
            File Destination = new File("C:\\Users\\piyu4\\eclipse-workspace\\OrhanegHRM\\Screenshots\\" + filename + ".png");
            FileHandler.copy(Source, Destination);
            System.out.println("Screenshot taken successfully");
        }
    }

