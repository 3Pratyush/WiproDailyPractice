package DP_Day16;
import java.sql.*;
public class InsertData_Ex {
public static void main(String[] args)
{
 
	try
	{
		String url="jdbc:mysql://localhost:3306/Ecommerce_DB";
		Connection con=DriverManager.getConnection(url, "root", "Lostfiber@8");
 
		Statement st=con.createStatement();
		String query="insert into Customers values(6, 'hul', 'hul@gmail.com', 'Dilhi')";
		
		int rows=st.executeUpdate(query);
		
		System.out.println(rows + " row inserted");
		
		con.close();
	}catch(Exception e)
	{
		System.out.println(e);
	}
	
}
 
}
