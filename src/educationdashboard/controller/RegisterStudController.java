package educationdashboard.controller;

import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import educationdashboard.model.RegisterStud;
import educationdashboard.dao.RegisterStudDao;


/**
 * Servlet implementation class RegisterStudController
 */
@WebServlet("/RegisterStudController")
public class RegisterStudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterStudController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("username");
		String pass=request.getParameter("pass");
		String cpass=request.getParameter("cpass");
		String phone=request.getParameter("phno");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String add=request.getParameter("add");
		String enroll=request.getParameter("eno");
		String dept=request.getParameter("dept");
		String gen=request.getParameter("gender");
		
		RegisterStud rstud=new RegisterStud();
		RegisterStudDao rdao=new RegisterStudDao();
		boolean b=rdao.validateUser(rstud, uname);
		boolean bo=rdao.validateEnrol(rstud, enroll);
		if(b)
		{
			HttpSession s=request.getSession();
			s.setAttribute("error", "Username already exists");
			response.sendRedirect("RegisterStudent.jsp");
		}
		else if(bo) {
			HttpSession ss=request.getSession();
			ss.setAttribute("rolerror", "Enrollment already exists");
			response.sendRedirect("RegisterStudent.jsp");
		}
		else
		{
			RegisterStud rs=new RegisterStud(fname, lname, uname, pass, cpass, phone, email, dob, add, dept, gen, Integer.parseInt(enroll));
			List<RegisterStud> lst=new LinkedList<RegisterStud>();
			lst.add(rs);
			int i=rdao.saveData(lst);
			if(i>=0)
			{
				response.sendRedirect("LoginStud.jsp");
			}
			else
			{
				response.sendRedirect("");
			}
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
