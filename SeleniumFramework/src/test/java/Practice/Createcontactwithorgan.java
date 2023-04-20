package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.Excel_utility;
import generic_utility.Java_utility;
import generic_utility.Property_utility;
import generic_utility.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateOrganisationpage;
import pom.Homepage;
import pom.Organplus;
import pom.loginpage;

public class Createcontactwithorgan {

	public static void main(String[] args) throws Throwable
{
//		String Key="webdriver.chrome.driver";
//		String value="./src/main/resources/chromedriver.exe";
//		System.setProperty(Key, value);
//		WebDriver driver=new ChromeDriver();
	Property_utility plib=new Property_utility();
	String browser = plib.getkeyvalue("Browser");
	WebDriver driver;
//	WebDriverManager.edgedriver().setup();
//	driver=new EdgeDriver();
	
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
		Webdriver_utility wblib=new Webdriver_utility();
		wblib.getwait(driver);
		wblib.getmaximaze(driver);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		
		String URL = plib.getkeyvalue("url");
		String USERNAME = plib.getkeyvalue("username");
		String PASSWORD =plib.getkeyvalue("password");
	
		driver.get(URL);
		loginpage log=new loginpage(driver);
		log.login(USERNAME,PASSWORD);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
		Homepage home=new Homepage(driver);
		home.getOrganmodule().click();
		//driver.findElement(By.linkText("Organizations")).click();
		Organplus organpl=new Organplus(driver);
		organpl.getOrganplusbutton().click();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
		Java_utility jlib=new Java_utility();
		int rannum = jlib.getRandomNum();
	
		Excel_utility exlib=new Excel_utility();
		String data = exlib.getexceldata("Organization", 2, 0)+rannum;
		
		CreateOrganisationpage organdata=new CreateOrganisationpage(driver);
		organdata.Organisationdata(data);
		organdata.getSaveOrganisation().click();
//		driver.findElement(By.name("accountname")).sendKeys(data);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		home.getContactmodule().click();
		//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		String firstname = exlib.getexceldata("Contacts",1,0);
		String lastname = exlib.getexceldata("Contacts",1,1);

		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		wblib.switchwindows(driver, "Accounts&action");
		/*Set<String> allid = driver.getWindowHandles();
		Iterator<String> id = allid.iterator();
		while(id.hasNext())
		{
			String wind = id.next();
			driver.switchTo().window(wind);
			if(driver.getTitle().contains("Accounts&action"))
			{
				break;
			}
		}*/
		driver.findElement(By.name("search_text")).sendKeys(data);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+data+"']")).click();
		wblib.switchwindows(driver, "Contacts&action");
		/*Set<String> allid1 = driver.getWindowHandles();
		Iterator<String> id1 = allid1.iterator();
		while(id1.hasNext())
		{
			String wind1 = id1.next();
			driver.switchTo().window(wind1);
			if(driver.getTitle().contains("Contacts&action"))
			{
				break;
			}
		}*/
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String value1 = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(value1.contains(lastname))
		{
			System.out.println("contact pass");
		}
		else
		{
			System.out.println("contact failed");
		}
		
		home.getAdmindropdown().click();
		home.getSignoutbutton().click();
//		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//	     driver.findElement(By.linkText("Sign Out")).click();
	      
	}

}
