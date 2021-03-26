package kubra;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class deney {
	
	public WebDriver driver;
	
	@Before
	public void setupDriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kübra Asan\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		//open the web app
		driver= new ChromeDriver();
		String url = "https://www.gittigidiyor.com/";
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//check
				String title = driver.getTitle();
				
				if(title.equalsIgnoreCase("GittiGidiyor - Türkiye'nin Öncü Alýþveriþ Sitesi"))
					System.out.println("You are in HomePage");
				else
					System.out.println(title);
	}
	
	@Test
	public void TestHome() {
		//https://www.gittigidiyor.com/uye-girisi
		driver.findElement(By.xpath("//header[@id='main-header']/div[3]/div/div/div/div[3]/div/div/div/div[2]")).click();
		driver.findElement(By.xpath("//header[@id='main-header']/div[3]/div/div/div/div[3]/div/div/div[2]/div/div/div/a/span")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//enter email
		WebElement mailbox=driver.findElement(By.id("L-UserNameField"));
		mailbox.click();
		mailbox.sendKeys("releasefoto@gmail.com");
		
		//enter password
		WebElement password=driver.findElement(By.id("L-PasswordField"));
		password.click();
		password.sendKeys("adminadmin1");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.findElement(By.id("gg-login-enter")).click();
		// check
		String expected_title = "GittiGidiyor - Türkiye'nin Öncü Alýþveriþ Sitesi" ;
		String actual_title = driver.getTitle();
		
		if (expected_title.equals(actual_title)) {
			System.out.println("Login Successfull");
		}
		else {
			System.out.println("Login Failed");
		}
	}
	
	@After
	
	public void quitDriver() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.quit();
	}
	
	
}
