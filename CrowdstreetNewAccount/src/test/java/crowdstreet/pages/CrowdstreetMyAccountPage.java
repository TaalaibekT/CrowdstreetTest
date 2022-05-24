package crowdstreet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrowdstreetMyAccountPage {

    WebDriver driver;
    public CrowdstreetMyAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='My Account']")
    public WebElement MyAccountBtn;

    @FindBy(id = "ssn")
    public WebElement SSN;

    @FindBy(id = "zipCode")
    public WebElement ZipCode;

    @FindBy(id = "address")
    public WebElement Address;

    @FindBy(id = "city")
    public WebElement City;

    @FindBy(id = "dob")
    public WebElement DOB;

    @FindBy(id = "headlessui-listbox-button-14")
    public WebElement State;

    //@FindBy(xpath = "//li[@id='headlessui-listbox-option-137']//span[.='Pennsylavania']")
    //public WebElement MyState;

    @FindBy(id = "headlessui-listbox-button-17")
    public WebElement Country;

    //@FindBy(xpath = "//li[@id='headlessui-listbox-option-152']//span[.='United States of America']")
    //public WebElement MyCountry;

    @FindBy(xpath = "//span[.='Save']")
    public WebElement SaveBtn;




}
