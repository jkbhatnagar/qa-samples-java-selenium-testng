package org.example.tests;

import org.example.utils.EnvService;
import org.example.utils.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest extends EnvService {

    protected WebDriver driver = null;
    private static final long IMPLICIT_TIME = 30;

    @Parameters({ "ENV", "BROWSER" })
    @BeforeSuite
    public void beforeSuite(String envParam, String browserParam) {
        Log.startLog("Test is starting:");
        Log.info("# Setup.");
        setEnvironment(envParam, browserParam);
        driver = getDriver();
        driver.get(APPURL);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {
        Log.endLog("Test is ending.");
        driver.quit();
    }
}
