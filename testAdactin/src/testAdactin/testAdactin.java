package testAdactin;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

class testAdactin {
     


		@Test
		public void openDriver() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		 
		// open adactin
		driver.get("http://www.facebook.com");
		 
		// Maximize browser
		
		Thread.sleep(5000);
		driver.manage().window().maximize();
		 

		
	}

}
