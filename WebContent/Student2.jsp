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
    <title>Student</title>
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
     <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="index.css">
<link rel="stylesheet" href="popupform.css">
<link rel="stylesheet" href="course.css">
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
                    <a href="StudentDashboard.jsp" ><span class="fa fa-graduation-cap"></span>
                    <span >Semester</span></a>
                </li>
                <li>
                    <a href="Student.jsp" ><span class="fa fa-book"></span>
                    <span>ODD 2021</span></a>
                </li>
                <li>
                    <a href="Student2.jsp" class="active"><span class="fa fa-book"></span>
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
                    <h4>Student</h4>
                    <small>Shruti Dikkar</small>
                </div>
            
        </header>
        
        
       
<section id=courseid>
 <sql:setDataSource var="db" driver="oracle.jdbc.driver.OracleDriver"  
     url="jdbc:oracle:thin:@localhost:1521:XE"  
     user="system"  password="12345"/>  
     <c:set var="semname" value="EVEN 2021"/>
<sql:query dataSource="${db}" var="rs">  
SELECT * from course,studentCourse where c_code=coursecode AND sem=?
<sql:param value="${semname}"/>
</sql:query>  

<c:forEach var="table" items="${rs.rows}">  
  <div class="coursecard">
  	<section id=course>
  	
      <c:url value="StudInsertAss.jsp" var="StudAssUrl">
  	<c:param name="code" value="${table.c_code}"/>
  	</c:url>
      <a href="${StudAssUrl}">
        <div class="course">
        <div class="course-info">
            <h6><c:out value="${table.sem}"/></h6>
            <h2>Gauri Garud</h2>  
        </div>
        <div class="course-progress">
        <h6>Course Code-<c:out value="${table.c_code}"/></h6>
            <h2><c:out value="${table.c_name}"/></h2>    
        </div>
    </div>
    </a>
    </section>
    </div>
</c:forEach>     
</section>


 <div class="center">
         <input type="checkbox" id="show">
         
         <div class="container">
            <label for="show" class="close-btn fas fa-times" title="close"></label>
            <div class="text">
               Join Class
            </div>
            <form action="StudentController" method="post">
            <div class="data">
                  <label>Enrollment Number</label>
                  <input type="number" name="enrol" required>
               </div>
               <div class="data">
                  <label>Course Code</label>
                  <input type="text" name="ccode" required>
               </div>
            </br>
            <%
          	HttpSession s=request.getSession();
          	if(!s.isNew()) {
          	Object o=s.getAttribute("csrror");
          	out.println("<h4 style=color:red>Course not created</h4>");
          	}
          	session.invalidate();
          	%>
               <div class="btn">
                  <div class="inner"></div>
                  <button type="submit"><a href="#">Join Class</a></button>
               </div>
            </form>
         </div>
      </div>
      <label for="show" class="show-btn"><img src="add.png" height="60" width="60" /></label>

</body>
</html>