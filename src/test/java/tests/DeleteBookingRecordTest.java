package test.java.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pages.BookingPage;
import test.java.utilities.HTTPClient;
import test.java.utilities.PropertyManager;

public class DeleteBookingRecordTest extends BaseTest {

    private String baseUrl = PropertyManager.getInstance().getBaseUrl();
    private BookingPage bookingPage;
    private HTTPClient httpClient;

    public DeleteBookingRecordTest() {
        bookingPage = new BookingPage(driver);
        httpClient = new HTTPClient();
    }

    @BeforeMethod
    public void createBookingAndNavigateToPage() throws Exception {
        httpClient.createBookingPostRequest(); //Create the record through the API in order to avoid clicking through the UI, which makes the tests slower
        driver.get(baseUrl);
    }

    @Test
    public void deleteBookingRecordTest() {
        bookingPage.clickDelete();
    }

}
