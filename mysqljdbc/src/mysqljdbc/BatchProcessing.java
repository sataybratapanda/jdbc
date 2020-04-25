package mysqljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessing {
public static void main(String[] args) throws SQLException  {
	Connection myCon=null;
		try {
			//get the connection
			 myCon =DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","Satya@123");
			//create statement
			Statement stmt =myCon.createStatement();
			myCon.setAutoCommit(false);
			//execute the sql query
			String sql="insert into book(book_name,book_id,book_author) values('my life','12334of','chetan vagat')";
			String sql1="update book set book_id='3000' where book_author='chetan vagat'";
			String sq2="insert into book(book_name,book_id,book_author) values('good','1233','maha kal')";
			
			
			stmt.addBatch(sql);
			stmt.addBatch(sq2);
			stmt.addBatch(sql1);
			
			stmt.executeBatch();
			myCon.commit();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			myCon.rollback();
			e.printStackTrace();
		}
	}
}
