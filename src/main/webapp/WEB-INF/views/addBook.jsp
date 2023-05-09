<%@page import="advancejava5.service.AuthorServiceImpl"%>
<%@page import="advancejava5.model.Author"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

/* Add book form styles */
form {
  max-width: 600px;
  margin: 0 auto;
  margin-top:5%;
}

form label {
  display: block;
  margin-bottom: 5px;
}

form input[type="number"],
form input[type="text"],
form select,
form input[type="date"] {
  width: 100%;
  padding: 10px;
  margin-bottom: 15px;
  border: none;
  background-color: #333;
  color: #f8f8f8;
  border-radius: 5px;
  box-sizing: border-box;
}

form input[type="submit"] {
  background-color: #2d882d;
  color: #fff;
  border: none;
  padding: 8px 16px;
  border-radius: 4px;
  font-size: 14px;
  cursor: pointer;
}

form input[type="submit"]:hover {
  background-color: #44a944;
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
	
	

<form action="addBook" method="post">
  <label for="bookId">Book ID:</label>
  <input type="number" id="bookId" name="bookId" required><br>
  <label for="bookName">Book Name:</label>
  <input type="text" id="bookName" name="bookName" required><br>
  <label for="authorName">Author Name:</label>
  <!-- <input type="text" id="authorName" name="authorName" required><br>-->
  
 <select name="authorName">
	<%
	Author[] listAuthor=(Author[])new AuthorServiceImpl().getAuthor();
	for(Author author:listAuthor){%>
		<option><%=author.getAuthorName() %></option>
	<%} %>
</select>

  <label for="date">Publication Date:</label>
  <input type="date" id="date" name="date" required><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>