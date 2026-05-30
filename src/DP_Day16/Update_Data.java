package DP_Day16;
import java.sql.*;
public class Update_Data {
public static void main(String[] args) {
	try {
		String url = "jdbc:mysql://localhost:3306/wipro_db";
		String user = "root";
		String password = "pass@word1";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,password);
		Statement st = con.createStatement();
		String insertquery = "Insert into employee values(1,'Shaurya',30000)";
		int insertRows = st.executeUpdate(insertquery);
		System.out.println(insertRows);
		String updatequery = "Update employee set salary = 50000 where id = 1";
		int updateRows = st.executeUpdate(updatequery);
		System.out.println(updateRows); 
		con.close();
	}catch(Exception e) {
		System.out.println(e);
	}
}
}
