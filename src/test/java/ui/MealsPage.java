package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MealsPage extends Page {

    public MealsPage(WebDriver driver) {
        super(driver);
        driver.get(getPath() + "?command=Overview");
    }

    public boolean containsMealFromName(String naam) {
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));
        for (WebElement tr : trs) {
            if (tr.getText().equals(naam)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsErrorMessage(String ssn) {
        WebElement error = driver.findElement(By.cssSelector("em"));
        return error.getText().equals(ssn);
    }

    public boolean containsNutsFromName(String zalm, boolean containsNuts) {
        WebElement table = driver.findElement(By.cssSelector("table"));

        List<WebElement> firstCells = table.findElements(By.id(zalm));
        String[] parameters = firstCells.get(0).getText().split(" ");
        return (Boolean.parseBoolean(parameters[2])) == (containsNuts);
    }

    public boolean containsVegiFromName(String zalm, boolean b) {
        WebElement table = driver.findElement(By.cssSelector("table"));

        List<WebElement> firstCells = table.findElements(By.id(zalm));
        String[] parameters = firstCells.get(0).getText().split(" ");
        return (Boolean.parseBoolean(parameters[3])) == (b);
    }

    public boolean containsLactoseFromName(String zalm, boolean b) {
        WebElement table = driver.findElement(By.cssSelector("table"));

        List<WebElement> firstCells = table.findElements(By.id(zalm));
        String[] parameters = firstCells.get(0).getText().split(" ");
        return (Boolean.parseBoolean(parameters[4])) == (b);
    }

    public boolean containsPriceFromName(String zalm, int i) {
        WebElement table = driver.findElement(By.cssSelector("table"));

        List<WebElement> firstCells = table.findElements(By.id(zalm));
        String[] parameters = firstCells.get(0).getText().split(" ");
        return (Double.parseDouble(parameters[5])) == (i);
    }

    public boolean containsOrderList(String[] paramaters) {


        WebElement table = driver.findElement(By.cssSelector("table"));
        List<WebElement> firstCells = table.findElements(By.cssSelector("tr"));
        firstCells.remove(0);
        ArrayList<String> sorted = new ArrayList<>();
        firstCells.forEach(e -> sorted.add((e.getText().split(" "))[0]));

        for (int i = 0; i < paramaters.length; i++) {
           if(!sorted.get(i).equals(paramaters[i]))return false;
        }
        return true;
    }
}
