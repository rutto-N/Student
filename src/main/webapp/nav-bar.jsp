<%--
  Created by IntelliJ IDEA.
  User: Tee
  Date: 18/09/2021
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
    <style>
        @media all and (min-width: 992px) {
            .navbar .nav-item .dropdown-menu{ display: none; }
            .navbar .nav-item:hover .nav-link{   }
            .navbar .nav-item:hover .dropdown-menu{ display: block; }
            .navbar .nav-item .dropdown-menu{ margin-top:0; }
        }
    </style>

</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">Student Management</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="nav-item"><a href="./view-students.jsp">Home</a></li>
            <li class="nav-item dropdown">
                <a class="nav-link  dropdown-toggle" data-bs-toggle="dropdown">Courses</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="./add-course.jsp"> New Course </a></li>
                    <li><a class="dropdown-item" href="./view-courses.jsp"> All Courses </a></li>
                </ul>
            </li>
<%--            <li class="nav-item"><a href="./view-students.jsp">Teachers</a></li>--%>
            <li class="nav-item dropdown">
                <a class="nav-link  dropdown-toggle"  data-bs-toggle="dropdown">Enrolments</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="./enrol.jsp"> Enrol </a></li>
                    <li><a class="dropdown-item" href="./view-enrolments.jsp"> My enrolments </a></li>
                    <li><a class="dropdown-item" href="./view-all-enrolments.jsp"> All enrolments </a></li>
                </ul>
            </li>
<%--            <li class="nav-item"><a href="./view-students.jsp">Exams</a></li>--%>
            <li class="nav-item dropdown">
                <a class="nav-link  dropdown-toggle" data-bs-toggle="dropdown">Students</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="./add-student.jsp"> New Student </a></li>
                    <li><a class="dropdown-item" href="./view-students.jsp"> All Students </a></li>
                </ul>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link  dropdown-toggle"  data-bs-toggle="dropdown">Users</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="./add-user.jsp"> New User </a></li>
                    <li><a class="dropdown-item" href="./view-users.jsp"> All Users </a></li>
                </ul>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link  dropdown-toggle"  data-bs-toggle="dropdown">Teachers</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="./add-teacher.jsp"> New Teacher </a></li>
                    <li><a class="dropdown-item" href="./view-teachers.jsp"> All Teachers </a></li>
                </ul>
            </li>
<%--            <li  class="nav-item navbar-center"> <span class="text-white"><%=session.getAttribute("email")%></span></li>--%>

        </ul>
        <div class="navbar-right">
            <li class="nav-item">
                <span class="text-white"></span>
                <div>
                    <a class="nav-link  dropdown-toggle" href="#" data-bs-toggle="dropdown">
                        <span class="material-icons md-24">&#xe853;</span></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="./logout">Logout</a></li>
                        <li><%=session.getAttribute("email")%></li>
                    </ul>
                </div>
            </li>
        </div>
    </div>
</nav>


</body>
</html>
