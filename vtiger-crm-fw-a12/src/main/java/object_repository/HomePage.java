package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	WebElement orgLink;
	
	public WebElement getorgLink() {
		return orgLink;
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	WebElement profilePic;
	
	public WebElement getProfilePic() {
		return profilePic;
	}
	
	@FindBy(linkText="Sign Out")
	private WebElement singOutLink;
	
	public WebElement getsingOutLink() {
		return singOutLink;
	}
}
