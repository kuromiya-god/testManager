package servlet;
//ログインの成否を判定するservlet
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuesListSetDAO;
import model.Login;
import model.LoginLogic;
import model.Ques;
import model.Workbook;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		
		//ログイン処理の実行
		Login login = new Login(userId,pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		
		//ログイン処理の成否によって処理を分岐
		if(result) {//ログイン成功時
			//セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			
			//フォワード(試験画面へ)
			QuesListSetDAO l = new QuesListSetDAO();
			ArrayList<Ques> quesList = l.findByQuesList();
			QuesListSetDAO s = new QuesListSetDAO();
			ArrayList<Workbook> workbook = s.findByWorkbook();
			
			session.setAttribute("workbook",workbook);
			session.setAttribute("quesList",quesList);
			request.getRequestDispatcher("/WEB-INF/jsp/quizWorkbook.jsp").forward(request, response);
			
			 
		}else {
			//フォワード(外から見れないjspへ)
			String logmessage = "ユーザーIDまたはパスワードのどちらかに誤りがあります";
			request.setAttribute("logmessage", logmessage);
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}

}
