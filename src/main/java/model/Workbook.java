package model;

public class Workbook {
	String user_id;
	String title;
	String genre;
	String list;
	String author_name;
	int workbook_id;
	int limit;
	boolean random;
	boolean stealth;
	
	public Workbook(String user_id,String title,String genre,String list,String author_name,int workbook_id,boolean random,int limit) {
		this.user_id = user_id;
		this.title = title;
		this.genre = genre;
		this.list = list;
		this.author_name = author_name;
		this.workbook_id = workbook_id;
		this.random = random;
		this.limit = limit;
	}
	
	public Workbook(String user_id,String title,String genre,String list,String author_name,int workbook_id) {
		this.user_id = user_id;
		this.title = title;
		this.genre = genre;
		this.list = list;
		this.author_name = author_name;
		this.workbook_id = workbook_id;
	}
	
	public Workbook(String user_id,String title,String genre,String list,String author_name) {
		this.user_id = user_id;
		this.title = title;
		this.genre = genre;
		this.list = list;
		this.author_name = author_name;
	}
	
	public Workbook(String title,String genre,String list,String author_name,int workbook_id) {
		this.title = title;
		this.genre = genre;
		this.list = list;
		this.author_name = author_name;
		this.workbook_id = workbook_id;
	}
	
	public Workbook(String title,String genre,String list,String author_name) {
		this.title = title;
		this.genre = genre;
		this.list = list;
		this.author_name = author_name;
	}
	
	public Workbook(String title,String genre,String list,String author_name,boolean random,boolean stealth,int limit) {
		this.title = title;
		this.genre = genre;
		this.list = list;
		this.author_name = author_name;
		this.random = random;
		this.stealth = stealth;
		this.limit = limit;
	}
	
	public Workbook(String user_id,int workbook_id) {
		this.user_id = user_id;
		this.workbook_id = workbook_id;
	}
	
	public Workbook(String title,String genre,String list,String author_name,int workbook_id,int limit,boolean random) {
		this.title = title;
		this.genre = genre;
		this.list = list;
		this.author_name = author_name;
		this.workbook_id = workbook_id;
		this.limit = limit;
		this.random = random;
	}
	
	public Workbook(String title,String genre,String list,String author_name,int workbook_id,int limit) {
		this.title = title;
		this.genre = genre;
		this.list = list;
		this.author_name = author_name;
		this.workbook_id = workbook_id;
		this.limit = limit;
	}
	
	public Workbook(String title,String genre,String list,String author_name,int workbook_id,boolean random) {
		this.title = title;
		this.genre = genre;
		this.list = list;
		this.author_name = author_name;
		this.workbook_id = workbook_id;
		this.random = random;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public int getWorkbook_id() {
		return workbook_id;
	}

	public void setWorkbook_id(int workbook_id) {
		this.workbook_id = workbook_id;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public boolean isRandom() {
		return random;
	}

	public void setRandom(boolean random) {
		this.random = random;
	}

	public boolean isStealth() {
		return stealth;
	}

	public void setStealth(boolean stealth) {
		this.stealth = stealth;
	}

	
	
	
}
