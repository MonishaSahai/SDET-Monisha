package com.vtiger;


	import java.io.IOException;
	import java.util.Iterator;
import java.util.Random;
import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;

	import generic.FileUtility;
	import generic.Iconstants;
import generic.JavaUtility;
	public class CreateContactIntegrationNew {
        JavaUtility jv = new JavaUtility();
		FileUtility fu = new FileUtility();
		@Test
		public void createcontact() throws IOException, InterruptedException {
            
			int randomnumber=	jv.createRandomNumber();
			
			String UN=fu.readDatafrompropfile(Iconstants.propfilepath, "username");
			String PWD=fu.readDatafrompropfile(Iconstants.propfilepath, "password");
			String URL=fu.readDatafrompropfile(Iconstants.propfilepath, "url");

			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   	driver.manage().window().maximize();
			driver.get(URL);
			
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
    	   	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
    	   	driver.findElement(By.xpath("//img[@title='Select'][1]")).click();
    	   	String lastname ="kumar";
    	   	/*Random r1 = new Random();
    	   	int x1 = r1.nextInt(100);
    	   	lastname = lastname + x1;*/
    	   	//String lastname+randomnumber;
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
    	   			driver.findElement(By.xpath("//table[@class='dvtContentSpace']//tbody//tbody//tbody/tr[4]/td[2]/input")).sendKeys("kr");
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
