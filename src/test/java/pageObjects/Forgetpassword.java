	package pageObjects;
	
	import java.time.Duration;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.TimeoutException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	public class Forgetpassword extends Login
	{
	WebDriver driver;
	WebDriverWait wait;
	public Forgetpassword(WebDriver driver)
	{
	super(driver);
	this.driver=driver;
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@FindBy(xpath="//a[text()='Forgot password ?']")
	WebElement fpwd;
	@FindBy(name="Email")
	WebElement emailfiled;
	@FindBy(xpath="//button[text()='Send link']")
	WebElement send;
	@FindBy(xpath="//div[contains(@class, 'Toastify')]//div[contains(@class, 'message-class')]")
	WebElement message;
	public void forgetpwd()
	{
	try
	{
	fpwd.click();
	}
	catch(NoSuchElementException e)
	{
	System.out.println("Forget paasword button is not working: " + e.getMessage());
	}
	}
	
	public void emailf()
	{
	try
	{
	emailfiled.sendKeys("UveI890@yopmail.com");
	}
	catch(NoSuchElementException e)
	{
	System.out.println("Email field box is not open: " + e.getMessage());
	}
	}
	public void sendlink()
	{
	try
	{
	send.click();
	printmessage();
	}
	catch(NoSuchElementException e)
	{
	System.out.print("The send link button is not working: "+ e.getMessage());
	}
	}
	public void printmessage()
	{
	try
	{
	WebElement toastmessage = wait.until(ExpectedConditions.visibilityOf(message));
	String messagetext = toastmessage.getText();
	System.out.println("Message displayed: "+messagetext);
	}
	catch(NoSuchElementException e)
	{
	System.out.println("Message element is not found: " + e.getMessage());
	}
	catch(TimeoutException e)
	{
	System.out.println("Message element is not found: "+e.getMessage());
	}
	}
	}