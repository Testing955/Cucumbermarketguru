package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {
	WebDriver driver;

	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[text()='Log In']")
	WebElement loginfield;
	@FindBy(name = "email")
	WebElement emailfield;
	@FindBy(name = "password")
	WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement signin;

	public void lfield() {
		try {
			loginfield.click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void efield(String ef) {
		try {
			emailfield.sendKeys(ef);
		} catch (NoSuchElementException e) {
			System.out.println("The email field is not found: " + e.getMessage());
		}
	}

	public void pwdfield(String pwd) {
		try {
			passwordfield.sendKeys(pwd);
		} catch (NoSuchElementException e) {
			System.out.println("Password field is not matching: " + e.getMessage());
		}
	}

	public void signinlink() {
		signin.click();
	}

	public void login(String email, String password) {
		lfield();
		efield(email);
		pwdfield(password);
		
	}
}