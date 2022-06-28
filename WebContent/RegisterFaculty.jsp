<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="RegisterStud.js"></script>
    <link rel="stylesheet" href="Registration.css">
    <link rel="icon" type="image/x-icon" href="favicon.png">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
   <title>Registration</title>
<body>
	
  <div class="container">
    <div class="con1">
    <div class="title">Register Faculty</div>
    <div class="content">
      <form action="RegisterFactController" method="post" onsubmit="return validates(this)">
        <div class="user-details">
          <div class="input-box">
            <span class="details">First Name</span>
            <input type="text" placeholder="Enter your First name" name="fname" required>
            <span style="color: red" id="fnameErr"></span>
          </div>
          <div class="input-box">
            <span class="details">Last Name</span>
            <input type="text" placeholder="Enter your  Last name" name="lname" required>
            <span style="color: red" id="lnameErr"></span>
          </div>
          <div class="input-box">
            <span class="details">Username</span>
            <input type="text" placeholder="Enter your username" name="username" required>
          	<span style="color: red" id="unameErr"></span>
          	<span style="color: red" id="exitErr"></span>
          	<%
          	HttpSession s=request.getSession();
          	if(!s.isNew()) {
          
          	Object o=s.getAttribute("uerror");
          	out.println("<h4 style=color:red>Username already exists</h4>");
          	}
          	session.invalidate();
          	%>
          	
          </div>
          <div class="input-box">
            <span class="details">Password</span>
            <input type="password" placeholder="Enter your password" name="pass" min="8" max="10" required>
         	<span style="color: red" id="passErr"></span>
         	<span style="color: red" id="passErr1"></span>
         	<span style="color: red" id="passErr2"></span>
          </div>
          <div class="input-box">
            <span class="details">Confirm Password</span>
            <input type="password" placeholder="Confirm your password" name="cpass" min="8" max="10" required>
          	<span style="color: red" id="cpassErr"></span>
          	<span style="color: red" id="Err"></span>
          </div>
          <div class="input-box">
            <span class="details">Phone Number</span>
            <input type="tel" placeholder="Enter your number" name="phno" pattern="^[0-9]*$" required>
         	<span style="color: red" id="telErr"></span>
          </div>
          <div class="input-box">
            <span class="details">Email</span>
            <input type="email" placeholder="Enter your email" name="email" required>
          </div>
          <div class="input-box">
            <span class="details">Date Of Birth</span>
            <input type="date" placeholder="Enter DOB" name="dob" required>
            <span style="color: red" id="dErr"></span>
          </div>
          <div class="input-box">
            <span class="details">Address</span>
            <input type="text" placeholder="Enter your Address" name="add" required>
          </div> 
          <div class="input-box">
            <span class="details">Department</span>   
            <select name="dept">
                <option value="department">Select Department</option>
                <option value="Computer">Computer</option>
                <option value="IT">IT</option>
                <option value="Electrical">Electrical</option>
                <option value="Mechanical">Mechanical</option>
                <option value="Civil">Civil</option>
                <option value="Electronics and Telecommunication">Electronics and Telecommunication</option>
            </select>
          </div>
        </div>

        <div class="gender-details">
            <input type="radio" name="gender" id="dot-1">
            <input type="radio" name="gender" id="dot-2">
            <input type="radio" name="gender" id="dot-3">
            <span class="gender-title">Gender</span>
            <div class="category">
              <label for="dot-1">
              <span class="dot one"></span>
              <span class="gender">Male</span>
            </label>
            <label for="dot-2">
              <span class="dot two"></span>
              <span class="gender">Female</span>
            </label>
            <label for="dot-3">
              <span class="dot three"></span>
              <span class="gender">Prefer not to say</span>
              </label>
            </div>
          </div>
        
        
          <button type="submit">Register</button>
      </form>
    </div>
  </div>
  </div>
  
</body>

</html>
