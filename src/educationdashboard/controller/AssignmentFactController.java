package educationdashboard.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AssignmentFactController")
public class AssignmentFactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AssignmentFactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 PrintWriter out = response.getWriter();  
	        String acode=request.getParameter("acode");
	        String atitle = request.getParameter("atitle");  
	        String aaim = request.getParameter("aaim");  
	        String adueDate = request.getParameter("adueDate");
	        String apoints = request.getParameter("apoints");  
	        String auploadFile = request.getParameter("auploadFile");
	        /*
		create table assignment(
		corcode varchar2(20),
		title varchar2(10),
		aim varchar2(100),
		duedate varchar2(20),
		points varchar2(10), 
		uploadfile varchar2(100)
		);
		*/
	        
	        try
	        {  
	             //load the driver
	             Class.forName("oracle.jdbc.driver.OracleDriver");  
	             //create connection object
	              Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345");  
	             // create the prepared statement object
	              boolean b=true;
	              Statement st=con.createStatement();
	              ResultSet rs=st.executeQuery("select c_code from course");
	              while(rs.next()) {
	              if(rs.getString(1).equals(acode))
	              {
	            	  b=false;
	             	 break;
	              }
	              }
	              if(b) {
	            	  HttpSession s=request.getSession();
		      			s.setAttribute("coerror", "Course already created");
		      			response.sendRedirect("FacultyDashboard.jsp");
	              }
	              else {
	            	  PreparedStatement ps=con.prepareStatement("insert into assignment values(?,?,?,?,?,?)");  
		 	             ps.setString(1,acode);
		 	             ps.setString(2,atitle);  
		 	             ps.setString(3,aaim);  
		 	             ps.setString(4,adueDate);  
		 	             ps.setString(5,apoints);  
		 	             ps.setString(6,auploadFile);  
		 	             
		 	             int i = ps.executeUpdate();  
		 	             if(i>=0) {
		 	          	   response.sendRedirect("InsertAss.jsp");
		 	             }
	              }
	              
	        }
	        catch (Exception ex)
	        {
	             System.out.println(ex);	     
	             } 
	        
	        out.close();
	}

}
