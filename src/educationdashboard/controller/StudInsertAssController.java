package educationdashboard.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/StudInsertAssController")
@MultipartConfig(fileSizeThreshold=1024 * 1024 * 10,
			maxFileSize=1024 * 1024 * 1000,
			maxRequestSize=1024 * 1024 * 1000)
public class StudInsertAssController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter out=null;
	Connection con=null;
	PreparedStatement ps=null;
	HttpSession session=null;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/plain/charset=UTF-8");
		try
		{
			/*create table studentassign(enroll varchar2(20),filename varchar(225),path varchar2(255),currentdate date)

			select * from studentassign;
			 */
			out=response.getWriter();
			session=request.getSession(false);
			String folderName="resources";
			String uploadPath=request.getServletContext().getRealPath("")+folderName;
			File dir=new File(uploadPath);
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			Part filePart=request.getPart("file");
			String enroll=request.getParameter("rollno");
			String fileName=filePart.getSubmittedFileName();
			String path=uploadPath+File.separator+fileName;
			Date currentdate=new Date(System.currentTimeMillis());
			System.out.println("FileName "+fileName);
			System.out.println("Path :"+uploadPath);
			InputStream is=filePart.getInputStream();
			Files.copy(is,Paths.get(uploadPath+File.separator+fileName),StandardCopyOption.REPLACE_EXISTING);
		
		
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");  
	            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345");
	            System.out.println("Connection Done");
				String sql="insert into studentassign(enroll,filename,path,currentdate) values(?,?,?,?)";
				ps=con.prepareStatement(sql);
				ps.setString(1, enroll);
				ps.setString(2, fileName);
				ps.setString(3, path);
				ps.setDate(4, currentdate);
				
				int status=ps.executeUpdate();
				if(status>=0) {
					response.sendRedirect("Student.jsp");
				}
			}
			catch(Exception e)
			{
				out.println("Exception :" +e);
				System.out.println("Exception " +e);
			}
		finally
		{
			try
			{
				if(ps!=null)
				{
					ps.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
			}catch(SQLException e)
			{
				out.println(e);
			}
		}
	}catch(IOException |ServletException e)
		{
			out.println("Exception"+e);
			System.out.println("Exception :"+e);
		}
	}
}
