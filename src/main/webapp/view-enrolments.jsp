<%@ page import="com.student.models.EnrolmentDetail" %>
<%@ page import="com.student.dao.EnrolmentDao" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Tee
  Date: 23/09/2021
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Students</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">

</head>
<body>

<jsp:include page="nav-bar.jsp"></jsp:include>
<% List<EnrolmentDetail> enrolments =new EnrolmentDao().viewEnrolmentsPerStudent((Integer) session.getAttribute("id")); %>
<div class="container ">
    <div class="col-md-8 col-md-offset-2 ">

        <form class="form-inline col-md-offset-8">
            <div class="form-group ">
                <input type="text" id="search" onkeyup="searchTable()" class="form-control " name="search" placeholder="Type name here...">
            </div>
        </form>
        <table id="enrolments-table" class="table center table-hover table-responsive table-bordered">
            <caption class="text-center">Enrolments</caption>
            <th class="text-center success">Student Name</th>
            <th class="text-center success">Unit</th>
            <th class="text-center success">Edit</th>
            <th class="text-center success">Delete</th>

                <% if (enrolments!=null){
                for (EnrolmentDetail enrolment : enrolments) {%>
            <tr><td><%=enrolment.getStudentName()%></td>
                <td><%=enrolment.getCourseName()%></td>
                <td><a href="./enrolment/edit?id=<%=enrolment.getEnrolmentId()%>"><button class="btn btn-success btn-sm ">Edit</button></a></td>
                <td><a href="./enrolment/delete?id=<%=enrolment.getEnrolmentId()%>"><button class="btn btn-danger btn-sm text-center">Delete</button></a></td>
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
                    table = document.getElementById("enrolments-table");
                    tr = table.getElementsByTagName("tr");

                    // Loop through all table rows, and hide those who don't match the search query
                    for (i = 0; i < tr.length; i++) {
                        td = tr[i].getElementsByTagName("td")[0];
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

