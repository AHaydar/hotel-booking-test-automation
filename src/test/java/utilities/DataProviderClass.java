package test.java.utilities;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderClass {

    @DataProvider(name="booking-info")
    public Object[][] getBookingInfo(Method m) {
        if(m.getName().equalsIgnoreCase("addBookingRecordTest")) {
            return new Object[][]
                    {
                            { "John", "Smith", "5", "true", "2019-09-20", "2019-09-21"}
                    };
        }
        return null;
    }
}
