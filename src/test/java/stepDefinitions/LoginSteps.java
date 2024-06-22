package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Login;

public class LoginSteps {
	WebDriver driver = BaseClass.getDriver();
	Login loginaccount;

	@Given("the user navigates to webpagemarketguru")
	public void the_user_navigates_to_webpagemarketguru() {
		BaseClass.getLogger().info("User is on the marketguruwepage");
	}

	@When("the user click on the login option")
	public void the_user_click_on_the_login_option() {
		BaseClass.getLogger().info("clicking on the signup options");
		loginaccount = new Login(driver);
		loginaccount.lfield();
	}

	@Then("the login page should open")
	public void the_login_page_should_open() {
		BaseClass.getLogger().info("User is on the loginpage");
	}

	@Then("in the login page the email password field should shown")
	public void in_the_login_page_the_email_password_field_should_shown() {
		BaseClass.getLogger().info("User is on the emailpage");
	}

	@When("the user enters the below detils in the field and click on the login field")
	public void the_user_enters_the_below_detils_in_the_field(io.cucumber.datatable.DataTable dataTable) {
		BaseClass.getLogger().info("Enter Email,password");
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		loginaccount.efield(dataMap.get("Email"));
		loginaccount.pwdfield(dataMap.get("Password"));
		loginaccount.signinlink();
	}

	@Then("the user successfully login message should shown")
	public void the_user_successfully_login_message_should_shown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement title = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Welcome back, Prince Gaurav']")));
		assertTrue("Title not found", title.isDisplayed());

	}
}
