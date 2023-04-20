package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productdeletevalidation 
{
	public Productdeletevalidation(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]")private List<WebElement> productslist;

	
	
	public void checkproductinlist(WebDriver driver,String data)
	{
		boolean check=false;
		for(WebElement eachproduct:productslist)
		{
		  if(eachproduct.getText().contains(data))	
		  {
			  check=true;
			  break;
		  }
		}
		if(check)
		{
		 System.out.println("product not deleted");
		}
		else 
		{
			System.out.println("product deleted");
		}
	}
}
