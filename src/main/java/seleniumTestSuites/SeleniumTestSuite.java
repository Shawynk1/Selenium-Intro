package seleniumTestSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * This abstract class TestSuite is the parent class of all the Selenium test suites in this package and sub packages.
 */
public abstract class SeleniumTestSuite {

    private Properties loadChromeWebDriverProperties() {
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

    protected boolean checkCurrentURL(String expectedURL, WebDriver driver) {
        return driver.getCurrentUrl().equals(expectedURL);
    }

    protected boolean setWebDriverURL(String URL, WebDriver driver) {
        driver.get(URL);
        return checkCurrentURL(URL, driver);
    }

    protected ChromeDriver initializeChromeDriver() {
        return initializeChromeDriver(Duration.ofSeconds(5));
    }

    protected ChromeDriver initializeChromeDriver(Duration implicitWait) {
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
