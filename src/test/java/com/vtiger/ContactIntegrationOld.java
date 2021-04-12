package com.vtiger;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContactIntegrationOld {
       public static void main(String[]args) {
    	   WebDriver driver = new ChromeDriver();
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	   	driver.manage().window().maximize();
    	   	driver.get("http://localhost:8888/");
    	   	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
    	   	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("root");
    	   	driver.findElement(By.id("submitButton")).click();
    	   	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
    	   	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
    	   	driver.findElement(By.xpath("//img[@title='Select'][1]")).click();
    	   	String lastname ="kumar";
    	   	Random r1 = new Random();
    	   	int x1 = r1.nextInt(100);
    	   	lastname = lastname + x1;
    	   	
    	   	String mainId = driver.getWindowHandle();
    	   	Set<String> allId= driver.getWindowHandles();
    	   	for(String id : allId) {
    	   		if(!mainId.equals(id)) {
    	   			driver.switchTo().window(id);
    	   			driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("Test1");
    	   			driver.findElement(By.xpath("//input[@name='search']")).click();
    	   			driver.findElement(By.xpath("//table[contains(@style,'background-color')]/tbody/tr[2]//a")).click();
    	   			driver.switchTo().window(mainId);
    	   			
    	   			driver.findElement(By.xpath("//table[@class='dvtContentSpace']//tbody//tbody//tbody/tr[5]/td[4]/input")).sendKeys("9876543210");
    	   			driver.findElement(By.xpath("//table[@class='dvtContentSpace']//tbody//tbody//tbody/tr[4]/td[2]/input")).sendKeys(lastname);
    	   			driver.findElement(By.xpath("//input[@type='submit'][1]")).click();
    	   			WebElement title  = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
    	   		   
    	   		   if(driver.getTitle().contains("Contacts")){
    	   			   System.out.println("contact created successfully!!");
    	   			   
    	   		   }
    	   		   
    	   		 //LOGOUT
    	   			
    	   			WebElement crmout =driver.findElement(By.xpath("//td[contains(@onmouseout,'fnHideDrop')][1]"));
    	   			Actions act1 = new Actions(driver);
    	   			act1.moveToElement(crmout).perform();
    	   			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
    	   			
    	   			driver.close();
    	   		}
    	   		
    	   	}
       }
}
