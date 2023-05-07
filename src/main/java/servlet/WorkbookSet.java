package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuesListSetDAO;
import dao.QuesUpDAO;
import model.Ques;
import model.Workbook;

/**
 * Servlet implementation class WorkbookSet
 */
@WebServlet("/WorkbookSet")
public class WorkbookSet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		String author_name = request.getParameter("author_name");
		String random1 = request.getParameter("random");
		String stealth1 = request.getParameter("stealth");
		boolean stealth = false;
		if(stealth1!=null) {
			stealth = true;
		}
		boolean random = false;
		if(random1!=null) {
			random = true;
		}
				
		String[]  ids1 = request.getParameterValues("ids[]");
		
		//チェックボックスなのでnullが来たら元のページへ戻す
		if(ids1==null){
		    QuesListSetDAO l = new QuesListSetDAO();
		    ArrayList<Ques> quesList = l.findByQuesList();
		    HttpSession session = request.getSession();
		    String errormessage ="最低でも１つの問題にチェックを入れてください";
		    session.setAttribute("quesList",quesList);
		    request.setAttribute("errormessage", errormessage);
		    request.getRequestDispatcher("/WEB-INF/jsp/workbook.jsp").forward(request, response);
		} 
		
		String list = String.join(",", ids1);
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("userId");
		
		if(user_id==null) {
			response.sendRedirect("/login.jsp");
		}
		
		//Quesクラスをインスタンス化
		Workbook workbook = new Workbook(user_id,title,genre,list,author_name);
		QuesUpDAO qd = new QuesUpDAO(); 
		//問題をupインサート出来れば1が返される
		int result = qd.workbookUpDAO(workbook);
		
		if(result==1) {
			
			//インサート出来た場合
			
		
			
			//フォワード(問題、問題集選択ページへ)
			request.getRequestDispatcher("/WEB-INF/jsp/makeWorkbook.jsp").forward(request, response);
		}else {
			//インサート出来なかった場合
			//フォワード(問題集作成ページへ)
			String errormessage = "ご入力いただいた題名は既にご使用いただいております。";
	        request.setAttribute("errormessage", errormessage);
	        request.getRequestDispatcher("/WEB-INF/jsp/workbook.jsp").forward(request, response);
		}
		
		
		}

}
