package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Organizations")private WebElement organmodule;
	@FindBy(xpath="//a[text()='Products']")private WebElement productmodule;
	@FindBy(xpath = "//a[text()='Contacts']")private WebElement contactmodule;
	@FindBy(linkText="More")private WebElement moredropdown;
	@FindBy(name = "Invoice")private WebElement invoicemodule;
	@FindBy(name="Campaigns")private WebElement campaignmodule;
	@FindBy(xpath="(//img[@style='padding: 0px;padding-left:5px'])[1]")private WebElement admindropdown;
	@FindBy(linkText = "Sign Out")private WebElement signoutbutton;
	
	public WebElement getCampaignmodule() {
		return campaignmodule;
	}
	public WebElement getOrganmodule() {
		return organmodule;
	}
	public WebElement getProductmodule() {
		return productmodule;
	}
	public WebElement getContactmodule() {
		return contactmodule;
	}
	public WebElement getMoredropdown() {
		return moredropdown;
	}
	public WebElement getInvoicemodule() {
		return invoicemodule;
	}
	public WebElement getAdmindropdown() {
		return admindropdown;
	}
	public WebElement getSignoutbutton() {
		return signoutbutton;
	}


	
	
	
	
	
}
