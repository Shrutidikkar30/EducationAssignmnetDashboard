package educationdashboard.model;



public class RegisterStud {
		private String fname,lname,uname,pass,cpass,phone,email,dob,address,dept,gender;
		private int enroll;
		public RegisterStud()
		{
			
		}
		public RegisterStud(String fname, String lname, String uname, String pass, String cpass, String phone, String email,
				String dob, String address, String dept, String gender, int enroll) {
			super();
			this.fname = fname;
			this.lname = lname;
			this.uname = uname;
			this.pass = pass;
			this.cpass = cpass;
			this.phone = phone;
			this.email = email;
			this.dob = dob;
			this.address = address;
			this.dept = dept;
			this.gender = gender;
			this.enroll = enroll;
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
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
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
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
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
		public int getEnroll() {
			return enroll;
		}
		public void setEnroll(int enroll) {
			this.enroll = enroll;
		}
}

