<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Management System</title>
</head>
<body>
	<h1 align="center">Library Management System</h1>
	<table align="center" border="1" width="30%" style="text-align: center; font-size: 25px; height: 80vh">
		<tr>
			<td><a href="add.jsp" style="text-decoration: none;">Add a Book</a> </td>
		</tr>
		<tr>
			<td><a href="bookServlet?action=list" style="text-decoration: none">List Books</a> </td>
		</tr>
		<tr>
			<td><a href="search.jsp" style="text-decoration: none">Search for a Book</a></td>
		</tr>
		<tr>
			<td><a href="update.jsp" style="text-decoration: none">Update a Book</a></td>
		</tr>
		<tr>
			<td><a href="delete.jsp" style="text-decoration: none">Delete a Book</a></td>
		</tr>
	</table>
</body>
</html>