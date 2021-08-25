package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(css = "#submit-button")
    private WebElement submitButton;

    @FindBy(css = "#inputUsername")
    private WebElement usernameField;

    @FindBy(css = "#inputPassword")
    private WebElement passwordField;

    private final JavascriptExecutor js;

    public void login(String userName, String password) {
        js.executeScript("arguments[0].value='" + userName + "';", usernameField);
        js.executeScript("arguments[0].value='" + password + "';", passwordField);
        js.executeScript("arguments[0].click();", submitButton);
    }

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        js = (JavascriptExecutor) webDriver;
    }


}
