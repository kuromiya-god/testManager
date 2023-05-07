package model;
//新規登録関係のDTO
public class RegisterDTO {
	private String userId;
	private String pass;
	private String email;
	private String job;
	private int age;
	
	public RegisterDTO(String userId,String pass,String email,String job,int age) {
		this.userId = userId;
		this.pass = pass;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
