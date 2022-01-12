package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class SearchTripsScreen extends screens.PhoneLookupScreen {

    public SearchTripsScreen(AppiumDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void startShifting (){

        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("More options");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("android:id/button1");
        el3.click();
    }

    public void searchTrips(){
        MobileElement el1 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/search_trips_boarding_tv");
        el1.click();

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.TextView");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/search_trips_landing_tv");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/search_trips_get_trips_btn");
        el5.click();
    }

    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }
}
