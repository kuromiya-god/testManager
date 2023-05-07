package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuesUpDAO;
import model.Workbook;

/**
 * Servlet implementation class WorkbookChange
 */
@WebServlet("/WorkbookChange")
public class WorkbookChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		String author_name = request.getParameter("author_name");
		String random1 = null;
		random1 = request.getParameter("random");
		String stealth1 = null;
		stealth1 = request.getParameter("stealth");
		boolean stealth = false;
		if(stealth1!=null) {
			stealth = true;
		}
		boolean random = false;
		if(random1!=null) {
			random = true;
		}
		System.out.println(random);
		/*if(random1.length()==0) {
			random1=null;
		}*/
		
		//System.out.println(random1);
		String answer1 = request.getParameter("answer");
		
		int limit = 0;
		if(answer1!=null&&answer1.length()!=0) {
			limit=Integer.parseInt(answer1);
		}
		
		if(answer1.length()==0) {
			answer1=null;
		}
		
		System.out.println("アンサー" +answer1.length());
		System.out.println("リミット"+limit);
		
		String[]  ids1 = request.getParameterValues("ids[]");
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("userId");
		
		Workbook workbookcontent = (Workbook)session.getAttribute("workbookContent");
		int workbook_id = workbookcontent.getWorkbook_id();
		//System.out.println(workbook_id);
		
		//チェックボックスなのでnullが来たら元のページへ戻す
		if(ids1==null){
		    //QuesListSetDAO l = new QuesListSetDAO();
		    //ArrayList<Ques> quesList = l.findByQuesList(user_id);
		    //HttpSession session = request.getSession();
		    String errormessage ="最低でも１つの問題にチェックを入れてください";
			//session.setAttribute("quesList",quesList);
		    request.setAttribute("errormessage", errormessage);
		    request.getRequestDispatcher("/WEB-INF/jsp/workbookChange.jsp").forward(request, response);
		} 
		
		String list = String.join(",", ids1);
		
		if (user_id == null) {
			
			session.invalidate();
			response.sendRedirect("/testManager/login.jsp");
			return;
		}
		

		//Quesクラスをインスタンス化
		QuesUpDAO qd = new QuesUpDAO();
		
		if(stealth1!=null) {
			qd.workbookChangeDAO(workbook_id, stealth);
		}else {
			stealth = false;
			qd.workbookChangeDAO(workbook_id, stealth);
		}
		
		if(random1!=null&&answer1!=null) {
		
		
		//問題集の編集内容をDBにup
		qd.workbookChangeDAO(user_id, title, genre, list, author_name,workbook_id,random,limit);
		
	} /*else {
		System.out.println("本栖湖");
		random = false;
		limit = 0;
		qd.workbookChangeDAO(user_id, title, genre, list, author_name,workbook_id,random,limit);
		}*/
		
		if(answer1!=null) {
			
			
			//問題集の編集内容をDBにup
			
			qd.workbookChangeDAO(user_id, title, genre, list, author_name,workbook_id,limit);
			System.out.println("アンサー" + limit);
			}else{
				limit = 0;
				System.out.println("アンケート"+limit);
				qd.workbookChangeDAO(user_id, title, genre, list, author_name,workbook_id,limit);
			}
		
		if(random1!=null) {
			
			
			//問題集の編集内容をDBにup
			
			qd.workbookChangeDAO(user_id, title, genre, list, author_name,workbook_id,random);
			}else {
				random = false;
				qd.workbookChangeDAO(user_id, title, genre, list, author_name,workbook_id,random);
			}
		
		
		
		//問題集の編集内容をDBにup
		Workbook workbook = new Workbook(user_id, title, genre, list, author_name,workbook_id);
		qd.workbookChangeDAO(workbook);

		//フォワード(問題、問題集選択ページへ)
		request.getRequestDispatcher("/WEB-INF/jsp/editWorkbook.jsp").forward(request, response);
		
	}

}
