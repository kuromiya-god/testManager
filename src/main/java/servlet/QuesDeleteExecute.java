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

/**
 * Servlet implementation class QuesDeleteExecute
 */
@WebServlet("/QuesDeleteExecute")
public class QuesDeleteExecute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String question = request.getParameter("question");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String option4 = request.getParameter("option4");
		String answer1 = request.getParameter("answer");
		int answer = Integer.parseInt(answer1);
		String explanation = request.getParameter("explanation");
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		
		
		
		//Quesクラスをインスタンス化
		Ques ques = new Ques(question,option1,option2,option3,option4,answer,explanation,id);
		QuesUpDAO qd = new QuesUpDAO(); 
		//削除を実行
		qd.quesDeleteDAO(ques);
		
		//今編集できるリストを呼び出して
		//フォワード(編集ページへ)
		QuesListSetDAO l = new QuesListSetDAO();
		ArrayList<Ques> quesList = l.findByQuesList();
		HttpSession session = request.getSession();
		session.setAttribute("quesList",quesList);
		request.getRequestDispatcher("/WEB-INF/jsp/editBefore.jsp").forward(request, response);
	}

}
