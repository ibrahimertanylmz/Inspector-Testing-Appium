import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.DeviceListScreen;
import screens.SearchTripsScreen;
import screens.TicketOperationScreen;
import screens.TripsScreen;

public class DeviceListActivityTesting extends AppiumController{
    protected SearchTripsScreen searchTripsScreen;
    protected TripsScreen tripsScreen;
    protected TicketOperationScreen ticketOperationScreen;
    protected DeviceListScreen deviceListScreen;

    @Parameters({"appPackage", "appActivity", "appWaitActivity", "automationName", "androidBundleId", "deviceId", "deviceOs"})
    public void setUp() throws Exception {
        appPackage = "com.piton.ticidis.inspector.live";
        appActivity = "com.piton.ticidis.inspector.ui.splash.SplashActivity";
        appWaitActivity = "com.piton.ticidis.inspector.ui.trips.SearchTripsActivity";
        startAppium();

        searchTripsScreen = new SearchTripsScreen(driver, wait);
        tripsScreen = new TripsScreen(driver, wait);
        ticketOperationScreen = new TicketOperationScreen(driver, wait);
        deviceListScreen = new DeviceListScreen(driver,wait);
    }

    @Test
    public void listPairedDevices() throws Exception {
        setUp();
        searchTripsScreen.searchTrips();
        tripsScreen.selectTripsItem(3);
        ticketOperationScreen.imposePenaltyWithoutTicket( "10912240002","Jason Hood");
        deviceListScreen.listPairedDevices();
    }
}
