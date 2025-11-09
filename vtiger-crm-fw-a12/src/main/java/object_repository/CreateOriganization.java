package object_repository;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreateOriganization {
	public static void main(String[] args) throws InterruptedException, IOException {
	FileUtility fUtil = new FileUtility();

//	Get the data from properties file
	String BROWSER = fUtil.getDataFromPropertiesFile("bro");
	String URL = fUtil.getDataFromPropertiesFile("url");

//	Get the data from excel file
	String orgName = fUtil.getStringDataFromExcelFile("org", 3, 0);

//	Open Browser 
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//	Login
	driver.get(URL);

	LoginPage lp = new LoginPage(driver);

	lp.login();

	Thread.sleep(3000);

//	Create Organization
	
	HomePage hp = new HomePage(driver);
	hp.getorgLink().click();

	Thread.sleep(2000);
	
	OrgPage op = new OrgPage(driver);
			
	op.getorgPlusIcon().click();

//	Filling data to the form
	
	WebElement orgField = op.getorgField();
	orgField.sendKeys(orgName);

	Thread.sleep(3000);
//	Save 
	
	op.getsaveBtn().click();

//	Verification
	
	VerifyOrgPage vop = new VerifyOrgPage(driver);
	String actOrgName = vop.getActOrgName().getText();

	if (actOrgName.equals(orgName)) {
		System.out.println("Created Organization successfully!!!!");
	} else {
		System.out.println("Failed....");
	}

//	Logout
	
	WebElement profilePic = hp.getProfilePic();

	WebDriverUtility wdUtil = new WebDriverUtility(driver);

	wdUtil.hover(profilePic);

	Thread.sleep(2000);
	hp.getorgLink().click();

//	Close browser
	
	Thread.sleep(3000);
	driver.quit();
	}
}
