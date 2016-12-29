package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	static Connection con =null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	public static Connection getConnection()
	{
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		 con= DriverManager.getConnection("jdbc:oracle:thin:@Sammy:1521:XE","SANJIT","SANJIT");
		}catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public static void closeConnection(Connection con)
	{
		try{
		if(con!=null)
		{
			con.close();
		}
		}
		catch(SQLException e)
		{
			
		}
		
	}
	public static void closePreparedStatement(PreparedStatement ps)
	{
		try{
		if(ps!=null)
		{
			ps.close();
		}
		}
		catch(SQLException e)
		{
			
		}
		
	}
	public static void closeResultSet(ResultSet rs)
	{
		try{
		if(rs!=null)
		{
			rs.close();
		}
		}
		catch(SQLException e)
		{
			
		}
		
	}

}
