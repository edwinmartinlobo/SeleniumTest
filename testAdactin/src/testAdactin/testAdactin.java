package testAdactin;


import  org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

class testAdactin {
     


		@Test
		public void openDriver() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		 
		// open Firmex
		driver.get("https://www.firmex.com/");
		
		// Verify Page Title
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals("The World's Most Trusted Virtual Data Room | Firmex", actualTitle);
	   
	    
		//--------------------Clicking on Login Button
		driver.findElement(By.xpath("//*[@class='button login']")).click();
		
		//--------------------Validating Error Messages for Empty Email Address and Password
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'login_btn']")).click();
	
		//--------------------validating empty Email Address
		Thread.sleep(4000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"div_login_email\"]/div[2]/p"));
		String contents = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", element); 
        Assert.assertEquals("Please enter your email address.", contents);
		
      //--------------------validating empty password
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[4]/div/div[2]/p"));
	    String contents1 = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", element1); 
        System.out.println(contents1);
        Assert.assertEquals("Please enter your password.", contents1);
		  
      //--------------------Validating Invalid Email Format
        Thread.sleep(4000);
        System.out.println("entering data in fields ");
	    driver.findElement(By.xpath("//*[@id=\'login_user\']")).sendKeys("Test");
	    Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\'login_pw\']")).sendKeys("123456");
      
        
        System.out.println("Checking for valid email format");
        driver.findElement(By.xpath("//*[@id=\'login_btn\']")).click();
        WebElement element3 = driver.findElement(By.xpath("//*[@id=\"div_login_email\"]/div[2]/p"));
		String contents3 = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", element3); 
        Assert.assertEquals("Please enter a valid email address.", contents3);
        
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\'login_user\']")).clear();
        driver.findElement(By.xpath("//*[@id=\'login_pw\']")).clear();
        
		 
        
		driver.close();

		
	}

}
