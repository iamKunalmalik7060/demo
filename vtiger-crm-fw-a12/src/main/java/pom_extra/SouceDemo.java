package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SouceDemo {
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.saucedemo.com/v1/");
	LoginPage lp=new LoginPage(driver);
//	lp.un.sendKeys("standard_user");
//	lp.pwd.sendKeys("secret_sauce");
//	lp.login.click();
	
	//login
	//Declaration with initialization
	WebElement un=lp.getun();
	WebElement pwd=lp.getpwd();
	WebElement login=lp.getLogin();
	
	driver.navigate().refresh();
	
	//Utilization
	un.sendKeys("standard_user");
	pwd.sendKeys("secret_sauce");
	login.click();
	
	//Verify
	HomePage hp=new HomePage(driver);
	
	//Declaration & initialization
	WebElement logo=hp.getLogo();
	
	//Utilization
	if(logo.isDisplayed()) {
		System.out.println("Logged is Successfully!!!!!");
	}
	else {
		System.out.println("Could not login....");
	}
	Thread.sleep(5000);
	driver.quit();
	}
}
