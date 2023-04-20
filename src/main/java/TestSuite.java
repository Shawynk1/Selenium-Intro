import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class TestSuite {
    protected final static String rahulAcademyURL = "https://rahulshettyacademy.com/";
    protected ChromeDriver chromeDriver = null;
    protected Properties chromeWebdriverProperties = new Properties();

    TestSuite() { initialization(); }

    private void loadInitialGeneralProperties() {
        try {
            FileReader testSuitePropertiesFile = new FileReader("src/main/resources/chromeWebdriver");
            chromeWebdriverProperties.load(testSuitePropertiesFile);
            testSuitePropertiesFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialization() {
        loadInitialGeneralProperties();
        chromeDriver = initializeChromeDriver();
    }

    protected boolean checkCurrentURL(String expectedURL, WebDriver driver) {
        return driver.getCurrentUrl().equals(expectedURL);
    }

    protected boolean setWebDriverURL(String URL, WebDriver driver) {
        driver.get(URL);
        return checkCurrentURL(URL, driver);
    }

    protected ChromeDriver initializeChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=" + chromeWebdriverProperties.getProperty("--remote-allow-origins"));

        System.out.println(chromeWebdriverProperties.getProperty("webdriver.chrome.driver"));
        System.setProperty("webdriver.chrome.driver", chromeWebdriverProperties.getProperty("webdriver.chrome.driver"));
        ChromeDriver newChromeDriver = new ChromeDriver(options);
        newChromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return newChromeDriver;
    }

    public boolean close() {
        chromeDriver.quit();
        return true;
    }
}
