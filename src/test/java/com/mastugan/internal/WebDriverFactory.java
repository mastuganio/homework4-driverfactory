package com.mastugan.internal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class WebDriverFactory {

    private static final Logger LOGGER = LogManager.getLogger(WebDriverFactory.class);

    private static final String BROWSER = "browser";

    private WebDriverFactory() {
    }

    public static WebDriver create(Driver driver) {
        WebDriver wd = init(driver);
        LOGGER.info("Init WebDriver");
        return wd;
    }

    public static <T extends MutableCapabilities> WebDriver create(Driver driver, T options) {
        WebDriver wd = init(driver, options);
        LOGGER.info("Init WebDriver with user options");
        return wd;
    }

    public static WebDriver create() {
        final String browser = System.getProperty(BROWSER);
        Objects.requireNonNull(browser, "I need property \"browser\" for run!");
        Driver driver = null;
        try {
            driver = Driver.valueOf(browser.toUpperCase());
        } catch (IllegalArgumentException e) {
            LOGGER.error("Wrong run property {}=\"{}\". Please, check documentation!", BROWSER, browser);
        }
        return create(driver);
    }

    private static WebDriver init(Driver driver) {
        driver.setup();
        return driver.create();
    }

    private static <T extends MutableCapabilities> WebDriver init(Driver driver, T option) {
        assertBrowserOptions(option.getClass(), driver.getOptionsType());
        driver.setup();
        return driver.create(option);
    }

    private static void assertBrowserOptions(Class<? extends MutableCapabilities> expected, Class<? extends MutableCapabilities> actual) {
        if (!actual.equals(expected)) {
            final String message = String.format("Invalid option! Need: %s, but was: %s", expected.getSimpleName(), actual.getSimpleName());
            LOGGER.error(message);
            throw new AssertionError(message);
        }
    }
}
