package model;

import java.util.ArrayList;

import dao.QuesListSetDAO;

public class Searchs {
	public ArrayList<Workbook> findByWorkbookSearch(String search){
		QuesListSetDAO l = new QuesListSetDAO();
		ArrayList<Workbook> workbook = l.findByWorkbookSearch(search);
		
		
		return workbook;
	}
	
	public ArrayList<Workbook> findByWorkbookSearchagain(String search){
		QuesListSetDAO l = new QuesListSetDAO();
		ArrayList<Workbook> workbook = l.findByWorkbookSearchagains(search);
		
		
		
		
		return workbook;
	}
}
