package intervue_test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import intervue_test.utils.TestDataLoader;

public class Login_test {
	
	WebDriver driver = new ChromeDriver();
		
	// launch Website and check expected Elements
		
	@Test(priority = 1)
		public void launch() throws InterruptedException {
			driver.manage().window().maximize();
			driver.get(TestDataLoader.get("baseUrl"));
			Thread.sleep(2000);

			WebElement COMPUTERS = driver.findElement(By.linkText("Products"));
			Actions act = new Actions(driver);
			act.moveToElement(COMPUTERS).build().perform();
			Thread.sleep(1000);
			
			WebElement TASK = driver.findElement(By.linkText("Solutions"));
			Actions act1 = new Actions(driver);
			act1.moveToElement(TASK).build().perform();
			Thread.sleep(1000);
			
			WebElement PRODUCT = driver.findElement(By.linkText("Pricing"));
			Actions act2 = new Actions(driver);
			act2.moveToElement(PRODUCT).build().perform();
			Thread.sleep(1000);
			
			WebElement SOLUTION = driver.findElement(By.linkText("Resources"));
			Actions act3 = new Actions(driver);
			act3.moveToElement(SOLUTION).build().perform();
			Thread.sleep(1000);
			
			WebElement CONTACT = driver.findElement(By.linkText("Contact us"));
			Actions act4 = new Actions(driver);
			act4.moveToElement(CONTACT).build().perform();
			Thread.sleep(1000);
		}

	// Log user via company login 
	
          @Test (priority = 2)
          public void login() throws InterruptedException {
	      driver.findElement(By.linkText("Login")).click();
	      Thread.sleep(2000);
	      ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1)); // index 1 = new tab
			
			WebElement Loginbycompanyparent = driver.findElement(By.cssSelector("div[class*='Companies']"));

			WebElement loginButton = Loginbycompanyparent.findElement(By.className("AccessAccount-ColoredButton"));
			loginButton.click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(TestDataLoader.get("email"));
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(TestDataLoader.get("password"));
			Thread.sleep(1000);
			
			// scroll little down 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400);");
		
			WebElement clickonlogin = driver.findElement(By.xpath("//button[@class= 'ant-btn btn LoginDarkButton-sc-1ertvag-0 isOnQC ant-btn-primary ant-btn-lg ant-btn-block']"));
			Thread.sleep(2000);
			clickonlogin.click();
			Thread.sleep(3000);
     }
          
          // Search for candidate by name 
          
       @Test(priority = 3)
       public void search() throws InterruptedException {
   		WebElement searchbar = driver.findElement(By.cssSelector("span.search_placeholder"));
    	searchbar.click();
    	Thread.sleep(2000);
    	WebElement searchbarInput = driver.findElement(By.cssSelector("input[placeholder='Type what you want to search for']"));
    	searchbarInput.sendKeys(TestDataLoader.get("searchText"));
   		Thread.sleep(2000);
   		List<WebElement> searchResults = driver.findElements(By.cssSelector("div[class*='SearchThrough__PlaceholderText']"));
   		System.out.println(searchResults.size());
   		searchResults.get(0).click();
    	Thread.sleep(3000);
     }
       
       // logout 
       
     @Test(priority = 4)
       public void logout() throws InterruptedException {
    	   WebElement dropdown = driver.findElement(By.xpath("//div[text()='Neha']/parent::div[contains(@class, 'ProfileHeader__StyedDropdownHoverLink')]"));
    	dropdown.click();
    	Thread.sleep(2000);
    	driver.findElement(By.linkText("Logout")).click();
       Thread.sleep(4000);
       driver.quit();
       }

}

