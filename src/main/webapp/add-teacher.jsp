<%--
  Created by IntelliJ IDEA.
  User: Tee
  Date: 18/09/2021
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.student.models.Course" %>
<%@ page import="com.student.dao.CourseDao" %>
<%@ page import="com.student.enums.Gender" %>
<%@ page import="java.util.Arrays" %>
<html>
<head>
    <title>Add Teacher</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">

</head>
<body>
<jsp:include page="nav-bar.jsp"></jsp:include>
<% List<Course> courseList=new CourseDao().view();
    List<Gender> genderValues = Arrays.asList(Gender.values());%>

<div class="row ">
<div class="col-md-4 col-md-offset-4">
<h2>Add Teacher </h2>
<form class="form-horizontal" action="./teacher/add" method="POST">
      <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
          </div>
      <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
          </div>
      <div class="form-group">
          <label for="courseId">Course:</label>
          <select class="form-control" name="courseId" id="courseId">

              <option disabled selected value="">------Select Course-----</option>
              <% for (Course course:courseList) {%>
              <option value="<%=course.getCourseId()%>"><%=course.getCourseName()%></option>
              <%

              }%>
          </select>
         </div>
     <div class="form-group">
          <label for="gender">Gender:</label>
          <select class="form-control" name="gender" id="gender">
                         <option disabled selected value="">------Select Gender------</option>

              <% for (Gender gender:genderValues) {%>
              <option value="<%=gender.name()%>"><%=gender.getName()%></option>
              <%
                  }%>
                         </select>
         </div>
    <div class="form-group">
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Enter phone number">
          </div>
      <button type="submit" class="btn btn-success">Submit</button>
    </form>
</div></div>

</body>
</html>
