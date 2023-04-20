package pom;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.Excel_utility;

public class Amazonhome 
{
	Excel_utility ex=new Excel_utility();
  public Amazonhome(WebDriver driver) 
  {
	PageFactory.initElements(driver,this);
  }
  @FindBy(id="twotabsearchtextbox") private WebElement search;
 @FindBy(id="nav-search-submit-button") private WebElement searchbutton;
 
 @FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")private List<WebElement> allproducts;
  public WebElement getSearchbutton() {
	return searchbutton;
}
public WebElement getSearch() {
	return search;
  }

	public List<WebElement> getAllproducts() {
	return allproducts;
}
	public void searchdata(String data)
	{
		search.sendKeys(data);
		searchbutton.click();
	}
	
	public void writeproduct() throws Throwable
	{
		int i=1;
		for (WebElement webElement : allproducts)
		{
			
			//System.out.println(webElement.getText());
			String product = webElement.getText();
			 
			if(product!="") {
				//System.out.println(product);
		        ex.writeexceldata("amazon", i, 0, product);
		        i++;
		       // System.out.println(i);
			}
			else 
			{
				System.out.println("no list");
			}
		}
	}

  
  
}
