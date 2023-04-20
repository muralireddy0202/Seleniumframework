package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organplus 
{
 public Organplus(WebDriver driver)
 {
	 PageFactory.initElements(driver,this);
 }
 @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")private WebElement organplusbutton;
 
 public WebElement getOrganplusbutton() {
	return organplusbutton;
}
 
 
}
