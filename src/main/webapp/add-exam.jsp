<%@ page import="com.student.enums.Gender" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.student.enums.Grade" %>
<%@ page import="java.util.List" %>
<%@ page import="com.student.dao.UnitDao" %>
<%@ page import="com.student.models.Unit" %><%--
  Created by IntelliJ IDEA.
  User: Tee
  Date: 29/09/2021
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
</head>
<body>
<jsp:include page="nav-bar.jsp"></jsp:include>
<%List<Unit> unitList = new UnitDao().view();%>//

<div class="container ">
    <div class="col-md-4 col-md-offset-4">
        <h2>New Exam </h2>
        <form class="form-horizontal" action="./exam/add" method="POST">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
            </div>
            <div class="form-group">
                <label for="unit">Course:</label>
                <select class="form-control" name="unit" id="unit">
                    <option disabled selected value="">------Select Year-----</option>
                    <% for (Unit unit : unitList) {%>
                    <option value="<%=unit.getCourseId()%>"><%=unit.getCourseAbbr()%></option>
                    <%
                        }%>
                </select>
            </div>
            <button type="submit" class="btn btn-success">Submit</button>
        </form>
    </div></div>




</body>
</html>
