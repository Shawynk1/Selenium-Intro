public class IntroSelenium {
    public static void main(String[] args) {
        RahulAcademySeleniumIntroductionTestCases rahulAcademySeleniumTestCases = new RahulAcademySeleniumIntroductionTestCases();
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

        rahulAcademySeleniumTestCases.close();
    }
}
