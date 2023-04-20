package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampValidation 
{
public CampValidation(WebDriver driver) 
{
	PageFactory.initElements(driver,this);
}
@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")private WebElement camapignactualdata;

public WebElement getCamapignactualdata() {
	return camapignactualdata;
}



public String actualdatavalidation(WebDriver driver,String data)
{
	String actualdata = camapignactualdata.getText();
	if(actualdata.contains(data))
	{
		System.out.println(" campaign pass");
	}
	else
	{
		System.out.println("campaign fail");
	}
	return actualdata;
}

}
