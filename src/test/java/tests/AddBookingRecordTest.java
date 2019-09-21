package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pages.BookingPage;
import test.java.utilities.DataProviderClass;
import test.java.utilities.PropertyManager;

public class AddBookingRecordTest extends BaseTest {

    private String baseUrl = PropertyManager.getInstance().getBaseUrl();
    private BookingPage bookingPage;

    public AddBookingRecordTest() {
        bookingPage = new BookingPage(driver);
    }


    @BeforeMethod
    public void navigateToHomePage(){
        driver.get(baseUrl);
    }

    @Test(description = "Add a new booking with valid data", dataProvider = "booking-info", dataProviderClass = DataProviderClass.class)
    public void addBookingRecordTest(String firstName, String lastName, String price, String deposit, String checkinDate, String checkoutDate) {

        bookingPage.setFirstNameInput(firstName);
        bookingPage.setLastNameInput(lastName);
        bookingPage.setPriceInput(price);
        bookingPage.setDepositDropdown(deposit);
        bookingPage.setCheckinInput(checkinDate);
        bookingPage.setCheckoutInput(checkoutDate);

        bookingPage.clickSave();

        Assert.assertEquals(bookingPage.getBookingsGridRecordsNumber(), 1, "The number of records in the grid is not correct");
        Assert.assertTrue(bookingPage.getBookingGridRecords().contains(firstName));
        Assert.assertTrue(bookingPage.getBookingGridRecords().contains(lastName));
        Assert.assertTrue(bookingPage.getBookingGridRecords().contains(price));
        Assert.assertTrue(bookingPage.getBookingGridRecords().contains(checkinDate));
        Assert.assertTrue(bookingPage.getBookingGridRecords().contains(checkoutDate));
    }

    @AfterMethod(alwaysRun = true)
    public void cleanupData() {
        bookingPage.clickDelete();
    }
}
