package Practice.SpicejetAutomation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FetchDbData extends WebDriverManager{
	static String dburl;
	static String dbusername;
	static String dbpassword ;
	
	public FetchDbData() throws SQLException, IOException {
		super();
			
		// TODO Auto-generated constructor stub
	}

	/*
	 * public static void main(String[] args) throws SQLException, IOException {
	 * FetchDbData fb = new FetchDbData(); List<Loginparameters> logindata =
	 * fb.fetchUserdata();
	 * 
	 * System.out.println(logindata);
	 * 
	 * }
	 */
     public  List<Loginparameters> fetchUserdata() throws SQLException
     {
       List<Loginparameters> users = new ArrayList<>();
    	Connection connection = null;
    	dburl = getProp().getProperty("jdbcURL");
        dbusername = getProp().getProperty("username");
 		dbpassword = getProp().getProperty("password");
 		connection = DriverManager.getConnection(dburl, dbusername,dbpassword);
    	 String getUserData = "Select Mobile_Number ,Email_Id,Password from loginData";
    	
			PreparedStatement statement1;
			try {
				statement1 = connection.prepareStatement(getUserData);
				ResultSet rs = statement1.executeQuery();
				while(rs.next())
				{
					users.add(new Loginparameters(rs.getString(1),rs.getString(2),rs.getString(3)));
					
				}
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return users;
    	 
     }
	
	
	
	
}
