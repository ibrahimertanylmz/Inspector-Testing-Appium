package screens;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class TicketOperationScreen extends screens.PhoneLookupScreen{

    public TicketOperationScreen(AppiumDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void readTicketByTicketNo(String ticketNo){
        MobileElement el1 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/get_trips_tv");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.view.ViewGroup[3]/android.widget.TextView");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/ticket_check_ticket_no_tv");
        el3.sendKeys(ticketNo);
        MobileElement el4 = (MobileElement) driver.findElementById("android:id/button1");
        el4.click();
    }

    public void readTicketByQRCode(String image) throws IOException, NotFoundException {
        MobileElement el1 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/get_trips_tv");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.view.ViewGroup[1]/android.widget.TextView");
        el2.click();
        //MobileElement el3 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
        //el3.click();

        byte[] bytes = driver.pullFile("/storage/emulated/0/DCIM/Camera/"+image);
        InputStream is = new ByteArrayInputStream(bytes);
        BufferedImage bufferedImage = ImageIO.read(is);
        System.out.println("here: " + readQRCode(bufferedImage));
    }

    public void imposePenaltyWithoutTicket(String passengerId, String passengerName){
        MobileElement el1 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/penalty_without_ticket_rl");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/activity_penalty_spinner");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/penalty_identity");
        el4.sendKeys(passengerId);
        MobileElement el5 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/passengerNameTextView_withoutTicketNo");
        el5.sendKeys(passengerName);
        MobileElement el6 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/activity_penalty_dialog_btn_submit");
        el6.click();
    }

    public void openPenaltyPage(){
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‏‏‏‏‏‏‎‏‏‎‏‏‏‏‎‏‎‎‎‏‏‎‏‏‏‎‏‏‎‏‎‏‎‎‎‎‎‎‏‎‎‎‏‏‏‎‏‏‏‏‎‎‎‏‎‎‎‏‎‏‎More options‎‏‎‎‏‎");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el2.click();
    }

    public void sendDataWithPenalty(){
        openPenaltyPage();
        imposePenaltyWithoutTicket("11913426003","Casey Lianne");
        MobileElement el1 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/send_penalties_rl");
        el1.click();
    }

    public void sendDataWithoutPenalty(){
        openPenaltyPage();
        MobileElement el1 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/send_penalties_rl");
        el1.click();
    }

    public void listAllPenaltiesWithPenalty(){
        openPenaltyPage();
        imposePenaltyWithoutTicket("10479866321","Daniel Corrado");
        MobileElement el1 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/list_all_penalties_button");
        el1.click();
    }

    public void listAllPenaltiesWithoutPenalty(){
        openPenaltyPage();
        MobileElement el1 = (MobileElement) driver.findElementById("com.piton.ticidis.inspector.live:id/list_all_penalties_button");
        el1.click();
    }

    public static String readQRCode(BufferedImage bufferedImage)
            throws FileNotFoundException, IOException, NotFoundException {
        String encodedContent = null;
        try {
            BufferedImageLuminanceSource bufferedImageLuminanceSource = new BufferedImageLuminanceSource(bufferedImage);
            HybridBinarizer hybridBinarizer = new HybridBinarizer(bufferedImageLuminanceSource);
            BinaryBitmap binaryBitmap = new BinaryBitmap(hybridBinarizer);
            MultiFormatReader multiFormatReader = new MultiFormatReader();

            Result result = multiFormatReader.decode(binaryBitmap);
            encodedContent = result.getText();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return encodedContent;
    }
}
