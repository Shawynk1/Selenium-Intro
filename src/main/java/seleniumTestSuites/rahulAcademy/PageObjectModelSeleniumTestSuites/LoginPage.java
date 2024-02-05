package seleniumTestSuites.rahulAcademy.PageObjectModelSeleniumTestSuites;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BasePage {
    private final String TITLE_OF_LOGIN_PAGE = "Rahul Shetty Academy - Login page";
    private final String URL_OF_LOGIN_PAGE = "https://rahulshettyacademy.com/locatorspractice/";

    private final String USERNAME = "rahul";
    private final String PASSWORD = "rahulshettyacademy";

    private By usernameBy = By.id("inputUsername");
    private By passwordBy = By.name("inputPassword");
    private By loginBy = By.className("signInBtn");
    private By welcomeText = By.xpath("/html/body/div/div/div/div/h2");

    public LoginPage() {
        super();
        chromeDriver.get(URL_OF_LOGIN_PAGE);
        initialize();
    }

    public LoginPage(ChromeDriver driver) {
        super(driver);
        initialize();
    }

    protected boolean checkCurrentURL(String expectedURL) {
        return chromeDriver.getCurrentUrl().equals(expectedURL);
    }

    protected boolean setWebDriverURL(String URL) {
        chromeDriver.get(URL);
        return checkCurrentURL(URL);
    }

    private void initialize() {
        if (!checkCurrentURL(TITLE_OF_LOGIN_PAGE)) throw new IllegalStateException("This is not the Login Page, this page is the \"" + chromeDriver.getCurrentUrl());
    }

    public HomePage loginValidUser(String userName, String password) throws IllegalAccessException {
        chromeDriver.findElement(usernameBy).sendKeys(USERNAME);
        chromeDriver.findElement(passwordBy).sendKeys(PASSWORD);
        chromeDriver.findElement(loginBy).click();
        if (chromeDriver.findElement(welcomeText).getText().equals("Hello " + userName + ",")) return new HomePage(chromeDriver);
        else throw new IllegalAccessException();
    }
}
