import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class IntroSelenium {
    public static void main(String[] args) {
        RahulAcademySeleniumTestCases rahulAcademySeleniumTestCases = new RahulAcademySeleniumTestCases();
        try {
            System.out.println("passwordErrorMessageTestCase " + rahulAcademySeleniumTestCases.passwordErrorMessageTestCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        rahulAcademySeleniumTestCases.close();
    }
}
