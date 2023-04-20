package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createprodpage 
{
	public Createprodpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="productname")private WebElement prodnametxt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveprod;
	
	public WebElement getProdnametxt() {
		return prodnametxt;
	}
	public WebElement getSaveprod() {
		return saveprod;
	}
	
	public void prodtxtfield(String data)
	{
		prodnametxt.sendKeys(data);
	}
	
}
