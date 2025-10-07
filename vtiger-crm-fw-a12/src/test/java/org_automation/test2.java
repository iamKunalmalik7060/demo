package org_automation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class test2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Opportunities']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys("asdfghjk");
		
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
		driver.findElement(By.name("assigntype")).click();
		}
}
