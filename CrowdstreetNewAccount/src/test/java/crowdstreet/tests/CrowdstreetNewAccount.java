package crowdstreet.tests;

import com.github.javafaker.Faker;
import crowdstreet.pages.CrowdstreetHomePage;
import crowdstreet.pages.CrowdstreetMyAccountPage;
import crowdstreet.pages.CrowdstreetUserFieldInputs;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class CrowdstreetNewAccount {

    WebDriver driver;

    String url = "https://test.crowdstreet.com/invexp/properties/all";

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
    driver.quit();
    }

    @Test
    public void CrowdstreetNewAccount() throws InterruptedException {

        CrowdstreetHomePage createAccount = new CrowdstreetHomePage(driver);
        createAccount.createAnAccountBtn.click();

        CrowdstreetUserFieldInputs inputs = new CrowdstreetUserFieldInputs(driver);
        Faker faker = new Faker();

        inputs.FirstName.sendKeys(faker.name().firstName());
        inputs.LastName.sendKeys(faker.name().lastName());
        inputs.Email.sendKeys(faker.internet().emailAddress());
        inputs.Password.sendKeys("Password@123");
        inputs.ConfirmPassword.sendKeys("Password@123");
        inputs.AreYouAccreditedInvestor.click();
        inputs.Agreement.click();

        Thread.sleep(3000);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        WebElement captcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
        captcha.click();
        driver.switchTo().defaultContent();

        Thread.sleep(3000);

        inputs.CreateAccountBtn.click();


        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//abbr[@class='head-link']"))).perform();

        CrowdstreetMyAccountPage register = new CrowdstreetMyAccountPage(driver);
        register.MyAccountBtn.click();

        register.SSN.sendKeys(faker.numerify("111111111"));

        register.ZipCode.sendKeys(faker.address().zipCode());

        register.City.sendKeys(faker.address().cityName());

        register.Address.sendKeys(faker.address().streetAddress());

        register.DOB.sendKeys("01/01/1999");

        register.State.click();

        Actions actionsMyState = new Actions(driver);
        actionsMyState.moveToElement(driver.findElement(By.id("headlessui-listbox-option-75"))).click().perform();
        //register.MyState.click();

        register.Country.click();

        Actions actionsMyCountry = new Actions(driver);
        actionsMyCountry.moveToElement(driver.findElement(By.xpath("//span[.='United States of America']"))).click().perform();
        //register.MyCountry.click();


        register.SaveBtn.click();












    }
}
