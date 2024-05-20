WebElement retailerName = new WebDriverWait(driver, Duration.ofSeconds(30)).
until(ExpectedConditions.visibilityOfElementLocated(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains("text here").instance(0))")));
retailerName.click(); //scroll down to the element and click


DesiredCapabilities - 
It refer to the combination of "key-value pairs". It decides which plateform, device, version and application its run/create session. 


================= Appium Setup ================= 


1. Download and install Java (JDK) and set a path of JDK and bin folder

Environment setup of Java ---->
Go to this PC and right click >> "Advanced system settings" >> "Environment Variables" >> New (System Variables) >> 

Variable name: JAVA_HOME   
Variable value: JDK path (C:\Program Files\Java\jdk1.8.0_202)
click "OK"

Find variable's "Path" and select & click "Edit" then "New" and paste "bin" path (C:\Program Files\Java\jdk1.8.0_202\bin)

--> Run cmd: java -version (check successfully installed?)

2. Download and install Node.js(LTS)

--> Run cmd: node --version (check successfully installed?)

--> Run cmd: npm --version (check successfully installed?)

3. Install Appium

--> Run cmd: npm install -g appium (install)

--> Run cmd: appium -v (check successfully installed?)

4. Download and install Android studio for SDK and set up SDK & SDK's platform-tools and tools 

Environment setup of Android ---->
Go to this PC and right click >> "Advanced system settings" >> "Environment Variables" >> New (System Variables) >> 

Variable name: ANDRIOD_HOME   
Variable value: JDK path (C:\Users\Asus\AppData\Local\Android\Sdk) [find it from android studio]
click "OK"

Find variable's "Path" and select & click "Edit" then "New" and paste "platform-tools" path (C:\Users\Asus\AppData\Local\Android\Sdk\platform-tools)

Find variable's "Path" and select & click "Edit" then "New" and paste "tools" path (C:\Users\Asus\AppData\Local\Android\Sdk\tools)

Run cmd: adb (check successfully setup?)

Run cmd: adb --version(check successfully setup?)

5. Download and install "Appium GUI (From Github)" & "Appium Studio" or "Appium Inspector" 

 
6. Connect your mobile with pc (must be do "developer mode" on and "usb debugging" enable & ["Disable permission monitoring" enable] from your mobile)

--> Run cmd: adb devices (find UDID)

7. For "Package and activity" name 

--> Run cmd: adb shell 

--> Run cmd: dumpsys window | grep -E "mCurrentFocus|mFocusedApp"  [Search Google "mfocus adb"]

* Search "Pointer Location" from your mobile for "TouchAction" point
 
* Download "Vysor.exe" for mobile display's show in laptop

**Session Not created exception [Original error: The instrumentation process cannot be initialized]

Run cmd: adb uninstall io.appium.settings

adb uninstall io.appium.uiautomator2.server

adb uninstall io.appium.uiautomator2.server.test

 
