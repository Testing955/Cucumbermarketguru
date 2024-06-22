package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Signup extends BasePage 
{
    WebDriver driver;

    public Signup(WebDriver driver) 
    {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text()='Sign Up']")
    WebElement Signupbutton;

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement Firstname;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement Lastname;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailfield;

    @FindBy(xpath = "//input[@name='password']")
    WebElement Createpassword;

    @FindBy(xpath = "//input[@name='confirm_password']")
    WebElement Confirmpassword;

    @FindBy(xpath = "//input[@name='company_name']")
    WebElement companyname;

    @FindBy(xpath = "//input[@name='designation_name']")
    WebElement designationname;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement createaccount;

    public void signup() 
    {
        try 
        {
            Signupbutton.click();
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("Sign Up button not found: " + e.getMessage());
        }
    }

    public void fname(String first) 
    {
        try 
        {
            Firstname.sendKeys(first);
        } catch (NoSuchElementException e) 
        {
            System.out.println("First name field is not found " + e.getMessage());
        }
    }

    public void lname(String last) 
    {
        try 
        {
            Lastname.sendKeys(last);
        } 
        catch (Exception e) 
        {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void efield(String email) 
    {
        try 
        {
            emailfield.sendKeys(email);
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("Email field is not found: " + e.getMessage());
        }
    }

    public void createpwd(String createpass) 
    {
        try 
        {
            Createpassword.sendKeys(createpass);
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("Create password field is not found: " + e.getMessage());
        }
    }

    public void confirmpwd(String conpwd) 
    {
        try 
        {
            Confirmpassword.sendKeys(conpwd);
        } 
        catch (Exception e) 
        {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
    
    
    public void company(String comname) 
    {
        try 
        {
            companyname.sendKeys(comname);
        } catch (NoSuchElementException e) 
        {
            System.out.println("Company name field is not found: " + e.getMessage());
        }
    }

    public void designation(String desiname) 
    {
        try 
        {
            designationname.sendKeys(desiname);
        } 
        catch (Exception e) 
        {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void create() 
    {
        try 
        {
            createaccount.click();
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("Create button is not found: " + e.getMessage());
        }
    }

    public boolean isVerificationCodePageDisplayed() {
        try 
        {

            return driver.findElement(By.xpath("//h3[normalize-space()='Enter Verification Code']")).isDisplayed();
        } 
        catch (Exception e) 
        {
            return false;
        }
    }
}
