package model;

import dao.QuestionsetDAO;

public class WorkbookTimes {
	public int workbookTimes(Workbook wbi) {
		int time = 0;
		QuestionsetDAO i = new QuestionsetDAO();
		time = i.findByWorkbookTimes(wbi)+1;
		
		return time;
	}
}
