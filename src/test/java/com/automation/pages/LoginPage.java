package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage{


    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    WebElement usernameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    WebElement passwordField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    WebElement loginBtn;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'The currently accepted usernames')]/following-sibling::android.view.ViewGroup/android.widget.TextView")
    List<WebElement> usernames;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'password')]/following-sibling::android.widget.TextView")
    List<WebElement> passwords;


    public void enterUsername(String data)
    {
        usernameField.sendKeys(data);
    }
    public boolean isUsernameDisplayed()
    {
        return usernameField.isDisplayed();
    }

    public void enterPassword(String data)
    {
        passwordField.sendKeys(data);
    }

    public void clickOnLoginBtn()
    {
        loginBtn.click();
    }

    public void printDescriptionOnLogin()
    {
        System.out.println("in printing method");
        usernames.stream().map(WebElement::getText).forEach(System.out::println);
        passwords.stream().map(WebElement::getText).forEach(System.out::println);
    }

}
