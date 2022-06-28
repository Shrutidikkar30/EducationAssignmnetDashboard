<%@page import="educationdashboard.dao.MyConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

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
<link rel="stylesheet" type="text/css" href="list.css">
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
                    <a href="facultyDashboard.jsp" ><span class="fa fa-graduation-cap"></span>
                    <span>Semester</span></a>
                </li>
                 <li>
                    <a href="faculty.jsp"><span class="fa fa-book"></span>
                    <span>EVEN 2021</span></a>
                </li>
                <li>
                    <a href="faculty2.jsp" class="active"><span class="fa fa-book"></span>
                    <span>ODD 2021</span></a>
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
          <section class="main">
      <section class="attendance">
      	<div class="attendance-list">
      	 <h1>Student List</h1>
<%
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
%>
<table border="2">
<tr class="head">
<th>Enrollment No</th><th>File Name</th><th>File Path</th><th>Uploaded Date</th><th>File Status</th>
</tr>
<%
	MyConnection mcon=new MyConnection();
	con=mcon.conncetDb();
	String sql="select * from studentassign";
	ps=con.prepareStatement(sql);
	rs=ps.executeQuery();
	while(rs.next()){
		
%>
<tr class="tbody">
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(3)%></td>
<td><%=rs.getDate(4)%></td>
<td><a href="E:\Education Assignment Dashboard\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\FinalProject\resources<%=rs.getString(1)%>">Submitted</a></td>
</tr>
<%}%>
</table><br>
<a href="FacultyDashboard.jsp"><i style='font-size:24px' class='far'>&#xf359;</i></a>
</div>

</section>

</section>

</div>
</body>

</html>