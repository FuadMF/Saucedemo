package stepdefinitions;

import Pom.YourInformationPom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class YourInformationSteps extends BaseMethods{
    YourInformationPom informationPom;

    public YourInformationSteps(){
        informationPom = YourInformationPom.getInstance();
    }

    @Then("User should be navigated to Your Information page")
    public void UserShouldBeNavigatedToYourInformationPage(){
        WebElement element = getElement(informationPom.getPageTitle());
        Assert.assertTrue(element.isDisplayed());
    }

    @When("User fill First Name input field with {string}")
    public void userFillFirstNameInputFieldWith(String FirstName) {
        getElement(informationPom.getFirstNameInput()).sendKeys(FirstName);
    }

    @And("User fill Last Name input field with {string}")
    public void userFillLastNameInputFieldWith(String LastName) {
        getElement(informationPom.getLastNameInput()).sendKeys(LastName);
    }

    @And("User fill Postal code input field with {string}")
    public void userFillPostalCodeInputFieldWith(String PostalCode) {
        getElement(informationPom.getPostalCodeInput()).sendKeys(PostalCode);
    }

    @Then("User should be navigated to Overview page")
    public void userShouldBeNavigatedToOverviewPage() {
        WebElement element = getElement(informationPom.getPageTitle());
        Assert.assertTrue(element.isDisplayed());
    }

    @Then("{string} Error message should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedError) {
        String actualError = getElement(informationPom.getErrorMessage()).getText();
        Assert.assertEquals(actualError,expectedError);
    }
}
