package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Homepage;
import pom.loginpage;

public class BaseClass 
{
	//public static WebDriver sDriver;
	public WebDriver driver;
	
	@BeforeSuite(groups = {"smoketest","regressiontest","sanitytest"})
	public void BS() 
	{
		System.out.println("Database connection");
	}
	
	@BeforeTest(groups = {"smoketest","regressiontest","sanitytest"})
	public void BT() 
	{
		System.out.println("parallel execution");
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smoketest","regressiontest","sanitytest"})
//	public void BC( String browser)  throws Throwable
	public void BC() throws Throwable
	{
		Property_utility plib=new Property_utility();
		String browser = plib.getkeyvalue("Browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		System.out.println("launching the browser");
		//sDriver=driver;
	}
	
	@BeforeMethod(groups = {"smoketest","regressiontest","sanitytest"})
	public void BM() throws Throwable
	{
			Webdriver_utility wblib=new Webdriver_utility();
			wblib.getwait(driver);
			wblib.getmaximaze(driver);
	    	Property_utility plib=new Property_utility();
			String URL = plib.getkeyvalue("url");
			String USERNAME = plib.getkeyvalue("username");
			String PASSWORD =plib.getkeyvalue("password");
			driver.get(URL);
			loginpage log=new loginpage(driver);
			log.login(USERNAME,PASSWORD);
		System.out.println("login to application");
	}
	
	@AfterMethod(groups = {"smoketest","regressiontest","sanitytest"})
	public void AM() 
	{
		Homepage home=new Homepage(driver);
		home.getAdmindropdown().click();
		home.getSignoutbutton().click();
		System.out.println("logout of application");
	}
	
	@AfterClass(groups = {"smoketest","regressiontest","sanitytest"})
	public void AC() 
	{
		//driver.quit();
		System.out.println("close the browser");	
	}
	
	@AfterTest(groups = {"smoketest","regressiontest","sanitytest"})
	public void AT() 
	{
		System.out.println("parallel execution done ");
	}
	
	@AfterSuite(groups = {"smoketest","regressiontest","sanitytest"})
	public void AS()
	{
		System.out.println("database connection close ");
	}
}
