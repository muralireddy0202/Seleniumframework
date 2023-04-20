package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderexample 
{
	@Test(dataProvider="dataprovider")
	public void booktickets(String src,String dest) 
	{
		System.out.println("BOOk tickets from "+ src +" to " + dest );
	}
	@DataProvider
	public Object[][] dataprovider()
	{
		Object[][] obj=new Object[3][2];
		
		obj[0][0]="Bangalore";
		obj[0][1]="goa";
		obj[1][0]="Bangalore";
		obj[1][1]="mysore";
		obj[2][0]="Bangalore";
		obj[2][1]="mangalore";
		return obj;
	}
}
