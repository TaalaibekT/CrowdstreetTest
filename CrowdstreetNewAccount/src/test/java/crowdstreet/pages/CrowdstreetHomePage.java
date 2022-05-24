package crowdstreet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;

public class CrowdstreetHomePage{

    WebDriver driver;
        public CrowdstreetHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
}

    @FindBy(xpath = "//div[@class='menus-container css-rzhaz7']//a[.='Create An Account']")

    public WebElement createAnAccountBtn;

}
