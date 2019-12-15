package org.example.tests;

import org.example.pages.LandingPage;
import org.example.utils.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LandingPage landingPage;
//    DashboardPage dashboard;
//    LoginPage loginPage;


    @BeforeClass
    public void beforeClass() {
        Log.info("Starting beforeClass");
        landingPage = new LandingPage(driver);
    }

    @Test
    public void selectSydneyToBaliFlight_1stOfMonth_2Adultsx2Children() {
        Log.info("Starting selectSydneyToBaliFlight_1stOfMonth_2Adultsx2Children");
        landingPage.enterStartLocation();
    }
}
