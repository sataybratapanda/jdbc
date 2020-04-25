package mysqljdbc;
import java.sql.*;
public class DatabaseMetadata {
	public static void main(String args[])
	{
		Connection myCon;
		try {
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Satya@123");
			Statement stmt=myCon.createStatement();
			DatabaseMetaData dbmt=myCon.getMetaData();
			System.out.println("Db name"+dbmt.getDatabaseProductName());
			System.out.println("Db version"+dbmt.getDatabaseProductVersion());
			System.out.println("Db driver name"+dbmt.getDriverName());
			System.out.println("Db driver version"+dbmt.getDriverVersion());
			String t[]= {"TABLE"};
			
			ResultSet rs=dbmt.getTables(null, null, "%", t);
			while(rs.next())
			{
				System.out.println(rs.getString("TABLE_NAME"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
