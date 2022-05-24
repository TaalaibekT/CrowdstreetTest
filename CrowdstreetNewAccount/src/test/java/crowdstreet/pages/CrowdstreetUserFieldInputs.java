package crowdstreet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrowdstreetUserFieldInputs {

    WebDriver driver;
    public CrowdstreetUserFieldInputs(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement FirstName;

    @FindBy(id = "lastName")
    public WebElement LastName;

    @FindBy(id = "email")
    public WebElement Email;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(id = "confirmPassword")
    public WebElement ConfirmPassword;

    @FindBy(id = "accreditedNo")
    public WebElement AreYouAccreditedInvestor;

    @FindBy(id = "hasAgreedTos")
    public WebElement Agreement;

    @FindBy(xpath = "//span[.='Create an account']")
    public WebElement CreateAccountBtn;



}
