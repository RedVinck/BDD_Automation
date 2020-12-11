package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ui.Page;
import ui.MealsPage;
/*import ui.RegisterPage;*/
import ui.RegisterPage;
import ui.WebDriverService;

import java.util.List;

import static org.junit.Assert.*;

public class ViewAllMealsSteps {

    private WebDriver driver;
    private String path = "http://localhost:8080/Controller";

    private Page currentPage;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "/Users/.../web3pers/chromedriver");
        // windows: gebruik dubbele \\ om pad aan te geven
        // hint: zoek een werkende test op van web 2 ...
        System.setProperty("webdriver.chrome.driver", WebDriverService.getDriver());
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.get(path+"?command=DeleteAll");
        driver.quit();
    }

    @Given("dat er maaltijden op het menu staan")
    public void there_are_mails_on_menu() {
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNameField("Zalm");
        page.setCategoryField("Vis");
        page.setPriceField(50);
        page.setContainsLactoseButton(false);
        page.setVegetarianField(false);
        page.setContainsNutsButton(false);
        page.submitValid();

    }

    @When("Wanneer Jan op het menu kijkt")
    public void wanneer_jan_op_het_menu_kijkt() {
        currentPage = PageFactory.initElements(driver, MealsPage.class);
    }

    @Then("Dan worden alle maaltijden getoond die op het menu staan")
    public void dan_worden_alle_maaltijden_getoond_die_op_het_menu_staan() {
        assertEquals("Patient Overview - BMI app", driver.getTitle());
        assertTrue(((MealsPage)currentPage).containsMealFromName("Zalm"));
    }
    @Given("er geen maaltijden op het menu staan")
    public void er_geen_maaltijden_op_het_menu_staan() {
        driver.get(path+"?command=DeleteAll");
    }

    @Then("krijgt Jan een melding dat er momenteel nog geen maaltijden op het menu  staan")
    public void krijgtJanEenMeldingDatErMomenteelNogGeenMaaltijdenOpHetMenuStaan() {
        currentPage = PageFactory.initElements(driver, MealsPage.class);
        assertFalse(((MealsPage)currentPage).containsMealFromName("Zalm"));
        assertTrue(((MealsPage)currentPage).containsErrorMessage("No Meals found"));
    }




    @Given("dat er maaltijden zijn waar extra informatie bij hoort")
    public void datErMaaltijdenZijnWaarExtraInformatieBijHoort() {
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNameField("Zalm");
        page.setCategoryField("Vis");
        page.setPriceField(50);
        page.setContainsLactoseButton(false);
        page.setVegetarianField(false);
        page.setContainsNutsButton(true);
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNameField("Groensels");
        page.setCategoryField("koud");
        page.setPriceField(50);
        page.setContainsLactoseButton(false);
        page.setVegetarianField(true);
        page.setContainsNutsButton(false);
        page.submitValid();
    }

    @Then("zou Jan het menu te zien moeten krijgen met bij elke maaltijd extra informatie over wat deze bevat.")
    public void zouJanHetMenuTeZienMoetenKrijgenMetBijElkeMaaltijdExtraInformatieOverWatDezeBevat() {
        currentPage = PageFactory.initElements(driver, MealsPage.class);
        assertTrue(((MealsPage)currentPage).containsMealFromName("Zalm"));
        assertTrue(((MealsPage)currentPage).containsMealFromName("Groensels"));
        assertTrue(((MealsPage)currentPage).containsNutsFromName("Zalm",false));
        assertTrue(((MealsPage)currentPage).containsVegiFromName("Zalm",false));
        assertTrue(((MealsPage)currentPage).containsLactoseFromName("Zalm",false));
    }

    @Then("ziet “Jan” bij elke maaltijd de prijs van de maaltijd")
    public void zietJanBijElkeMaaltijdDePrijsVanDeMaaltijd() {
        currentPage = PageFactory.initElements(driver, MealsPage.class);
        assertTrue(((MealsPage)currentPage).containsMealFromName("Zalm"));
        assertTrue(((MealsPage)currentPage).containsPriceFromName("Zalm",50));
    }

    @Given("er maaltijden van verschillende categorieën op het menu staan")
    public void erMaaltijdenVanVerschillendeCategorieënOpHetMenuStaan() {
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNameField("Zalm");
        page.setCategoryField("Vis");
        page.setPriceField(50);
        page.setContainsLactoseButton(false);
        page.setVegetarianField(false);
        page.setContainsNutsButton(true);
        page.submitValid();



        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNameField("Kaas");
        page.setCategoryField("Koud");
        page.setPriceField(50);
        page.setContainsLactoseButton(false);
        page.setVegetarianField(true);
        page.setContainsNutsButton(false);
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNameField("Tonijn");
        page.setCategoryField("Vis");
        page.setPriceField(50);
        page.setContainsLactoseButton(false);
        page.setVegetarianField(false);
        page.setContainsNutsButton(true);
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNameField("Hesp");
        page.setCategoryField("Koud");
        page.setPriceField(50);
        page.setContainsLactoseButton(false);
        page.setVegetarianField(false);
        page.setContainsNutsButton(true);
        page.submitValid();

    }

    @Then("ziet “Jan” dat de maaltijden per categorie gegroepeerd staan")
    public void zietJanDatDeMaaltijdenPerCategorieGegroepeerdStaan() {
        currentPage = PageFactory.initElements(driver, MealsPage.class);
        String[] paramaters= {"Kaas","Hesp","Zalm","Tonijn"};
        assertTrue(((MealsPage)currentPage).containsOrderList(paramaters));
    }




}
