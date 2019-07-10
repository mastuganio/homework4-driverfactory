package com.mastugan;

import com.mastugan.rule.WebDriverRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DefaultDriverTest {

    @Rule
    public final WebDriverRule driverRule = WebDriverRule.getInstance();

    public WebDriver driver;

    @Before
    public void setUp() {
        driver = driverRule.getDriver();
    }

    @Test
    public void name() {

        driver.get("https://otus.ru");
    }
}
