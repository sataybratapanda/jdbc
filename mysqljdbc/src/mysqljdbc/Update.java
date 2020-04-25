package mysqljdbc;
import java.sql.*;
public class Update {
	
		public static void main(String[] args) {
			try {
				PreparedStatement myStmnt = null;
				ResultSet myRes = null;
			
				//get the connection
				Connection myCon =DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Satya@123");
				//create statement
				System.out.println("got connection");
				//create statement
				Statement mystmt = myCon.createStatement();
				
				myStmnt = myCon.prepareStatement("update employees set salary=? where  department=?");

				 

				//Set the parameters 
				myStmnt.setDouble(1,75000);
				myStmnt.setString(2,"HR");
				myStmnt.executeUpdate();
				myRes= mystmt.executeQuery("select * from employees");
				while(myRes.next())
				{
					String lastName = myRes.getString("last_name");
					String firstName = myRes.getString("first_name");
					double salary = myRes.getDouble("salary");
					String departments  = myRes.getString("department");
					System.out.printf("%s,%s,%.2f,%s\n",lastName,firstName,salary,departments);
				
			} 
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


