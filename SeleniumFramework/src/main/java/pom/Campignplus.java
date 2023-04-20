package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campignplus 
{
	public Campignplus(WebDriver driver) 
	{
	   PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Campaign...']")private WebElement campplusign;

	public WebElement getCampplusign() {
		return campplusign;
	}
	
	
}
