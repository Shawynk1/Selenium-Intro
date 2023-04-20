import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class IntroSelenium {


    private static Properties testSuiteProperties = new Properties();
    private static void loadInitialGeneralProperties() {
        try {
            FileReader testSuitePropertiesFile = new FileReader("src/main/resources/chromeWebdriver");
            testSuiteProperties.load(testSuitePropertiesFile);
            testSuitePropertiesFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(testSuiteProperties.getProperty("--remote-allow-origins"));
    }




    public static void main(String[] args) {

        loadInitialGeneralProperties();

        /*RahulAcademySeleniumIntroductionTestCases rahulAcademySeleniumTestCases = new RahulAcademySeleniumIntroductionTestCases();
        try {
            System.out.println("passwordErrorMessageTestCase " + rahulAcademySeleniumTestCases.passwordErrorMessageInChromeTestCase());

        } catch (Exception e) {
            System.out.println("\nException occurred!\n\nMessage:\n" + e.getMessage() + "\n\nTo String:\n" + e.toString() + "\n\n");
            e.printStackTrace();
            System.out.println("\n");
        }

        try {

            System.out.println("Test Case 2: " + rahulAcademySeleniumTestCases.testCase2());

        } catch (Exception e) {
            System.out.println("\nException occurred!\n\nMessage:\n" + e.getMessage() + "\n\nTo String:\n" + e.toString() + "\n\n");
            e.printStackTrace();
            System.out.println("\n");
        }

        try {
            System.out.println("Dynamic dropdown test case: " + rahulAcademySeleniumTestCases.dynamicDropDownTestCase());

        } catch (Exception e) {
            System.out.println("\nException occurred!\n\nMessage:\n" + e.getMessage() + "\n\nTo String:\n" + e.toString() + "\n\n");
            e.printStackTrace();
            System.out.println("\n");
        }

        rahulAcademySeleniumTestCases.close();*/
    }
}
