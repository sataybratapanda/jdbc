package mysqljdbc;
import java.io.*;
import java.sql.*;
public class ImageToMysql {
	public static void main(String[] args) throws SQLException, IOException {
	 
		try {
			
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Satya@123");
			PreparedStatement ps=myCon.prepareStatement("insert into imgtable values(?,?,?)");  
			ps.setString(1,"signature");  
			  
			FileInputStream fin=new FileInputStream("d:\\a.jpg");
			FileInputStream fin1=new FileInputStream("d:\\resume.docx");
			ps.setBinaryStream(2,fin,fin.available());  
			ps.setBinaryStream(3,fin1,fin1.available());  
			
			ps.executeUpdate();  
			System.out.println(" records affected");  
			ResultSet rs=ps.executeQuery("select * from imgtable");
			while(rs.next())
			{
				System.out.println("the photo and resume"+" "+rs.getBlob("photo")+" "+rs.getBlob("file"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	

}
