package generic_utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_utility
{
/**
 * This method is used for waits
 */
	public void getwait(WebDriver driver)
	{
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	}
	/**
	 * This method is used to maximaze the screen
	 * @param driver
	 */
    public void getmaximaze(WebDriver driver)
    {
    	driver.manage().window().maximize();
    }
    
    /**
     * this method is used to switch to windows
     * @param driver
     * @param partialtitle
     */
    public void switchwindows(WebDriver driver,String partialtitle)
    {
    	Set<String> allid = driver.getWindowHandles();
		Iterator<String> id = allid.iterator();
		while(id.hasNext())
		{
			String wind = id.next();
			driver.switchTo().window(wind);
			if(driver.getTitle().contains(partialtitle))
			{
				break;
			}
		}
    }
    /**
     * to accept the alert window
     * @param driver
     */
    public void switchtoalertaccept(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    /**
     *  to dismiss the alert window
     * @param driver
     */
    public void switchtoalertdismiss(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();;
    }
    /**
     * used to select from dropdown using indexvalue
     * @param ele
     * @param num
     */
    public void selectbyindex(WebElement ele,int num)
    {
    	Select sel=new Select(ele);
    	sel.selectByIndex(num);
    }

    /**
     * used to select from dropdown using visible text
     * @param ele
     * @param text
     */
    public void selectbytext(WebElement ele,String text)
    {
    	Select sel=new Select(ele);
    	sel.selectByVisibleText(text);
    }
    
    /**
     * used to move cursor to element and highlight
     * @param driver
     * @param ele
     */
    public void actmovetoelement(WebDriver driver,WebElement ele)
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(ele).perform();
    }
    
    /**
     * used to right click on element
     * @param driver
     * @param ele
     */
    public void rightclicktoelement(WebDriver driver,WebElement ele)
    {
    	Actions act=new Actions(driver);
    	act.contextClick(ele).perform();
    }
    
 
}
