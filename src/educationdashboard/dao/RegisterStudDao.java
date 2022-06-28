
package educationdashboard.dao;

import java.awt.Button;
import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


import educationdashboard.model.LoginStud;
import educationdashboard.model.RegisterStud;
import educationdashboard.model.*;


public class RegisterStudDao {
		Connection con=null;
		PreparedStatement pstate;
		ResultSet rs;
		Statement st;
		MyConnection mcon=new MyConnection();
		/*
		 create table registerStud
		(
 			fname varchar2(10),
 			lname varchar2(10),
 			uname varchar2(10) unique,
 			pass varchar2(10) ,
 			cpass varchar2(10),
 			phone varchar2(10),
 			email varchar2(20),
 			dob varchar2(10),
 			address varchar2(20),
 			enroll number,
 			dept varchar2(10),
 			gender varchar2(10)
		);  
		*/
		public int saveData(List<RegisterStud> lst)
		{
			int i=0;
			RegisterStud rs=null;
			con=mcon.conncetDb();
			try
			{
				Iterator<RegisterStud> itr=lst.iterator();
				while(itr.hasNext())
				{
					rs=itr.next();
					pstate=con.prepareStatement("insert into registerStud values(?,?,?,?,?,?,?,?,?,?,?,?)");
					pstate.setString(1, rs.getFname());
					pstate.setString(2, rs.getLname());
					pstate.setString(3, rs.getUname());
					pstate.setString(4, rs.getPass());
					pstate.setString(5, rs.getCpass());
					pstate.setString(6, rs.getPhone());
					pstate.setString(7, rs.getEmail());
					pstate.setString(8, rs.getDob());
					pstate.setString(9, rs.getAddress());
					pstate.setInt(10, rs.getEnroll());
					pstate.setString(11, rs.getDept());
					pstate.setString(12,rs.getGender());
					i=pstate.executeUpdate();
				}
			}catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				try {
					con.close();
				}catch(SQLException e)
				{
					System.out.println(e);
				}
			}
			return i;
		}
		public List<RegisterStud> getAllData()
		{
			List<RegisterStud> lst=new LinkedList<RegisterStud>();
			con=mcon.conncetDb();
			try {
				Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs=s.executeQuery("select * from registerStud");
				while(rs.next())
				{
					RegisterStud rst=new RegisterStud();
					rst.setFname(rs.getString(1));
					rst.setLname(rs.getString(2));
					rst.setUname(rs.getString(3));
					rst.setPass(rs.getString(4));
					rst.setCpass(rs.getString(5));
					rst.setPhone(rs.getString(6));
					rst.setEmail(rs.getString(7));
					rst.setDob(rs.getString(8));
					rst.setAddress(rs.getString(9));
					rst.setEnroll(rs.getInt(10));
					rst.setDept(rs.getString(11));
					rst.setGender(rs.getString(12));
					lst.add(rst);
				}
			}catch(Exception e)
			{
				System.out.println(e);
			}
			finally {
				try {
					con.close();
				}catch(SQLException e)
				{
					System.out.println(e);
				}
			}
			return lst;
		}
		public boolean validateUser(RegisterStud rst,String u)
		{
			con=mcon.conncetDb();
			List<RegisterStud> lst=getAllData();
			boolean b=false;
			for(RegisterStud r:lst)
			{
				if(r.getUname().equals(u))
				{
					b=true;
					break;
				}
			}
			return b;
		}
		public boolean validateEnrol(RegisterStud rst,String e) {
			con=mcon.conncetDb();
			List<RegisterStud> lst=getAllData();
			boolean b=false;
			for(RegisterStud r:lst)
			{
				if(r.getEnroll()==Integer.parseInt(e))
				{
					b=true;
					break;
				}
			}
			return b;
		}
		public boolean loginValidate(LoginStud ls) {
			boolean b=false;
			con=mcon.conncetDb();
			System.out.println("in dao");
			List<RegisterStud> lst=getAllData();
			for(RegisterStud r:lst)
			{
				
				if(r.getUname().equals(ls.getUsername()))
				{
					
					if(r.getPass().equals(ls.getPass()))
					{
						
						b=true;
						break;
					}
				}
			}
			
			return b;
		}

		public boolean resetPass(resetStud rf) {
			boolean b=false;
			con=mcon.conncetDb();
			List<RegisterStud> lst=getAllData();
			
			for(RegisterStud r:lst)
			{
				
				if(r.getUname().equals(rf.getUname()))
				{
					b=true;
					break;
				}
			}
			
			return b;
		}
		public int queryReset(String p,String u) {
			int i=-1;
			con=mcon.conncetDb();
			try {
			pstate=con.prepareStatement("update registerStud set pass=? where uname=?");
			pstate.setString(1,p);
			pstate.setString(2, u);
			i=pstate.executeUpdate();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return i;
		}

}
