package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organisationvalidation 
{
	public Organisationvalidation(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

@FindBy(xpath = "//span[@id='dtlview_Organization Name']")private WebElement organactualdata;

public WebElement getOrganactualdata() {
	return organactualdata;
}



public String actualdatavalidation(WebDriver driver,String data)
{
	String actualdata = organactualdata.getText();
	if(actualdata.contains(data))
	{
		System.out.println(" organ pass");
	}
	else
	{
		System.out.println("organ fail");
	}
	return actualdata;
}
}
