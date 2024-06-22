package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountsSettings extends Login {
	WebDriver driver;

	public accountsSettings(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//button[text()='Accounts Settings']")
	WebElement accountsSettings;
	@FindBy(xpath = "(//button[text()='Profile'])[1]")
	WebElement profileOptions;
	@FindBy(xpath = "//div[text()='Edit']")
	WebElement editOption;
	@FindBy(xpath = "(//input[@type='text' and @value=''])[1]")
	WebElement nameFirst;
	@FindBy(xpath = "(//input[@type='text' and @value=''])[2]")
	WebElement nameLast;
	@FindBy(xpath = "(//input[@type='text' and @value=''])[3]")
	WebElement companyName;
	@FindBy(xpath = "(//input[@type='text' and @value=''])[4]")
	WebElement designation;
	@FindBy(xpath = "//button[text()='Change']")
	WebElement passwordChange;
	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement oldPassword;
	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement newPassword;
	@FindBy(xpath = "(//input[@type='password'])[3]")
	WebElement confirmPassword;
	@FindBy(xpath = "//button[text()='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//*[name()='svg' and @class='w-[16px] h-[16px] cursor-pointer']//*[name()='path' and @fill='currentColor']")
	WebElement cancelButton;

	public void clickonAccountsSettingsDropdown() {
		try {
			accountsSettings.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void chooseProfileOptions() {
		try {
			profileOptions.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickOnEditOptions() {
		try {
			editOption.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterFirstName(String fname) {
		try {
			nameFirst.clear();
			nameFirst.sendKeys(fname);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterLastName(String lname) {
		try {
			nameLast.clear();
			nameLast.sendKeys(lname);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterCompanyName(String cname) {
		try {

			companyName.sendKeys(cname);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterDesignation(String desig) {
		try {
			designation.clear();
			designation.sendKeys(desig);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickOnCancelButton() {
		try {
			cancelButton.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}
}
