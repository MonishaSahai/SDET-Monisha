package com.Testyantra;


	import java.util.NoSuchElementException;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class FutureDateHandling {
		public static void main(String[]args) throws InterruptedException{
			
			
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
	          
		  	  int count=0;
		  	  
		  	  while(count<11) 
		  	  {
		  		   try
		  		   {
		  			   driver.findElement(By.xpath("//div[@aria-label='Mon Sep 06 2021']")).click();
		  			   
		  		   }
		  		   catch(Exception e1) {
		  			 
		  			   driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		  			 Thread.sleep(1000);
		  			   count++;
		  		   }
		  		 
		  	  }
		  	  System.out.println(count);
		
		}
	

}
