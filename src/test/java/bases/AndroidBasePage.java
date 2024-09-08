package bases;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidBasePage {
    protected AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement androidElement;

    public AndroidBasePage(AndroidDriver<AndroidElement> androidDriver) {
        this.androidDriver = androidDriver;
    }

    public static AndroidDriver<AndroidElement> appiumStart() throws Exception {
        AppiumDriverLocalService service;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        // Appium Capabilities
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.saucelabs.mydemoapp.android");
        desiredCapabilities.setCapability("appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
        desiredCapabilities.setCapability("noReset", true);

        // Start Appium Local Service
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        service = AppiumDriverLocalService.buildService(serviceBuilder.usingAnyFreePort());
        service.start();

        String serviceUrl = service.getUrl().toString();
        System.out.println("Appium Service Address: " + serviceUrl);

        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<>(new URL(serviceUrl), desiredCapabilities);
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return androidDriver;
    }

    public AndroidBasePage waitForElement(By by, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(androidDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return this;
    }

    public AndroidBasePage check(By by) {
        this.androidElement = androidDriver.findElement(by);
        return this;
    }

    public AndroidBasePage click(By by) {
        check(by).androidElement.click();
        return this;
    }

    public AndroidBasePage sendKeys(By by, String text) {
        check(by).androidElement.sendKeys(text);
        return this;
    }

    public String getText(By by) {
        check(by);
        return androidElement.getText();
    }

    public AndroidBasePage assertText(By by, String expectedText) {
        String actualText = getText(by);
        Assert.assertEquals(actualText, expectedText);
        return this;
    }

    public AndroidBasePage scrollToElementByTextAndID(String text, String id) {
        androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text + "\"))"
        ));
        androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceIdMatches(\".*" + id + "\"))"
        ));
        return this;
    }
    public AndroidBasePage scrollToElementByID(String id ) {
        androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceIdMatches(\".*" + id + "\"))"
        ));
        return this;
    }
}

