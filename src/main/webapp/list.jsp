<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.bean.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Books</title>
</head>
<body>
<%
	List<Book> b = (List<Book>)request.getAttribute("BLIST");
%>
	<h2 align="center">List of Books</h2>
	<table align="center" border="1" width="80%" style="font-size: 18px; height: 25vh">
		<tr>
			<th> Book Id </th>
			<th> Book Name </th>
			<th> Book Category </th>
			<th> Book Price </th>
		</tr>
		<%
			for(Book bk: b) {
		%>
		<tr align="center">
			<td> <%= bk.getBookId() %> </td>
			<td> <%= bk.getBookName() %> </td>
			<td> <%= bk.getBookCategory() %> </td>
			<td> <%= bk.getBookPrice() %> </td>
		</tr>
		<%
			}
		%>
	</table>
	<p align="center"><a href="index.jsp" style="text-decoration: none; font-size: 18px">Back to Main Menu</a></p>
</body>
</html>