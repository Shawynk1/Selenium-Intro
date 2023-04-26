package testSuites;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FlightsTestSuite extends TestSuite {

    @Test
    public void bookFlightTestCase() {
        ChromeDriver chromeDriver = initializeChromeDriver();

        try {
            setWebDriverURL("https://rahulshettyacademy.com/dropdownsPractise/", chromeDriver);

            new WebDriverWait(chromeDriver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_originStation1_CTXT")));
            chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
            chromeDriver.findElement(By.xpath("//a[@value='BLR']")).click();

            new WebDriverWait(chromeDriver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"]")));
            chromeDriver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
            chromeDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
            Thread.sleep(10000);
            //*[@id="ctl00_mainContent_view_date1"]
        } catch (Exception e) {

            e.printStackTrace();

        } // try catch

        try {

            //Assert.isTrue(false, "Assert not implemented.");

        } catch (Exception e) {
            throw e;
        } finally {
            chromeDriver.close();
        }
    }
}
