<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="advancejava5.model.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  background-color: #222;
  color: #f8f8f8;
}

.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #525151;
  color: #fff;
  padding: 10px;
  border-radius:5px;
}

.left-section {
  display: flex;
  align-items: center;
}

h2 {
  margin: 0;
}

.center-section {
  text-align: center;
}

.logo {
  color: #fff;
  font-size: 24px;
  font-weight: bold;
  text-decoration: none;
}

.right-section {
  display: flex;
  align-items: center;
}

form {
  margin: 0;
}

.logout-btn {
  background-color: #222;
  color: #fff;
  border: none;
  padding: 8px 16px;
  border-radius: 4px;
  cursor: pointer;
}

.logout-btn:hover {
  background-color: #444;
}

.button {
  display: inline-block;
  background-color: #444;
  color: #fff;
  border: none;
  padding: 8px 16px;
  border-radius: 4px;
  font-size: 14px;
  cursor: pointer;
  text-decoration: none;
}

.button:hover {
  background-color: #666;
}

/* Positioning for the button */
.button-container {
  display: flex;
  justify-content: flex-end;
  margin-top: 10px;
}

/* Table styling */
table {
  margin: 50px auto;
  width: 90%;
  border-collapse: collapse;
  background-color: #333;
  color: #f8f8f8;
  border: 1px solid #f8f8f8;
}

th {
  text-align: left;
  padding: 10px;
  border-bottom: 1px solid #f8f8f8;
}

td {
  padding: 10px;
  border-bottom: 1px solid #f8f8f8;
}

/* Button styling */
.btn {
  background-color: #444;
  color: #fff;
  border: none;
  padding: 8px 16px;
  border-radius: 4px;
  font-size: 14px;
  cursor: pointer;
}

.btn-success {
  background-color: #2d882d;
}

.btn-warning {
  background-color: #d1a800;
}

/* Link styling */
a {
  color: #f8f8f8;
  text-decoration: none;
}

a:hover {
  color: #fff;
}


</style>
</head>
<body>
	
		
	<%
	String username = (String) request.getAttribute("name");
%>
<nav class="navbar">
  <div class="left-section">
    <h2>Welcome <%=username%></h2>
  </div>
  <div class="center-section">
    <a href="#" class="logo">Librarian Assist</a>
  </div>
  <div class="right-section">
    <form action="logout" method="post">
      <button type="submit" class="logout-btn">Logout</button>
    </form>
  </div>
</nav>

	

	<!-- <h2>
		Hello
		<%=username%></h2>
	<form action="logout" method="post">
		<strong>Welcome</strong>
		<button type="submit" style="margin-left: 5px;"
			class="btn btn-info btn-sm ">Logout</button>
	</form>
	<a href="logout"><button type="submit" style="margin-left: 5px;"
			class="btn btn-info btn-sm ">Logout</button></a>-->
	<div class="container">
		<div class="button-container">
			<a href="showAddBook" class="button ">Add book</a>
		</div>
	</div>

	<div>
		<table id="Table" style="margin-top: 50px;">
			<thead>
				<tr>
					<td>Book Code</td>
					<td>Book Name</td>
					<td>Author</td>
					<td>Date Added</td>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
				<%
					Object bookListObj = request.getAttribute("bookList");
					Book[] bookList = (Book[]) bookListObj;
					for (Book p : bookList) {
				%>
				<tr>
					<td><%=p.getBookCode()%></td>
					<td><%=p.getBookName()%></td>
					<td><%=p.getAuthorName()%></td>
					<td><%=p.getDate()%></td>
					<td><a href="showupdateBook?id=<%=p.getBookCode()%>"><button
								type="button" class="btn btn-success">Edit</button></a> <a
						href="deleteBook?bookCode=<%=p.getBookCode()%>"><button
								type="button" class="btn btn-warning">Delete</button></a></td>
				</tr>
				<%
					}
				%>
			</tbody>

		</table>
	</div>


</body>
</html>