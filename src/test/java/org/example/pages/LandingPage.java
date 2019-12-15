package org.example.pages;

import org.example.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class LandingPage {

    WebDriver driver;

    String pageTitle = "Jetstar Airways - Australia | Jetstar";

    By startLocationButtonBy = By.xpath("//*[@class=\"sector__field\"][1]/div/button");
    By startLocationEntryBy = By.cssSelector("div[data-name=\"SectorsContainer\"] input[name=outbound]");
    By startLocationResultButton = By.cssSelector("div[data-name=\"SectorsContainer\"] button.hu_hv.hu_h2");

    By finishLocationButtonBy = By.xpath("//*[@class=\"sector__field\"][2]/div/button");
    By finishLocationEntryBy = By.cssSelector("div[data-name=\"SectorsContainer\"] input[id*=\"search-inbound\"]");
    By finishLocationResultButtonBy = By.cssSelector("div[data-name=\"SectorsContainer\"] div[id*=locations] button.hu_hv.hu_h2");

    By dateSelector = By.cssSelector("div[data-name=\"SectorsContainer\"] div.sector__field.sector__field--date button.hu_hv.hu_h6[tabindex=\"0\"]");

    By dateDiv = By.cssSelector("div[data-auto=\"calendarGrid\"] button.qg_qh div.qg_qr div.qg_qs");
    By confirmDatesButton = By.xpath("//*/footer[@data-auto=\"calendarReview\"] //*/button[text()='Confirm dates']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage enterStartLocation(HashMap<String, Object> testData) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement startLocationButton = wait.until(ExpectedConditions.elementToBeClickable(startLocationButtonBy));
            startLocationButton.click();

            driver.findElement(startLocationEntryBy).sendKeys((String) testData.get("startlocation"));

            driver.findElement(startLocationResultButton).click();

            Thread.sleep(3*1000);

            driver.findElement(finishLocationButtonBy).click();

            driver.findElement(finishLocationEntryBy).sendKeys((String) testData.get("finishlocation"));

            driver.findElement(finishLocationResultButtonBy).click();

            Thread.sleep(3*1000);

            driver.findElement(dateSelector).click();

            Thread.sleep(3*1000);

            By dateDivTextStart = By.xpath("//*[text()='" + (String) testData.get("startdate") + "']");
            By dateDivTextFinish = By.xpath("//*[text()='" + (String) testData.get("finishdate") + "']");

            driver.findElement(dateDiv).findElement(dateDivTextStart).click();

            Thread.sleep(3*1000);

            driver.findElement(dateDiv).findElement(dateDivTextFinish).click();

            Thread.sleep(3*1000);

            driver.findElement(confirmDatesButton).click();

            Thread.sleep(3*1000);

        }catch (Exception ex){
            Log.info(ex.getStackTrace().toString());
        }
        return this;
    }

}
