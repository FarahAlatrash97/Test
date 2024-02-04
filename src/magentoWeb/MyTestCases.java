package magentoWeb;



import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends Parametars {
	
	@BeforeTest
	public void mySetup() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test(priority = 1)
	public void SighnUp() throws InterruptedException {
		  driver.get("https://magento.softwaretestingboard.com/");
	       
	       driver.findElement(By.linkText("Create an Account")).click();
	       
	       WebElement FirstName = driver.findElement(By.id("firstname"));
	       WebElement LasttName = driver.findElement(By.id("lastname"));
	       WebElement Email = driver.findElement(By.id("email_address"));
	       WebElement Password = driver.findElement(By.id("password"));
	       WebElement ConfirmPassword = driver.findElement(By.id("password-confirmation"));
	       WebElement createAccountButtonElement = driver.findElement(By.cssSelector("button[title='Create an Account'] span"));

	       
	       FirstName.sendKeys(myFirstName);
	       LasttName.sendKeys(myLastName);
	       Email.sendKeys(emailID);
	       Password.sendKeys(CommonPassword);
	       ConfirmPassword.sendKeys(CommonPassword);
	       
	       createAccountButtonElement.click();       
	       
	       String WelcomeMassage = driver.findElement(By.className("message-success")).getText();
	       assertEquals(WelcomeMassage, "Thank you for registering with Main Website Store.");
	       
	       Thread.sleep(3000);	}
	
	  @Test(priority = 2)
	    public void Logout() throws InterruptedException {
	    	Thread.sleep(5000);
	    	driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
	    	
	    	assertEquals(driver.getCurrentUrl().contains("logoutSuccess"),true );
	    }
	    
	    @Test(priority = 3)
	    public void Login() throws InterruptedException {
	    	driver.findElement(By.linkText("Sign In")).click();
	    	driver.findElement(By.id("email")).sendKeys(emailID);
	    	driver.findElement(By.id("pass")).sendKeys(CommonPassword);
	    	driver.findElement(By.id("send2")).click();
	    	
	    	Thread.sleep(3000);
	    	String WelcomeMsg = driver.findElement(By.cssSelector(".greet.welcome")).getText();
	    	assertEquals(WelcomeMsg.contains("Welcome"), true);
	    }
	    
	    @Test(priority = 4)
	    public void AddOneRandomItem() throws InterruptedException {
	    	driver.get("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");

			WebElement ItemsContainer = driver.findElement(By.cssSelector(".products.wrapper.grid.products-grid"));

			int numberofitems = ItemsContainer.findElements(By.tagName("li")).size();

			int randomItemToSelect = rand.nextInt(numberofitems);
			ItemsContainer.findElements(By.tagName("li")).get(randomItemToSelect).click();

			WebElement sizesContainer = driver.findElement(By.cssSelector(".swatch-attribute-options.clearfix"));

			int theSizes = sizesContainer.findElements(By.className("swatch-option")).size();
			sizesContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theSizes)).click();
			Thread.sleep(2000);

			WebElement colorsContainer = driver.findElement(By.cssSelector(".swatch-attribute.color"));
			int theColors = colorsContainer.findElements(By.className("swatch-option")).size();
			colorsContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theColors)).click();
			Thread.sleep(2000);
			driver.findElement(By.id("product-addtocart-button")).click();
			Thread.sleep(3000);

			String ActualMsg = driver.findElement(By.cssSelector(".page.messages")).getText();

			assertEquals(ActualMsg.contains("You added"),true);
	 }
	
	
}
