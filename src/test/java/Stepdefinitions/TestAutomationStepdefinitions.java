package Stepdefinitions;

import Pages.TestAutomationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestAutomationStepdefinitions {
    TestAutomationPage testAutomationPage = new TestAutomationPage();

    @Given("user goes to the Test Automation homepage")
    public void user_goes_to_the_test_automation_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }

    @When("user searches for phone in the search box")
    public void user_searches_for_phone() {
        testAutomationPage.searchBox.sendKeys("phone" + Keys.ENTER);
    }

    @Then("verifies that products are found in the search results")
    public void verifies_that_products_are_found() {
        String unexpectedResult = ConfigReader.getProperty("toUnExpectedSonucYazisi");
        String actualResult = testAutomationPage.searchResultText.getText();
        Assertions.assertNotEquals(unexpectedResult, actualResult);
    }

    @Then("closes the page")
    public void closes_the_page() {
        Driver.quitDriver();
    }

    @When("user searches for dress in the search box")
    public void user_searches_for_dress() {
        testAutomationPage.searchBox.sendKeys("dress" + Keys.ENTER);
    }

    @When("user searches for Java in the search box")
    public void user_searches_for_java() {
        testAutomationPage.searchBox.sendKeys("Java" + Keys.ENTER);
    }

    @Then("verifies that no products are found in the search results")
    public void verifies_no_products_found() {
        String expectedResult = ConfigReader.getProperty("toUnExpectedSonucYazisi");
        String actualResult = testAutomationPage.searchResultText.getText();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @When("user searches for {string} in the search box")
    public void user_searches_for_word(String searchWord) {
        testAutomationPage.searchBox.sendKeys(searchWord + Keys.ENTER);
    }

    @And("waits for {int} seconds for synchronization")
    public void waits_for_seconds_for_sync(int sec) {
        ReusableMethods.wait(sec);
    }

    @Given("user navigates to the {string} homepage")
    public void user_navigates_to_homepage(String urlKey) {
        Driver.getDriver().get(ConfigReader.getProperty(urlKey));
    }

    @Then("clicks the account button")
    public void clicks_the_account_button() {
        testAutomationPage.accountLink.click();
    }

    @Then("enters {string} as email")
    public void enters_email(String emailKey) {
        testAutomationPage.emailBox.sendKeys(ConfigReader.getProperty(emailKey));
    }

    @Then("enters {string} as password")
    public void enters_password(String passwordKey) {
        testAutomationPage.passwordBox.sendKeys(ConfigReader.getProperty(passwordKey));
    }

    @Then("clicks the sign in button")
    public void clicks_the_sign_in_button() {
        testAutomationPage.loginButton.click();
    }

    @Then("verifies successful login")
    public void verifies_successful_login() {
        Assertions.assertTrue(testAutomationPage.logoutButton.isDisplayed());
    }

    @Then("logs out")
    public void logs_out() {
        testAutomationPage.logoutButton.click();
    }

    @And("verifies login was not successful")
    public void verifies_login_unsuccessful() {
        Assertions.assertTrue(testAutomationPage.emailBox.isDisplayed());
    }
}
