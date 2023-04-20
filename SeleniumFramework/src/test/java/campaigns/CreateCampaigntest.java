package campaigns;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.Excel_utility;
import generic_utility.Java_utility;
import pom.CampValidation;
import pom.Campignplus;
import pom.Createcamppage;
import pom.Homepage;


public class CreateCampaigntest extends BaseClass {

	@Test(groups = {"smoketest","regressiontest"})
	public void createCampaign() throws Throwable 
	{
		//pushed and pulling back
		//2nd push
//		String Key="webdriver.chrome.driver";
//		String value="./src/main/resources/chromedriver.exe";
//		System.setProperty(Key, value);
//		WebDriver driver=new ChromeDriver();
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
		}
		*/
//		Webdriver_utility wblib=new Webdriver_utility();
//		wblib.getwait(driver);
//		wblib.getmaximaze(driver);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	/*	Property_utility plib=new Property_utility();
		String URL = plib.getkeyvalue("url");
		String USERNAME = plib.getkeyvalue("username");
		String PASSWORD =plib.getkeyvalue("password");
	/*	FileInputStream fis=new FileInputStream("./src/test/resources/Propertyfiledata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		driver.get(URL);
		loginpage log=new loginpage(driver);
		log.login(USERNAME,PASSWORD);
		*/
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		Homepage home=new Homepage(driver);
		home.getMoredropdown().click();
		home.getCampaignmodule().click();
		//driver.findElement(By.linkText("More")).click();
		//driver.findElement(By.name("Campaigns")).click();
		Campignplus campplus=new Campignplus(driver);
		campplus.getCampplusign().click();
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		/*Random ran=new Random();
		int ranval = ran.nextInt(1000);*/
		
		Java_utility jlib=new Java_utility();
		int rannum = jlib.getRandomNum();
		
		Excel_utility exlib=new Excel_utility();
		String campaigndata = exlib.getexceldata("Campaigns", 0, 0)+rannum;
//		FileInputStream fes=new FileInputStream("./src/test/resources/Excelsheetdata.xlsx");
//		Workbook book = WorkbookFactory.create(fes);
//		Sheet sheet = book.getSheet("Campaigns");
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		String campaigndata = cell.getStringCellValue()+rannum;
		
		Createcamppage createcamp=new Createcamppage(driver);
		createcamp.campignnametxtfield(campaigndata);
		//driver.findElement(By.name("campaignname")).sendKeys(campaigndata);
		//driver.findElement(By.xpath("//img[@title='Select']")).click();
	
		createcamp.getCampsave().click();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		CampValidation valid=new CampValidation(driver);
		String actualdata = valid.actualdatavalidation(driver, campaigndata);
		Assert.assertEquals(actualdata, campaigndata);
	//	String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		
		
		
//		home.getAdmindropdown().click();
//		home.getSignoutbutton().click();
    
//		driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
	}

}
