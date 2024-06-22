package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Forgetpassword;

public class ForgetpasswordSteps 
{
WebDriver driver = BaseClass.getDriver();
Forgetpassword fp;
@Given("the user navigates to webpage")
public void the_user_navigates_to_webpage() 
{
BaseClass.getLogger().info("User is on the webpage");	
}
@When("the user click on the login link")
public void the_user_click_on_the_login_link() 
{
BaseClass.getLogger().info("clicking on the login options");
fp = new Forgetpassword(driver);
fp.lfield();
}

@Then("in the login page,forgot password option should shown")
public void in_the_login_page_forgot_password_option_should_shown() 
{
BaseClass.getLogger().info("User is on the log");
}

@When("the user click on the forgot password? option")
public void the_user_click_on_the_forgot_password_option() 
{
	BaseClass.getLogger().info("Click on the forgetpassword");
    fp.forgetpwd();
}
@Then("the email field page should open")
public void the_email_field_page_should_open() 
{
	BaseClass.getLogger().info("Email field open");
   fp.emailf();
}

@When("the user click on the send link option")
public void the_user_click_on_the_send_link_option() 
{
	BaseClass.getLogger().info("User is clicking on the send link");
	fp.sendlink();
}
@Then("a success message should be displayed")
public void a_success_message_should_be_displayed() 
{
	BaseClass.getLogger().info("Forgetpassword send successfully");
	fp.printmessage();
}
}
