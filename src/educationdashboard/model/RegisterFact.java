package educationdashboard.model;


public class RegisterFact {
	private String fname,lname,uname,pass,cpass,phno,email,dob,add,dept,gender;
	public RegisterFact() {}
	public RegisterFact(String fname, String lname, String uname, String pass, String cpass, String phno, String email,
			String dob, String add, String dept, String gender) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.pass = pass;
		this.cpass = cpass;
		this.phno = phno;
		this.email = email;
		this.dob = dob;
		this.add = add;
		this.dept = dept;
		this.gender = gender;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
}
