package stepdefinitions;

import Pom.LoginPom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public final class LoginSteps extends BaseMethods {


    LoginPom loginPom;
    public LoginSteps(){
        loginPom = LoginPom.getInstance();
    }


    @When("User fills username input field with {string}")
    public void userFillsUsernameInputFieldWith(String username) {
        getElement(loginPom.getUsernameInput()).sendKeys(username);
    }

    @And("User fill password input field with {string}")
    public void userFillPasswordInputFieldWith(String password) {
        getElement(loginPom.getPasswordInput()).sendKeys(password);
    }

    @And("Click login button")
    public void clickLoginButton() {
       getElement(loginPom.getLoginBtn()).click();
    }

    @Then("User should be navigated to the homepage")
    public void userShouldBeNavigatedToTheHomepage() {
        WebElement element = getElement(loginPom.getHomepageLogo());
        Assert.assertTrue(element.isDisplayed());
    }


    @Then("{string} error message should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedResult) {
        String actualResult = getElement(loginPom.getLoginError()).getText();
        Assert.assertEquals(actualResult,expectedResult);
    }



}