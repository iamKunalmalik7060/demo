package generic_utility;


import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	WebDriver driver;
	Actions act;
	Select s;
	Dimension d;
	public  WebDriverUtility(WebDriver driver) {
		this.driver=driver;
		this.act=new Actions(driver);
		//this.s= new Select();
	}
	public void winmax() {
		driver.manage().window().maximize();
	}
	public void winQuit() {
		driver.quit();
	}
	public void Lounch(WebElement email) {
		driver.get("https://www.facebook.com/");
		email.sendKeys("706047234");
	}
	public void password(WebElement pass) {
		pass.sendKeys("kunal@13$");
	}
	public void Login(WebElement login) {
		login.click();
	}
	public void hover(WebElement targetElement) {
		act.moveToElement(targetElement).build().perform();
	}
	public void rightClick(WebElement targetElement) {
		act.contextClick().build().perform();
	}
	public void doubleClick(WebElement targetElement) {
		act.doubleClick(targetElement).build().perform();
	}
	public void dropdown(WebElement src,WebElement dest) {
		act.dragAndDrop(src, dest).build().perform();
	}
	public void selectByIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    public void selectByValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    public void selectByVisibleText(WebElement element, String visibleText) {
        new Select(element).selectByVisibleText(visibleText);
    }

//	public Point getPosition() {
//		return driver.manage().window().getPosition(d);
//	}
	public void refresh() {
		driver.navigate().refresh();
	}
	public void back() {
		driver.navigate().back();
	}
	public void forword() {
		driver.navigate().forward();
	}
	public void implicitWait(long second) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	public WebElement emolicitWait(WebElement element , long seconds) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	public WebElement waitForClickable(WebElement element , long seconds) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public boolean waitForAlert(long seconds) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.alertIsPresent())!=null;
	}
	 public void leftClick(WebElement targetElement) {
	        act.click(targetElement).perform();
	    }

	    public void dragAndDrop(WebElement src, WebElement dest) {
	        act.dragAndDrop(src, dest).perform();
	    }

	    public void moveByOffset(int x, int y) {
	        act.moveByOffset(x, y).perform();
	    }

	    public void keyDown(Keys key) {
	        act.keyDown(key).perform();
	    }

	    public void keyUp(Keys key) {
	        act.keyUp(key).perform();
	    }

	    public void jsClick(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	    }
	    public void jsSendKeys(WebElement element, String value) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
	    }

	    public void scrollIntoView(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    }

	    public void scrollBy(int x, int y) {
	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
	    }

	    public void highlightElement(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
	    }

	    public void acceptAlert() {
	        driver.switchTo().alert().accept();
	    }
	    public void dismissAlert() {
	        driver.switchTo().alert().dismiss();
	    }

	    public String getAlertText() {
	        return driver.switchTo().alert().getText();
	    }

	    public void sendKeysToAlert(String text) {
	        driver.switchTo().alert().sendKeys(text);
	    }

	  
	    public void switchToFrame(int index) {
	        driver.switchTo().frame(index);
	    }

	    public void switchToFrame(String nameOrId) {
	        driver.switchTo().frame(nameOrId);
	    }

	    public void switchToFrame(WebElement frameElement) {
	        driver.switchTo().frame(frameElement);
	    }

	    public void switchToDefaultContent() {
	        driver.switchTo().defaultContent();
	    }

	    public void switchToWindow(String partialTitle) {
	        Set<String> windows = driver.getWindowHandles();
	        for (String win : windows) {
	            if (driver.switchTo().window(win).getTitle().contains(partialTitle)) {
	                break;
	            }
	        }
	    }

	    
	    public String takeScreenshot(String fileName) throws IOException {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
	        FileUtils.copyFile(src, new File(dest));
	        return dest;
	    }
	
	public boolean isDisplayed(WebElement element) {
	    return element.isDisplayed();
	}

	public boolean isEnabled(WebElement element) {
	    return element.isEnabled();
	}

	public boolean isSelected(WebElement element) {
	    return element.isSelected();
	}
	public String getElementText(WebElement element) {
	    return element.getText();
	}

	public String getElementAttribute(WebElement element, String attribute) {
	    return element.getAttribute(attribute);
	}

	public void clearAndType(WebElement element, String value) {
	    element.clear();
	    element.sendKeys(value);
	}

	public String getTitle() {
	    return driver.getTitle();
	}

	public String getCurrentUrl() {
	    return driver.getCurrentUrl();
	}

	public String getPageSource() {
	    return driver.getPageSource();
	}

	public List<WebElement> getAllOptions(WebElement element) {
	    return new Select(element).getOptions();
	}
	public String getFirstSelectedOption(WebElement element) {
	    return new Select(element).getFirstSelectedOption().getText();
	}

	public void deselectAll(WebElement element) {
	    new Select(element).deselectAll();
	}

	public void deselectByIndex(WebElement element, int index) {
	    new Select(element).deselectByIndex(index);
	}

	public void deselectByValue(WebElement element, String value) {
	    new Select(element).deselectByValue(value);
	}

	public void deselectByVisibleText(WebElement element, String text) {
	    new Select(element).deselectByVisibleText(text);
	}

	
	public void fluentWait(WebElement element, int timeout, int pollingTime) {
	    Wait<WebDriver> wait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(timeout))
	            .pollingEvery(Duration.ofSeconds(pollingTime))
	            .ignoring(NoSuchElementException.class);
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	public boolean waitForUrlContains(String partialUrl, long seconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	    return wait.until(ExpectedConditions.urlContains(partialUrl));
	}

	
	public String takeElementScreenshot(WebElement element, String fileName) throws IOException {
	    File src = element.getScreenshotAs(OutputType.FILE);
	    String dest = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
	    FileUtils.copyFile(src, new File(dest));
	    return dest;
	}

	
	public String jsGetTitle() {
	    return (String) ((JavascriptExecutor) driver).executeScript("return document.title;");
	}

	public void jsRefresh() {
	    ((JavascriptExecutor) driver).executeScript("history.go(0)");
	}

	public String jsGetInnerText(WebElement element) {
	    return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", element);
	}
	public int getWindowCount() {
	    return driver.getWindowHandles().size();
	}

	public void switchToWindowByIndex(int index) {
	    Set<String> windows = driver.getWindowHandles();
	    int i = 0;
	    for (String win : windows) {
	        if (i == index) {
	            driver.switchTo().window(win);
	            break;
	        }
	        i++;
	    }
	}

	
	public void pressEnter(WebElement element) {
	    element.sendKeys(Keys.ENTER);
	}

	public void pressTab(WebElement element) {
	    element.sendKeys(Keys.TAB);
	}

	public void pressEsc(WebElement element) {
	    element.sendKeys(Keys.ESCAPE);
	}

}
