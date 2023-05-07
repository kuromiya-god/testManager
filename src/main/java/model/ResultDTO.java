package model;

import java.util.ArrayList;

public class ResultDTO {
	private String user_id;
	private int workbook_id;
	private String title;
	private String question_id;
	private String result;
	private float resultpercentage;
	private int workbookTime;
	private ArrayList<String> question;
	private ArrayList<String> results;
	
	public ResultDTO(String title,String question_id,String result,	float resultpercentage,int workbookTime) {
		this.title = title;
		this.question_id = question_id;
		this.result = result;
		this.resultpercentage = resultpercentage;
		this.workbookTime = workbookTime;
	}
	
	public ResultDTO(int workbook_id,String title,String question_id,String result,float resultpercentage,int workbookTime) {
		this.workbook_id = workbook_id;
		this.title = title;
		this.question_id = question_id;
		this.result = result;
		this.resultpercentage = resultpercentage;
		this.workbookTime = workbookTime;
	}
	
	public ResultDTO(int workbook_id,String title,ArrayList<String> question,ArrayList<String> results,float resultpercentage,int workbookTime) {
		this.workbook_id = workbook_id;
		this.title = title;
		this.question = question;
		this.results = results;
		this.resultpercentage = resultpercentage;
		this.workbookTime = workbookTime;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getWorkbook_id() {
		return workbook_id;
	}

	public void setWorkbook_id(int workbook_id) {
		this.workbook_id = workbook_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public float getResultpercentage() {
		return resultpercentage;
	}

	public void setResultpercentage(float resultpercentage) {
		this.resultpercentage = resultpercentage;
	}

	public int getWorkbookTime() {
		return workbookTime;
	}

	public void setWorkbookTime(int workbookTime) {
		this.workbookTime = workbookTime;
	}

	public ArrayList<String> getQuestion() {
		return question;
	}

	public void setQuestion(ArrayList<String> question) {
		this.question = question;
	}

	public ArrayList<String> getResults() {
		return results;
	}

	public void setResults(ArrayList<String> results) {
		this.results = results;
	}
	
	
}
