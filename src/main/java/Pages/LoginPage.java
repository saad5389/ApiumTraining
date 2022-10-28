package Pages;

import BaseClass.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @FindBy(id="com.booking:id/identity_text_input_edit_text")
    public WebElement email;

    @FindBy(id="com.booking:id/identity_text_input_edit_text")
    public List<WebElement> password;

    @FindBy(id="com.booking:id/identity_landing_social_button_text")
    public WebElement socialButton;

    @FindBy(id = "com.booking:id/genius_onbaording_bottomsheet_title")
    public WebElement getWelcomeText;

    @FindBy(id = "com.booking:id/genius_onbaording_bottomsheet_cta")
    public WebElement searchButton;

    By createPassword = By.id("com.booking:id/password_policy_1");

    public void waitForElement(WebDriver d, WebElement elem){
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public void waitForElements(WebDriver d, List<WebElement> elem){
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfAllElements(elem));
    }

    public void button(){
        waitForElement(AppDriver.getDriver(), socialButton);
        socialButton.click();
    }

    public void enterEmail(String emailAdd){
        String emailName = "saad";
        waitForElement(AppDriver.getDriver(), email);
        email.sendKeys(emailName+Math.random()+emailAdd);
    }

    public void enterPassword(String pass){
        waitForElements(AppDriver.getDriver(), password);
        new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated((By) createPassword));
        password.get(0).sendKeys(pass);
    }

    public void enterConfirmPassword(String pass){
        waitForElements(AppDriver.getDriver(), password);
        password.get(1).sendKeys(pass);
    }

    public void welcome(){
        waitForElement(AppDriver.getDriver(), getWelcomeText);
        getWelcomeText.isDisplayed();
    }

    public void startSearchingBtn(){
        waitForElement(AppDriver.getDriver(), searchButton);
        searchButton.click();
    }
}
