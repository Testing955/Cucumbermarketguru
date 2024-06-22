package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.NoSuchElementException;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

public class createNewReport extends Login {
	WebDriver driver;

	public createNewReport(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Create New Report']")
	WebElement createNewReport;
	@FindBy(xpath = "//div[text()='Market Research reports']")
	WebElement marketResearchReport;
	@FindBy(xpath = "//div[text()='Next Step']")
	WebElement nextStepButton;
	@FindBy(xpath = "//div[text()='Health']")
	WebElement health;
	@FindBy(xpath = "//div[text()='Next Step']")
	WebElement nextStep;
	@FindBy(xpath = "//div[text()='Business Manager']")
	WebElement businessManager;
	@FindBy(xpath = "//div[text()='Next Step']")
	WebElement next;
	@FindBy(xpath = "(//div/div/button/img)[1]")
	WebElement firstTemplate;
	@FindBy(xpath = "//div[text()='Next Step']")
	WebElement finalNextStep;
	@FindBy(name = "report")
	WebElement reportName;
	@FindBy(name = "prompt")
	WebElement promptText;
	@FindBy(xpath = "//button[text()='Finish']")
	WebElement finishButton;
	@FindBy(xpath = "//button[text()='Next']")
	WebElement reportNext;
	@FindBy(xpath = "//button[text()='Prev']")
	WebElement reportPrev;
	@FindBy(xpath = "//a[text()='4']")
	WebElement pageNumber;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveOption;
	@FindBy(xpath = "//p[text()='Report Saved']")
	WebElement reportSaved;
	@FindBy(xpath = "//p[text()='Return to Dashboard']")
	WebElement returnToDashboard;

	public void clickonthecreateNewReport() {
		try {
			createNewReport.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void choosemarketResearchReportOption() {
		try {
			marketResearchReport.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickonnextStepButton() {
		try {
			nextStepButton.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void chooseHealthOption() {
		try {
			health.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void chooseNextStep() {
		try {
			nextStep.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void chooseBusinessManagerOption() {
		try {
			businessManager.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickonnext() {
		try {
			next.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void chooseFirstTemplate() {
		try {
			firstTemplate.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickOnFinalNextStep() {
		try {
			finalNextStep.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterReportName() {
		try {
			reportName.sendKeys("Automation Market Guru Report");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterPromptText() {
		try {
			promptText.sendKeys("Generate the automation report of the health card");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickonFinishButton() {
		try {
			finishButton.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickOnNextOptionOfReportGenerated() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.visibilityOf(reportNext));
			reportNext.click();
		} catch (WebDriverException e) {
			System.out.println("Element not found or not visible: " + e.getMessage());
		}
	}

	public void clicOnPrevOptionOfReportGenerated() {
		try {
			reportPrev.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void chooseThePageNumberOfTheGeneratedReport() {
		try {
			pageNumber.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickOnSaveOption() {
		try {
			saveOption.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public void matchTheText() {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(reportSaved));

			assertTrue("Report Saved not found", reportSaved.isDisplayed());
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

	public void clickOnReturnDashboardOption() {
		try {
			returnToDashboard.click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

}
