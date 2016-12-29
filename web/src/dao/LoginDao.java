package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

import util.DBUtil;

public class LoginDao {
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public User login(String u,String p)
	{
		
		
		con=DBUtil.getConnection();
		try
		{
		String query="select * from tbl_user_1126702 where userid=? and password=?";
		ps=con.prepareStatement(query);
		ps.setString(1,u);
		ps.setString(2,p);
		rs=ps.executeQuery();
		if(rs.next())
		{
			
			User user=new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setUserid(rs.getString(3));
			user.setPassword(rs.getString(4));
			user.setStatus(rs.getString(5));
			return user;
		}
		
		}catch(ClassCastException |SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			DBUtil.closeConnection(con);
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeResultSet(rs);
		}
		return null;
		
	}

}
