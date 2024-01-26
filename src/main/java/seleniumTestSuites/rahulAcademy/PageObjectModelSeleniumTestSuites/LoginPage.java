package seleniumTestSuites.rahulAcademy.PageObjectModelSeleniumTestSuites;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BasePage {
    private final String TITLE_OF_LOGIN_PAGE = "Rahul Shetty Academy - Login page";

    private By usernameBy = By.id("inputUsername");
    private By passwordBy = By.name("inputPassword");
    private By loginBy = By.className("signInBtn");

    public LoginPage() {
        super();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        initialize();
    }

    public LoginPage(ChromeDriver driver) {
        super(driver);
        initialize();
    }

    protected boolean checkCurrentURL(String expectedURL) {
        return driver.getCurrentUrl().equals(expectedURL);
    }

    protected boolean setWebDriverURL(String URL) {
        driver.get(URL);
        return checkCurrentURL(URL);
    }

    private void initialize() {
        if (!checkCurrentURL(TITLE_OF_LOGIN_PAGE)) throw new IllegalStateException("This is not the Login Page, this page is the \"" + driver.getCurrentUrl());
    }

    public HomePage loginValidUser(String userName, String password) {
        throw new UnsupportedOperationException("Not implemented.");
        //return new HomePage(driver);
    }
}
