package educationdashboard.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import educationdashboard.dao.MyConnection;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String code=request.getParameter("ccode");
		String enroll=request.getParameter("enrol");
		MyConnection mcon=new MyConnection();
		Connection con=mcon.conncetDb();
		boolean b=true;
		try {
			PreparedStatement pstmt;
			pstmt=con.prepareStatement("select c_code from course");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(code)) {
					b=false;
					break;
				}
			}
			if(b) {
				HttpSession s=request.getSession();
     			s.setAttribute("csrror", "Course not created");
     			response.sendRedirect("Student.jsp");
			}
			else {
				PreparedStatement pst=con.prepareStatement("select * from studentCourse where coursecode=?");
				pst.setString(1,code);
				ResultSet rst=pst.executeQuery();
				if(!rst.next()) {
				PreparedStatement ps=con.prepareStatement("insert into studentCourse values(?,?)");  
				  
	               ps.setString(1,enroll);  
	               ps.setString(2,code);
	               int i = ps.executeUpdate();  
	               if(i>=0)
	               {
	            	   //System.out.println("in the if statement");
	            	   request.getRequestDispatcher("Student.jsp").forward(request, response);
	               }
				}
				else {
					response.sendRedirect("Student.jsp");
				}
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
