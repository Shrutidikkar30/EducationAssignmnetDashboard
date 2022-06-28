package educationdashboard.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import educationdashboard.dao.RegisterFactDao;
import educationdashboard.dao.RegisterStudDao;
import educationdashboard.model.LoginFact;
import educationdashboard.model.LoginStud;

/**
 * Servlet implementation class LoginStudController
 */
@WebServlet("/LoginStudController")
public class LoginStudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginStudController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		LoginStud lf=new LoginStud(uname,pass);
		
		RegisterStudDao rsDao=new RegisterStudDao();
		
		
		boolean b=rsDao.loginValidate(lf);
		if(b) {
			
			response.sendRedirect("StudentDashboard.jsp");
		
		}
		else {
			HttpSession s=request.getSession();
			s.setAttribute("lerror", "Username already exists");
			response.sendRedirect("LoginStud.jsp");

		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
