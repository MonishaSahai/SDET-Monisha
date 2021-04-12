package com.vtiger;


	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic.JavaUtility;
	public class Create_Contact {
		JavaUtility jv = new JavaUtility();
        @Test
		public void createContact(){
			
		
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://localhost:8888/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
				driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("12345");
				driver.findElement(By.id("submitButton")).click();
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();

				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

				Select title = new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
				title.selectByVisibleText("Ms.");

				driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Milana");
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("C P");

				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		}

	
}
