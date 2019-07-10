package com.mastugan.internal;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public final class WebDriverFactory {

    private static final Logger LOGGER = LogManager.getLogger(WebDriverFactory.class);

    private WebDriverFactory() {
    }

    public static WebDriver create(Driver name) {
        WebDriver wd = null;
        switch (name) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                wd = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                wd = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                wd = new EdgeDriver();
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                wd = new OperaDriver();
                break;
        }
        LOGGER.info("Init WebDriver");
        return wd;
    }

    public static <T extends MutableCapabilities> WebDriver create(Driver driver, T options) {
        WebDriver wd = null;
        switch (driver) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                wd = new ChromeDriver(options);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                wd = new FirefoxDriver(options);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                wd = new EdgeDriver(options);
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                wd = new OperaDriver(options);
                break;
        }
        LOGGER.info("Init WebDriver");
        return wd;
    }

    public static WebDriver create() {
        String browser = RunProperties.getProperty(RunProperties.BROWSER);
        if (browser != null) {
            try {
                Driver result = Driver.valueOf(browser.toUpperCase());
                return create(result);
            } catch (IllegalArgumentException e) {
                LOGGER.error("Wrong {}=\"{}\".  ", RunProperties.BROWSER, browser);
            }
        }
        return create(Driver.CHROME);
    }
}
