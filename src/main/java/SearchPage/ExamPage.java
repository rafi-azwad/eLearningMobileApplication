package SearchPage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static SearchPage.LoginPage.driver;

public class ExamPage {

/*    public static AndroidDriver driver;

    public ExamPage(AndroidDriver driver) {
        this.driver = driver;
    }*/

    public static void selectMonthlyQuiz() {
        WebElement monthlyQuiz = new WebDriverWait(driver, Duration.ofSeconds(30)).   //login driver
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"Monthly Quiz\n" +
                        "0\"]")));
        monthlyQuiz.click();
    }

    public static void selectQaTesting() {
        WebElement qaTesting = new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='QA Testing']")));
        qaTesting.click();

        try {
            WebElement download = new WebDriverWait(driver, Duration.ofSeconds(3)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@content-desc='Download']")));
            download.click();
        } catch (Exception e) {
            System.out.println("Download button not found: " + e);
        }

        try {
            WebElement attendNow = new WebDriverWait(driver, Duration.ofSeconds(3)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@content-desc='Attend Now']")));
            attendNow.click();
        } catch (Exception e) {
            System.out.println("Attend Now Not Found: " + e);
        }
    }

    public static void examQuestion() {

        String q1 = "What do you like to do in your leisure time?";
        String q2 = "Are you married?";
        String q3 = "What is your favorite color?";

        String wq1 = "";
        String wq2 = "";
        String wq3 = "";

        for(int i=0; i<3; i++){

        try {
            WebElement ques1 = new WebDriverWait(driver, Duration.ofSeconds(6)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='What do you like to do in your leisure time?']")));
            wq1 = ques1.getAttribute("content-desc");
            System.out.println(wq1);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            WebElement ques2 = new WebDriverWait(driver, Duration.ofSeconds(2)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Are you married?']")));
            wq2 = ques2.getAttribute("content-desc");
            System.out.println(wq2);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            WebElement ques3 = new WebDriverWait(driver, Duration.ofSeconds(2)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='What is your favorite color?']")));
            wq3 = ques3.getAttribute("content-desc");
            System.out.println(wq3);
        }
        catch (Exception e){
            System.out.println(e);
        }

            if(q1.equals(wq1)) {
                WebElement question1 = new WebDriverWait(driver, Duration.ofSeconds(10)).
                        until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Sleeping')]")));
                question1.click();
                wq1 = wq1+"1";
            }

            else if(q2.equals(wq2)){
                WebElement question2 = new WebDriverWait(driver, Duration.ofSeconds(10)).
                        until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'No')]")));
                question2.click();
                wq2 = wq2+"1";
            }

            else if(q3.equals(wq3)){
                WebElement question3 = new WebDriverWait(driver, Duration.ofSeconds(10)).
                        until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Green')]")));
                question3.click();
                wq3 = wq3+"1";
            }

            WebElement next = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Next']")));
            next.click();
            }

        }

    public static void submit() {
        WebElement submit = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Submit']")));
        submit.click();

        WebElement yes = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Yes']")));
        yes.click();

    }

}