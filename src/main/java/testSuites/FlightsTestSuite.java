package testSuites;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class FlightsTestSuite extends TestSuite {

    @Test
    public void searchForFlightTestCase() {
        int numberOfAdults = 3;
        int numberOfChildren = 2;
        int numberOfInfants = 1;

        ChromeDriver chromeDriver = initializeChromeDriver();

        try {
            setWebDriverURL("https://rahulshettyacademy.com/dropdownsPractise/", chromeDriver);

            new WebDriverWait(chromeDriver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_originStation1_CTXT")));
            chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
            chromeDriver.findElement(By.xpath("//a[@value='BLR']")).click();

            new WebDriverWait(chromeDriver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"]")));
            chromeDriver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
            chromeDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

            new WebDriverWait(chromeDriver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.id("ui-datepicker-div")));
            chromeDriver.findElement(By.id("ui-datepicker-div")).click();

            new WebDriverWait(chromeDriver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"] //a[contains(@class,'ui-state-default ui-state-highlight')]")));
            chromeDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"] //a[contains(@class,'ui-state-default ui-state-highlight')]")).click();

            chromeDriver.findElement(By.id("divpaxinfo")).click();
            for (int i = 1; i < numberOfAdults; i++) chromeDriver.findElement(By.id("hrefIncAdt")).click();
            for (int i = 0; i < numberOfChildren; i++) chromeDriver.findElement(By.id("hrefIncChd")).click();
            for (int i = 0; i < numberOfInfants; i++) chromeDriver.findElement(By.id("hrefIncInf")).click();
            chromeDriver.findElement(By.id("btnclosepaxoption")).click();

            Select currency = new Select(chromeDriver.findElement(By.name("ctl00$mainContent$DropDownListCurrency")));
            currency.selectByValue("USD");
            chromeDriver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
            System.out.println();
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
