package model;
//ログイン関係のDTO
public class Account {
	private String userId;
	private String pass;
	private String mail;
	private String job;
	private int age;
	
	public Account(String userId,String pass,String mail,String job,int age) {
		this.userId = userId;
		this.pass = pass;
		this.mail = mail;
		this.job = job;
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
