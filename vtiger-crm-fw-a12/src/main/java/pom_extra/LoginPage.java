package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	  public LoginPage(WebDriver driver){
	 		PageFactory.initElements(driver, this);
	  }
	  
	  @FindBy(id="user-name")
	 private WebElement un;
	  
	  @FindBy(id="password")
	  private WebElement pwd;
	  
	  @FindBy(id="login-button")
	 private WebElement login;
	  
	  public WebElement getun() {
		  return un;
	  }
	  public WebElement getpwd() {
		  return pwd;
	  }
	  public WebElement getLogin() {
		  return login;
	  }
}
