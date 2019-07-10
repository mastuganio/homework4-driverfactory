package com.mastugan.internal;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public enum Driver {
    CHROME {
        public WebDriver create() {
            return new ChromeDriver();
        }

        public <T extends MutableCapabilities> WebDriver create(T options) {
            return new ChromeDriver(options);
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
            return new FirefoxDriver(options);
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
            return new EdgeDriver(options);
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
            return new OperaDriver(options);
        }

        public void setup() {
            WebDriverManager.operadriver().setup();
        }
    };

    public abstract WebDriver create();

    public abstract <T extends MutableCapabilities> WebDriver create(T options);

    public abstract void setup();
}
