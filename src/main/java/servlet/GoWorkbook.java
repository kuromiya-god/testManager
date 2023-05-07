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
import model.Ques;

/**
 * Servlet implementation class GoWorkbook
 */
@WebServlet("/GoWorkbook")
public class GoWorkbook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("userId");
		if(user_id==null) {
			session = request.getSession();
			session.invalidate();
			response.sendRedirect("/testManager/login.jsp");
			return;
		}
		
		QuesListSetDAO l = new QuesListSetDAO();
		ArrayList<Ques> quesList = l.findByQuesList(user_id);
		session.setAttribute("quesList",quesList);
		request.getRequestDispatcher("/WEB-INF/jsp/workbook.jsp").forward(request, response);
	}

}
