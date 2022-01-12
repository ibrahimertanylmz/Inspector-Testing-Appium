package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen extends screens.PhoneLookupScreen {

    public LoginScreen(AppiumDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    public void login(String loginMail, String password){
        MobileElement el9 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/login_mail_edt");
        el9.sendKeys(loginMail);

        MobileElement el10 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/login_password_edt");
        el10.sendKeys(password);

        MobileElement el11 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/login_btn");
        el11.click();
    }

    public void registerDevice(String apiLocal, String apiServer){
        MobileElement el1 = (MobileElement) driver.findElementById("android:id/button1");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/config_btn");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/config_btn");
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/server_url_edt");
        el6.sendKeys(apiServer);

        MobileElement el7 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/local_url_edt");
        el7.sendKeys(apiLocal);

        MobileElement el8 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/config_save_btn");
        el8.click();

    }

    public void registerDeviceWithoutPermissions(String apiServer,String apiLocal){
        MobileElement el1 = (MobileElement) driver.findElementById("android:id/button1");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/config_btn");
        el2.click();

        MobileElement el6 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/server_url_edt");
        el6.sendKeys(apiServer);

        MobileElement el7 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/local_url_edt");
        el7.sendKeys(apiLocal);

        MobileElement el8 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/config_save_btn");
        el8.click();
    }

}