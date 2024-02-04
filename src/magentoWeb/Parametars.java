package magentoWeb;



import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parametars {
	
	WebDriver driver = new ChromeDriver();	
	String URL = "https://magento.softwaretestingboard.com/";
	
	Random rand = new Random();

	String myFirstName = "Farah";
	String myLastName = "AlAtrash";
	
	String CommonPassword="Fsd#$@12";
	
	int randomEmailId = rand.nextInt(9999);
	String emailID = myFirstName+myLastName+randomEmailId+"@gmail.com";
}
