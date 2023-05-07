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
import model.Workbook;

/**
 * Servlet implementation class GoWorkbookEdit
 */
@WebServlet("/GoWorkbookEdit")
public class GoWorkbookEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//今ある問題集（useridが一致するのだけ）
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("userId");
		if(user_id==null) {
			response.sendRedirect("/testManager/login.jsp");
			return;
		}
		
		QuesListSetDAO l = new QuesListSetDAO();
		ArrayList<Workbook> workbook = l.findByWorkbooks(user_id);
		
		session.setAttribute("workbook",workbook);
		//Object obj = session.getAttribute("userId");
		//System.out.println((String)obj);
		request.getRequestDispatcher("/WEB-INF/jsp/workbookChoice.jsp").forward(request, response);
	}

}
