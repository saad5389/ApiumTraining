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

public class ProfilePage {
    public ProfilePage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @FindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Profile\"]/android.widget.ImageView")
    public WebElement profile;

    By buiTitle = By.id("com.booking:id/bui_title_title");

    @FindBy(xpath="//android.view.ViewGroup[@index='2']")
    public WebElement manageYourAccount;

    @FindBy(id="com.booking:id/edit_profile_public_detail_user_name")
    public WebElement displayName;

    @FindBy(id="com.booking:id/edit_profile_save_action")
    public WebElement saveBtn;

    public void waitForElement(WebDriver d, WebElement elem){
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public void waitForElements(WebDriver d, List<WebElement> elem){
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfAllElements(elem));
    }

    public void profileBtn(){
        waitForElement(AppDriver.getDriver(), profile);
        new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated((By) buiTitle));
        profile.click();
    }

    public void manageAccount(){
        waitForElement(AppDriver.getDriver(), manageYourAccount);
        manageYourAccount.click();
    }

    public void displayName(String displayName) {
        waitForElement(AppDriver.getDriver(), this.displayName);
        this.displayName.sendKeys(displayName+Math.random());
    }

    public void saveAction() {
        waitForElement(AppDriver.getDriver(), this.saveBtn);
        this.saveBtn.click();
    }
}
