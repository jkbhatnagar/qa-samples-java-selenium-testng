package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

    WebDriver driver;

    String pageTitle = "Jetstar Airways - Australia | Jetstar";

    By startLocationButtonBy = By.xpath("//*[@class=\"sector__field\"][1]/div/button");
    By startLocationEntryBy = By.cssSelector("div[data-name=\"SectorsContainer\"] input[name=outbound]");
    By startLocationResultButton = By.cssSelector("div[data-name=\"SectorsContainer\"] button.hu_hv.hu_h2");

    By finishLocationButtonBy = By.xpath("//*[@class=\"sector__field\"][2]/div/button");
    By finishLocationEntryBy = By.cssSelector("div[data-name=\"SectorsContainer\"] button.hu_hv.hu_h2[tabindex=\"0\"]");
    By finishLocationResultButtonBy = By.cssSelector("div[data-name=\"SectorsContainer\"] div[id*=locations] button.hu_hv.hu_h2");

    By dateSelector = By.cssSelector("div[data-name=\"SectorsContainer\"] div.sector__field.sector__field--date button.hu_hv.hu_h6[tabindex=\"0\"]");

    By dateDiv = By.cssSelector("div[data-auto=\"calendarGrid\"] button.qg_qh div.qg_qr div.qg_qs");
    By dateDivText = By.xpath("//*[text()='28']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage enterStartLocation() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement startLocationButton = wait.until(ExpectedConditions.elementToBeClickable(startLocationButtonBy));
        startLocationButton.click();

        driver.findElement(startLocationEntryBy).sendKeys("Sydney");

        driver.findElement(startLocationResultButton).click();

        driver.findElement(finishLocationButtonBy).click();

        driver.findElement(finishLocationEntryBy).sendKeys("Bali");

        driver.findElement(finishLocationResultButtonBy).click();

        driver.findElement(dateSelector).click();

        driver.findElement(dateDiv).findElement(dateDivText).click();

        return this;
    }

}
