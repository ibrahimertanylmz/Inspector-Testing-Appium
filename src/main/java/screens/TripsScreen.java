package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TripsScreen extends screens.PhoneLookupScreen{
    public TripsScreen(AppiumDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void selectTripsItem(int element){
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView["+element+"]/android.view.ViewGroup");
        el1.click();
    }

}
