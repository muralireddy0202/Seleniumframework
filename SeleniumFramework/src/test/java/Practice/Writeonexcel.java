package Practice;
import org.testng.annotations.Test;
import generic_utility.BaseClass;
import generic_utility.Excel_utility;
import pom.Amazonhome;


public class Writeonexcel  extends BaseClass
{
	@Test
public void writeonexceltest() throws Throwable
{
		Excel_utility ex=new Excel_utility();
		String data = ex.getexceldata("amazon",0,0);
	
		Amazonhome homepage=new Amazonhome(driver);
		homepage.searchdata(data);
		
		homepage.writeproduct();
		
	
		
}

}
