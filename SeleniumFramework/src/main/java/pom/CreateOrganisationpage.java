package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationpage 
{
public CreateOrganisationpage(WebDriver driver) 
{
	PageFactory.initElements(driver,this);
}

@FindBy(name= "accountname")private WebElement organisationnametxt;
@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveOrganisation;
public WebElement getOrganisationnametxt() {
	return organisationnametxt;
}
public WebElement getSaveOrganisation() {
	return saveOrganisation;
}

public void Organisationdata(String data)
{
	organisationnametxt.sendKeys(data);
}
}
