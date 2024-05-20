package ELearningStepDefinition;

import Core.AppHelper;
import Core.ReadFromXL;
import SearchPage.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.MalformedURLException;
public class LoginStepDefinition {

    public static AndroidDriver driver;
    LoginPage el;
    @Given("user on login page")
    public void userOnLoginPage() {
       // driver = AppHelper.appAutomation();
        el = new LoginPage(driver);
       // el.loginPage();
    }

   /* @When("user enter userid {string} and password {string}")
    public void userEnterUseridAndPassword(String userid, String password) {
        el = new LoginPage(driver);
        el.userInformation(userid, password);


    }
*/
   @When("user enter userid and password from XL file")
   public void userEnterUseridAndPasswordFromXLFile() {
       el.userInformationFromXL();
   }

    @And("click on login button")
    public void clickOnLoginButton() {
        //el.clickLogin();
        System.out.println("Successfully click");
    }

    @Then("successfully login to the dashboard")
    public void successfullyLoginToTheDashboard() {

        //el.getSuccessfulMsg();
        System.out.println("Successfully login");
    }


}

