import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.naming.ldap.PagedResultsControl;
import javax.print.DocFlavor;
import java.time.Duration;

public class RahulAcademySeleniumTestCases {
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

    RahulAcademySeleniumTestCases() {
        initialization();
    }

    private boolean checkCurrentURLInChrome(String expectedURL) {
        return chromeDriver.getCurrentUrl().equals(expectedURL);
    }

    private boolean setChromeURL(String URL) {
        chromeDriver.get(URL);
        return checkCurrentURLInChrome(URL);
    }

    private boolean resetChromeDriver() {
        return setChromeURL(rahulAcademyURL);
    }

    private boolean initializeTestCase() {
        return resetChromeDriver();
    }

    public boolean close() {
        chromeDriver.quit();
        return true;
    }

    public boolean passwordErrorMessageTestCase() {
        try {
            if (!initializeTestCase()) return false;
            if (!setChromeURL("https://rahulshettyacademy.com/locatorspractice/")) return false;
            chromeDriver.findElement(By.id("inputUsername")).sendKeys("rahul");
            chromeDriver.findElement(By.name("inputPassword")).sendKeys("INCORRECTPASSWORD");
            chromeDriver.findElement(By.className("signInBtn")).click();
            return chromeDriver.findElement(By.cssSelector("p.error")).getText().equals(incorrectPasswordMessage);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return false;
        }
    }
}
