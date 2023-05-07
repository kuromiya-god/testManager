package servlet;
//削除の確認ページへ遷移するservlet
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionsetDAO;
import model.Ques;

/**
 * Servlet implementation class ConfirmDelete
 */
@WebServlet("/ConfirmDelete")
public class ConfirmDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String numberList = request.getParameter("answer");
		if(numberList==null) {
			request.getRequestDispatcher("/WEB-INF/jsp/editBefore.jsp").forward(request, response);
		}
		int id = Integer.parseInt(numberList);
		System.out.println("numberの"+id);
		ArrayList<Integer> questionId = new ArrayList<>();
		questionId.add(id);
		QuestionsetDAO dao = new QuestionsetDAO();
		ArrayList<Ques> question = dao.findByQuestion(questionId);
		request.setAttribute("question", question);
		request.getRequestDispatcher("/WEB-INF/jsp/confirmDelete.jsp").forward(request, response);
	}

}
