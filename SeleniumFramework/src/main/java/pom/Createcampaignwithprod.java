package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createcampaignwithprod 
{
public Createcampaignwithprod(WebDriver driver) 
{
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//img[@title='Select']")private WebElement plusincreatecamp;
@FindBy(id="search_txt")private WebElement productnamesearch;
@FindBy(name="search")private WebElement prodsearchbutton;



public WebElement getProductnamesearch() {
	return productnamesearch;
}


public WebElement getProdsearchbutton() {
	return prodsearchbutton;
}



public WebElement getPlusincreatecamp() {
	return plusincreatecamp;
}

public void  searchtxtdata(String productdata)
{
	productnamesearch.sendKeys(productdata);
	
}


}
