package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import org.example.enums.BrowserType;
import org.example.enums.ENVType;
import org.example.enums.OSType;

import java.io.FileInputStream;
import java.util.Properties;

import java.lang.System;

public class EnvService {
    protected ENVType ENV;
    protected OSType OS;
    protected BrowserType BROWSER;
    protected Properties properties;
    protected String APPURL;
    protected String DATADIR;
    protected  WebDriver driver = null;

    public void setEnvironment(String envParam, String browserParam) {
        try {
            Log.info("ENV : " + envParam);
            if(envParam.indexOf("DEV") >= 0){
                ENV = ENVType.DEV;
            }else if(envParam.indexOf("SIT") >= 0){
                ENV = ENVType.SIT;
            }else if(envParam.indexOf("UAT") >= 0 ){
                ENV = ENVType.UAT;
            }else if(envParam.indexOf("PROD") >= 0 ){
                ENV = ENVType.PROD;
            }else{
                throw new Exception("Environment Not Supported");
            }

            String osname = System.getProperty("os.name");
            Log.info("OSNAME : " + osname);
            if(osname.indexOf("Win") >= 0){
                OS = OSType.WINDOWS;
            }else if(osname.indexOf("Mac") >= 0){
                OS = OSType.MACOSX;
            }else if(osname.indexOf("nix") >= 0 || osname.indexOf("nux") >= 0){
                OS = OSType.LINUX;
            }else{
                throw new Exception("Operating System Not Supported");
            }

            Log.info("BROWSER : " + browserParam);
            if(browserParam.indexOf("chrome") >= 0){
                BROWSER = BrowserType.CHROME;
            }else if(browserParam.indexOf("firefox") >= 0){
                BROWSER = BrowserType.FIREFOX;
            }else if(browserParam.indexOf("safari") >= 0){
                BROWSER = BrowserType.SAFARI;
            }else if(browserParam.indexOf("ie11") >= 0){
                BROWSER = BrowserType.IE11;
            }else if(browserParam.indexOf("edge") >= 0){
                BROWSER = BrowserType.EDGE;
            }else{
                throw new Exception("Browser Not Supported");
            }

            Log.info("OS : " + OS.name());
            switch(OS) {
                case WINDOWS:
                    switch(BROWSER){
                        case CHROME:
                            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                            break;
                        case FIREFOX:
                            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
                            break;
                        case SAFARI:
                            //
                            break;
                        case EDGE:
                            System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
                            break;
                        default:
                            throw new Exception("Driver Not Available");
                    }
                    break;

                case MACOSX:
                case LINUX:
                    switch(BROWSER){
                        case CHROME:
                            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
                            break;
                        case FIREFOX:
                            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
                            break;
                        case SAFARI:
                            //
                            break;
                        case EDGE:
                            System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver");
                            break;
                        default:
                            throw new Exception("Driver Not Available");
                    }
                    break;

                default:
                    throw new Exception("Driver Not Available");
            }

        } catch (Exception e) {
            Log.info(e.getStackTrace().toString());
        }
    }

    public WebDriver getDriver() {
        try {
            switch(BROWSER){
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case SAFARI:
                    driver = new SafariDriver();
                    break;
                case EDGE:
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new Exception("Driver Not Available");
            }

            properties = new Properties();
            properties.load(new FileInputStream("./config/config.properties"));

            switch(ENV){
                case DEV:
                    APPURL = properties.getProperty("DEV_URL");
                    DATADIR = properties.getProperty("DEV_DATA_LOCATION");
                    break;
                case SIT:
                    APPURL = properties.getProperty("SIT_URL");
                    DATADIR = properties.getProperty("SIT_DATA_LOCATION");
                    break;
                case UAT:
                    APPURL = properties.getProperty("UAT_URL");
                    DATADIR = properties.getProperty("UAT_DATA_LOCATION");
                    break;
                case PROD:
                    APPURL = properties.getProperty("PROD_URL");
                    DATADIR = properties.getProperty("PROD_DATA_LOCATION");
                    break;
                default:
                    throw new Exception("Environment Not Available");
            }

            Log.info("APPURL : " + APPURL);
            Log.info("DATADIR : " + DATADIR);

        } catch (Exception e) {
            Log.info(e.getStackTrace().toString());
        }
        return driver;
    }

    private FirefoxProfile createFirefoxProfile() {
        Log.info("# Setting up Firefox profile.");
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.dir", "E:\\git_projects\\download");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/pdf,application/vnd.ms-excel,application/octet-stream");
        firefoxProfile.setPreference("pdfjs.disabled", true);
        return firefoxProfile;

    }
}
