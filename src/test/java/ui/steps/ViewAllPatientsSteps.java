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
import ui.RegisterPage;
import ui.WebDriverService;

import java.util.List;

import static org.junit.Assert.*;

public class ViewAllPatientsSteps {

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

    @Given("there are patients registered")
    public void there_are_patients_registered() {
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setSSN("93051822361");
        page.setGender("MALE");
        page.setLength("180");
        page.setWeight("750000");
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setSSN("87081220062");
        page.setGender("FEMALE");
        page.setLength("160");
        page.setWeight("800000");
        page.submitValid();
    }

    @When("Martha requests to get all patients")
    public void martha_requests_to_get_all_patients() {
        currentPage = PageFactory.initElements(driver, MealsPage.class);
    }

    @Then("Martha should be able to get the list of all social security numbers of the registered patients")
    public void martha_should_be_able_to_get_the_list_of_all_social_security_numbers_of_the_registered_patients() {
        assertEquals("Patient Overview - BMI app", driver.getTitle());
        assertTrue(((MealsPage)currentPage).containsPatientWithSSN("93051822361"));
        assertTrue(((MealsPage)currentPage).containsPatientWithSSN("87081220062"));
    }

    @Given("there are no patients registered")
    public void there_are_no_patients_registered() {
        driver.get(path+"?command=DeleteAll");
    }

    @Then("Martha should be able to get a message that there are no patients registered")
    public void martha_should_be_able_to_get_a_message_that_there_are_no_patients_registered() {
        currentPage = PageFactory.initElements(driver, MealsPage.class);
        assertFalse(((MealsPage)currentPage).containsPatientWithSSN("93051822361"));
        assertTrue(((MealsPage)currentPage).containsErrorMessage("No patients found"));
    }

    @Then("Martha should be able to get {string}")
    public void martha_should_be_able_to_get(String ssn) {
        assertTrue(((MealsPage)currentPage).containsPatientWithSSN(ssn));
    }

    @Given("the following patients are registered")
    public void the_following_patients_are_registered(List<String> ssns) {
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setSSN("93051822361");
        page.setGender("MALE");
        page.setLength("180");
        page.setWeight("750000");
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setSSN("87081220062");
        page.setGender("FEMALE");
        page.setLength("160");
        page.setWeight("800000");
        page.submitValid();
    }

}
