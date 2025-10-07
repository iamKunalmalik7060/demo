
public class CreateContactTest {
	public static void main(String[] args) {
//		Get the data from properties file
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");

//		Get the data from excel file
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(13);
		Cell cell = row.getCell(0);
		String lastName = cell.getStringCellValue();
		wb.close();
		
//		Open Browser 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Login
		driver.get(URL);

		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(USERNAME);
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);

//		Create contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

//		String lastName = "Kumar";
		WebElement lastNameField = driver.findElement(By.name("lastname"));
		lastNameField.sendKeys(lastName);

//		Save 
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();

//		Verification
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.equals(lastName)) {
			System.out.println("Created contact " + lastName + " successfully!!!");
		} else {
			System.out.println("Failed....");
		}

//		Logout
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();

		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();

//		Close browser
		Thread.sleep(3000);
		driver.quit();
	}
}
