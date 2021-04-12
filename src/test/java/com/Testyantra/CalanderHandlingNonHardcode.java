package com.Testyantra;


	import java.util.Date;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class CalanderHandlingNonHardcode {
		public static void main(String[]args) {
			Date d = new Date();
			String cursysdate = d.toString();
			System.out.println(cursysdate);
			
			String arr[]=cursysdate.split(" ");
			String var = arr[0];
			String date = arr[2];
			String month = arr[1];
			String year = arr[5];
			
			System.out.println(var+ " "+date+" "+month+" "+year);
	  	  
	  	  WebDriver driver = new ChromeDriver();
	  	
	    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	driver.manage().window().maximize();
	    	driver.get("https://www.makemytrip.com/");
	    	 
	  	  WebDriverWait wait = new WebDriverWait(driver,20);
	  	  //to handle pop
	  	  Actions a = new Actions(driver);
	  	  a.moveByOffset(10,10).click().perform();
	  	  
	  	  driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("BOM");
	  	  driver.findElement(By.xpath("//div[contains(text(),'BOM')]")).click();
	  	  
	  	  driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("PNQ");
	  	  driver.findElement(By.xpath("//div[contains(text(),'PNQ')]")).click();
	  	  
	  	  
	  	  WebElement e = driver.findElement(By.xpath("//span[text()='DEPARTURE']"));
	  	  wait.until(ExpectedConditions.elementToBeClickable(e)).click();
	  	  
	  	  String currentdate = var+" "+month+" "+date+" "+year;
	  	  
	  	  // driver.findElement(By.xpath("//div[@aria-label='Wed Apr 07 2021']")).click();
	  	  driver.findElement(By.xpath("//div[@aria-label='"+currentdate+"']")).click();
	  	 /* Date d = new Date();
	  	  SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	  	String date  = sdf.format(d);
	  	WebElement e1=driver.findElement(By.xpath("//div[@aria-selected='true']"));
	  	e1.click();
	  	System.out.println(e1);
	  	 if(e==e1)
	  	  {
	  		
	  		System.out.println("pass");
	  		
	  	  }*/
	  	  driver.close();
	    }


	
}
