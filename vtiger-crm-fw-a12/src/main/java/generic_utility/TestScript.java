package generic_utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {
	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	WebDriverUtility wdUtil=new WebDriverUtility(driver);
	WebElement email=driver.findElement(By.id("email"));
	WebElement pass=driver.findElement(By.id("passContainer"));
	WebElement login=driver.findElement(By.name("login"));

	wdUtil.winmax();
	wdUtil.Lounch(email);
	wdUtil.password(pass);
	wdUtil.Login(login);
	
	}
}
