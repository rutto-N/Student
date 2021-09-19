<%--
  Created by IntelliJ IDEA.
  User: Tee
  Date: 17/09/2021
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

<div class="card-body col-md-4 col-md-offset-4 ">
    <h2>Login Form</h2>
    <hr>
    <form action="./login" method="POST">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
        </div>
        <div class="form-group">
            <h5>Dont have an account? <a href="./add-user.jsp">Register</a></h5>
        </div>

        <button type="submit" class="btn btn-success">Login</button>
    </form>
    <% session.invalidate(); %>
</div>
</body>
</html>
