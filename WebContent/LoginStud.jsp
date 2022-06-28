<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Student Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<link href="css/style.css" rel="stylesheet">
	<script type="text/javascript" src="LoginStud.js"></script>
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<link rel="icon" type="image/x-icon" href="favicon.png">
</head>
<body>
	<div class="container infinity-container">
		<div class="row">
			<div class="col-md-1 infinity-left-space"></div>
			
			<!-- FORM BEGIN -->
			<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12 text-center infinity-form">
				<!-- Company Logo -->
				<div class="text-center mb-3 mt-5">
					<img src="logo.jpg" width="100px">
				</div>
				<div class="text-center mb-4">
					<h4>Student Login</h4>
				</div>
				<!-- Form -->
				<form action="LoginStudController" method="post" onSubmit="return validate(this)">
					<!-- Input Box -->
					<div class="form-input">
						<span><i class="fa fa-user"></i></span>
						<input type="text" name="username" placeholder="Username"  required>
						 <span style="color:red" id="unameErr"></span>
					</div>
					<div class="form-input">
						<span><i class="fa fa-lock"></i></span>
						<input type="password" name="password" placeholder="Password"  required>
						 <span style="color:red" id="pErr"></span>
					</div>
					<%
          				HttpSession s=request.getSession();
						
          				if(!s.isNew()) {
          					Object o=session.getAttribute("lerror");
          					out.println("<h4 style=color:red>Enter correct username and password</h4>");
          				}
          				session.invalidate();
          				%>
					<div class="row mb-3">
						<!-- Remember Box -->
			            <div class="col-auto d-flex align-items-center">
			                <div class="custom-control custom-checkbox">
			                    <input type="checkbox" class="custom-control-input" id="cb1">
			                   	<label class="custom-control-label" for="cb1">Remember me</label>
			                </div>
				        </div>
			   	    </div>
			   	    <div class="text-right ">
		                <a href="resetStud.jsp" class="forget-link">Forgot password?</a>
		            </div>
			   	    <!-- Login Button -->
		            <div class="mb-3"> 
						<a href="student.jsp"><button type="submit" class="btn btn-block">Login</button></a>
					</div>
					
					<div class="text-center mb-5" style="color: #777;">Don't have an account? 
						<a class="" href="RegisterStudent.jsp">Register here</a>
			       	</div>
				</form>
			</div>
			<!-- FORM END -->
		</div>
	</div>
		<div class="card-body">
                            <a href="LoginStud.jsp"><div class="customer">
                                <div class="info">
                                    <img src="logo.jpg" alt="">
                                    <div>
                                        <h4>Student </h4>
                                     </div>
                               
                                </div>
                            </div>  </a><br>
                            <a href="LoginFact.jsp">
                            <div class="customer">
                                <div class="info">
                                    <img src="logo.jpg" alt=" ">
                                    <div>
                                        <h4>Faculty</h4>
                                     </div>
                                </div>
                            </div></a>
                        </div>
</body>
</html>
