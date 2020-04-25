package mysqljdbc;
import java.sql.*;
public class Count {
	public static void main(String[] args) throws SQLException {
	     PreparedStatement myStmnt= null;
	     ResultSet myRes = null;
	     
	
	try {


		//create a statement
		
		String theDepartment = "Engineering";
		
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Satya@123");
		
		
		CallableStatement myStmnt1 =myConn.prepareCall("{call get_count_for_department(?,?)}");
		
		//set the parameters
		
		myStmnt1.setString(1,theDepartment);
		myStmnt1.registerOutParameter(2,Types.INTEGER);
		//call store procedure
		System.out.println("calling stored procedure. get_count_for_department('"+theDepartment+"',?)");
		
		myStmnt1.execute();
		System.out.println("finished calling stored procedure");
		//get the valueof the outparameter
		int theCount=myStmnt1.getInt(2);
		System.out.println("\n the count="+theCount+" "+theDepartment);
		

}
  catch (Exception exc)
	{
  	exc.printStackTrace();
	}  
	}
}
