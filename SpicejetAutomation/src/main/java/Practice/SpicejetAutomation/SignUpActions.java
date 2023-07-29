package Practice.SpicejetAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestUtility;

public class SignUpActions {

	public SignUpActions() {
		PageFactory.initElements(WebDriverManager.getDriver(), this);

	}

	TestUtility utility = new TestUtility();

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1jkjb']/div")
	WebElement LoginButton;

	@FindBy(xpath = "//div[@class='css-76zvg2 r-c20mna r-18tvxmy r-n6v787']")
	WebElement SignUp;

	@FindBy(xpath = "//div[@class='col-sm-4 mt-2 px-sm-4']//select[@class='form-control form-select ']")
	WebElement SelectTitle;

	@FindBy(xpath = "//*[@id='first_name']")
	WebElement Firstname;

	@FindBy(xpath = "//*[@id='last_name']")
	WebElement lastname;

	@FindBy(xpath = "//div[@class='col-sm-6 mt-30 px-sm-4']//select[@class='form-control form-select']")
	WebElement SelectCountry;

	@FindBy(xpath = "//input[@id='dobDate']")
	WebElement SelectDob;

	@FindBy(className = "react-datepicker__month-select")
	WebElement SelectMonth;

	@FindBy(className = "react-datepicker__year-select")
	WebElement SelectYear;

	@FindBy(xpath = "//div[@class='selected-flag']")
	WebElement SelectCountryDropdown;

	@FindBy(xpath = "//input[@class=' form-control']")
	WebElement PhoneNumber;

	@FindBy(id = "email_id")
	WebElement Email;

	@FindBy(xpath = "//input[@id='new-password']")
	WebElement Password;

	@FindBy(xpath = "//input[@id='c-password']")
	WebElement ConfirmPassword;

	@FindBy(xpath = "//input[@id='defaultCheck1']")
	WebElement Checkbox;

	@FindBy(xpath = "//button[@class='btn btn-red']")
	WebElement Submitbutton;

	public WebElement getDate(String dateOfBirth) {
		String[] arrOfStr = dateOfBirth.split("/");
		String formatteddate = arrOfStr[0];
		return WebDriverManager.getDriver().findElement(By.xpath("//div[text()='" + formatteddate + "']"));

	}

	public WebElement getCountryCode(String countryname) {

		return WebDriverManager.getDriver()
				.findElement(By.xpath("//ul[@class=' country-list']/li/span[text()='" + countryname + "']"));
	}

	public void ClickLoginButton() throws InterruptedException {
		utility.waitForElementToAppear(LoginButton, WebDriverManager.getDriver());
		LoginButton.click();

	}

	public void SignUpUser() {
		SignUp.click();
		utility.switchWindow(WebDriverManager.getDriver());

	}

	public void Emailtext() {
		Actions action1 = new Actions(WebDriverManager.getDriver());
		action1.moveToElement(Email).click().perform();
		action1.sendKeys("Test@gmail.com");

	}

	public void MemberEnrollment() throws InterruptedException {
		Thread.sleep(1000);
		utility.waitForElementToAppear(SelectTitle, WebDriverManager.getDriver());
		SelectTitle.click();
		utility.Select(SelectTitle, "MRS");
		utility.ScrollDownElement(WebDriverManager.getDriver(), Firstname);
		Firstname.sendKeys("Gitika");
		Thread.sleep(1000);
		lastname.sendKeys("Jindal");
		SelectCountry.click();
		utility.Select(SelectCountry, "AF");
		SelectDob.click();
		SelectMonth.click();
		utility.selectMonth(SelectMonth, "28-08-1993");
		SelectYear.click();
		utility.selectyear(SelectYear, "28-08-1993");
		getDate("28/08/1993").click();
		SelectCountryDropdown.click();
		Thread.sleep(3000);
		getCountryCode("Afghanistan").click();
		Thread.sleep(3000);
		PhoneNumber.sendKeys("0774112953");
		PhoneNumber.sendKeys(Keys.TAB);
		/*
		 * WebDriverWait wait = new
		 * WebDriverWait(WebDriverManager.getDriver(),Duration.ofSeconds(7));
		 * wait.until(ExpectedConditions.invisibilityOf(Checkbox));
		 */
		Thread.sleep(8000);
		Email.sendKeys("geetika@gmail.com");
		Thread.sleep(2000);
		Password.click();
		Thread.sleep(1000);
		Password.sendKeys("Testing@0707");
		ConfirmPassword.sendKeys("Testing@0707");
		utility.ScrollDownElement(WebDriverManager.getDriver(), Checkbox);
		Checkbox.sendKeys(Keys.ENTER);
		utility.ScrollDownuntilVisible(Submitbutton, WebDriverManager.getDriver());
		Thread.sleep(1000);
		Submitbutton.sendKeys(Keys.ENTER);

	}
}
