package com.automation.v1.BaseClass;

import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static Properties prop;

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeTest
    public void ConfigSetup() {

        try {

            prop = new Properties();

            FileInputStream fis = new FileInputStream(
                    "C:\\Users\\Ashish\\eclipse-workspace\\Java\\com.automation.v1\\src\\test\\resources\\config.properties");

            prop.load(fis);

        } catch (Exception e) {

            System.out.println("File Upload error " + e.getMessage());
        }
    }

    @BeforeMethod
    @Parameters("browser")
    public void browserSetup(String br) throws IOException, MalformedURLException {

        String env = prop.getProperty("execution_env");

        if (br.equalsIgnoreCase("Chrome")) {

            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--incognito");
            opt.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

            if (env.equalsIgnoreCase("remote")) {

                driver.set(new RemoteWebDriver(
                        new URL("http://localhost:4444"),
                        opt));

            } else {

                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(opt));
            }
        }

        else if (br.equalsIgnoreCase("Edge")) {

            EdgeOptions opt = new EdgeOptions();
            opt.addArguments("--incognito");

            if (env.equalsIgnoreCase("remote")) {

                driver.set(new RemoteWebDriver(
                        new URL("http://localhost:4444"),
                        opt));

            } else {

                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver(opt));
            }
        }

        else if (br.equalsIgnoreCase("Firefox")) {

            FirefoxOptions opt = new FirefoxOptions();

            if (env.equalsIgnoreCase("remote")) {

                driver.set(new RemoteWebDriver(
                        new URL("http://localhost:4444"),
                        opt));

            } else {

                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver(opt));
            }
        }

        else {

            throw new IllegalArgumentException("Incorrect Browser");
        }

        getDriver().manage().window().maximize();

        getDriver().manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Long.parseLong(prop.getProperty("implicitWait"))));

        getDriver().get(prop.getProperty("url"));
    }

    @AfterMethod
    public void KillBrowser() {

        getDriver().quit();
        driver.remove();
    }
}