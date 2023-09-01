package stepdef;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	WebDriver driver;

	@Given("Launch an chrome Browser")
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@When("Load the url {string}")
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
	
	
	@And("Click on the wait page in Main Menu")
	public void navigatetoWaitsPage()
	{
		driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Waits']")).click();
	}
	
	@And("Click on the button")
	public void clickonButton()
	{
		driver.findElement(By.xpath("//h5[contains(text(),'Wait for Visibility')]/following::button[1]")).click();
		
	}
	@Then("Confirm the element is visible")
	public void confirmElementisVisible()
	{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'I am here')]")));

		if (driver.findElement(By.xpath("//*[contains(text(),'I am here')]")).isDisplayed())
			System.out.println("element is Visible");
		else
			System.out.println("element is Not Visible");
		driver.quit();
	}
	
	
	@When("Click on the Text page in Main Menu")
	public void clickonTextButton()
	{
		driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Text Box']")).click();
	}
	
	@And("Enter the Values {string} and {string}")
	public void entertheValues(String name,String country)
	{
	driver.findElement(By.xpath("//h5[text()='Type your name']/following::input")).sendKeys(name);
	driver.findElement(By.xpath("//h5[contains(text(),'Append Country')]/following::input")).sendKeys(country);
	}
	
	@Then("Verify the values are entered")
	public void verify()
	{
		System.out.println( driver.findElement(By.xpath("//h5[text()='Append Country to this City.']/following::input[1]")).getAttribute("value"));
		driver.quit();
	}
}
