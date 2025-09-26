package org_automation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class test1 {
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("manager");
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Organizations")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("accountname")).sendKeys("automation_work");
	driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.raj.com");
	driver.findElement(By.xpath("//input[@id='tickersymbol']")).sendKeys("workwithpiyush");
	
	String pid = driver.getWindowHandle();
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	Thread.sleep(2000);
	
	Set<String> ids = driver.getWindowHandles();
	for(String id : ids) {
		if(!id.equals(pid)) {
			driver.switchTo().window(id);
			driver.findElement(By.id("3")).click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			break;
		}
	}
	driver.switchTo().window(pid);
	driver.findElement(By.xpath("//input[@id='employees']")).sendKeys("princekumar");
	driver.findElement(By.xpath("//input[@id='email2']")).sendKeys("ankit.rathi4567@gmail.com");
	WebElement indestry=driver.findElement(By.xpath("//select[@name='industry']"));
	Thread.sleep(3000);
	Select s=new Select(indestry);
	s.selectByIndex(4);
	Thread.sleep(3000);
	WebElement type=driver.findElement(By.xpath("//select[@name='accounttype']"));
	Thread.sleep(3000);
	Select s3=new Select(type);
	s.selectByIndex(2);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='emailoptout']")).click();
	Thread.sleep(3000);
	driver.findElement(By.cssSelector("input[value$='T']")).click();
	Thread.sleep(3000);
	WebElement assigned=driver.findElement(By.xpath("//select[@name='assigned_group_id']"));
	Thread.sleep(3000);
	Select s1=new Select(assigned);
	s1.selectByIndex(2);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("9867543910");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='fax']")).sendKeys("iamworkingwithmyteam");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='otherphone']")).sendKeys("7869543201");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='email1']")).sendKeys("raj.67@gmail.com");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='ownership']")).sendKeys("kunalmalik");
	WebElement ratting=driver.findElement(By.xpath("//select[@name='rating']"));
	Select s2=new Select(ratting);
	s.selectByIndex(2);
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='siccode']")).sendKeys("201306");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='annual_revenue']")).sendKeys("5,00,000");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='notify_owner']")).click();
	Thread.sleep(5000);
	//driver.findElement(By.name("button")).click();
	driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
	driver.quit();
	}
}
