package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productvalidation 
{
public Productvalidation(WebDriver driver) 
{
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//span[@id='dtlview_Product']")private WebElement actualproductdata;
@FindBy(xpath="//span[@id='dtlview_Product Name']")private WebElement actualproductdata1;

public WebElement getActualproductdata1() {
	return actualproductdata1;
}

public WebElement getActualproductdata() {
	return actualproductdata;
}

public void productvalidation(WebDriver driver,String data)
{
	String actualdata = actualproductdata.getText();
	if(actualdata.contains(data))
	{
		System.out.println("product pass");
	}
	else
	{
		System.out.println("product fail");
	}
}
public String productvalidation1(WebDriver driver,String data)
{
	String actualdata = actualproductdata1.getText();
	if(actualdata.contains(data))
	{
		System.out.println("product pass");
	}
	else
	{
		System.out.println("product fail");
	}
	return actualdata;
}

}
