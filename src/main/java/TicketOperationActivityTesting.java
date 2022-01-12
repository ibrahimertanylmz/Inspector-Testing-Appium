import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.SearchTripsScreen;
import screens.TicketOperationScreen;
import screens.TripsScreen;

public class TicketOperationActivityTesting extends AppiumController {
    protected SearchTripsScreen searchTripsScreen;
    protected TripsScreen tripsScreen;
    protected TicketOperationScreen ticketOperationScreen;

    @Parameters({"appPackage", "appActivity", "appWaitActivity", "automationName", "androidBundleId", "deviceId", "deviceOs"})
    public void setUp() throws Exception {
        appPackage = "com.piton.ticidis.inspector.live";
        appActivity = "com.piton.ticidis.inspector.ui.splash.SplashActivity";
        appWaitActivity = "com.piton.ticidis.inspector.ui.trips.SearchTripsActivity";
        startAppium();

        searchTripsScreen = new SearchTripsScreen(driver, wait);
        tripsScreen = new TripsScreen(driver, wait);
        ticketOperationScreen = new TicketOperationScreen(driver, wait);
    }

    @Test
    public void readTicketByTicketNo() throws Exception {
        setUp();
        searchTripsScreen.searchTrips();
        tripsScreen.selectTripsItem(3);
        ticketOperationScreen.readTicketByTicketNo("TRC1221087ac860"); //ticketNo for dar_to_moro_08.12.21_21.00
    }

    @Test
    public void readTicketByQRCode() throws Exception {
        setUp();
        searchTripsScreen.searchTrips();
        tripsScreen.selectTripsItem(3);
        ticketOperationScreen.readTicketByQRCode("dar_to_moro_08.12.21_21.00.jpeg");
    }

    @Test
    public void imposePenaltyWithoutTicket() throws Exception {
        setUp();
        searchTripsScreen.searchTrips();
        tripsScreen.selectTripsItem(3);
        ticketOperationScreen.imposePenaltyWithoutTicket("10963455006","Travis Moore");
    }

    @Test
    public void sendDataWithoutPenalty() throws Exception {
        setUp();
        ticketOperationScreen.sendDataWithoutPenalty();
    }

    @Test
    public void sendDataWithPenalty() throws Exception { //failed because of no printer device connected // passed when device connected
        setUp();
        ticketOperationScreen.sendDataWithPenalty();
    }

    @Test
    public void listAllPenaltiesWithPenalty() throws Exception { //failed because of no printer device connected // waiting for retest when printer connected
        setUp();
        ticketOperationScreen.listAllPenaltiesWithPenalty();
    }

    @Test
    public void listAllPenaltiesWithoutPenalty() throws Exception {
        setUp();
        ticketOperationScreen.listAllPenaltiesWithoutPenalty();
    }
}
