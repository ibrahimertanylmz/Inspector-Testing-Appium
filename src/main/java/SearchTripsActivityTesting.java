import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SearchTripsScreen;


public class SearchTripsActivityTesting extends AppiumController{

    protected SearchTripsScreen searchTripsScreen;

    @Parameters({"appPackage", "appActivity", "appWaitActivity", "automationName", "androidBundleId", "deviceId", "deviceOs"})
    public void setUp() throws Exception {
        appPackage = "com.piton.ticidis.inspector.live";
        appActivity = "com.piton.ticidis.inspector.ui.splash.SplashActivity";
        appWaitActivity = "com.piton.ticidis.inspector.ui.trips.SearchTripsActivity";
        startAppium();

        searchTripsScreen = new SearchTripsScreen(driver, wait);
    }

    @Test
    public void searchTripsWithoutShifting() throws Exception {
        setUp();
        searchTripsScreen.searchTrips();
    }

    @Test
    public void searchTripsWithShifting() throws Exception {
        setUp();
        searchTripsScreen.startShifting();
        searchTripsScreen.searchTrips();
    }

}
