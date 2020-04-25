package mysqljdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class InOutParameter {
	public static void main(String[] args) throws SQLException {
	     
	     ResultSet myRes = null;
	     
	
	try {


		//create a statement
		
		String theDepartment = "Engineering";
		
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Satya@123");
		
		
		 PreparedStatement myStmnt =myConn.prepareCall("{call greet_the_department(?)}");
		
		//set the parameters
		 ((CallableStatement) myStmnt).registerOutParameter(1,Types.VARCHAR);
		myStmnt.setString(1,theDepartment);
		
		//call store procedure
		System.out.println("calling stored procedure. greet_the_department('"+theDepartment+"',?)");
		
		myStmnt.execute();
		System.out.println("finished calling stored procedure");
		myRes= myStmnt.executeQuery("select * from employees");
		while(myRes.next())
		{
			String lastName = myRes.getString("last_name");
			String firstName = myRes.getString("first_name");
			double salary = myRes.getDouble("salary");
			String departments  = myRes.getString("department");
			System.out.printf("%s,%s,%.2f,%s\n",lastName,firstName,salary,departments);
		
	} 
		
		

}
 catch (Exception exc)
	{
 	exc.printStackTrace();
	}  
	}

}
