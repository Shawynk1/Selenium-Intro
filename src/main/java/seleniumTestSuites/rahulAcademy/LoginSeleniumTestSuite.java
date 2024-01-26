package seleniumTestSuites.rahulAcademy;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import seleniumTestSuites.ConfiguredWebDrivers.DefaultChromeWebDriver;

import java.time.Duration;

/**
 * The FlightsTestSuite class is for practicing writing test cases using Selenium and element ids on websites.
 */
public class LoginSeleniumTestSuite extends RahulAcademySeleniumTestSuite {

    @Test
    public void passwordErrorMessageInChromeTestCase() {

        ChromeDriver chromeDriver = DefaultChromeWebDriver.initializeChromeDriver();

        try {

            setWebDriverURL("https://rahulshettyacademy.com/locatorspractice/", chromeDriver);
            chromeDriver.findElement(By.id("inputUsername")).sendKeys("rahul");
            chromeDriver.findElement(By.name("inputPassword")).sendKeys("INCORRECTPASSWORD");
            chromeDriver.findElement(By.className("signInBtn")).click();

            //return chromeDriver.findElement(By.cssSelector("p.error")).getText().equals(incorrectPasswordMessage);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                Assert.isTrue(chromeDriver.findElement(By.cssSelector("p.error")).getText().equals(INCORRECT_PASSWORD_MESSAGE), "Error message is not correct.");
            } catch (Exception e) {
                throw e;
            } finally {
                chromeDriver.close();
            }
        }
    } // passwordErrorMessageTestCase

    @Test
    public void forgotPasswordInChromeTestCase() {
        ChromeDriver chromeDriver = DefaultChromeWebDriver.initializeChromeDriver();
        try {

            setWebDriverURL("https://rahulshettyacademy.com/locatorspractice/", chromeDriver);
            chromeDriver.findElement(By.linkText("Forgot your password?")).click();
            WebElement firstResult = new WebDriverWait(chromeDriver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.className("reset-pwd-btn")));
            chromeDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("NewTestUser");
            chromeDriver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("newTestUser12345@test.test");
            chromeDriver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("234-567-8901");
            chromeDriver.findElement(By.className("reset-pwd-btn")).click();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {

                Assert.isTrue(chromeDriver.findElement(By.className("infoMsg")).getText().equals(FORGOT_PASSWORD_MESSAGE), "Forgot Password message is not correct.");

            } catch (Exception e) {
                throw e;
            } finally {
                chromeDriver.close();
            }
        }
    }
}
