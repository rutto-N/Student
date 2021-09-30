<%@ page import="com.student.enums.Gender" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="com.student.enums.Grade" %>
<%@ page import="com.student.enums.Course" %><%--
  Created by IntelliJ IDEA.
  User: Tee
  Date: 17/09/2021
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">

</head>
<body>
<jsp:include page="nav-bar.jsp"></jsp:include>
<%List<Gender> genderValues = Arrays.asList(Gender.values());%>//
<%List<Grade> grades = Arrays.asList(Grade.values());%>
<%List<Course> courseList = Arrays.asList(Course.values());%>


<div class="container ">
<div class="col-md-4 col-md-offset-4">
  <h2>Add Student </h2>
  <form class="form-horizontal" action="./student/add" method="POST">
       <div class="form-group">
              <label for="name">Name:</label>
              <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
            </div>
        <div class="form-group">
              <label for="email">Email:</label>
              <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
            </div>
        <div class="form-group">
              <label for="dateOfBirth">Date Of Birth:</label>
              <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" placeholder="Enter date of birth">
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
            <label for="grade">Academic year:</label>
            <select class="form-control" name="grade" id="grade">
                           <option disabled selected value="">------Select Year-----</option>
                <% for (Grade grade:grades) {%>
                <option value="<%=grade.name()%>"><%=grade.getLabel()%></option>
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
