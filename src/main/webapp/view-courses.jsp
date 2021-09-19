<%--
  Created by IntelliJ IDEA.
  User: Tee
  Date: 18/09/2021
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.student.dao.CourseDao" %>
<%@ page import="com.student.models.Course" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>View Courses</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">

</head>
<body>

<jsp:include page="nav-bar.jsp"></jsp:include>

<% List<Course> courseList =new CourseDao().view();%>
<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <form class="form-inline  col-md-offset-8">
            <div class="form-group ">
                <%--                <span><i class="material-icons md-18">&#xe8b6;</i></span>--%>
                <input type="text" id="search" onkeyup="searchTable()" class="form-control " name="search" placeholder="Type name here...">
            </div>
        </form>

        <table id="courses-table" class="table center table-hover table-responsive table-bordered">
            <caption class="text-center">Courses</caption>
            <th class="text-center success">Course Id</th>
            <th class="text-center success">Course ABBR</th>
            <th class="text-center success">Course Title</th>
            <th class="text-center success">Edit</th>
            <th class="text-center success">Delete</th>

                <% if (courseList!=null){
                for (Course course : courseList) {%>
            <tr><td><%=course.getCourseId()%></td>
                <td><%=course.getCourseAbbr()%></td>
                <td><%=course.getCourseName()%></td>
                <td><a href="./course/edit?id=<%=course.getCourseId()%>"><button class="btn btn-success btn-sm ">Edit</button></a></td>
                <td><a href="./course/delete?id=<%=course.getCourseId()%>"><button class="btn btn-danger btn-sm text-center">Delete</button></a></td>
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
                    table = document.getElementById("courses-table");
                    tr = table.getElementsByTagName("tr");

                    // Loop through all table rows, and hide those who don't match the search query
                    for (i = 0; i < tr.length; i++) {
                        td = tr[i].getElementsByTagName("td")[2];
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