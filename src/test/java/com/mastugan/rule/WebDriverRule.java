package com.mastugan.rule;

import com.mastugan.internal.Driver;
import com.mastugan.internal.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverRule extends ExternalResource {

    private static final Logger LOGGER = LogManager.getLogger(WebDriverRule.class);

    private WebDriver driver;

    private WebDriverRule(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriverRule getInstance() {
        return new WebDriverRule(WebDriverFactory.create());
    }

    public static WebDriverRule getInstance(Driver driver) {
        return new WebDriverRule(WebDriverFactory.create(driver));
    }

    public static <T extends MutableCapabilities> WebDriverRule getInstance(Driver driver, T options) {
        return new WebDriverRule(WebDriverFactory.create(driver, options));
    }


    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Override
    protected void after() {
        if (driver != null) {
            driver.quit();
            LOGGER.info("Quits WebDriver, closing every associated window ");
        }
    }
}
