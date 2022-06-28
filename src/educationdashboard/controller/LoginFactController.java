package educationdashboard.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import educationdashboard.dao.RegisterFactDao;
import educationdashboard.model.LoginFact;
import educationdashboard.model.RegisterFact;

/**
 * Servlet implementation class LoginFactController
 */
@WebServlet("/LoginFactController")
public class LoginFactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("factuname");
		String pass=request.getParameter("factpass");
		LoginFact lf=new LoginFact(uname,pass);
		
		RegisterFactDao rfDao=new RegisterFactDao();
		
		
		boolean b=rfDao.loginValidate(lf);
		if(b) {
			
			
			//response.sendRedirect("FacultyDashboard.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("FacultyDashboard.jsp");
			rd.forward(request, response);
		
		}
		else {
			HttpSession s=request.getSession();
			s.setAttribute("error", "Username already exists");
			response.sendRedirect("LoginFact.jsp");

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
