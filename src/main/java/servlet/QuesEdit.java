package servlet;
//editBeforeから問題idを貰って編集がっ面に表示させるservlet
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
 * Servlet implementation class QuesEdit
 */
@WebServlet("/QuesEdit")
public class QuesEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//問題のidをうける
		String numberList = request.getParameter("answer");
		
		//削除ボタンを押された時の処理
		if(numberList==null) {
			request.getRequestDispatcher("/WEB-INF/jsp/editBefore.jsp").forward(request, response);
		}
		
		int id = Integer.parseInt(numberList);
		System.out.println("numberの"+id);
		//ArrayListじゃなくても良いけど、試験モードの記述と合わせた(DAOが同じだから)
		ArrayList<Integer> questionId = new ArrayList<>();
		questionId.add(id);
		QuestionsetDAO dao = new QuestionsetDAO();
		ArrayList<Ques> question = dao.findByQuestion(questionId);
		request.setAttribute("question", question);
		request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request, response);
	}

}
