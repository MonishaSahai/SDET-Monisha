package com.generic;


	import java.util.Date;
	import java.util.Random;

	public class JavaUtility 
	{

		/**
		 * @author Monisha
		 *  Generate a random number
		 * @return randomnumber till 10000
		 */
		public int createRandomNumber() 
		{
			Random r = new Random();
			int randomnumber= r.nextInt(9999);
			return randomnumber;
		}

		/**
		 * @author Monisha
		 * Provide Current System Date
		 * @return currentSysDate
		 */

		public String getCurrentSystemDate() 
		{
			Date dateobj= new  Date();
			String currentSysDate=dateobj.toString();
			return currentSysDate;

		}
		/**
		 * @author Monisha
		 * Provide current month
		 * @return current month
		 */
		public int getCurrentMonth() 
		{
			Date dateobj= new  Date();
			return dateobj.getMonth();

		}

		/**
		 * @author Monisha
		 * Gives current date
		 * @return date
		 */
		public String getDate()
		{
			Date dateobj= new  Date();
			String currentSysDate=dateobj.toString();
			String arr[]=currentSysDate.split(" ");
			return arr[2];

		}

	
}
