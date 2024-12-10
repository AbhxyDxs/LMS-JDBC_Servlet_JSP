package com.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
import com.service.LibraryService;

/**
 * Servlet implementation class bookServlet
 */
@WebServlet("/bookServlet")
public class bookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("list")) {
			LibraryService service = new LibraryService();
			RequestDispatcher rd = null;
			try {
				List<Book> b = service.listBook();
				if(b != null) {
					rd = request.getRequestDispatcher("list.jsp");
					request.setAttribute("BLIST", b);
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("search")) {
			LibraryService service = new LibraryService();
			RequestDispatcher rd = null;
			String id = request.getParameter("id");
			Book b = null;
			try {
				b = service.searchBook(id);
				rd = request.getRequestDispatcher("search.jsp");
				request.setAttribute("BLIST", b);
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("update")) {
			LibraryService service = new LibraryService();
			RequestDispatcher rd = null;
			String id = request.getParameter("id");
			Book b = null;
			try {
				b = service.fetchBook(id);
				rd = request.getRequestDispatcher("update.jsp");
				request.setAttribute("BLIST", b);
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("delete")) {
			LibraryService service = new LibraryService();
			RequestDispatcher rd = null;
			String id = request.getParameter("id");
			Book b = null;
			try {
				b = service.fetchBook(id);
				rd = request.getRequestDispatcher("delete.jsp");
				request.setAttribute("BLIST", b);
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("add")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String category = request.getParameter("category");
			String price = request.getParameter("price");
			RequestDispatcher rd = null;
			Book b = new Book(id, name, category, Double.parseDouble(price));
			LibraryService service = new LibraryService();
			boolean result = false;;
			try {
				result = service.addBook(b);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			if (result)
				rd = request.getRequestDispatcher("addSuccess.jsp");
			else
				rd = request.getRequestDispatcher("addFail.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("update")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String category = request.getParameter("category");
			String price = request.getParameter("price");
			RequestDispatcher rd = null;
			Book b = new Book(id, name, category, Double.parseDouble(price));
			LibraryService service = new LibraryService();
			try {
				boolean res = service.updateBook(id, b);
				if(res)
					rd = request.getRequestDispatcher("updateSuccess.jsp");
				else
					rd = request.getRequestDispatcher("updateFail.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("delete")) {
			String id = request.getParameter("id");
			RequestDispatcher rd = null;
			LibraryService service = new LibraryService();
			try {
				boolean res = service.deleteBook(id);
				if(res)
					rd = request.getRequestDispatcher("deleteSuccess.jsp");
				else
					rd = request.getRequestDispatcher("deleteFail.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
}