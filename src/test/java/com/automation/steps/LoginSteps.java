package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    HomePage homePage = new HomePage();
LoginPage loginPage = new LoginPage();
    @Given("user opens application")
    public void user_opens_application() {
        System.out.println("application started");
    }

    @Then("verify user is on Login Screen")
    public void verify_user_is_on_login_screen() {
        Assert.assertTrue(loginPage.isUsernameDisplayed());
       
    }

    @When("user enters {string} as username")
    public void user_enters_as_username(String string) {

        loginPage.enterUsername(ConfigReader.getConfigValue(string));
       
    }

    @When("user enters {string} as password")
    public void user_enters_as_password(String string) {
       loginPage.enterPassword(ConfigReader.getConfigValue(string));
    }

    @When("user clicks on login")
    public void user_clicks_on_login() {

       loginPage.clickOnLoginBtn();
    }

    @Then("verify user is on homeScreen")
    public void verify_user_is_on_home_screen() {

        Assert.assertTrue(homePage.isCartLogoDisplayed());

    }

    @And("print descriptions")
    public void printDescriptions() {
        loginPage.printDescriptionOnLogin();
    }
}
