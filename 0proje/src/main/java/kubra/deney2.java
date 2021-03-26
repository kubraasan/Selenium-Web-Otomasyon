package kubra;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class deney2 {
	
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
	
	}
	
	@Test
	
	public void deneySearch() {
		
		//search
		WebElement searchBox = driver.findElement(By.name("k"));
		searchBox.click();
		searchBox.sendKeys("bilgisayar");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				
		
		
		
		/* second page denemeleri 
		WebElement paging = driver.findElement(By.className("pager pt30 hidden-m gg-d-24"));
		WebElement paging = driver.findElement(By.linkText("2"));
		paging.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
	
		//second page
		driver.get("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
		driver.findElement(By.xpath("//*[@id='product_id_667084863']/a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
		
        /*add to basket denemeleri
		Actions action = new Actions(driver);
		WebElement numberBox = driver.findElement(By.id("CountInput"));
		action.moveToElement(numberBox).clickAndHold();
		
		Actions action2 = new Actions(driver);
		WebElement basket= driver.findElement(By.cssSelector("#add-to-basket"));
		action2.moveToElement(basket).clickAndHold();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        //driver.findElement(By.className("control-button gg-ui-button plr10 gg-ui-btn-default")).click();
		
		//go to basket
		//driver.findElement(By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/div/div/div/div[2]/div[4]/div[1]/a")).click();*/
		
        
        
	}
	

	
	 @After
	    public void quitDriver(){
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.quit();
	        
	 }

}
