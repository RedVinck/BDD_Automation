package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class RegisterPage extends Page {

    @FindBy(id="name")
    private WebElement nameField;

    @FindBy(id="price")
    private WebElement priceField;

    @FindBy(id="category")
    private WebElement categoryField;

    @FindBy(id="vegetarian")
    private WebElement vegetarianField;


    @FindBy(id="containsLactose")
    private WebElement containsLactoseButton;

    @FindBy(id="containsNuts")
    private WebElement containsNutsButton;

    @FindBy(id="register")
    private WebElement registerButton;


    public RegisterPage (WebDriver driver) {
        super(driver);
        this.driver.get(getPath()+"?command=SignUp");
    }

    public void setNameField(String ssn) {
        nameField.clear();
        nameField.sendKeys(ssn);
    }

    public void setPriceField(int proce) {
        priceField.clear();
        priceField.sendKeys(String.valueOf(proce));
    }

    public void setCategoryField(String category) {
        categoryField.clear();
        categoryField.sendKeys(category);
    }

    public void setVegetarianField(boolean vegetarian) {
        if (vegetarian){
            vegetarianField.click();
        }
    }
    public void setContainsLactoseButton(boolean containsLactose) {
        if (containsLactose){
            containsLactoseButton.click();
        }
    }
    public void setContainsNutsButton(boolean containsNuts) {
        if (containsNuts){
            containsNutsButton.click();
        }
    }

    public void submitValid() {
        registerButton.click();
    }

}