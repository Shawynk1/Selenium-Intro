public class IntroSelenium {
    public static void main(String[] args) {
        RahulAcademySeleniumIntroductionTestCases rahulAcademySeleniumTestCases = new RahulAcademySeleniumIntroductionTestCases();
        try {
            //System.out.println("passwordErrorMessageTestCase " + rahulAcademySeleniumTestCases.passwordErrorMessageInChromeTestCase());
            System.out.println("Test Case 2 " + rahulAcademySeleniumTestCases.testCase2());
        } catch (Exception e) {
            e.printStackTrace();
        }
        rahulAcademySeleniumTestCases.close();
    }
}
