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

    public boolean containsMealFromName (String naam) {
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));
        for (WebElement tr: trs) {
            if (tr.getText().equals(naam)){
                return true;
            }
        }
        return false;
    }

    public boolean containsErrorMessage (String ssn) {
        WebElement error = driver.findElement(By.cssSelector("em"));
        return error.getText().equals(ssn);
    }

    public boolean containsNutsFromName(String zalm,boolean containsNuts) {
//  Fix me
       /* WebElement table = driver.findElement(By.cssSelector("table"));

        List<WebElement> firstCells = table.findElements(By.id(zalm));
        firstCells.forEach(fe-> fe.getText().equals(containsNuts));
        return false;*/
        return false;
    }
}
