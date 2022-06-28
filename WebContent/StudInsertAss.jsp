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
<link rel="stylesheet" type="text/css" href="popup.css">
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
                    <a href="StudentDashboard.jsp"><span class="fa fa-graduation-cap"></span>
                    <span>Semester</span></a>
                </li>
                 <li>
                    <a href="Student.jsp"><span class="fa fa-book"></span>
                    <span>ODD 2021</span></a>
                </li>
                <li>
                    <a href="student2.jsp" class="active"><span class="fa fa-book"></span>
                    <span>EVEN 2021</span></a>
                </li>
                <li><a href="LoginStud.jsp" class="logout">
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
        
      </div>
       <div class="info1">
        
        <p>Assignment No : <c:out value="${table.title}"/></p><br>
        <p>Aim : <c:out value="${table.aim}"/></p>
      </div>
       <form action="StudInsertAssController" method="post" enctype="multipart/form-data">
      <div class="upload">
      		    <div class="data">
      		    <input type="text" name="rollno" placeholder="Enter your Enrollment Number" required>
                <input class="file1" type="file" required name="file" accept="application/pdf,application/vnd.ms-excel" ></input>
 				<a href="#"><button type="submit" class="button button1">Submit</button></a>
         </div>
      </div>
      </form>
</section>
</c:forEach> 
</div>  
</div>
</body>

</html>