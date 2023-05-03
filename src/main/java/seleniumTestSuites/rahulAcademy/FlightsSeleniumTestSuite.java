package seleniumTestSuites.rahulAcademy;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * The FlightsTestSuite class is for practicing writing test cases using Selenium and drop-downs on websites.
 */
public class FlightsSeleniumTestSuite extends RahulAcademySeleniumTestSuite {

    @Test
    public void searchForFlightTestCase() {
        int numberOfAdults = 3;
        int numberOfChildren = 2;
        int numberOfInfants = 1;

        ChromeDriver chromeDriver = initializeChromeDriver();

        try {
            setWebDriverURL(RAHULSHETTYACADEMY_COM_DROPDOWNS_PRACTISE, chromeDriver);

            new WebDriverWait(chromeDriver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_originStation1_CTXT")));
            chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
            System.out.println();
            chromeDriver.findElement(By.xpath("//a[@value='BLR']")).click();

            System.out.println(chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"));

            new WebDriverWait(chromeDriver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"]")));
            chromeDriver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
            chromeDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

            new WebDriverWait(chromeDriver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"] //a[contains(@class,'ui-state-highlight')]")));
            chromeDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"] //a[contains(@class,'ui-state-highlight')]")).click();

            chromeDriver.findElement(By.id("divpaxinfo")).click();
            for (int i = 1; i < numberOfAdults; i++) chromeDriver.findElement(By.id("hrefIncAdt")).click();
            for (int i = 0; i < numberOfChildren; i++) chromeDriver.findElement(By.id("hrefIncChd")).click();
            for (int i = 0; i < numberOfInfants; i++) chromeDriver.findElement(By.id("hrefIncInf")).click();
            chromeDriver.findElement(By.id("btnclosepaxoption")).click();

            Select currency = new Select(chromeDriver.findElement(By.name("ctl00$mainContent$DropDownListCurrency")));
            currency.selectByValue("USD");
            chromeDriver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
            System.out.println();
        } finally {

            try {

                chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

                Assert.isTrue(chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value").isEmpty(), "Departure City was not cleared");

             } catch (Exception e) {
                throw e;
            } finally {
                chromeDriver.close();
            }
        }
    }
}
