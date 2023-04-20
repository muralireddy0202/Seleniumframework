package generic_utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_utility 
{
	/**
	 * This method is used to fetch the common data from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
 public String getkeyvalue(String key) throws Throwable
 {
	    FileInputStream fis=new FileInputStream("./src/test/resources/Propertyfiledata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
 }
}
