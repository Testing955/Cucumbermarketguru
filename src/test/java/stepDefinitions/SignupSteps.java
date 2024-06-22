package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue; 
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Signup;

public class SignupSteps 
{
WebDriver driver = BaseClass.getDriver();
Signup su;
@Given("the user navigates to Signup Account page")
public void the_user_navigates_to_signup_account_page() 
{
BaseClass.getLogger().info("clicking on the signup options");
su = new Signup(driver);
su.signup();
}

@When("the user enters the details into below fields")
public void the_user_enters_the_details_into_below_fields(io.cucumber.datatable.DataTable dataTable)
{
	BaseClass.getLogger().info("Enter Name,Email,Company name, designation, password and confirm password");
    Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
    su.fname(dataMap.get("firstName"));
    su.lname(dataMap.get("lastName"));
    su.efield(BaseClass.randomAlphaNumeric()+"@yopmail.com");
    String password = (BaseClass.randomAlphaNumeric()+"@");
    su.createpwd(password);
    su.confirmpwd(password);
    //su.createpwd(dataMap.get("Create Password"));
    //su.confirmpwd(dataMap.get("Confirm Password"));
    su.company(BaseClass.randomString());
    su.designation(BaseClass.randomString());
   
}

@When("the user click on the createaccount button")
public void the_user_click_on_the_createaccount_button() 
{
	BaseClass.getLogger().info("The user click on the create account");
    su.create();
}

@Then("the verification code should open")
public void the_verification_code_should_open() 
{
	BaseClass.getLogger().info("The verification code page should open");
	assertTrue("Verification code page did not open.",su.isVerificationCodePageDisplayed());
}
}
