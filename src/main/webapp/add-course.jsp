<%--
  Created by IntelliJ IDEA.
  User: Tee
  Date: 18/09/2021
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Course</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">

</head>
<body>
<jsp:include page="nav-bar.jsp"></jsp:include>
<div class="col-md-4 col-md-offset-4 ">
<h2>Add Student Form</h2>
<form action="./course/add" method="POST">
    <div class="form-group">
        <label for="courseAbbr">Course Abbr:</label>
        <input type="text" class="form-control" id="courseAbbr" name="courseAbbr" placeholder="Course Abbr eg MAT 101">
      </div>
    <div class="form-group">
        <label for="courseName">Course Title:</label>
        <input type="text" class="form-control" id="courseName" name="courseName" placeholder="Course Title eg Mathematics">
      </div>
    <button type="submit" class="btn btn-success">Submit</button>
  </form>
</div>

</body>
</html>
