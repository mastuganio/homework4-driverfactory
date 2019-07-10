package com.mastugan;

import com.mastugan.internal.Driver;
import com.mastugan.rule.WebDriverRule;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CustomDriverWithCustomOptionsTest {

    @Rule
    public final WebDriverRule driverRule = WebDriverRule.getInstance(Driver.FIREFOX, new FirefoxOptions());

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
