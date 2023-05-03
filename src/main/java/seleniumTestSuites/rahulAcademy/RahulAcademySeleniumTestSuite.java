package seleniumTestSuites.rahulAcademy;

import seleniumTestSuites.SeleniumTestSuite;

/**
 * This abstract class was created to be extended for test suites that interact with the websites for the Udemy class "Selenium WebDriver with Java -Basics to Advanced+Frameworks" by Rahul Shetty.
 */
public abstract class RahulAcademySeleniumTestSuite extends SeleniumTestSuite {

    protected static final String INCORRECT_PASSWORD_MESSAGE = "* Incorrect username or password";
    protected static final String FORGOT_PASSWORD_MESSAGE = "Please use temporary password 'rahulshettyacademy' to Login.";
    protected static final String RAHULSHETTYACADEMY_COM_DROPDOWNS_PRACTISE = "https://rahulshettyacademy.com/dropdownsPractise/";
    protected final static String RAHUL_ACADEMY_URL = "https://rahulshettyacademy.com/";

}
