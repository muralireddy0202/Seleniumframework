package generic_utility;

import java.util.Random;

public class Java_utility 
{
	/**
	 * This method is used to avoid duplicates
	 * @return
	 */
	public int getRandomNum() 
	{
		Random ran=new Random();
		int rannum=ran.nextInt(1000);
		
		return rannum;
		
	}
}
