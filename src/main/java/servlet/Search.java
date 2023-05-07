package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Searchs;
import model.Workbook;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("search");
		
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("userId");
		if(user_id==null) {
			response.sendRedirect("/testManager/login.jsp");
			return;
		}
		
		Searchs s = new Searchs();
		ArrayList<Workbook> workbook = s.findByWorkbookSearch(search);
		if(workbook==null||workbook.size()==0) {
			workbook = s.findByWorkbookSearchagain(search);
		}

		
		
		session.setAttribute("workbook",workbook);
		request.getRequestDispatcher("/WEB-INF/jsp/quizWorkbook.jsp").forward(request, response);
	}

}
