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
import model.Workbook;

/**
 * Servlet implementation class WorkbookEdit
 */
@WebServlet("/WorkbookEdit")
public class WorkbookEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userId");
		//問題のtitleをうける
		String title = request.getParameter("title");
		Workbook workbookcontent = null;
		//削除ボタンを押された時の処理
		if(title==null) {
			request.getRequestDispatcher("/WEB-INF/jsp/workbookChoice.jsp").forward(request, response);
		}
		
		
		System.out.println("numberの"+title);
		//ArrayListじゃなくても良いけど、試験モードの記述と合わせた(DAOが同じだから)
		
		QuesListSetDAO dao = new QuesListSetDAO();
		workbookcontent = dao.findByWorkbookEdit(userid,title);
		QuesListSetDAO l = new QuesListSetDAO();
		ArrayList<Ques> quesList = l.findByQuesList(userid);
		session.setAttribute("quesList",quesList);
		session.setAttribute("workbookContent", workbookcontent);
		request.getRequestDispatcher("/WEB-INF/jsp/workbookChange.jsp").forward(request, response);
	}

}
