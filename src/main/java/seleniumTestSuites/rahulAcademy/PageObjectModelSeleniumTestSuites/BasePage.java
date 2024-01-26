package seleniumTestSuites.rahulAcademy.PageObjectModelSeleniumTestSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumTestSuites.ConfiguredWebDrivers.DefaultChromeWebDriver;

public abstract class BasePage {
    protected ChromeDriver driver;

    public BasePage() {
        this.driver = DefaultChromeWebDriver.initializeChromeDriver();
    }

    public BasePage(ChromeDriver driver) {
        this.driver = driver;
    }


}
