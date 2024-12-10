package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		return DriverManager.getConnection("jdbc:derby:D:\\Projects\\TCS\\[Java]\\Eclipse WS\\LMS_JSP_Servlet_JDBC\\Library_DB;create = true");
	}
	public static void closeConnection(Connection cn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(cn != null)
			cn.close();
		if(ps != null)
			ps.close();
		if(rs != null)
			rs.close();
	}
//	public static void main(String args[]) throws ClassNotFoundException, SQLException {
//		Connection c = createConnection();
//		if(c != null)
//			System.out.println("DB Created!");
//		else
//			System.out.println("DB Creation Failed!");
//	}
}