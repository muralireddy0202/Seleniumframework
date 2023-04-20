package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productplus 
{
	public Productplus(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }
	 @FindBy(xpath="//img[@alt='Create Product...']")private WebElement prodplusbutton;
	 
	public WebElement getProdplusbutton()
	{
		return prodplusbutton;
	}
	 

}
