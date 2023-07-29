package StepDefinitions;

import java.io.IOException;
import Practice.SpicejetAutomation.WebDriverManager;
import Practice.SpicejetAutomation.SignUpActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStepDef extends WebDriverManager{

	public SignUpStepDef() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	SignUpActions login ; 
	
	  @Before
	  public void setup() throws IOException 
	  { 
		initialization(); 
	    login = new SignUpActions();
	  
	  }
	 

@Given("Click Login button on Site")
public void click_login_button_on_site() throws IOException, InterruptedException {
	//initialization();
	login.ClickLoginButton();
}

@When("I click on SignUp link")
public void i_click_on_sign_up_link() {
   login.SignUpUser();
}

@Then("Member Enrollment form is filled")
public void member_enrollment_page_displays() throws InterruptedException {
   
	login.MemberEnrollment();
}

@After
void Teardown()
{
	try {
	getDriver().close();
	getDriver().quit();
	}
	catch(NullPointerException e)
	{
		e.printStackTrace();
	}
}

}