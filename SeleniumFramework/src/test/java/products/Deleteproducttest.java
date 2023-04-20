package products;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.Excel_utility;
import generic_utility.Java_utility;
import generic_utility.Webdriver_utility;
import pom.Createprodpage;
import pom.Homepage;
import pom.Productdeletevalidation;
import pom.Productplus;

public class Deleteproducttest extends BaseClass {

	@Test
	public void deleteproduct() throws Throwable 
	{
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
//		
		Webdriver_utility wblib=new Webdriver_utility();
//		wblib.getwait(driver);
//		wblib.getmaximaze(driver);
	
	/*	Property_utility plib=new Property_utility();
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
		*/
		/*
		driver.get(URL);
		loginpage log=new loginpage(driver);
		log.login(USERNAME,PASSWORD);
		*/
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		Homepage home=new Homepage(driver);
		home.getProductmodule().click();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		Productplus prodpl=new Productplus(driver);
		prodpl.getProdplusbutton().click();
//		driver.findElement(By.xpath("//a[text()='Products']")).click();
//		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		//Random ran=new Random();
		//int rannum = ran.nextInt(1000);
		Java_utility jlib=new Java_utility();
		int rannum = jlib.getRandomNum();
		
		Excel_utility exlib=new Excel_utility();
		String data = exlib.getexceldata("Products", 1, 2)+rannum;
//		FileInputStream fes=new FileInputStream("./src/test/resources/Excelsheetdata.xlsx");
//		Workbook book = WorkbookFactory.create(fes);
//		Sheet sheet = book.getSheet("Products");
//		Row row = sheet.getRow(1);
//		Cell cell = row.getCell(2);
//		String data = cell.getStringCellValue()+rannum;
//		
//		driver.findElement(By.name("productname")).sendKeys(data);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Createprodpage prod=new Createprodpage(driver);
		prod.prodtxtfield(data);
		prod.getSaveprod().click();
		
		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		wblib.switchtoalertaccept(driver);
		
		Productdeletevalidation proddelevalid=new Productdeletevalidation(driver);
		proddelevalid.checkproductinlist(driver, data);
		/*List<WebElement> allproducts = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		boolean check=false;
		for(WebElement eachproduct:allproducts)
		{
		  if(eachproduct.getText().contains(data))	
		  {
			  check=true;
			  break;
		  }
		}
		if(check)
		{
		 System.out.println("product not deleted");
		}
		else 
		{
			System.out.println("product deleted");
		}*/
	}

}
