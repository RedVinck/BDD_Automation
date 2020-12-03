package ui;

import org.openqa.selenium.WebDriver;

public class WebDriverService {
    static String driver ="/Users/DePau/Programtools/GoogleDriver/chromedriver.exe";
   static String path = "http://localhost:8080/Controller";

    public static String getDriver() {
        return driver;
    }


    public static String getPath() {
        return path;
    }

}
