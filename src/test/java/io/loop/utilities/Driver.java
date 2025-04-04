package io.loop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class Driver {

    private Driver() {
    }

    /*
    making driver instance private
    static - run before everything else and also use in static method
     */

    //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> drivePool = new InheritableThreadLocal<>();


    /*
    reusable method that will return the same driver instance every time called
     */

    /**
     * singleton pattern
     *
     * @return driver
     */
    public static WebDriver getDriver() {
        if (drivePool.get() == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    drivePool.set(new ChromeDriver());
                    drivePool.get().manage().window().maximize();
                    drivePool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperty("timeout"))));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    drivePool.set(new FirefoxDriver());
                    drivePool.get().manage().window().maximize();
                    drivePool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperty("timeout"))));
                    break;
                case "headless":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--start-maximized");
                    WebDriverManager.chromedriver().setup();
                    drivePool.set(new ChromeDriver(options));
                    drivePool.get().manage().window().maximize();
                    drivePool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperty("timeout"))));
                    break;
                case "remote-chrome-linux":
                    try {
                        // assign your grid server address
                        String gridAddress = "18.212.164.52";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--no-sandbox");
                        chromeOptions.addArguments("--disable-dev-shm-usage");
                        desiredCapabilities.merge(chromeOptions);
                        //Driver.getDriver() = new RemoteWebDriver(url, desiredCapabilities);
                        // driver = new RemoteWebDriver(url, desiredCapabilities);
                        drivePool.set(new RemoteWebDriver(url, desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

            }

        }
        return drivePool.get();
    }

    /**
     * closing driver
     */
    public static void closeDriver() {
        if (drivePool.get() != null) {
            drivePool.get().quit();
            drivePool.remove();
        }
    }
}

