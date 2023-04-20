package Practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

public class Browser {

	public static void main(String[] args) throws Throwable 
	{
		
	String Key="webdriver.chrome.driver";
	String value="./src/main/resources/chromedriver.exe";
	System.setProperty(Key, value);
	WebDriver driver=new ChromeDriver();
		
	/*	String Key="webdriver.edge.driver";
		String value="./src/main/resources/msedgedriver.exe";
		System.setProperty(Key, value);
		WebDriver driver=new EdgeDriver();*/
		
	FileInputStream fis=new FileInputStream("./src/test/resources/Propertyfiledata.properties");
	Properties pro=new Properties();
	pro.load(fis);
	String URL = pro.getProperty("url");
	driver.get(URL);
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");
	driver.findElement(By.id("username")).sendKeys(USERNAME);
	driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
	driver.findElement(By.id("loginButton")).click();

	}

}
