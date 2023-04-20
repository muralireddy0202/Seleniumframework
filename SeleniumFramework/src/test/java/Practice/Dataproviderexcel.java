package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utility.Excel_utility;

public class Dataproviderexcel 
{	
	@Test(dataProvider="dataproviderfetch")
	public void booktickets(String src,String dest) 
	{
		System.out.println("BOOk tickets from "+ src +" to " + dest );
	}
	@DataProvider
	public Object[][] dataproviderfetch() throws Throwable
	{
		Excel_utility exlib=new Excel_utility();
		Object[][] data = exlib.dataproviderfetcher("dataprovider");
		
		/*Object[][] obj=new Object[3][2];
		for(int i=0;i<3;i++) 
		{
		for(int j=0;j<2;j++)
		{
			obj[i][j]=exlib.getexceldataformatter1("dataprovider",i,j);
		}
		}*/
	/*	
		obj[0][0]=exlib.getexceldataformatter1("dataprovider", 0, 0);
		obj[0][1]=exlib.getexceldataformatter1("dataprovider", 0, 1);
		obj[1][0]=exlib.getexceldataformatter1("dataprovider", 1, 0);
		obj[1][1]=exlib.getexceldataformatter1("dataprovider", 1, 1);
		obj[2][0]=exlib.getexceldataformatter1("dataprovider", 2, 0);
		obj[2][1]=exlib.getexceldataformatter1("dataprovider", 2, 1);
		
	*/	
		return data;
	}
	
}
