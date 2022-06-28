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
import educationdashboard.model.resetFact;

/**
 * Servlet implementation class resetController
 */
@WebServlet("/resetController")
public class resetFactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetFactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		resetFact rf=new resetFact(uname,pass);
		RegisterFactDao rfDao=new RegisterFactDao();
		boolean b=rfDao.resetPass(rf);
		if(b) {
			int i=rfDao.queryReset(pass, uname);
			if(i>=0) {
				response.sendRedirect("LoginFact.jsp");
			}
			
		}else {
			HttpSession s=request.getSession();
			s.setAttribute("error", "Wrong username");
			response.sendRedirect("resetFact.jsp");
			
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
