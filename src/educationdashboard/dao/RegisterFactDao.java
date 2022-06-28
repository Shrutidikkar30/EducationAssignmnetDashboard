package educationdashboard.dao;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import educationdashboard.model.LoginFact;
import educationdashboard.model.RegisterFact;
import educationdashboard.model.resetFact;
public class RegisterFactDao {
	Connection con=null;
	PreparedStatement pstmt;
	MyConnection mcon=new MyConnection();
	/*
	 create table registerFact(
		fname varchar(20) ,
		lname varchar(20),
		uname varchar(20) unique,
		pass varchar(20) ,
		cpass varchar(20),
		phno varchar(20),
		email varchar(20),
		dob varchar(10),
		addr varchar(20),
		dept varchar(20),
		gender varchar(5)
	);*/

public int saveData(List<RegisterFact> lst) {
	int i=0;
	RegisterFact rf=null;
	con=mcon.conncetDb();
	try {
		Iterator<RegisterFact> itr=lst.iterator();
		while(itr.hasNext()) {
			rf=itr.next();
			pstmt = con.prepareStatement("insert into registerFact values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,rf.getFname());
			pstmt.setString(2,rf.getLname());
			pstmt.setString(3,rf.getUname());
			pstmt.setString(4,rf.getPass());
			pstmt.setString(5,rf.getCpass());
			pstmt.setString(6,rf.getPhno());
			pstmt.setString(7,rf.getEmail());
			pstmt.setString(8,rf.getDob());
			pstmt.setString(9,rf.getAdd());
			pstmt.setString(10,rf.getDept());
			pstmt.setString(11,rf.getGender());
			i=pstmt.executeUpdate();
		}
	}
	catch(Exception e) {
		System.out.println(e);
		
	}
	finally {
		try {
			con.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	return i;
}
public List<RegisterFact> getAllData()
{
	List<RegisterFact> lst=new LinkedList<RegisterFact>();
	con=mcon.conncetDb();
	try
	{
	Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=s.executeQuery("select * from registerFact");
		while(rs.next())
		{
			RegisterFact rf=new RegisterFact();
			rf.setFname(rs.getString(1));
			rf.setLname(rs.getString(2));
			rf.setUname(rs.getString(3));
			rf.setPass(rs.getString(4));
			rf.setCpass(rs.getString(5));
			rf.setPhno(rs.getString(6));
			rf.setEmail(rs.getString(7));
			rf.setDob(rs.getString(8));
			rf.setAdd(rs.getString(9));
			rf.setDept(rs.getString(10));
			rf.setGender(rs.getString(11));
			lst.add(rf);
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	finally {
		try {
			con.close();
		}catch(SQLException e) {
			
		}
	}
	return lst;
}
public boolean validateUser(RegisterFact rf,String u)
{
	con=mcon.conncetDb();
	List<RegisterFact> lst=getAllData();
	boolean b=false;
	for(RegisterFact r:lst)
	{
		if(r.getUname().equals(u))
		{		//System.out.println("in");
				b=true;
				break;
		}
		
		}
	
	return b;
}
public boolean loginValidate(LoginFact lf) {
	boolean b=false;
	con=mcon.conncetDb();
	List<RegisterFact> lst=getAllData();
	for(RegisterFact r:lst)
	{
		if(r.getUname().equals(lf.getUsername()))
		{
			if(r.getPass().equals(lf.getPass()))
			{
				b=true;
				break;
			}
		}
	}
	
	return b;
}

public boolean resetPass(resetFact rf) {
	boolean b=false;
	con=mcon.conncetDb();
	List<RegisterFact> lst=getAllData();
	for(RegisterFact r:lst)
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
	pstmt=con.prepareStatement("update registerFact set pass=? where uname=?");
	pstmt.setString(1,p);
	pstmt.setString(2, u);
	i=pstmt.executeUpdate();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return i;
}
}

