package Practice.SpicejetAutomation;

public class Loginparameters {

	
	private String Mobile_Number;
	private String Email_Id;
	private String Password;
	
	
	
	public Loginparameters(String mobile_Number, String email_Id, String password) {
	//	super();
		Mobile_Number = mobile_Number;
		Email_Id = email_Id;
		Password = password;
	}
	
	
	@Override
	public String toString() {
		return "Loginparameters [Mobile_Number=" + Mobile_Number + ", Email_Id=" + Email_Id + ", Password=" + Password
				+ "]";
	}
	public String getMobile_Number() {
		return Mobile_Number;
	}
	public void setMobile_Number(String mobile_Number) {
		Mobile_Number = mobile_Number;
	}
	public String getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
}
