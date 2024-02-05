package seleniumTestSuites.rahulAcademy.PageObjectModelSeleniumTestSuites;

import org.testng.annotations.Test;
import seleniumTestSuites.rahulAcademy.RahulAcademySeleniumTestSuite;

public class PageObjectModelSeleniumTestSuite extends RahulAcademySeleniumTestSuite {
    @Test
    public void homePageTest() {
        LoginPage loginPage = new LoginPage();
        try {
            HomePage homePage = loginPage.loginValidUser("rahul", "rahulshettyacademy");
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
