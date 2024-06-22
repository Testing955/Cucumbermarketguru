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
import pageObjects.accountsSettings;

public class accountsSettingsSteps {
	WebDriver driver = BaseClass.getDriver();
	accountsSettings as;

	public accountsSettingsSteps() {
		as = new accountsSettings(driver);
	}

	@Given("the email and password field is open by clicking on the login option")
	public void the_email_and_password_field_is_open_by_clicking_on_the_login_option(io.cucumber.datatable.DataTable dataTable) {
		as.lfield();
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		as.efield(dataMap.get("email"));
		as.pwdfield(dataMap.get("password"));
	}

	@When("the user click on the sigin option")
	public void the_user_click_on_the_sigin_option() {
	as.signinlink();
	}

	@Then("the user navigate to the dashboard page and the text should be matched")
	public void the_user_navigate_to_the_dashboard_page_and_the_text_should_be_matched() {
		BaseClass.getLogger().info("The title should be matched");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement title = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Welcome back, Prince Gaurav']")));
		assertTrue("Title not found", title.isDisplayed());
	}

	@When("the user clicks on the accounts setting option then the dropdown should open")
	public void the_user_clicks_on_the_accounts_setting_option_then_the_dropdown_should_open() {
as.clickonAccountsSettingsDropdown();
	}

	@Then("the profile page should open after clicking on the profile option")
	public void the_profile_page_should_open_after_clicking_on_the_profile_option() {
	as.chooseProfileOptions();
	}

	@When("the user clicks on the edit option")
	public void the_user_clicks_on_the_edit_option() {
as.clickOnEditOptions();

	}

	@Then("the details edit should be allowed")
	public void the_details_edit_should_be_allowed() {
as.enterFirstName(randomString());
as.enterLastName(randomString());
	}

@Then("when the user click on the update option then the changes should be updated")
public void when_the_user_click_on_the_update_option_then_the_changes_should_be_updated() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
}