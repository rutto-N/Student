<%@ page import="com.student.enums.Grade" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="com.student.enums.Course" %><%--
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
<%List<Grade> grades = Arrays.asList(Grade.values());%>
<%List<Course> courseList = Arrays.asList(Course.values());%>

<div class="col-md-4 col-md-offset-4 ">
<h2>Add Unit</h2>
<form action="./course/add" method="POST">
<%--<form action="./show-unit.jsp" method="POST">--%>
    <div class="form-group">
        <label for="courseAbbr">Unit Abbr:</label>
        <input type="text" class="form-control" id="courseAbbr" name="courseAbbr" placeholder="Course Abbr eg MAT 101">
      </div>
    <div class="form-group">
        <label for="gradeId">Academic year:</label>
        <select class="form-control" name="gradeId" id="gradeId">
            <option disabled selected value="">------Select Year-----</option>
            <% for (Grade grade:grades) {%>
            <option value="<%=grade.name()%>"><%=grade.getLabel()%></option>
            <%
                }%>
        </select>
    </div>
    <div class="form-group">
        <label for="course">Course:</label>
        <select class="form-control" name="course" id="course">
            <option disabled selected value="">------Select Year-----</option>
            <% for (Course course:courseList) {%>
            <option value="<%=course.name()%>"><%=course.getDisplayName()%></option>
            <%
                }%>
        </select>
    </div>
    <div class="form-group">
        <label for="courseName">Unit Title:</label>
        <input type="text" class="form-control" id="courseName" name="courseName" placeholder="Course Title eg Mathematics">
      </div>
    <button type="submit" class="btn btn-success">Submit</button>
  </form>
</div>

</body>
</html>
