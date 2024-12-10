<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.bean.Book" %>
<%@ page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update a Book</title>
</head>
<body>
<body>
	<form action="bookServlet" method="get">
	    <input type="hidden" name="action" value="update">
		<table align="center" border="0" width="20%" style="font-size: 18px">
			<tr>
				<td> Book Id </td>
				<td> <input type="text" name="id" required> </td>
			</tr>
			<tr align="center">
				<td colspan="2" style="padding-top: 20px"> <input type="submit" value="Fetch Book" style="padding: 5px 10px; font-size: 16px; margin-top: 10px; border-radius: 4px"> </td>
			</tr>
		</table>
	</form>
	<br> <br>
	<%
	    String action = request.getParameter("action");
	    if ("update".equalsIgnoreCase(action)) {
		    Book b = (Book)request.getAttribute("BLIST");
		    if (b != null) {
	%>
	<h3 align="center">Book Details</h3>
	<form action="bookServlet?action=update" method="post">
		<table align="center" border="0" width="25%" style="font-size: 18px">
			<tr>
				<td> Book Id </td>
				<td> <input type="text" name="id" value=" <%= b.getBookId() %>" readonly></td>
			</tr>
			<tr>
				<td> Book Name </td>
				<td> <input type="text" name="name" value=" <%= b.getBookName() %>" required></td>
			</tr>
			<tr>
				<td> Book Category </td>
				<td> <input type="text" name="category" value=" <%= b.getBookCategory() %>" required></td>
			</tr>
			<tr>
				<td> Book Price </td>
				<td> <input type="text" name="price" value=" <%= b.getBookPrice() %>" required></td>
			</tr>
			<tr align="center">
				<td colspan="2" style="padding-top: 20px"> <input type="submit" value="Update" style="padding: 5px 10px; font-size: 16px; margin-top: 10px; border-radius: 4px"></td>
			</tr>
		</table>
	</form>
	<%
            } else {
    %>
    <p align="center" style="color: red;">No book found with the given ID.</p>
    <%
            }
        }
    %>
    <p align="center"><a href="index.jsp" style="text-decoration: none; font-size: 18px">Back to Main Menu</a></p>
</body>
</html>