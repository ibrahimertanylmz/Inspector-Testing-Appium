package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeviceListScreen extends screens.PhoneLookupScreen{

    public DeviceListScreen(AppiumDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void listPairedDevices (){
        MobileElement el1 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/item_device_name_tv");
        el1.click();
    }
}
