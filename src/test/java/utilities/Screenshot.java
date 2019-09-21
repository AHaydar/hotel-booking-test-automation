package test.java.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Screenshot {

    public static void captureScreenshot(WebDriver driver){
        try {
            TakesScreenshot scrShot = ((TakesScreenshot)driver);
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            Calendar cal = Calendar.getInstance();
            String time = "" + dateFormat.format(cal.getTime());

            String dest = System.getProperty("user.dir") + "/ErrorScreenShot/" + time + ".jpg";
            File destFile = new File(dest);

            FileUtils.copyFile(srcFile, destFile);

        } catch (Exception e) {

        }
    }
}
