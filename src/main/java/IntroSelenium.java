public class IntroSelenium {
    public static void main(String[] args) {
        RahulAcademySeleniumIntroductionTestCases rahulAcademySeleniumTestCases = new RahulAcademySeleniumIntroductionTestCases();
        try {
            System.out.println("passwordErrorMessageTestCase " + rahulAcademySeleniumTestCases.passwordErrorMessageInChromeTestCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        rahulAcademySeleniumTestCases.close();
    }
}
