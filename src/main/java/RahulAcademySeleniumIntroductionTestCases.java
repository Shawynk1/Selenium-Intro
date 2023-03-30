import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class RahulAcademySeleniumIntroductionTestCases {
    private final static String rahulAcademyURL = "https://rahulshettyacademy.com/";
    private ChromeDriver chromeDriver = null;

    private final static String incorrectPasswordMessage = "* Incorrect username or password";

    private void initialization() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shawy\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    RahulAcademySeleniumIntroductionTestCases() {
        initialization();
    }

    private boolean checkCurrentURL(String expectedURL, WebDriver driver) {
        return driver.getCurrentUrl().equals(expectedURL);
    }

    private boolean setWebDriverURL(String URL, WebDriver driver) {
        driver.get(URL);
        return checkCurrentURL(URL, driver);
    }

    private boolean resetChromeDriver() {
        return setWebDriverURL(rahulAcademyURL, chromeDriver);
    }

    private boolean initializeTestCase() {
        return setWebDriverURL(rahulAcademyURL, chromeDriver);
    }

    public boolean close() {
        chromeDriver.quit();
        return true;
    }

    public boolean passwordErrorMessageInChromeTestCase() {

        try {

            if (!initializeTestCase()) return false;
            if (!setWebDriverURL("https://rahulshettyacademy.com/locatorspractice/", chromeDriver)) return false;
            chromeDriver.findElement(By.id("inputUsername")).sendKeys("rahul");
            chromeDriver.findElement(By.name("inputPassword")).sendKeys("INCORRECTPASSWORD");
            chromeDriver.findElement(By.className("signInBtn")).click();
            return chromeDriver.findElement(By.cssSelector("p.error")).getText().equals(incorrectPasswordMessage);

        } catch (Exception e) {

            e.printStackTrace();

        } // try catch

        return false;
    } // passwordErrorMessageTestCase

    private boolean testCase2() {
        return false;
    }

}
