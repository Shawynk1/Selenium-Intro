package seleniumTestSuites.ConfiguredWebDrivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public final class DefaultChromeWebDriver {
    private static Properties loadChromeWebDriverProperties() {
        try {
            Properties chromeWebdriverProperties = new Properties();
            FileReader testSuitePropertiesFile = new FileReader("src/main/resources/chromeWebdriver");
            chromeWebdriverProperties.load(testSuitePropertiesFile);
            testSuitePropertiesFile.close();
            return chromeWebdriverProperties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ChromeDriver initializeChromeDriver() {
        return initializeChromeDriver(Duration.ofSeconds(5));
    }

    public static ChromeDriver initializeChromeDriver(Duration implicitWait) {
        Properties chromeWebdriverProperties = loadChromeWebDriverProperties();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=" + chromeWebdriverProperties.getProperty("--remote-allow-origins"));

        System.out.println(chromeWebdriverProperties.getProperty("webdriver.chrome.driver"));
        System.setProperty("webdriver.chrome.driver", chromeWebdriverProperties.getProperty("webdriver.chrome.driver"));
        ChromeDriver newChromeDriver = new ChromeDriver(options);
        newChromeDriver.manage().timeouts().implicitlyWait(implicitWait);
        newChromeDriver.manage().window().maximize();
        return newChromeDriver;
    }
}
