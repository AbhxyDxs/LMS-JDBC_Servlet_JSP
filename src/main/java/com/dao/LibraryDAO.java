package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Book;
import com.util.DBUtil;

public class LibraryDAO {
	public boolean addBook(Book b) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.createConnection();
		if(con != null) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO LIBRARY VALUES (?, ?, ?, ?)");
			ps.setString(1, b.getBookId());
			ps.setString(2, b.getBookName());
			ps.setString(3, b.getBookCategory());
			ps.setDouble(4, b.getBookPrice());
			int res = ps.executeUpdate();
			DBUtil.closeConnection(con, ps, null);
			if(res > 0)
				return true;
		}
		return false;
	}

	public List<Book> listBook() throws SQLException, ClassNotFoundException {
		Connection con = DBUtil.createConnection();
		List<Book> bookList = new ArrayList<>();
		if(con != null) {
			PreparedStatement ps = con.prepareStatement("SELECT *FROM LIBRARY");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book b = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
				bookList.add(b);
			}
			DBUtil.closeConnection(con, ps, rs);
			return bookList;
		}
		return null;
	}

	public Book searchBook(String id) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.createConnection();
		if(con != null) {
			PreparedStatement ps = con.prepareStatement("SELECT *FROM LIBRARY WHERE BOOKID = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			Book b = null;
			while(rs.next()) {
				b = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
			DBUtil.closeConnection(con, ps, rs);
			if(b != null)
				return b;
		}
		return null;
	}

	public Book fetchBook(String id) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.createConnection();
		if(con != null) {
			PreparedStatement ps = con.prepareStatement("SELECT *FROM LIBRARY WHERE BOOKID = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			Book b = null;
			while(rs.next()) {
				b = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
			DBUtil.closeConnection(con, ps, rs);
			if(b != null)
				return b;
		}
		return null;
	}

	public boolean updateBook(String id, Book b) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.createConnection();
		if(con != null) {
			PreparedStatement ps = con.prepareStatement("UPDATE LIBRARY SET BOOKNAME = ?, BOOKCATEGORY = ?, BOOKPRICE = ? WHERE BOOKID = ?");
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getBookCategory());
			ps.setDouble(3, b.getBookPrice());
			ps.setString(4, id);
			int res = ps.executeUpdate();
			DBUtil.closeConnection(con, ps, null);
			if(res > 0)
				return true;
		}
		return false;
	}

	public boolean deleteBook(String id) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.createConnection();
		if(con != null) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM LIBRARY WHERE BOOKID = ?");
			ps.setString(1, id);
			int res = ps.executeUpdate();
			DBUtil.closeConnection(con, ps, null);
			if(res > 0)
				return true;
		}
		return false;
	}
}