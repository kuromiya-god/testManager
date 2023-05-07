package servlet;
//試験ページへ遷移するservlet
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuesListSetDAO;
import model.Ques;

/**
 * Servlet implementation class UpGo
 */
@WebServlet("/UpGo")
public class UpGo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//今ある問題を取ってきてset
		QuesListSetDAO l = new QuesListSetDAO();
		ArrayList<Ques> quesList = l.findByQuesList();
		HttpSession session = request.getSession();
		session.setAttribute("quesList",quesList);
		Object obj = session.getAttribute("userId");
		 System.out.println((String)obj);
		request.getRequestDispatcher("/WEB-INF/jsp/quizChoice.jsp").forward(request, response);
	}

}
