package educationdashboard.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import educationdashboard.dao.RegisterFactDao;
import educationdashboard.model.RegisterFact;

@WebServlet("/RegisterFactController")
public class RegisterFactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterFactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setAttribute("errorMessage","Username already Exist");
		PrintWriter out=response.getWriter();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("username");
		String pass=request.getParameter("pass");
		String cpass=request.getParameter("cpass");
		String phno=request.getParameter("phno");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String add=request.getParameter("add");
		String dept=request.getParameter("dept");
		String gender=request.getParameter("gender");
		RegisterFact rf=new RegisterFact();
		RegisterFactDao rfDao=new RegisterFactDao();
		
		
		boolean b=rfDao.validateUser(rf,uname);
		if(b) {
			HttpSession s=request.getSession();
			
			s.setAttribute("uerror", "Username already exists");
			response.sendRedirect("RegisterFaculty.jsp");
			
		}
		else {
			RegisterFact rfact=new RegisterFact(fname,lname,uname,pass,cpass,phno,email,dob,add,dept,gender);
			List<RegisterFact> lst=new LinkedList<RegisterFact>();
			lst.add(rfact);
			int i=rfDao.saveData(lst);
			if(i>=0) {
				out.println("<script type=\"text/javascript\">alert('Registered Successfully..!!');</script>");
				
				response.sendRedirect("LoginFact.jsp");
				
			}
			else {
				response.sendRedirect("");
			}
		}
		
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
