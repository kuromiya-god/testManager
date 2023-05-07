package model;

import java.util.ArrayList;

import dao.ResultFindDAO;

public class ResultFind {
	
	public ArrayList<ArrayList<String>> ResultFindResultList(String userid){
		ArrayList<ArrayList<String>> ra = new ArrayList<>();
		ResultFindDAO i = new ResultFindDAO();
		ra = i.ResultFindResultListDAO(userid);
		
		return ra;
	}
	
	public ArrayList<ArrayList<String>> ResultFindQuesList(String userid){
		ArrayList<ArrayList<String>> ra = new ArrayList<>();
		ResultFindDAO i = new ResultFindDAO();
		ra = i.ResultFindQuesListDAO(userid);
		
		return ra;
	}
	
	public ArrayList<Float> ResultFindPercentage(String userid){
		ArrayList<Float> ra = new ArrayList<>();
		ResultFindDAO i = new ResultFindDAO();
		ra = i.ResultFindPercentageDAO(userid);
		
		return ra;
	}
	
	public ArrayList<String> ResultFindTitle(String userid){
		ArrayList<String> ra = new ArrayList<>();
		ResultFindDAO i = new ResultFindDAO();
		ra = i.ResultFindTitleDAO(userid);
		
		return ra;
	}
	
	public ArrayList<Integer> ResultFindTime(String userid){
		ArrayList<Integer> ra = new ArrayList<>();
		ResultFindDAO i = new ResultFindDAO();
		ra = i.ResultFindTimeDAO(userid);
		
		return ra;
	}
	
	public ArrayList<ArrayList<String>> ResultFindResultListMaked(String userid,String title){
		ArrayList<ArrayList<String>> ra = new ArrayList<>();
		ResultFindDAO i = new ResultFindDAO();
		ra = i.ResultFindResultListMakesDAO(userid,title);
		
		return ra;
	}
	
	public ArrayList<ArrayList<String>> ResultFindQuesListMaked(String userid,String title){
		ArrayList<ArrayList<String>> ra = new ArrayList<>();
		ResultFindDAO i = new ResultFindDAO();
		ra = i.ResultFindQuesListMakesDAO(userid,title);
		
		return ra;
	}
	
	public ArrayList<Float> ResultFindPercentageMaked(String userid,String title){
		ArrayList<Float> ra = new ArrayList<>();
		ResultFindDAO i = new ResultFindDAO();
		ra = i.ResultFindPercentageMakesDAO(userid,title);
		
		return ra;
	}
	
	public ArrayList<String> ResultFindTitleMaked(String userid,String title){
		ArrayList<String> ra = new ArrayList<>();
		ResultFindDAO i = new ResultFindDAO();
		ra = i.ResultFindTitleMakesDAO(userid,title);
		
		return ra;
	}
	
	public ArrayList<Integer> ResultFindTimeMaked(String userid,String title){
		ArrayList<Integer> ra = new ArrayList<>();
		ResultFindDAO i = new ResultFindDAO();
		ra = i.ResultFindTimeMakesDAO(userid,title);
		
		return ra;
	}
	
	public ArrayList<String> ResultFindUser(String userid,String title){
		ArrayList<String> ra = new ArrayList<>();
		ResultFindDAO i = new ResultFindDAO();
		ra = i.ResultFindUserMakesDAO(userid,title);
		
		return ra;
	}
}
