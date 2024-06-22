package SwagLabWeb;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {

	WebDriver driver = new ChromeDriver();	
	String URL = "https://www.saucedemo.com/inventory.html";
	
	String TheUser = "standard_user";
	String ThePass = "secret_sauce";
	
	Random rand = new Random();
	
	String TheFirstName = "Farah";
	String TheLastName = "Harb";
	String TheZipCode = "11127";
	
}
