package mysqljdbc;
import java.sql.*;
public class PrepareStatement {
public static void main(String[] args)  {
		
		try {
			//get the connection
			Connection myCon =DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Satya@123");
			//create statement
			Statement stmt =myCon.createStatement();
			//create prepare statement
			PreparedStatement myStmnt = myCon.prepareStatement( "select * from employees where salary >? or  department=? or email=?");
			//Set the parameters 
			myStmnt.setDouble(1,75000);
			myStmnt.setString(2,"Legal");
			myStmnt.setString(3,"...");
			//Execute the SQL query 
			ResultSet myRes;
			myRes = myStmnt.executeQuery(); 
			display(myRes);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

private static void display(ResultSet myRes) throws SQLException {
	
	while(myRes.next())
	{
		System.out.println(myRes.getString("first_name")+" "+myRes.getDouble("salary")+" "+myRes.getString("department")+" "+myRes.getString("email"));
	}
}

}
