import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class LoginActivityTesting extends AppiumController{

    protected LoginScreen loginScreen;

    @Parameters({"appPackage", "appActivity", "appWaitActivity", "automationName", "androidBundleId", "deviceId", "deviceOs"})
    public void setUp() throws Exception {
        appPackage = "com.piton.ticidis.inspector.live";
        appActivity = "com.piton.ticidis.inspector.ui.splash.SplashActivity";
        appWaitActivity = "com.piton.ticidis.inspector.ui.login.LoginActivity";
        startAppium();
        loginScreen = new LoginScreen(driver, wait);
    }

    @Test
    public void registerDeviceInvalidAPI() throws Exception {
        setUp();
        String apiServer = "https://ticidisapi.com.tr/";
        String apiLocal = "https://ticidisapi.com.tr/";
        loginScreen.registerDevice(apiLocal,apiServer);
    }

    @Test
    public void registerDeviceOneInvalidAPI() throws Exception {
        setUp();
        String apiServer = "https://ticidisapi.com.tr/";
        String apiLocal = "https://ticidisapi.piton.com.tr/";
        loginScreen.registerDeviceWithoutPermissions(apiLocal,apiServer);
    }

    @Test
    public void registerDeviceOneEmptyAPI() throws Exception {
        setUp();
        String apiServer = "";
        String apiLocal = "https://ticidisapi.piton.com.tr/";
        loginScreen.registerDeviceWithoutPermissions(apiLocal,apiServer);
    }

    @Test
    public void registerDeviceAllEmptyAPI() throws Exception {
        setUp();
        String apiServer = "";
        String apiLocal = "";
        loginScreen.registerDeviceWithoutPermissions(apiLocal,apiServer);
    }

    @Test
    public void registerDeviceValidAPI() throws Exception {
        setUp();
        String apiLocal = "https://ticidisapi.piton.com.tr/";
        String apiServer = "https://ticidisapi.piton.com.tr/";
        loginScreen.registerDeviceWithoutPermissions(apiLocal,apiServer);
    }

    @Test
    public void loginAllFieldsEmpty() throws Exception {
        setUp();
        String loginMail = "";
        String password = "";
        loginScreen.login(loginMail,password);
    }

    @Test
    public void loginWithoutEmail() throws Exception {
        setUp();
        String loginMail = "";
        String password = "p@ssw0rd!";
        loginScreen.login(loginMail,password);
    }

    @Test
    public void loginWithoutPassword() throws Exception {
        setUp();
        String loginMail = "inspector@ticidis.com.tr";
        String password = "";
        loginScreen.login(loginMail,password);
    }

    @Test
    public void loginValid() throws Exception {
        setUp();
        String loginMail = "inspector@ticidis.com.tr";
        String password = "p@ssw0rd!";
        loginScreen.login(loginMail,password);
    }

}

