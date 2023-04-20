import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTestSuite extends TestSuite {


    private final static String incorrectPasswordMessage = "* Incorrect username or password";

    @Test
    public void passwordErrorMessageInChromeTestCase() {

        try {

            setWebDriverURL("https://rahulshettyacademy.com/locatorspractice/", chromeDriver);
            chromeDriver.findElement(By.id("inputUsername")).sendKeys("rahul");
            chromeDriver.findElement(By.name("inputPassword")).sendKeys("INCORRECTPASSWORD");
            chromeDriver.findElement(By.className("signInBtn")).click();

            //return chromeDriver.findElement(By.cssSelector("p.error")).getText().equals(incorrectPasswordMessage);

        } catch (Exception e) {

            e.printStackTrace();

        } // try catch

        Assert.isTrue(chromeDriver.findElement(By.cssSelector("p.error")).getText().equals(incorrectPasswordMessage), "Error message is not correct.");

    } // passwordErrorMessageTestCase
}
