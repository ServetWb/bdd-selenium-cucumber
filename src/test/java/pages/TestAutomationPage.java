package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestAutomationPage {

    // We won't repeat locators for each test
    // We'll create one Page class per URL
    // and store all locators related to that page here

    public TestAutomationPage() {
        // To use locators, we need to link WebDriver to this class
        // In POM, this is done in the constructor
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "global-search")
    public WebElement searchBox;

    @FindBy(className = "product-count-text")
    public WebElement searchResultText;

    @FindBy(className = "prod-img")
    public List<WebElement> foundProductElementsList;

    @FindBy(xpath = "//*[@class=' heading-sm mb-4']")
    public WebElement firstProductNameElement;

    @FindBy(xpath = "(//span[@class='menu-icon-text'])[1]")
    public WebElement accountLink;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(id = "submitlogin")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Logout']")
    public WebElement logoutButton;

}

