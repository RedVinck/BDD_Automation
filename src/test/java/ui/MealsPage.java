package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MealsPage extends Page {

    public MealsPage(WebDriver driver) {
        super(driver);
        driver.get(getPath()+"?command=Overview");
    }

    public boolean containsPatientWithSSN (String ssn) {
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));
        for (WebElement tr: trs) {
            if (tr.getText().equals(ssn)){
                return true;
            }
        }
        return false;
    }

    public boolean containsErrorMessage (String ssn) {
        WebElement error = driver.findElement(By.cssSelector("em"));
        return error.getText().equals(ssn);
    }
}
