package stepdef;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsSteps {
	WebDriver driver;
	
	@Given("Launch a chrome Browser")
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@When("Load the url {String}")
	public void navigatetoLeafGround(String url)
	{
		driver.get(url);
	}
	
	@And("Click on the window page in Main Menu")
	public void navigatetoWindowsPage()
	{
		driver.findElement(By.xpath("//span[text()='Browser']/ancestor::a")).click();

	}
	
	@And("Click on the open button")
	public void clickonWindoeButton()
	{
		driver.findElement(By.xpath("//span[text()='Window']")).click();
		String currentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//h5[text()='Click and Confirm new Window Opens']/following-sibling::button"))
				.click();
	}
	
	@Then("Confirm New window launched")
	public void validateWindowLaunched()
	{
		Set<String> numOfWindows = driver.getWindowHandles();
		List<String> numOfWindowsList = new ArrayList<String>(numOfWindows);
		
		if(numOfWindows.size()>1)
			{
			System.out.println("New window launched");
			driver.switchTo().window(numOfWindowsList.get(1));
			driver.quit();
			}
		else
		{
			System.out.println("New window not launched");
			driver.quit();
		}
		
		
	}
	

}
