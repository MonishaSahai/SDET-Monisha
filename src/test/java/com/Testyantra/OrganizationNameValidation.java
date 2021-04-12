package com.Testyantra;

	import java.util.ArrayList;
	import java.util.ArrayList;
import java.util.Collections;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;

	public class OrganizationNameValidation {
	               public static void main(String[]args) {
	            	   System.setProperty("webdriver.chrome.driver", "./src/test/resources/Driver Server/chromedriver.exe");   
	            	WebDriver driver = new ChromeDriver();
	            	
	            	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	               	driver.manage().window().maximize();
	               	driver.get("http://localhost:8888/");
	               	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	               	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("root");
	               	driver.findElement(By.id("submitButton")).click();
	               	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	               	
	               	ArrayList<String> al = new ArrayList<String>();
	               	
	               	
	                List<WebElement>  l= driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
	               	 for(int i =1;i<l.size();i++) {
	               		 
	               		 al.add(l.get(i).getText());
	               	 }
	               	Collections.sort(al);
	               	
	               	driver.findElement(By.xpath("//a[text()='Organization Name']")).click();
	               	
	               	ArrayList<String> al1 = new ArrayList<String>();
	               	List<WebElement>  l1= driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
	              	 for(int i =1;i<l1.size();i++) {
	              		 
	              		 al1.add(l1.get(i).getText());
	              	 }
	              	Collections.sort(al1);
	              	
	              	System.out.println(al);
	              	System.out.println(al1);
	              	
	              	Assert.assertEquals(al,al1);
	              	
	              	driver.close();
	              	
	               }
	           
	}


