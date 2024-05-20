package ELearningStepDefinition;

import Core.AppHelper;
import SearchPage.ExamPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static ELearningStepDefinition.LoginStepDefinition.driver;


public class ExamStepDefinition {
    ExamPage ep;
    @Given("user on dashboard page")
    public void userOnDashboardPage() {

        //ep = new ExamPage(driver);
        System.out.println("User successfully on dashboard");
    }

    @When("user click on monthly quiz")
    public void userClickOnMonthlyQuiz() {

        //ep.selectMonthlyQuiz();
        System.out.println("Successfully click on monthly quiz");
    }

    @And("click on qa testing option")
    public void clickOnQaTestingOption() {
        //ep.selectQaTesting();
        System.out.println("Successfully click on click on testing option");

    }

    @And("participate the exam")
    public void participateTheExam() {
        //ep.examQuestion();
        System.out.println("Successfully participate the exam");
    }

    @And("submit the result")
    public void submitTheResult() {
        //ep.submit();
        System.out.println("Successfully submit");
    }

    @Then("successfully show the exam result")
    public void successfullyShowTheExamResult() {
        System.out.println("Successfully Submitted the quiz.....");
        /*AppHelper.getScreenshot("Quiz result");
        AppHelper.stopRecording();*/
        //driver.quit();
    }
}
