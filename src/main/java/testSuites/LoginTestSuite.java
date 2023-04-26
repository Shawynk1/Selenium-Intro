package testSuites;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestSuite extends TestSuite {

    private final static String INCORRECT_PASSWORD_MESSAGE = "* Incorrect username or password";
    private final static String FORGOT_PASSWORD_MESSAGE = "Please use temporary password 'rahulshettyacademy' to Login.";

    @Test
    public void passwordErrorMessageInChromeTestCase() {

        ChromeDriver chromeDriver = initializeChromeDriver();

        try {

            setWebDriverURL("https://rahulshettyacademy.com/locatorspractice/", chromeDriver);
            chromeDriver.findElement(By.id("inputUsername")).sendKeys("rahul");
            chromeDriver.findElement(By.name("inputPassword")).sendKeys("INCORRECTPASSWORD");
            chromeDriver.findElement(By.className("signInBtn")).click();

            //return chromeDriver.findElement(By.cssSelector("p.error")).getText().equals(incorrectPasswordMessage);

        } catch (Exception e) {

            e.printStackTrace();

        } // try catch

        try {
            Assert.isTrue(chromeDriver.findElement(By.cssSelector("p.error")).getText().equals(INCORRECT_PASSWORD_MESSAGE), "Error message is not correct.");
        } catch (Exception e) {
            throw e;
        } finally {
            chromeDriver.close();
        }
    } // passwordErrorMessageTestCase

    @Test
    public void forgotPasswordInChromeTestCase() {
        ChromeDriver chromeDriver = initializeChromeDriver();

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

        } // try catch

        try {

            Assert.isTrue(chromeDriver.findElement(By.className("infoMsg")).getText().equals(FORGOT_PASSWORD_MESSAGE), "Forgot Password message is not correct.");

        } catch (Exception e) {
            throw e;
        } finally {
            chromeDriver.close();
        }
    }

}
