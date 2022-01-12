import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SearchTripsScreen;
import screens.TripsScreen;

public class TripsActivityTesting extends AppiumController{

    protected TripsScreen tripsScreen;
    protected SearchTripsScreen searchTripsScreen;
    protected LoginScreen loginScreen;

    @Parameters({"appPackage", "appActivity", "appWaitActivity", "automationName", "androidBundleId", "deviceId", "deviceOs"})
    public void setUp() throws Exception {
        appPackage = "com.piton.ticidis.inspector.live";
        appActivity = "com.piton.ticidis.inspector.ui.splash.SplashActivity";
        appWaitActivity = "com.piton.ticidis.inspector.ui.trips.SearchTripsActivity";
        startAppium();

        searchTripsScreen = new SearchTripsScreen(driver, wait);
        tripsScreen = new TripsScreen(driver, wait);
    }

    @Test
    public void selectTrip() throws Exception {
        setUp();
        searchTripsScreen.searchTrips();
        tripsScreen.selectTripsItem(3);
    }
}
