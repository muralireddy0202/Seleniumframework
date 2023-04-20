package organization;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.Excel_utility;
import generic_utility.Java_utility;
import pom.CreateOrganisationpage;
import pom.Homepage;
import pom.Organisationvalidation;
import pom.Organplus;

public class CreateOrganizationtest extends BaseClass {

  /*@Test
	public void method() 
	{
		System.out.println("method 1");
	}*/
	
	//@Test(groups = "sanitytest")
	@Test(retryAnalyzer = generic_utility.Retryexample.class)
	public void createOrganization() throws Throwable 
	{
		/*String Key="webdriver.chrome.driver";
		String value="./src/main/resources/chromedriver.exe";
		System.setProperty(Key, value);
		WebDriver driver=new ChromeDriver();*/
		
		/*WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();*/
		
		/*String browser = plib.getkeyvalue("Browser");
		WebDriver driver;
//		WebDriverManager.edgedriver().setup();
//		driver=new EdgeDriver();
		
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
		}*/
		
//		Webdriver_utility wblib=new Webdriver_utility();
//		wblib.getwait(driver);
//		wblib.getmaximaze(driver);
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		
	/*    Property_utility plib=new Property_utility();
		String URL = plib.getkeyvalue("url");
		String USERNAME = plib.getkeyvalue("username");
		String PASSWORD =plib.getkeyvalue("password");
		/*
		FileInputStream fis=new FileInputStream("./src/test/resources/Propertyfiledata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		*//*
		driver.get(URL);
		loginpage log=new loginpage(driver);
		log.login(USERNAME,PASSWORD);
		*/
		
		
//      log.getLoginButton().click();
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		Homepage home=new Homepage(driver);
		home.getOrganmodule().click();
	//	Assert.assertEquals(false,true);
	//	driver.findElement(By.linkText("Organizations")).click();
		Organplus organpl=new Organplus(driver);
		organpl.getOrganplusbutton().click();
	//	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Random ran=new Random();
		//int rannum = ran.nextInt(1000);
		Java_utility jlib=new Java_utility();
		int rannum = jlib.getRandomNum();
	
		Excel_utility exlib=new Excel_utility();
		String data = exlib.getexceldataformatter("Organization", 2, 0)+rannum;
		//String data = exlib.getexceldata("Organization", 2, 0)+rannum;
//		FileInputStream fes=new FileInputStream("./src/test/resources/Excelsheetdata.xlsx");
//		Workbook book = WorkbookFactory.create(fes);
//		Sheet sheet = book.getSheet("Organization");
//		Row row = sheet.getRow(2);
//		Cell cell = row.getCell(0);
//		String data = cell.getStringCellValue()+rannum;
		
		CreateOrganisationpage organdata=new CreateOrganisationpage(driver);
		organdata.Organisationdata(data);
		organdata.getSaveOrganisation().click();
//		driver.findElement(By.name("accountname")).sendKeys(data);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Organisationvalidation organvalid=new Organisationvalidation(driver);
		//String actdata = driver.findElement(By.className("dvHeaderText")).getText();
		String actualdata = organvalid.actualdatavalidation(driver, data);
		Assert.assertEquals(actualdata, data);
//		
//		home.getAdmindropdown().click();
//		home.getSignoutbutton().click();
    
//		driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
	}

}
