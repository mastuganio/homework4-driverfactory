package com.mastugan;

import com.mastugan.internal.Driver;
import com.mastugan.rule.WebDriverRule;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CustomDriverWithCustomOptionsTest {

    @Rule
    public final WebDriverRule driverRule = WebDriverRule.getInstance(Driver.FIREFOX, new ChromeOptions());

    public WebDriver driver;

    @Before
    public void setUp() {
        driver = driverRule.getDriver();
    }

    @Test
    @Ignore
    public void name() {
        driver.get("https://otus.ru");
    }
}
