<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Management System</title>
</head>
<body>
	<h2 align="center">Add a Book</h2>
	<form action="bookServlet?action=add" method="post">
		<table align="center" width="30%" border="0" style="font-size: 18px">
			<tr>
				<td width="45%">Book Id</td>
				<td> <input type="text" name="id" required> </td>
			</tr>
			<tr>
				<td width="45%">Book Name</td>
				<td> <input type="text" name="name" required> </td>
			</tr>
			<tr>
				<td width="45%">Book Category</td>
				<td> <input type="text" name="category" required> </td>
			</tr>
			<tr>
				<td width="45%">Book Price</td>
				<td> <input type="text" name="price" required> </td>
			</tr>
			<tr >
				<td colspan="2" style="text-align: center; padding-top: 15px;">
					<input type="submit" value="Add" style="padding: 5px 10px; font-size: 16px; margin-top: 10px; border-radius: 4px">
				</td>
			</tr>
		</table>
	</form>
	<p align="center"><a href="index.jsp" style="text-decoration: none; font-size: 18px">Back</a></p>
</body>
</html>