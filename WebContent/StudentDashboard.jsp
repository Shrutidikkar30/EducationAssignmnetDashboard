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
                    <a href="StudentDashboard.jsp" class="active"><span class="fa fa-graduation-cap"></span>
                    <span>Semester</span></a>
                </li>
                <li>
                    <a href="Student.jsp"><span class="fa fa-book"></span>
                    <span>ODD 2021</span></a>
                </li>
                <li>
                    <a href="Student2.jsp" ><span class="fa fa-book"></span>
                    <span>EVEN 2021</span></a>
                </li>
                <li><a href="LoginStud.jsp" class="logout">
                     <i class="fas fa-sign-out-alt"></i>
                     <span class="nav-item">Log out</span>
                     </a></li>
            </ul>
        </div>
    </div>
<%
          	HttpSession s=request.getSession();
          	if(!s.isNew()) {
          	Object o=s.getAttribute("csrror");
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
                    <h4>Student</h4>
                    <small>Shruti Dikkar</small>
                </div>
        </header>
     
        
    </div>
</body>

</html>