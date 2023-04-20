package Practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import generic_utility.Excel_utility;
import generic_utility.Java_utility;
import generic_utility.Property_utility;
import generic_utility.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateOrganisationpage;
import pom.Homepage;
import pom.Organplus;
import pom.loginpage;

public class Createinvoicewithcontorgan {

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
	
		String URL = plib.getkeyvalue("url");
		String USERNAME = plib.getkeyvalue("username");
		String PASSWORD =plib.getkeyvalue("password");
	
		driver.get(URL);
		loginpage log=new loginpage(driver);
		log.login(USERNAME,PASSWORD);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		Homepage home=new Homepage(driver);
		home.getOrganmodule().click();
	//	driver.findElement(By.linkText("Organizations")).click();
		Organplus organpl=new Organplus(driver);
		organpl.getOrganplusbutton().click();
	//	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
		Java_utility jlib=new Java_utility();
		int rannum = jlib.getRandomNum();
	
		Excel_utility exlib=new Excel_utility();
		String organdata = exlib.getexceldata("Organization", 2, 0)+rannum;
		
		CreateOrganisationpage organ=new CreateOrganisationpage(driver);
		organ.Organisationdata(organdata);
		organ.getSaveOrganisation().click();
//		driver.findElement(By.name("accountname")).sendKeys(organdata);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
	

        driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		String firstname = exlib.getexceldata("Contacts",2,0);
		String lastname = exlib.getexceldata("Contacts",2,1);

		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		wblib.switchwindows(driver, "Accounts&action");


		driver.findElement(By.name("search_text")).sendKeys(organdata);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+organdata+"']")).click();
		wblib.switchwindows(driver, "Contacts&action");

	
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		String data = exlib.getexceldata("Products", 1, 2)+rannum;
		
		driver.findElement(By.name("productname")).sendKeys(data);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Invoice")).click();
		driver.findElement(By.xpath("//img[@alt='Create Invoice...']")).click();
		
		String invoicedata = exlib.getexceldata("Invoice", 1, 0)+rannum;
		driver.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[1]")).sendKeys(invoicedata);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[2]")).click();
		wblib.switchwindows(driver, "Contacts&action");
		
		driver.findElement(By.name("search_text")).sendKeys(organdata);
		WebElement selval = driver.findElement(By.name("search_field"));
		Select sel=new Select(selval);
		sel.selectByVisibleText("Organization Name");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+firstname+" "+lastname+"']")).click();
		wblib.switchtoalertaccept(driver);
		Thread.sleep(1000);
		wblib.switchwindows(driver, "Invoice&action");

		driver.findElement(By.xpath("(//img[@style='cursor:hand;cursor:pointer'])[3]")).click();
		wblib.switchwindows(driver, "Accounts&action");

		driver.findElement(By.name("search_text")).sendKeys(organdata);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+organdata+"']")).click();
		wblib.switchtoalertaccept(driver);

		Thread.sleep(1000);
		wblib.switchwindows(driver, "Invoice&action");
		String addres = exlib.getexceldata("Invoice",1,1);
		
		Thread.sleep(1000);
		driver.findElement(By.name("bill_street")).sendKeys(addres);
		driver.findElement(By.xpath("//input[@onclick='return copyAddressRight(EditView)']")).click();
		driver.findElement(By.xpath("//img[@title='Products']")).click();
		
		wblib.switchwindows(driver, "Products&action");
		driver.findElement(By.name("search_text")).sendKeys(data);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+data+"']")).click();
		
		Thread.sleep(1000);
		wblib.switchwindows(driver, "Invoice&action");

		String qty = exlib.getexceldataformatter("Invoice",1,2);
		driver.findElement(By.id("qty1")).sendKeys(qty);
		driver.findElement(By.name("listPrice1")).clear();
		
		String listprice = exlib.getexceldataformatter("Invoice",1,3);
		driver.findElement(By.name("listPrice1")).sendKeys(listprice);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actdata = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
		
		if(actdata.contains(invoicedata))
		{
			System.out.println("invoice pass");
		}
		else
		{
			System.out.println("invoice fail");
		}

	}

}
