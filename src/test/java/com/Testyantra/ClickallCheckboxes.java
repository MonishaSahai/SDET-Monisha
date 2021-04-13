package com.Testyantra;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClickallCheckboxes {
	
	@Test
	public void checkAllCheckBoxes() {
		WebDriver driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       	driver.manage().window().maximize();
       	driver.get("http://localhost:8888/");
       	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
       	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("root");
       	driver.findElement(By.id("submitButton")).click();
       	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
     // WebElement wb = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr/td/input[@id='selectCurrentPageRec']"));
       	List<WebElement> li = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		for (int i = 1; i < li.size(); i++) 
		{
		li.get(i).click();
		}
       	
	}

}
