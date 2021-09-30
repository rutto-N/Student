<%@ page import="com.student.dao.UnitDao" %>
<%@ page import="com.student.models.Unit" %>
<%@ page import="java.util.List" %>
<%@ page import="com.student.dao.UnitDao" %>
<%@ page import="com.student.models.Unit" %><%--
  Created by IntelliJ IDEA.
  User: Tee
  Date: 19/09/2021
  Time: 09:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enrol</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
</head>
<body>

<jsp:include page="nav-bar.jsp"></jsp:include>

<% List<Unit> unitList =new UnitDao().getUnitsByGradeAndCourse((String) session.getAttribute("grade"),
        (String) session.getAttribute("course"));%>

<div class="row ">
    <div class="col-md-4 col-md-offset-4">
        <h2>Enrol unit </h2>
        <%
            String sessionMsg = (String) session.getAttribute("LOGIN_MSG");
            if (sessionMsg != null)
        %>

        <form class="form-horizontal" action="./enrol/add" method="POST">


            <div class="form-group">
                <label for="courseId">Courses:</label>
                <% for (Unit unit : unitList) { %>
                <div class="form-group">
                <input type="checkbox" id="courseId" name="courseId" value="<%=unit.getCourseId()%>">
                    <%=unit.getCourseName()%>
                </div>
                                       <% } %>

            </div>
            <button type="submit" class="btn btn-success">Enrol</button>
        </form>
    </div></div>



</body>
</html>
