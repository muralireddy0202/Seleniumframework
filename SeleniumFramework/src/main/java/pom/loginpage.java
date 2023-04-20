package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage 
{
	public loginpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	//declaration
	
	@FindBy(name="user_name")
	private WebElement UserTextField;
	@FindBy(name="user_password")
	private WebElement PasswordTextField;
	@FindBy(id="submitButton")
	private WebElement LoginButton;
	
	//getter methods
	
	public WebElement getUserTextField() {
		return UserTextField;
	}
	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}
	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//logic
    public  void login(String username,String password)
   {
    	UserTextField.sendKeys(username); 
    	PasswordTextField.sendKeys(password);
    	LoginButton.click();
   }
	
}
