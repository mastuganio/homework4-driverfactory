package com.mastugan.internal;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public enum Driver {

    CHROME {
        public WebDriver create() {
            return new ChromeDriver();
        }

        public <T extends MutableCapabilities> WebDriver create(T options) {
            final ChromeOptions opt = new ChromeOptions().merge(options);
            return new ChromeDriver(opt);
        }

        public void setup() {
            WebDriverManager.chromedriver().setup();
        }
    },
    FIREFOX {
        public WebDriver create() {
            return new FirefoxDriver();
        }

        public <T extends MutableCapabilities> WebDriver create(T options) {
            final FirefoxOptions opt = new FirefoxOptions().merge(options);
            return new FirefoxDriver(opt);
        }

        public void setup() {
            WebDriverManager.firefoxdriver().setup();
        }
    },
    EDGE {
        public WebDriver create() {
            return new EdgeDriver();
        }

        public <T extends MutableCapabilities> WebDriver create(T options) {
            final EdgeOptions opt = new EdgeOptions().merge(options);
            return new EdgeDriver(opt);
        }

        public void setup() {
            WebDriverManager.edgedriver().setup();
        }
    },
    OPERA {
        public WebDriver create() {
            return new OperaDriver();
        }

        public <T extends MutableCapabilities> WebDriver create(T options) {
            final OperaOptions opt = new OperaOptions().merge(options);
            return new OperaDriver(opt);
        }

        public void setup() {
            WebDriverManager.operadriver().setup();
        }

    };

    public abstract WebDriver create();

    public abstract <T extends MutableCapabilities> WebDriver create(T options);

    public abstract void setup();

}
