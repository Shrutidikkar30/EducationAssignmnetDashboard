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

/**
 * Servlet implementation class FacultyController
 */
@WebServlet("/FacultyController")
public class FacultyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String sem = request.getParameter("semester");  
        String cname = request.getParameter("coursename");  
        String ccode = request.getParameter("coursecode");
        /*
          create table course(
          sem varchar2(20),
          c_name varchar2(20),
          c_code varchar2(20)
          );*/
        
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
             if(rs.getString(1).equals(ccode))
             {
            	HttpSession s=request.getSession();
     			s.setAttribute("cerror", "Course already created");
     			response.sendRedirect("FacultyDashboard.jsp");
     			b=false;
            	 break;
             }
             }
             if(b) {
             PreparedStatement ps=con.prepareStatement("insert into course values(?,?,?)");  
             
             ps.setString(1,sem);  
             ps.setString(2,cname);  
             ps.setString(3,ccode);  
             
             int i = ps.executeUpdate();  
             if(i>=0) {
          	   response.sendRedirect("FacultyDashboard.jsp");
             }
             }
        }
        catch (Exception ex)
        {
             ex.printStackTrace();
        }  
        out.close();  
	}

}
