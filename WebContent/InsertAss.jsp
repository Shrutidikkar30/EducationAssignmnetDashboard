<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
    <title>Assignment</title>
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="index.css">
<link rel="stylesheet" href="course.css">
<link rel="stylesheet" type="text/css" href="popupform.css">
<link rel="icon" type="image/x-icon" href="favicon.png">
</head>

<body>

    <input type="checkbox" id="nav-toggle">
    <div class="sidebar">
        <div class="sidebar-brand">
            <h2><span class=""></span><span>EDUCATION ASSIGNMENT</span></h2>
        </div>
        <div class="sidebar-menu">
            <ul>
                
                 <li>
                    <a href="FacultyDashboard.jsp" class="active"><span class="fa fa-graduation-cap"></span>
                    <span >Semester</span></a>
                </li>
                <li>
                    <a href="Faculty.jsp" ><span class="fa fa-book"></span>
                    <span>ODD 2021</span></a>
                </li>
                <li>
                    <a href="Faculty2.jsp" ><span class="fa fa-book"></span>
                    <span>EVEN 2021</span></a>
                </li>
                <li><a href="#" class="logout">
                     <i class="fas fa-sign-out-alt"></i>
                     <span class="nav-item">Log out</span>
                     </a></li>
            </ul>
        </div>
    </div>

    <div class="main-content">
        <header>
            <h2>
                <label for="nav-toggle">
                    <span class="fa fa-bars"></span>
                </label>DASHBOARD
            </h2>

            
                <div>
                    <h4>Faculty</h4>
                    <small>Gauri Garud</small>
                </div>
            
        </header>
        
        <div class="center">
         <input type="checkbox" id="show">
         <label for="show" class="show-btn1"><i class="fa fa-plus" aria-hidden="true"></i>Create</label>
         <div class="container">
            <label for="show" class="close-btn fas fa-times" title="close"></label>
            <div class="text">
               Create Assignment
            </div>
            <form action="AssignmentFactController" method="post">
            <div class="data">
                  <label>Course Code</label>
                  <input type="text" name="acode" required>
               </div>
               <div class="data">
                  <label>Title</label>
                  <input type="text" name="atitle" required>
               </div>
               <div class="data">
                <label>Aim</label>
                <input type="text" name="aaim" required>
             </div>
             
             <div class="data">
                <label>Points</label>
                <input type="number" name="apoints" value="0" required>
             </div>
             
             <%
          	HttpSession s=request.getSession();
          	if(!s.isNew()) {
          	Object o=s.getAttribute("coerror");
          	out.println("<h4 style=color:red>Course is not created</h4>");
          	}
          	session.invalidate();
          	%>
               <div class="btn">
                  <div class="inner"></div>
                  <button type="submit">Create Assignment</button>
               </div>
            </form>
         </div>
      </div>
      
<div id="assigncard">
<sql:setDataSource var="db" driver="oracle.jdbc.driver.OracleDriver"  
     url="jdbc:oracle:thin:@localhost:1521:XE"  
     user="system"  password="12345"/>  
<c:set var="cocode" value="${param.code}"/>
<sql:query dataSource="${db}" var="rs">  
SELECT * from assignment where corcode=?
<sql:param value="${cocode}"/>
</sql:query>  

<c:forEach var="table" items="${rs.rows}"> 
	<section class="card">
      <div class="info">
        <img src="logo.jpg"></img>
        
        <a href="StudentList.jsp"><i class="fa fa-users"></i></a><br>
      </div>
       <div class="info1">
        
        <p>Assignment No : <c:out value="${table.title}"/></p><br>
        <p>Aim : <c:out value="${table.aim}"/></p>
      </div>
</section>
</c:forEach> 
</div>
</div>
</body>

</html>