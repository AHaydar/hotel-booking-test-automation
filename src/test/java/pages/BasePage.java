package test.java.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver _driver) {
        driver = _driver;
    }
}
