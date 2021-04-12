package com.Testyantra;


	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class Data_Provider1 
	{
		@Test(dataProvider="getdata")
		public void testcity1(String src,String dest) throws InterruptedException 
		{
			System.out.println(src+"  "+dest);
			
			//System.setProperty("webdriver.chrome.driver", "./src/test/resources/Driver Server/chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.makemytrip.com/");

			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, 20);

			Actions act = new Actions(driver);
			act.moveByOffset(10, 10).click().perform();

			driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(src);
			driver.findElement(By.xpath("//div[contains(text(),'"+src+"')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(dest);
			driver.findElement(By.xpath("//div[contains(text(),'"+dest+"')]")).click();

			WebElement departure=driver.findElement(By.xpath("//span[text()='DEPARTURE']"));
			wait.until(ExpectedConditions.elementToBeClickable(departure)).click();
		
			driver.findElement(By.xpath("//div[@aria-label='Wed Apr 07 2021']")).click();
			
			driver.close();
			
		}

		@DataProvider
		public  Object[][] getdata()
		{
			Object[][] arr= new Object[5][2];

			arr[0][0]="BOM";
			arr[0][1]="PNQ";

			arr[1][0]="DEL";
			arr[1][1]="BOM";
			
			arr[2][0]="JFK";
			arr[2][1]="BOM";

			arr[3][0]="NYC";
			arr[3][1]="DEL";

			arr[4][0]="BLR";
			arr[4][1]="DEL";

			return arr;
		}
		

	}

