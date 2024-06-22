package SwagLabWeb;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class myTestcases extends Parameters{
	
	@BeforeTest
	public void mySetup() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}
	
	
	@Test(priority = 1)
	public void Sighnin() throws IOException {
		WebElement Username = driver.findElement(By.id("user-name"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement Login = driver.findElement(By.id("login-button"));
		
		Username.sendKeys(TheUser);
		Password.sendKeys(ThePass);
		Login.click();

		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("C:\\Users\\MY LAPTOP\\Downloads\\MyScreenshots\\sauce.jpg"));
	}
	
	@Test(priority = 2,invocationCount = 2)
	public void addRandom() {
		

		WebElement ItemsContainer = driver.findElement(By.className("inventory_list"));

		int numberofitems = ItemsContainer.findElements(By.className("inventory_item_description")).size();
		System.out.println(numberofitems);

		int randomItemToSelect = rand.nextInt(numberofitems);
		ItemsContainer.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).get(randomItemToSelect).click();


	}
	@Test(priority = 3)
	public void assurance() {
	String ActualMssg = driver.findElement(By.className("shopping_cart_badge")).getText();
		
		assertEquals(ActualMssg.contains("2"), true);
	}
	
	@Test(priority = 4)
	public void checkOut() {
		
		WebElement CartBtn = driver.findElement(By.className("shopping_cart_link"));
		CartBtn.click();
		
		WebElement CheckOutBtn = driver.findElement(By.id("checkout"));
		CheckOutBtn.click();
		
		WebElement FirstName = driver.findElement(By.id("first-name"));
		WebElement LastName = driver.findElement(By.id("last-name"));
		WebElement ZipCode  = driver.findElement(By.id("postal-code"));
		
		FirstName.sendKeys(TheFirstName);
		LastName.sendKeys(TheLastName);
		ZipCode.sendKeys(TheZipCode);
		
		WebElement ContBtn = driver.findElement(By.id("continue"));
		ContBtn.click();
		
		WebElement FinishBtn = driver.findElement(By.id("finish"));
		FinishBtn.click();
		
		String ThanksMsg = driver.findElement(By.className("complete-header")).getText();
		assertEquals(ThanksMsg.contains("Thank you"), true);
	}
	
	@Test(priority = 5)
	public void logout() {
		WebElement BackBtn = driver.findElement(By.id("back-to-products"));
		BackBtn.click();
		
		WebElement MenueBtn = driver.findElement(By.id("react-burger-menu-btn"));
		MenueBtn.click();
		
		WebElement LogoutBtn = driver.findElement(By.id("logout_sidebar_link"));
		LogoutBtn.click();
		
		
	}

}
