import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

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

            //return chromeDriver.findElement(By.cssSelector("p.error")).getText().equals(incorrectPasswordMessage);

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        } // try catch

        Assert.isTrue(chromeDriver.findElement(By.cssSelector("p.error")).getText().equals(incorrectPasswordMessage), "Error message is not correct.");

        return true;
    } // passwordErrorMessageTestCase

    public boolean testCase2() {

        Select dropdown = null;

        if (!setWebDriverURL("https://rahulshettyacademy.com/dropdownsPractise/", chromeDriver)) return false;
        try {
            dropdown = new Select(chromeDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
            dropdown.selectByIndex(2);
            dropdown.selectByValue("USD");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        Assert.isTrue(dropdown.getFirstSelectedOption().getText().equals("USD"), "Dropdown selected is:\t" + dropdown.getFirstSelectedOption().getText());

        return true;
    }

    public boolean dynamicDropDownTestCase() throws InterruptedException {
        if (!setWebDriverURL("https://rahulshettyacademy.com/dropdownsPractise/", chromeDriver)) return false;
        chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        //chromeDriver.findElement(By.xpath("/html/body/form/div[4]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[3]/div/div[3]/div/div[1]/div[2]/div/table/tbody/tr[2]/td[2]/div[3]/div[1]/div/ul[1]/li[8]/a[@value='MAA']")).click();
        chromeDriver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        //chromeDriver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        chromeDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        Assert.isTrue(chromeDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).isSelected(), "MAA is not selected.");
        Thread.sleep(3000);
        
        return true;
    }
}
