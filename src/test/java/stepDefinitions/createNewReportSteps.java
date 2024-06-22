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
import pageObjects.createNewReport;

public class createNewReportSteps {
	WebDriver driver = BaseClass.getDriver();
	createNewReport cnr;

	  public createNewReportSteps() {
	
	        cnr = new createNewReport(driver);
	    }
	@Given("the email and password field is open by click on the login option")
	public void the_email_and_password_field_is_open_by_click_on_the_login_option() {
		
		cnr.lfield();
	}

	@When("the user is logged in with the following credentials")
	public void the_user_is_logged_in_with_the_following_credentials(io.cucumber.datatable.DataTable dataTable) {
		BaseClass.getLogger().info("Click on the login option and then enters the details on it");
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		cnr.efield(dataMap.get("email"));
		cnr.pwdfield(dataMap.get("password"));
	}

	@When("the user click on the sigin button")
	public void the_user_click_on_the_sigin_button() {
		BaseClass.getLogger().info("Click on the signin button");
		cnr.signinlink();

	}

	@Then("the user should navigate to the dashboard page")
	public void the_user_should_navigate_to_the_dashboard_page() {
		BaseClass.getLogger().info("The title should be matched");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement title = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Welcome back, Prince Gaurav']")));
		assertTrue("Title not found", title.isDisplayed());
	}

	@When("the user clicks on the create new report option")
	public void the_user_clicks_on_the_create_new_report_option() {
		BaseClass.getLogger().info("Report page should open");
		cnr.clickonthecreateNewReport();

	}

	@Then("the user should redirected to the creating report page")
	public void the_user_should_redirected_to_the_creating_report_page() {
		BaseClass.getLogger().info("Report page should open");
		cnr.choosemarketResearchReportOption();
		cnr.clickonnextStepButton();
		cnr.chooseHealthOption();
		cnr.chooseNextStep();
		cnr.chooseBusinessManagerOption();
		cnr.clickonnext();

	}

	@Then("after creating report the user should redirected to the template page")
	public void after_creating_report_the_user_should_redirected_to_the_template_page() {
		cnr.chooseFirstTemplate();
		cnr.clickOnFinalNextStep();
	}

	@When("the user enters enters the report name and report prompt")
	public void the_user_enters_enters_the_report_name_and_report_prompt() {
		cnr.enterReportName();
		cnr.enterPromptText();
	}

	@Then("report should be generated")
	public void report_should_be_generated() {
		cnr.clickonFinishButton();

	}

	@When("the report is generated user use the functionality next previous and pagination on it")
	public void the_report_is_generated_user_use_the_functionality_next_previous_and_pagination_on_it() {
		cnr.clickOnNextOptionOfReportGenerated();
		cnr.clicOnPrevOptionOfReportGenerated();
	}

	@When("if the functionality work")
	public void if_the_functionality_work() {
		cnr.chooseThePageNumberOfTheGeneratedReport();
		cnr.clickOnSaveOption();
	}

	@Then("user click on the save option and after saving the file")
	public void user_click_on_the_save_option_and_after_saving_the_file() {
		cnr.matchTheText();
	}

	@When("the user clicks on the back to dashboard")
	public void the_user_clicks_on_the_back_to_dashboard() {
		cnr.clickOnReturnDashboardOption();
	}

	@Then("the user should be redirected to the dashboard")
	public void the_user_should_be_redirected_to_the_dashboard() {

	}
}
