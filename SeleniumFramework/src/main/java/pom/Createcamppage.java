package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createcamppage 
{
public Createcamppage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}
@FindBy(name="campaignname")private WebElement campaignnametxt;
@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement campsave;


public WebElement getCampsave() {
	return campsave;
}
public WebElement getCampaignnametxt() {
	return campaignnametxt;
}
public void campignnametxtfield(String name)
{
	campaignnametxt.sendKeys(name);
}
}
