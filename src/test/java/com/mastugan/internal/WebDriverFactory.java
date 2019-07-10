package com.mastugan.internal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public final class WebDriverFactory {

    private static final Logger LOGGER = LogManager.getLogger(WebDriverFactory.class);

    private WebDriverFactory() {
    }

    public static WebDriver create(Driver driver) {
        WebDriver wd = null;
        switch (driver) {
            case CHROME:
                Driver.CHROME.setup();
                wd = Driver.CHROME.create();
                break;
            case FIREFOX:
                Driver.FIREFOX.setup();
                wd = Driver.FIREFOX.create();
                break;
            case EDGE:
                Driver.EDGE.setup();
                wd = Driver.EDGE.create();
                break;
            case OPERA:
                Driver.OPERA.setup();
                wd = Driver.OPERA.create();
                break;
        }
        LOGGER.info("Init WebDriver");
        return wd;
    }

    public static <T extends MutableCapabilities> WebDriver create(Driver driver, T options) {
        WebDriver wd = null;
        switch (driver) {
            case CHROME:
                Driver.CHROME.setup();
                wd = Driver.CHROME.create(options);
                break;
            case FIREFOX:
                Driver.FIREFOX.setup();
                wd = Driver.FIREFOX.create(options);
                break;
            case EDGE:
                Driver.EDGE.setup();
                wd = Driver.EDGE.create(options);
                break;
            case OPERA:
                Driver.OPERA.setup();
                wd = Driver.OPERA.create(options);
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
