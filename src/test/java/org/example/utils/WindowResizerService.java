package org.example.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class WindowResizerService {

    public static void setWindowDimensions(WebDriver driver, String height, String width) throws Exception {
        int intHeight = (int) Float.parseFloat(height);
        int intWidth = (int) Float.parseFloat(width);
        Dimension dim = new Dimension(intHeight, intWidth);
        driver.manage().window().setSize(dim);
    }

    public static void setImplicitWait(WebDriver driver, String timeoutSeconds) throws Exception {
        int intHeight = (int) Float.parseFloat(timeoutSeconds);
        driver.manage().timeouts().implicitlyWait(intHeight, TimeUnit.SECONDS);
    }
}