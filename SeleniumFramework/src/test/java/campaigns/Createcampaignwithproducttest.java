package campaigns;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.Excel_utility;
import generic_utility.Java_utility;
import generic_utility.Webdriver_utility;
import pom.CampValidation;
import pom.Campignplus;
import pom.Createcampaignwithprod;
import pom.Createcamppage;
import pom.Createprodpage;
import pom.Homepage;
import pom.Productplus;
import pom.Productvalidation;

public class Createcampaignwithproducttest extends BaseClass {

	@Test(groups = "smoketest")
	public void createcampaignwithproducttest() throws Throwable 
	{
//		String Key="webdriver.chrome.driver";
//		String value="./src/main/resources/chromedriver.exe";
//		System.setProperty(Key, value);
//		WebDriver driver=new ChromeDriver();
	/*	String browser = plib.getkeyvalue("Browser");
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
		Webdriver_utility wblib=new Webdriver_utility();
//		wblib.getwait(driver);
//		wblib.getmaximaze(driver);
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		/*Property_utility plib=new Property_utility();
		String URL = plib.getkeyvalue("url");
		String USERNAME = plib.getkeyvalue("username");
		String PASSWORD =plib.getkeyvalue("password");
	/*	FileInputStream fis=new FileInputStream("./src/test/resources/Propertyfiledata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		*/
		/*
		driver.get(URL);
		loginpage log=new loginpage(driver);
		log.login(USERNAME,PASSWORD);*/
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		Homepage home=new Homepage(driver);
		home.getProductmodule().click();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		Productplus prodpl=new Productplus(driver);
		prodpl.getProdplusbutton().click();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		//Random ran=new Random();
		//int rannum = ran.nextInt(1000);
		Java_utility jlib=new Java_utility();
		int rannum = jlib.getRandomNum();
		
		Excel_utility exlib=new Excel_utility();
		String productdata = exlib.getexceldata("Products",1,1)+rannum;
//		FileInputStream fes=new FileInputStream("./src/test/resources/Excelsheetdata.xlsx");
//		Workbook book = WorkbookFactory.create(fes);
//		Sheet sheet = book.getSheet("Products");
//		Row row = sheet.getRow(1);
//		Cell cell = row.getCell(2);
//		String productdata = cell.getStringCellValue()+rannum;
		Createprodpage prod=new Createprodpage(driver);
		prod.prodtxtfield(productdata);
		prod.getSaveprod().click();
		//driver.findElement(By.name("productname")).sendKeys(data);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		home.getMoredropdown().click();
		home.getCampaignmodule().click();
		//driver.findElement(By.linkText("More")).click();
		//driver.findElement(By.name("Campaigns")).click();
		Campignplus campplus=new Campignplus(driver);
		campplus.getCampplusign().click();
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		

		//Excel_utility exlib1=new Excel_utility();
		String campaigndata = exlib.getexceldata("Campaigns",0,0)+rannum;
//		FileInputStream fes1=new FileInputStream("./src/test/resources/Excelsheetdata.xlsx");
//		Workbook book1 = WorkbookFactory.create(fes1);
//		Sheet sheet1 = book1.getSheet("Campaigns");
//		Row row1 = sheet1.getRow(0);
//		Cell cell1 = row1.getCell(0);
//		String campaigndata = cell1.getStringCellValue()+rannum;
		Createcamppage createcamp=new Createcamppage(driver);
		createcamp.campignnametxtfield(campaigndata);
	
		Createcampaignwithprod prodplus=new Createcampaignwithprod(driver);
		prodplus.getPlusincreatecamp().click();
		//driver.findElement(By.xpath("//img[@title='Select']")).click();
		wblib.switchwindows(driver, "Products&action");
		/*
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> id = allid.iterator();
		while(id.hasNext())
		{
		String window1 = id.next();
		driver.switchTo().window(window1);
		if(driver.getTitle().contains("Products&action"))
		{
			break;
		}
		}
		*/
		Createcampaignwithprod prodplus1=new Createcampaignwithprod(driver);
		prodplus1.searchtxtdata(productdata);
		prodplus1.getProdsearchbutton().click();
	 // driver.findElement(By.id("search_txt")).sendKeys(productdata);
  	 // driver.findElement(By.name("search")).click();
  	  
  	 //dynamic xpath
	
  	  driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
  	  
		wblib.switchwindows(driver, "Campaigns&action");

  	 /* Set<String> allId1 = driver.getWindowHandles();//org   //cont  //prd
        Iterator<String> id1 = allId1.iterator();
        
        while(id1.hasNext())
        {
      	  String wid1 = id1.next();//org
      	  driver.switchTo().window(wid1);
      	  String title = driver.getTitle();
      	  
      	  if(title.contains("Campaigns&action"))
      	  {
      		  break;
      	  }
        }
  	  */
		createcamp.getCampsave().click();

//        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CampValidation campvalid=new CampValidation(driver);
		campvalid.actualdatavalidation(driver, campaigndata);
      /*String act = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
      if(act.contains(campaigndata))
      {
      	System.out.println("camp pass");
      }
      else
      {
      	System.out.println("camp fail");
      }*/
		Productvalidation prodvalid=new Productvalidation(driver);
		prodvalid.productvalidation(driver, productdata);
    /*  String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
      if(actData.contains(productdata))
      {
      	System.out.println("product Pass");
      }
      else
      {
      	System.out.println("Product fail");
      }*/
//      
//      home.getAdmindropdown().click();
//	  home.getSignoutbutton().click();
      
		
	}

}
