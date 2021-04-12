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

	public class CalenderHandlingHardcode {
		public static void main(String[]args) {
			
			
			
	  	  
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
	  	  
	  
	  	  
	  	  driver.findElement(By.xpath("//div[@aria-label='Wed Apr 07 2021']")).click();
	  	  driver.close();
		}
	

}
