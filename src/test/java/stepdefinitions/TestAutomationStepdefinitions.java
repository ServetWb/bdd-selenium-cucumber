package stepdefinitions;

import pages.TestAutomationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.TestAutomationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestAutomationStepdefinitions {

    pages.TestAutomationPage testAutomationPage = new pages.TestAutomationPage();

    @Given("user goes to the Test Automation homepage")
    public void user_goes_to_the_test_automation_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }

    @When("user searches for phone in the search box")
    public void user_searches_for_phone_in_the_search_box() {
        testAutomationPage.searchBox.sendKeys("phone" + Keys.ENTER);
    }

    @When("user searches for dress in the search box")
    public void user_searches_for_dress_in_the_search_box() {
        testAutomationPage.searchBox.sendKeys("dress" + Keys.ENTER);
    }

    @When("user searches for Java in the search box")
    public void user_searches_for_java_in_the_search_box() {
        testAutomationPage.searchBox.sendKeys("Java" + Keys.ENTER);
    }

    @Then("verifies that products are found in the search results")
    public void verifies_that_products_are_found_in_the_search_results() {
        String unexpectedResult = ConfigReader.getProperty("unexpectedResultText");
        String actualResult = testAutomationPage.searchResultText.getText();
        Assertions.assertNotEquals(unexpectedResult, actualResult);
    }

    @Then("verifies that no products are found in the search results")
    public void verifies_that_no_products_are_found_in_the_search_results() {
        String expectedResult = ConfigReader.getProperty("unexpectedResultText");
        String actualResult = testAutomationPage.searchResultText.getText();
        Assertions.assertEquals(expectedResult, actualResult);
    }
    @When("user searches for {string} in the search box")
    public void user_searches_for_in_the_search_box(String keyword) {
        testAutomationPage.searchBox.sendKeys(keyword + Keys.ENTER);
    }
    @And("waits for {int} seconds for synchronization")
    public void waits_for_seconds_for_synchronization(int seconds) {
        ReusableMethods.wait(seconds);
    }
    @And("closes the page")
    public void closes_the_page() {
        Driver.quitDriver();
    }
}