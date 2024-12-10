<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.bean.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search a Book</title>
</head>
<body>
	<h2 align="center">Search using Book Id</h2>
	<form action="bookServlet" method="get">
	    <input type="hidden" name="action" value="search">
		<table align="center" border="0" width="20%" style="font-size: 18px">
			<tr>
				<td> Book Id </td>
				<td> <input type="text" name="id" required> </td>
			</tr>
			<tr align="center">
				<td colspan="2" style="padding-top: 20px;"> 
					<input type="submit" value="Search" style="padding: 5px 10px; font-size: 16px; margin-top: 10px; border-radius: 4px"> 
				</td>
			</tr>
		</table>
	</form>
	<br> <br>
	<%
	    String action = request.getParameter("action");
	    if ("search".equalsIgnoreCase(action)) {
		    Book b = (Book)request.getAttribute("BLIST");
		    if (b != null) {
	%>
	<h3 align="center">Book Details</h3>
	<table align="center" border="1" width="80%">
		<tr>
			<th> Book Id </th>
			<th> Book Name </th>
			<th> Book Category </th>
			<th> Book Price </th>
		</tr>
		<tr align="center">
			<td> <%= b.getBookId() %> </td>
			<td> <%= b.getBookName() %> </td>
			<td> <%= b.getBookCategory() %> </td>
			<td> <%= b.getBookPrice() %> </td>
		</tr>
	</table>
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