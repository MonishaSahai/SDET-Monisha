package com.vtiger;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.ExcelUtility;
import generic.FileUtility;
import generic.Iconstants;
import generic.JavaUtility;
import generic.WebDriverUtility;

public class CreateOrgNew {

	JavaUtility jv = new JavaUtility();
	FileUtility fu =  new FileUtility();
	ExcelUtility eu = new ExcelUtility();
	WebDriverUtility wdu = new WebDriverUtility();
	
	@Test
	public void createOrg() throws IOException, InterruptedException {
		int randomnumber=	jv.createRandomNumber();


		//Read data from property file
		String UN=fu.readDatafrompropfile(Iconstants.propfilepath, "username");
		String PWD=fu.readDatafrompropfile(Iconstants.propfilepath, "password");
		String URL=fu.readDatafrompropfile(Iconstants.propfilepath, "url");

		//Read Test Script Data from Excel
		String name= eu.readDatafromExcel("Sheet1", 0, 0);
		String orgname=name+randomnumber;
		String phonenumber= eu.readDatafromExcel("Sheet1", 1, 0);
		String indDD= eu.readDatafromExcel("Sheet1", 2, 0);
		String ratingDD= eu.readDatafromExcel("Sheet1", 3, 0);
		String typeDD=eu.readDatafromExcel("Sheet1", 4, 0);

		System.out.println(name+" "+orgname+" "+phonenumber+" "+indDD+" "+ratingDD+" "+typeDD);

		WebDriver driver = new ChromeDriver();
		wdu.maximizewindow(driver);
		driver.get(URL);
		wdu.implicitwait(driver);
		
        driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.id("phone")).sendKeys(phonenumber);

		WebElement industry=	driver.findElement(By.xpath("//select[@name='industry']"));
		wdu.selectdropdown(industry, indDD);

		WebElement rating= driver.findElement(By.xpath("//select[@name='rating']"));
		wdu.selectdropdown(rating, ratingDD);


		WebElement type=driver.findElement(By.xpath("//select[@name='accounttype']"));
		wdu.selectdropdown(type, typeDD);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		wdu.refresh(driver);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']")).click();

		//driver.navigate().refresh();
		//driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		WebElement searchbox=driver.findElement(By.xpath("//input[@name='search_text']"));

		wdu.elementisclickable(driver, searchbox);

		searchbox.sendKeys(orgname);

		WebElement orgnamedd=driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield']"));
		wdu.selectdropdown(orgnamedd, "Organization Name");
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		
       
		Thread.sleep(3000);
		String actual =driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']")).getText();
		//wdu.waitforElement(actual);
		System.out.println(actual);
        System.out.println(orgname);
        Assert.assertEquals(orgname, actual);
        System.out.println("Organization created Successfully");

		/*String actualorgname=driver.findElement(By.xpath("//a[text()='"+orgname+"']/ancestor::table[@class='lvt small']")).getText();

		String actualorgname=driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		a[text()='"+orgname+"']/ancestor::table[@class='lvt small']
		System.out.println(actualorgname);

		boolean result=actualorgname.contains(orgname);

		System.out.println(result);

		
		wait.until(ExpectedConditions.elementToBeClickable(search)).click();
		Thread.sleep(5000);
		
		String name = driver.findElement(By.xpath("//table[@class='lvt small']//a[@title = 'Organizations']")).getText();
		System.out.println(orgName.equals(name));*/
      //LOGOUT
    	
		WebElement crmout =driver.findElement(By.xpath("//td[contains(@onmouseout,'fnHideDrop')][1]"));
		Actions act1 = new Actions(driver);
    	act1.moveToElement(crmout).perform();
    	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
    	
    	driver.close();
    	}
    	
    
    
}


	






