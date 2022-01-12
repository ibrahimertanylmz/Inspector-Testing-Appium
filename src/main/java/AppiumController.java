


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppiumController {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public String appPackage;
    public String appActivity;
    public String appWaitActivity;

    public void startAppium() throws Exception {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        //desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"CT40");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("appPackage",appPackage);
        desiredCapabilities.setCapability("appActivity",appActivity);
        desiredCapabilities.setCapability("appWaitActivity",appWaitActivity);
        desiredCapabilities.setCapability("noReset",true);

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //if element could not found, wait up to 30 seconds until its clickable
    }
}