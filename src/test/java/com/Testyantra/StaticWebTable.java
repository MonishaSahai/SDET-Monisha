package com.Testyantra;


	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class StaticWebTable {
	       public static void main(String[]args) {
	    	WebDriver driver = new ChromeDriver(); 	
	       	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	       	driver.manage().window().maximize();
	       	driver.get("https://www.selenium.dev/downloads/");
	       	
	       	List<WebElement> wb = driver.findElements(By.xpath("//table[@class='data-list']//tr/td[1]"));
	       	
	       	for(WebElement w:wb) {
	       	String lang	= w.getText();
	       	System.out.println(lang);
	       	if(lang.equalsIgnoreCase("Python")) 
	       	{
	       		WebElement lan = driver.findElement(By.xpath("//table[@class='data-list']//tbody//tr[3]//td[2]"));
	       		System.out.println(lan);
	       	}
	       	}
	       	driver.close();
	       }
	

}
