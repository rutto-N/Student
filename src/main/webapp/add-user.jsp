<%--
  Created by IntelliJ IDEA.
  User: Tee
  Date: 18/09/2021
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">

</head>
<body>
<jsp:include page="nav-bar.jsp"></jsp:include>

<div class="container col-md-4 col-md-offset-4 ">
<h2>Registration </h2>
<form action="./register" method="POST">
      <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
          </div>
      <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
          </div>
      <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
          </div>
    <div class="form-group">
            <label for="re-password">Password:</label>
            <input type="password" class="form-control" id="re-password" name="re-password" placeholder="Enter password">
          </div>
      <button type="submit" class="btn btn-success">Submit</button>
    </form>
</div>

</body>
</html>
