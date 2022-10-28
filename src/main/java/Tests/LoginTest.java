package Tests;

import BaseClass.AppFactory;
import Pages.LoginPage;
import Pages.ProfilePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import configurationReaderFile.ConfigReader;
import org.jetbrains.annotations.NotNull;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.JsonReader;

import java.net.MalformedURLException;

public class LoginTest {
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public static ConfigReader reader;
    public static String login_filePath;

    public ExtentSparkReporter spark;
    public ExtentReports extent;
    public ExtentTest logger;
    JsonReader loginReader;

    @BeforeTest
    public void setupMobile() throws MalformedURLException {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/extentreport.html");
        extent.attachReporter(spark);
        spark.config().setReportName("Selenium Extent Report");
        reader = new ConfigReader();
        login_filePath = reader.getJSONFilePath();
        loginReader = new JsonReader(login_filePath);
        AppFactory.initialize();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
    }

    @Test
    public void createUser(){
        logger = extent.createTest("To create new user");
        loginPage.button();
        loginPage.enterEmail(loginReader.getValue("email"));
        loginPage.button();
        loginPage.enterPassword(loginReader.getValue("password"));
        loginPage.enterConfirmPassword(loginReader.getValue("password"));
        loginPage.button();
        loginPage.welcome();
        loginPage.startSearchingBtn();
    }

    @Test
    public void profile(){
        profilePage.profileBtn();
        profilePage.manageAccount();
        profilePage.displayName(loginReader.getValue("displayName"));
        profilePage.saveAction();
    }

    @AfterMethod
    public void getResult(@NotNull ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        }
        else if(result.getStatus() == ITestResult.SKIP){
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
//        driver.quit();
    }
    @AfterTest
    public void endReport() {
        extent.flush();
    }
}
