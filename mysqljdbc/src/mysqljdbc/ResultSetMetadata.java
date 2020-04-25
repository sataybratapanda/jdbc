package mysqljdbc;

import java.sql.*;


public class ResultSetMetadata {
	public static void main(String args[])
	{
		Connection myCon;
		try {
			
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Satya@123");
			
			Statement stmt=myCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employees");
			ResultSetMetaData rsmd=rs.getMetaData();
			System.out.println("the number of column "+rsmd.getColumnCount());
			System.out.println("the cloumn name"+rsmd.getColumnName(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}