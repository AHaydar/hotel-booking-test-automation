package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BookingPage extends BasePage {
    public BookingPage(WebDriver _driver) {
        super(_driver);
    }

    // Page elements
    private final By firstNameInput = By.id("firstname");
    private final By lastNameInput = By.id("lastname");
    private final By priceInput = By.id("totalprice");
    private final By depositDropdown = By.id("depositpaid");
    private final By checkinInput = By.id("checkin");
    private final By checkoutInput = By.id("checkout");
    private final By saveButton = By.xpath("//input[@type='button' and @value=' Save ']"); // The value shall be fixed in the application. Can be opened as a bug
    private final By bookingGridRows = By.xpath("//*[@id='bookings']/div");
    private final By deleteButton = By.xpath("//input[@type='button' and @value='Delete']");

    public void setFirstNameInput(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void setLastNameInput(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void setPriceInput(String price) {
        driver.findElement(priceInput).sendKeys(price);
    }


    // The deposit value can be true or false
    public void setDepositDropdown(String deposit) {

        Select depositDrp = new Select(driver.findElement(depositDropdown));
        depositDrp.selectByVisibleText(deposit);

    }

    // Enter the value manually using the following format yyyy-mm-dd
    public void setCheckinInput(String checkinDate) {
        driver.findElement(checkinInput).sendKeys(checkinDate);
    }

    // Enter the value manually using the following format yyyy-mm-dd
    public void setCheckoutInput(String checkoutDate) {
        driver.findElement(checkoutInput).sendKeys(checkoutDate);
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }

    // Get number of records in the bookings grid
    public int getBookingsGridRecordsNumber() {

        // Substracting 1 to stop counting the grid header
        return driver.findElements(bookingGridRows).size() - 1;
    }

    // Get the grid records as a string
    public String getBookingGridRecords() {
        return driver.findElement(bookingGridRows).getText();
    }

    public void clickDelete() {
        driver.findElement(deleteButton).click();
    }

}
