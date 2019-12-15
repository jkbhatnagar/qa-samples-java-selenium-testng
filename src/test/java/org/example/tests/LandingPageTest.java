package org.example.tests;

import org.example.pages.LandingPage;
import org.example.utils.Log;
import org.example.utils.YamlFileService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LandingPageTest extends BaseTest {
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
        HashMap<String, Object> testData = YamlFileService.getYamlLoader().getYamlObjectMap(DATADIR + "search_jetstar_bali_2x2.yml");
        Log.info("Starting selectSydneyToBaliFlight_1stOfMonth_2Adultsx2Children");
        landingPage.enterStartLocation(testData);
    }
}
