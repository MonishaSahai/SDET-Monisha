package com.vtiger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrganizationValidationOld {
	
	public static void main(String[]args) throws InterruptedException {
 	     
		
    	WebDriver driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       	driver.manage().window().maximize();
       	driver.get("http://localhost:8888/");
       	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
       	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("root");
       	driver.findElement(By.id("submitButton")).click();
       	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
       	//String actual =driver.findElement(By.xpath("//td[contains(text(),'Showing Records')][1]")).getText();
       	String exp =driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[3]")).getText();
       	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
       	String orgname ="IKEA";
       	Random r = new Random();
       	int x = r.nextInt(100);
       	orgname = orgname + x;
       	
       	
       	//create new organization
       	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
       	driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("9945623167");
       	//listbox:1
        WebElement Industry = driver.findElement(By.xpath("//select[@name='industry']"));
        Select s = new Select(Industry);
        s.selectByValue("Banking");
        //listbox:2
        WebElement Rating = driver.findElement(By.xpath("//select[@name='rating']"));
        Select s1 = new Select(Rating);
        s1.selectByValue("Active");
        //listbox:3
        WebElement Type = driver.findElement(By.xpath("//select[@name='accounttype']"));
        Select s2 = new Select(Type);
        s2.selectByValue("Analyst");
        driver.findElement(By.xpath(" //input[@accesskey='S'][1]")).click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='dvHeaderText']")));
        driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
        WebElement Searchbox = driver.findElement(By.xpath("//input[@name='search_text']"));
        wait.until(ExpectedConditions.elementToBeClickable(Searchbox));
        Searchbox.sendKeys(orgname);
        Select org = new Select(driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield']")));
        org.selectByVisibleText("Organization Name");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        Thread.sleep(3000);
        
        String actual =driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']")).getText();
        System.out.println(actual);
        System.out.println(orgname);
        Assert.assertEquals(orgname, actual);
        System.out.println("Organization created Successfully");
       // boolean result = actual.contains(orgname);
       // System.out.println(result);
        //wait.until(ExpectedConditions.elementToBeClickable(search)).click();
        
        
        
       /* Assert.assertEquals(actual, exp);
        System.out.println(actual);
        System.out.println(exp);
        /*wait.until(ExpectedConditions.elementToBeClickable(search)).click();
        Thread.sleep(5000);

        String name = driver.findElement(By.xpath("//table[@class='lvt small']//a[@title = 'Organizations']")).getText();
        System.out.println(orgName.equals(name));*/
      
        	/*if(actual==exp){
        		System.out.println("New Organisation not created");
        	}
        	else {
        		System.out.println("New Organisation created");
        		
             	 }*/
        	//LOGOUT
        	
    		WebElement crmout =driver.findElement(By.xpath("//td[contains(@onmouseout,'fnHideDrop')][1]"));
    		Actions act1 = new Actions(driver);
        	act1.moveToElement(crmout).perform();
        	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
        	
        	driver.close();
        	}
        	
        
        
}