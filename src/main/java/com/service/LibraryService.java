package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Book;
import com.dao.LibraryDAO;

public class LibraryService {
	public boolean addBook(Book b) throws ClassNotFoundException, SQLException {
		LibraryDAO dao = new LibraryDAO();
		return dao.addBook(b);
	}

	public List<Book> listBook() throws ClassNotFoundException, SQLException {
		LibraryDAO dao = new LibraryDAO();
		return dao.listBook();
	}

	public Book searchBook(String id) throws ClassNotFoundException, SQLException {
		LibraryDAO dao = new LibraryDAO();
		return dao.searchBook(id);
	}

	public Book fetchBook(String id) throws ClassNotFoundException, SQLException {
		LibraryDAO dao = new LibraryDAO();
		return dao.fetchBook(id);
	}

	public boolean updateBook(String id, Book b) throws ClassNotFoundException, SQLException {
		LibraryDAO dao = new LibraryDAO();
		return dao.updateBook(id, b);
	}

	public boolean deleteBook(String id) throws ClassNotFoundException, SQLException {
		LibraryDAO dao = new LibraryDAO();
		return dao.deleteBook(id);
	}
	
}