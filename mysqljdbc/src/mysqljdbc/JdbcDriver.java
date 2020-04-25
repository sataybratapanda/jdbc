package mysqljdbc;
import java.sql.*;
public class JdbcDriver {
	public static void main(String[] args)  {
		
		try {
			//get the connection
			Connection myCon =DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","Satya@123");
			//create statement
			Statement stmt =myCon.createStatement();
			//execute the sql query
			String sql="insert into book(book_name,book_id,book_author) values('my life','12334of','chetan vagat')";
			String sql1="insert into book(book_name,book_id,book_author) values('school days','0000','satyabrata panda')";
			String sq2="insert into book(book_name,book_id,book_author) values('good','1233','maha kal')";
			String sq3="insert into book(book_name,book_id,book_author) values('character','123637d','tulsi das')";
			//String sql2="delete from book where book_name='my life'";
			//String sql3="update book set book_name='creature of God' where book_id='0000'";
			//stmt.executeUpdate(sql);
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sq2);
			stmt.executeUpdate(sq3);

			
			
			ResultSet rs=stmt.executeQuery("select * from book");
			while(rs.next())
			{
				System.out.println(rs.getString("book_name")+" "+rs.getString("book_author")+" "+rs.getString("book_id"));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
