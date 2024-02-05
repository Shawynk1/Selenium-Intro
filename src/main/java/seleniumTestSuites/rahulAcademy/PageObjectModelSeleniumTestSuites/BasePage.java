package seleniumTestSuites.rahulAcademy.PageObjectModelSeleniumTestSuites;

import org.openqa.selenium.chrome.ChromeDriver;
import seleniumTestSuites.ConfiguredWebDrivers.DefaultChromeWebDriver;

public abstract class BasePage {
    protected ChromeDriver chromeDriver;

    public BasePage() {
        this.chromeDriver = DefaultChromeWebDriver.initializeChromeDriver();
    }

    public BasePage(ChromeDriver driver) {
        this.chromeDriver = driver;
    }


}
