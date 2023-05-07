package model;
//クイズ全般のDTO
public class Ques {
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private int answer;
	private String explanation;
	private int id;
	private boolean checkAns;
	private int result;
	private String user_id;
	
	public Ques(String question,String option1,String option2,String option3,String option4,int answer,String explanation,int id) {
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.explanation = explanation;
		this.id = id;
	}
	
	public Ques(String question,String option1,String option2,String option3,String option4,int answer,String explanation,String user_id) {
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.explanation = explanation;
		this.setUser_id(user_id);
	}
	
	public Ques(String question,String option1,String option2,String option3,String option4,int answer,String explanation,boolean checkAns,int result ) {
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.explanation = explanation;
		this.checkAns = checkAns;
		this.result = result;
	}
	
	public Ques(String question,int id) {
		this.question = question;
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCheckAns() {
		return checkAns;
	}

	public void setCheckAns(boolean checkAns) {
		this.checkAns = checkAns;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	
	
	
}
