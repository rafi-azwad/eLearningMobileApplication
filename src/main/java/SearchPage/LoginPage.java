package SearchPage;


import Core.AppHelper;
import Core.ReadFromXL;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;


public class LoginPage {
    public static AndroidDriver driver;
    public LoginPage(AndroidDriver driver){

        this.driver = driver;
    }


    public static void loginPage()  {
        driver = AppHelper.appAutomation();
    }
    public static void userInformation(String userid, String password) {

            WebElement userID = new WebDriverWait(driver, Duration.ofSeconds(15)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
            userID.click();
            userID.sendKeys(userid);

            WebElement pass = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            pass.click();
            pass.sendKeys(password);

            WebElement visiblePassword = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@index='0']")));
            visiblePassword.click();

    }
    public static void userInformationFromXL() {
        for (int i = 0; i <= 5; i++) {

            loginPage();
            WebElement userID = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
            userID.click();
            userID.sendKeys(ReadFromXL.ReadData(i)); //ReadFromXL.ReadData(0)

            WebElement pass = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='2']")));
            pass.click();
            pass.sendKeys(ReadFromXL.ReadData(i=i+1)); //ReadFromXL.ReadData(1)


           /* WebElement visiblePassword = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@index='0']")));
            visiblePassword.click();*/

            clickLogin();
            getSuccessfulMsg();
            ExamPage.selectMonthlyQuiz();
            ExamPage.selectQaTesting();
            ExamPage.examQuestion();
            ExamPage.submit();
            driver.quit();
        }

    }
    public static void clickLogin() {

        WebElement rememberMe = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Remember Me']")));
        rememberMe.click();

        WebElement login = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Login']")));
        login.click();

    }

    public static void getSuccessfulMsg() {

        String expect = "Dashboard";
        WebElement dashboard = new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Dashboard']")));
        String actual = dashboard.getAttribute("content-desc");

        Assert.assertEquals(actual, expect,"failed to login");

        System.out.println("Successfully login to home page ");

    }

}
