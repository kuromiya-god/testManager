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
 * Servlet implementation class GoWorkbookChoices
 */
@WebServlet("/GoWorkbookChoices")
public class GoWorkbookChoices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//今ある問題集を取ってきてset
		QuesListSetDAO l = new QuesListSetDAO();
		ArrayList<Workbook> workbook = l.findByWorkbook();
		HttpSession session = request.getSession();
		session.setAttribute("workbook",workbook);
		Object obj = session.getAttribute("userId");
		System.out.println((String)obj);
		request.getRequestDispatcher("/WEB-INF/jsp/workbookChoice.jsp").forward(request, response);
	}

}
