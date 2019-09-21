package test.java.tests;

import org.testng.Assert;
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
        Assert.assertEquals(bookingPage.getBookingsGridRecordsNumber(), 0, "The number of records in the grid is not 0, the record was not deleted properly");
    }

}
