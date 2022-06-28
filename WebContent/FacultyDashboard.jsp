<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %> 
<%@page import="educationdashboard.model.LoginFact"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
    <title>Faculty</title>
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
                    <a href="FacultyDashboard.jsp" class="active"><span class="fa fa-graduation-cap"></span>
                    <span>Semester</span></a>
                </li>
                <%String str=request.getParameter("factuname");%>
                <%System.out.println(str); %>
                <c:set var="factu" value="${str}"/>
                 <c:url value="Faculty.jsp" var="facultyPage">
  	             <c:param name="user" value="${factu}"/>
  	             </c:url>
                <li>
					
                    <a href="${facultyPage}"><span class="fa fa-book"></span>
                    <span>ODD 2021</span></a>
                    
                </li>
                <li>
                    <a href="Faculty2.jsp" ><span class="fa fa-book"></span>
                    <span>EVEN 2021</span></a>
                </li>
                <li><a href="LoginFact.jsp" class="logout">
                     <i class="fas fa-sign-out-alt"></i>
                     <span class="nav-item">Log out</span>
                     </a></li>
            </ul>
        </div>
    </div>
    <%
          	HttpSession s=request.getSession();
          	if(!s.isNew()) {
          		s.getAttribute("cerror");
          	}
          	session.invalidate();
          	%>
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
        </div>
        
</body>
</html>