<%--
  Created by IntelliJ IDEA.
  User: Tee
  Date: 18/09/2021
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.student.dao.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.student.models.User" %>
<html>
<head>
    <title>View Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">

</head>
<body>

<jsp:include page="nav-bar.jsp"></jsp:include>

<% List<User> userList = new UserDao().view(); %>
<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <form class="form-inline  col-md-offset-8">
            <div class="form-group ">
                <%--                <span><i class="material-icons md-18">&#xe8b6;</i></span>--%>
                <input type="text" id="search" onkeyup="searchTable()" class="form-control " name="search" placeholder="Type name here...">
            </div>
        </form>

        <table id="users-table"class="table center table-hover table-responsive table-bordered">
            <caption class="text-center">Users</caption>
            <th class="text-center success">User Id</th>
            <th class="text-center success">Username</th>
            <th class="text-center success">Email</th>
            <th class="text-center success">Edit</th>
            <th class="text-center success">Delete</th>

            <% if (userList!=null){
                for (User user : userList) {%>
            <tr><td><%=user.getId()%></td>
                <td><%=user.getUsername()%></td>
                <td><%=user.getEmail()%></td>
                <td><a href="./users/edit?id=<%=user.getId()%>"><button class="btn btn-success btn-sm ">Edit</button></a></td>
                <td><a href="./users/delete?id=<%=user.getId()%>"><button class="btn btn-danger btn-sm text-center">Delete</button></a></td>
            </tr>

            <%
                }
            }%>
            <script>
                function searchTable() {
                    // Declare variables
                    let input, filter, table, tr, td, i, txtValue;
                    input = document.getElementById("search");
                    filter = input.value.toUpperCase();
                    table = document.getElementById("users-table");
                    tr = table.getElementsByTagName("tr");

                    // Loop through all table rows, and hide those who don't match the search query
                    for (i = 0; i < tr.length; i++) {
                        td = tr[i].getElementsByTagName("td")[1];
                        if (td) {
                            txtValue = td.textContent || td.innerText;
                            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                                tr[i].style.display = "";
                            } else {
                                tr[i].style.display = "none";
                            }
                        }
                    }
                }
            </script>







</body>
</html>
