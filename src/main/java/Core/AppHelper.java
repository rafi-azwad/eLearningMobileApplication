package Core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.encoders.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppHelper {

        public static AndroidDriver driver;
        public static final String userName = "rafiazwad_AnBEZR";
        public static final String automateKey = "csAwKKNTzqdApcKoVTs1";
        public static final String url = "https://" +userName+ ":" +automateKey+ "@hub-cloud.browserstack.com/wd/hub";


    public static AndroidDriver appAutomation() {

        try {
            //Android
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability(MobileCapabilityType.UDID, "R58TA0A316N");
            //dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-A047F");
            dc.setCapability("platformVersion", "13.0");
            dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "bd.com.squareit.saga");
            dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
            dc.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            Thread.sleep(2000);
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
            driver.startRecordingScreen();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driver;


        //BrowserStack
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("device", "Google Pixel 2");
//        capabilities.setCapability("os_version", "9.0");
//        capabilities.setCapability("project", "Login");
//        capabilities.setCapability("build", "5.1");
//        capabilities.setCapability("name", "Test");
//        capabilities.setCapability("app", "bs://d8f7ef89a47c053f1ed00342c5a331dd717ee73f");
//        Thread.sleep(10000);
//        driver = new AndroidDriver(new URL(url), capabilities);
//        return driver;

    }

    public static void stopRecording(){

        String projectHomeDirectory = System.getProperty("user.dir");
        String base64String = driver.stopRecordingScreen();
        byte [] data = Base64.decode(base64String);
        String destinationPath = projectHomeDirectory + "/build/videos";

        File theDir = new File(destinationPath);
        if(!theDir.exists()) {
            theDir.mkdir();
        }
        String filePath = destinationPath + "/" + driver.getDeviceTime().replace(":","_").replace("+","_") + ".mp4";
        System.out.println("Filepath " +filePath);

        Path path = Paths.get(filePath);
        try{
            Files.write(path, data);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        }

    public static <Stirng> void getScreenshot(Stirng methodName) {

        try {
            Thread.sleep(2000);
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/src/screenshots/";
            FileUtils.copyFile(scrFile, new File(currentDir + methodName + System.currentTimeMillis() + ".png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Thread.sleep(3000);
    }


}

