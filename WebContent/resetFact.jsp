<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Reset Password</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<link href="css/style.css" rel="stylesheet">
	<script type="text/javascript" src="resetFact.js"></script>
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="icon" type="image/x-icon" href="favicon.png">
</head>
<body>
	<div class="container infinity-container">
		<div class="row">
			<div class="col-md-1 infinity-left-space"></div>

			<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12 text-center infinity-form">
				<div class="text-center mb-3 mt-5">
					<img src="forgotpassword.png" width="200px">
				</div>
				<div class="reset-form d-block">
				    <form action="resetController" method="post" onsubmit="return validateReset(this)" >
				    	<h4>Reset Your password</h4>
				        <p class="mb-3" style="color: #777">
				            Please enter your username and new password
				        </p>
				        <div class="form-input">
							<span><i class="fa fa-user"></i></span>
							<input type="text" name="uname" placeholder="Username" tabindex="10"required>
							<span style="color: red" id="unameErr"></span>
						</div>
						<div class="form-input">
							<span><i class="fa fa-envelope"></i></span>
							<input type="password" name="pass" placeholder="Password" tabindex="10"required>
							<span style="color: red" id="passErr"></span>
						</div>
						<%
          				HttpSession s=request.getSession();
						
          				if(!s.isNew()) {
          					Object o=session.getAttribute("error");
          					out.println("<h4 style=color:red>Enter correct username </h4>");
          				}
          				session.invalidate();
          				%>
				        <div class="mb-3"> 
							<button type="submit" class="btn">Reset Password</button>
						</div>
				    </form>
				</div>
				
			<div class="col-md-1 infinity-right-space"></div>
		</div>
	</div>

	

</body>
</html>
